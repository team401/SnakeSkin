package org.snakeskin.runtime

import org.snakeskin.compiler.VersionManager
import org.snakeskin.exception.InitException
import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.executor.IExecutor
import org.snakeskin.executor.IExecutorTaskHandle
import org.snakeskin.hid.IHIDValueProviderFactory
import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.rt.IRealTimeExecutor
import org.snakeskin.rt.RealTimeTask
import org.snakeskin.rt.TaskRegistrationOrder
import org.snakeskin.utility.value.AsyncBoolean

/**
 * SnakeSkin runtime object.  This object can be used to access various information
 * about the running instance of SnakeSkin
 */
object SnakeskinRuntime {
    /**
     * Indicates whether the runtime has been started.
     */
    var isRunning by AsyncBoolean(false)
    private set

    /**
     * The currently running platform.
     */
    var platform = SnakeskinPlatform.UNDEFINED
    private set

    /**
     * The binding for the currently running platform.
     */
    private lateinit var binding: IRuntimePlatformBinding

    /**
     * Modules that have registered with the runtime
     */
    private val modules = mutableSetOf<SnakeskinModules>()

    /**
     * The primary executor
     */
    lateinit var primaryExecutor: IExecutor
    private set

    /**
     * The default real time executor
     */
    private lateinit var rtExecutor: IRealTimeExecutor

    /**
     * Other real time executors
     */
    private val rtExecutors = hashMapOf<String, IRealTimeExecutor>()

    /**
     * The current system timestamp, in seconds
     */
    val timestamp: TimeMeasureSeconds
    get() = TimeMeasureSeconds(binding.getTimestampSeconds())

    /**
     * Delays for the specified time, in seconds
     */
    fun delay(time: TimeMeasureSeconds) {
        binding.blockMilliseconds(time.toMilliseconds().value.toLong())
    }

    /**
     * The current bus voltage of the system, in volts.
     */
    val voltage: Double
    get() = binding.getSystemVbusVolts()

    /**
     * Returns true if the given module is loaded, false otherwise
     */
    @Synchronized
    fun isModuleLoaded(module: SnakeskinModules): Boolean {
        return modules.contains(module)
    }

    /**
     * Registers a module with the runtime.  This must be called before the runtime is started,
     * otherwise an IllegalStateException will be thrown.  This is designed to be called by SnakeSkin modules themselves
     */
    @Synchronized
    fun registerModule(module: SnakeskinModules) {
        check (!isRunning) { "Cannot register module '$module' when runtime is already started"}
    }

    /**
     * Loads the platform binding, or throws an exception if the binding couldn't be loaded
     */
    private fun loadPlatformBinding(platform: SnakeskinPlatform): IRuntimePlatformBinding {
        try {
            val clazz = Class.forName(platform.platformBindingClass)
            val ctor = clazz.getConstructor()
            return ctor.newInstance() as IRuntimePlatformBinding
        } catch (e: Exception) {
            throw InitException("Error loading platform binding '${platform.platformBindingClass} for platform '${platform.name}'", e)
        }
    }

    private fun checkIsRunning() = check(isRunning) { "SnakeSkin runtime is not started" }

    /**
     * Returns the currently running version of SnakeSkin
     */
    @Synchronized
    fun getVersion(): String {
        return VersionManager.getVersion()
    }

    /**
     * Starts the SnakeSkin runtime with the specified platform
     */
    @Synchronized
    fun start(platform: SnakeskinPlatform) {
        //Initial setup
        check(!isRunning) { "SnakeSkin runtime is already started" }
        binding = loadPlatformBinding(platform) //Could potentially throw
        this.platform = platform

        //Start services
        primaryExecutor = binding.allocatePrimaryExecutor()

        isRunning = true
    }

    /**
     * Executes a task on the primary executor as soon as possible
     * @param task The task to execute
     */
    @Synchronized
    fun executeTask(task: ExceptionHandlingRunnable): IExecutorTaskHandle {
        checkIsRunning()
        return primaryExecutor.scheduleSingleTaskNow(task)
    }

    @Synchronized
    fun executeTaskAfter(task: ExceptionHandlingRunnable, delay: TimeMeasureSeconds): IExecutorTaskHandle {
        checkIsRunning()
        return primaryExecutor.scheduleSingleTask(task, delay)
    }

    /**
     * Schedules a task to run at a fixed rate on the primary executor
     * @param task The task to execute periodically
     * @param rate The rate to execute the task at in seconds
     */
    @Synchronized
    fun startPeriodicTask(task: ExceptionHandlingRunnable, rate: TimeMeasureSeconds): IExecutorTaskHandle {
        checkIsRunning()
        return primaryExecutor.schedulePeriodicTask(task, rate)
    }

    /**
     * Creates and starts a single use executor, which allows certain tasks to be executed
     * off of the primary executor
     */
    @Synchronized
    fun createSingleUseExecutor(): IExecutor {
        checkIsRunning()
        return binding.allocateSingleUseExecutor()
    }

    /**
     * Creates a new real time executor at the specified rate
     * @param rate The runtime rate of the executor in seconds
     * @param name The name of the executor to create.  If not provided, this creates the default executor
     */
    @Synchronized
    fun createRealTimeExecutor(rate: TimeMeasureSeconds, name: String? = null) {
        checkIsRunning()
        if (name == null) {
            check(!::rtExecutor.isInitialized) { "Default RT executor is already created" }
            rtExecutor = binding.allocateRealTimeExecutor(rate.value)
        } else {
            check(!rtExecutors.containsKey(name)) { "An RT executor with name '$name' already exists" }
            rtExecutors[name] = binding.allocateRealTimeExecutor(rate.value)
        }
    }

    /**
     * Registers a real time task
     * @param task The task to register
     * @param executorName The executor to register the task on.  If not provided, schedule on the default executor
     */
    @Synchronized
    fun registerRealTimeTask(task: RealTimeTask, executorName: String? = null, order: TaskRegistrationOrder = TaskRegistrationOrder.DEFAULT) {
        checkIsRunning()
        if (executorName == null) {
            check(::rtExecutor.isInitialized) { "Default RT executor has not been created" }
            rtExecutor.registerTask(task, order)
        } else {
            check(rtExecutors.containsKey(executorName)) { "No RT executor found with name '$executorName'" }
            rtExecutors[executorName]!!.registerTask(task, order)
        }
    }

    @Synchronized
    fun getRealTimeExecutor(executorName: String? = null): IRealTimeExecutor {
        checkIsRunning()
        return if (executorName == null) {
            check(::rtExecutor.isInitialized) { "Default RT executor has not been created" }
            rtExecutor
        } else {
            check(rtExecutors.containsKey(executorName)) { "No RT executor found with name '$executorName'" }
            rtExecutors[executorName]!!
        }
    }

    /**
     * Starts all created real time executors
     */
    @Synchronized
    fun startRealTimeExecutors() {
        checkIsRunning()
        if (::rtExecutor.isInitialized) {
            rtExecutor.start()
        }
        rtExecutors.forEach { (_, executor) ->
            executor.start()
        }
    }

    /**
     * Creates an HID factory for the given controller ID
     * This is used by the HID Controller abstraction classes, and most likely is not useful directly by the user
     */
    @Synchronized
    fun createHIDFactory(id: Int): IHIDValueProviderFactory {
        checkIsRunning()
        return binding.allocateHIDValueProviderFactory(id)
    }
}