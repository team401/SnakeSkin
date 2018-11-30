package org.snakeskin.init

import org.slf4j.LoggerFactory
import org.snakeskin.annotation.PostStartup
import org.snakeskin.annotation.PreStartup
import org.snakeskin.annotation.Setup
import org.snakeskin.compiler.RuntimeLoader
import org.snakeskin.compiler.VersionManager
import org.snakeskin.exception.InitException
import org.snakeskin.exception.StartupException
import org.snakeskin.factory.ExecutorFactory
import org.snakeskin.logging.LoggerManager
import org.snakeskin.registry.Subsystems
import java.lang.ClassCastException

/**
 * @author Cameron Earle
 * @version 7/16/17
 */
object InitManager {
    private val logger = LoggerFactory.getLogger(javaClass)

    /**
     * List of module initializers.  We may find them, we may not.  They will be loaded in order
     */
    private val initializerClasses = arrayOf(
            "org.snakeskin.init.CoreInit",
            "org.snakeskin.init.FrcInit",
            "org.snakeskin.init.CtreInit"
    )

    private val initializers = ArrayList<Initializer>(initializerClasses.size)

    private fun loadInitializers() {
        initializerClasses.forEach {
            try {
                val clazz = Class.forName(it)
                val ctor = clazz.getConstructor() //Get the default constructor
                val instance = ctor.newInstance() as Initializer
                initializers.add(instance)
            } catch (cnf: ClassNotFoundException) {
                //Ignore this, just means the module isn't present on the classpath
            } catch (nmf: NoSuchMethodException) {
                //This means that the initializer doesn't have a default constructor.  This is not supposed to happen
                throw InitException("Could not find default constructor for initializer '$it'.  This is not supposed to happen!", nmf)
            } catch (cce: ClassCastException) {
                //This means that the initializer doesn't implement the Initializer interface.  This is also not supposed to happen
                throw InitException("Initializer '$it' does not implement the Initializer interface.  This is not supposed to happen!", cce)
            } catch (e: Exception) {
                //At this point we have no idea what happened
                throw InitException("Unknown error while loading initializer '$it'.  This is definitely not supposed to happen!", e)
            }
        }
    }

    /**
     * This method runs before SETUP is loaded
     */
    @JvmStatic fun preStartup() {
        //First, do internal initialization
        initializers.forEach {
            try {
                it.preStartup()
            } catch (e: Exception) {
                throw InitException("Exception while running INTERNAL pre-startup task '${it.javaClass.name}', this is not supposed to happen!", e)
            }
        }

        //Next, do any user code initialization
        val preStartupTasks = RuntimeLoader.getAnnotated(PreStartup::class.java)
        preStartupTasks.forEach {
            try {
                it.run()
            } catch (e: Exception) {
                throw InitException("Exception while running pre-startup task '${it.javaClass.name}'", e)
            }
        }
    }

    /**
     * This method runs after SETUP is loaded
     */
    @JvmStatic fun postStartup() {
        //First, do internal initialization
        initializers.forEach {
            try {
                it.postStartup()
            } catch (e: Exception) {
                throw InitException("Exception while running INTERNAL post-startup task '${it.javaClass.name}', this is not supposed to happen!", e)
            }
        }

        //Next, do any user code initialization
        val postStartupTasks = RuntimeLoader.getAnnotated(PostStartup::class.java)
        postStartupTasks.forEach {
            try {
                it.run()
            } catch (e: Exception) {
                throw InitException("Exception while running post-startup task '${it.javaClass.name}'", e)
            }
        }
    }

    /**
     * This method does the initialization
     */
    @JvmStatic fun init() {
        //First, we'll initialize and start the logger
        LoggerManager.init()
        LoggerManager.logMainThread()

        //Print a message to show version
        println("SnakeSkin: Version '${VersionManager.getVersion()}'")

        //Next, we'll load all of the annotated tasks and internal initialization classes
        println("SnakeSkin: Loading classes")
        loadInitializers()
        RuntimeLoader.load()
        println("SnakeSkin: Classes loaded")

        //Next, we'll run the "pre-startup" init tasks
        preStartup()

        //Next, we'll load the setup methods
        val setupMethods = RuntimeLoader.getAnnotated(Setup::class.java)

        //If there are not setup methods, crash the code here (this event will be logged as a crash)
        if (setupMethods.isEmpty()) {
            throw StartupException("No 'setup' methods found!  Make sure they are annotated with the '@Setup' annotation!")
        }

        //Run each setup method
        setupMethods.forEach {
            try {
                it.run()
            } catch (e: Exception) {
                throw InitException("Exception while running setup method '${it.javaClass.name}'", e)
            }
        }

        //Now that the setup has been completed, we can run the "postStartup" init tasks
        postStartup()
    }
}