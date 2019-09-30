package org.snakeskin.runtime

import org.snakeskin.compiler.VersionManager
import org.snakeskin.exception.InitException
import org.snakeskin.utility.value.AsyncBoolean
import java.lang.ClassCastException

/**
 * SnakeSkin runtime objects.  This object can be used to access various information
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
        check (!isRunning) { "Cannot register module '$module' when runtime is already started!"}
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

    /**
     * Returns the currently running version of SnakeSkin
     */
    fun getVersion(): String {
        return VersionManager.getVersion()
    }

    /**
     * Starts the SnakeSkin runtime with the specified platform
     */
    @Synchronized
    fun start(platform: SnakeskinPlatform) {
        check(!isRunning) { "SnakeSkin runtime is already started!" }
        binding = loadPlatformBinding(platform) //Could potentially throw
        this.platform = platform
        isRunning = true
    }
}