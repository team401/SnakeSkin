package org.snakeskin

import org.slf4j.LoggerFactory
import org.snakeskin.annotation.PostStartup
import org.snakeskin.annotation.PreStartup
import org.snakeskin.annotation.Setup
import org.snakeskin.compiler.AnnotatedRunnable
import org.snakeskin.compiler.RuntimeLoader
import org.snakeskin.exception.InitException
import org.snakeskin.exception.StartupException
import org.snakeskin.logging.LoggerManager
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/*
 * snakeskin - Created on 7/16/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

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