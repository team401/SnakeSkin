package org.snakeskin

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner
import org.snakeskin.annotation.PostStartup
import org.snakeskin.annotation.PreStartup
import org.snakeskin.auto.AutoManager
import org.snakeskin.controls.ControlPoller
import org.snakeskin.factory.ExecutorFactory
import org.snakeskin.logging.LoggerManager
import org.snakeskin.registry.Autos
import org.snakeskin.registry.Controllers
import org.snakeskin.registry.Sensors
import org.snakeskin.registry.Subsystems
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
            it.invoke(null)
        }
    }

    /**
     * This method runs after SETUP is loaded
     */
    @JvmStatic fun postStartup() {
        postStartupTasks.forEach {
            it.invoke(null)
        }
    }
}