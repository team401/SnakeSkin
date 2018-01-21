package org.snakeskin

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner
import org.slf4j.LoggerFactory
import org.snakeskin.annotation.PostStartup
import org.snakeskin.annotation.PreStartup
import org.snakeskin.annotation.Setup
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
    private val preStartupTasks = arrayListOf<Method>()
    private val postStartupTasks = arrayListOf<Method>()
    private val logger = LoggerFactory.getLogger(javaClass)

    @JvmStatic fun register(scanner: FastClasspathScanner) {
        scanner.matchClassesWithMethodAnnotation(PreStartup::class.java) {
            _, executable ->
            if (executable is Method) {
                preStartupTasks.add(executable)
            }
        }
        scanner.matchClassesWithMethodAnnotation(PostStartup::class.java) {
            _, executable ->
            if (executable is Method) {
                postStartupTasks.add(executable)
            }
        }
    }

    /**
     * This method runs before SETUP is loaded
     */
    @JvmStatic fun preStartup() {
        preStartupTasks.forEach {
            it.isAccessible = true
            try {
                it.invoke(null)
            } catch (e: InvocationTargetException) {
                if (e.cause is InitException) {
                    throw e.cause!!
                } else {
                    throw InitException("Exception while running pre-startup task '${it.name}", e.cause)
                }
            }
        }
    }

    /**
     * This method runs after SETUP is loaded
     */
    @JvmStatic fun postStartup() {
        postStartupTasks.forEach {
            it.isAccessible = true
            try {
                it.invoke(null)
            } catch (e: InvocationTargetException) {
                if (e.cause is InitException) {
                    throw e.cause!!
                } else {
                    throw InitException("Exception while running post-startup task '${it.name}'", e.cause)
                }
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

        //Next, we'll create a classpath scanner
        val scanner = FastClasspathScanner()
        scanner.ignoreMethodVisibility()

        //Next, we'll register all init tasks
        register(scanner)

        //Now, by find the 'setup' method, but don't run it yet
        val setupMethods = arrayListOf<Method>()

        scanner.matchClassesWithMethodAnnotation(Setup::class.java) { _, executable ->
            if (executable is Method) {
                setupMethods.add(executable)
            }
        }

        //Now, we'll scan the classpath, populating all method arrays
        scanner.scan()

        //Next, we'll run the "pre-startup" init tasks
        preStartup()

        //If there are not setup methods, crash the code here (this event will be logged as a crash)
        if (setupMethods.isEmpty()) {
            throw StartupException("No 'setup' methods found!  Make sure they are annotated with the '@Setup' annotation!")
        }

        //Run each setup method
        setupMethods.forEach {
            try {
                it.invoke(null)
            } catch (e: InvocationTargetException) {
                if (e.cause is InitException) {
                    throw e.cause!!
                } else {
                    throw InitException("Exception while running setup method '${it.name}'", e.cause)
                }
            }
        }

        //Now that the setup has been completed, we can run the "postStartup" init tasks
        InitManager.postStartup()
    }
}