package org.snakeskin

import org.slf4j.LoggerFactory
import org.snakeskin.annotation.PostStartup
import org.snakeskin.annotation.PreStartup
import org.snakeskin.annotation.Setup
import org.snakeskin.compiler.AnnotatedRunnable
import org.snakeskin.compiler.RuntimeLoader
import org.snakeskin.compiler.VersionManager
import org.snakeskin.exception.InitException
import org.snakeskin.exception.StartupException
import org.snakeskin.factory.ExecutorFactory
import org.snakeskin.logging.LoggerManager
import org.snakeskin.registry.Subsystems
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/**
 * @author Cameron Earle
 * @version 7/16/17
 */
object InitManager {
    private val logger = LoggerFactory.getLogger(javaClass)

    /**
     * This method runs before SETUP is loaded
     */
    @JvmStatic fun preStartup() {
        //We'll run known core pre-init tasks here, since we can't run annotation processing on our own module
        ExecutorFactory.init()

        val preStartupTasks = RuntimeLoader.getAnnotated(PreStartup::class.java)
        preStartupTasks.forEach {
            try {
                it.run()
            } catch (e: Exception) {
                throw InitException("Exception while running pre-startup task '${it.javaClass.name}", e)
            }
        }
    }

    /**
     * This method runs after SETUP is loaded
     */
    @JvmStatic fun postStartup() {
        //We'll run known core post-init tasks here, since we can't run annotation processing on our own module
        Subsystems.initAll()

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

        //Next, we'll load all of the annotated tasks
        println("SnakeSkin: Loading classes")
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
        InitManager.postStartup()
    }
}