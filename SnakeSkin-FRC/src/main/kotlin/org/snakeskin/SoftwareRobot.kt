package org.snakeskin

import edu.wpi.first.wpilibj.RobotBase
import org.snakeskin.compiler.AnnotatedRunnable
import org.snakeskin.compiler.RuntimeLoader
import org.snakeskin.debug.DebuggerShell
import org.snakeskin.hardware.Environment
import org.snakeskin.hardware.Hardware
import org.snakeskin.init.InitManager
import org.snakeskin.runtime.SnakeskinPlatform

/**
 * @author Cameron Earle
 * @version 10/3/2018
 *
 */
object SoftwareRobot {
    @JvmStatic
    fun main(args: Array<String>) {
        Hardware.configureEnvironment(Environment.SOFTWARE)

        /*
        Thread {
            val shell = DebuggerShell(System.`in`, System.out)
            shell.init()
            shell.run()
        }.start()
        */

        RuntimeLoader.inject(object : AnnotatedRunnable {
            override fun getName(): String {
                return "org.snakeskin.annotation.Setup"
            }

            override fun run() {
                println("Injected setup!")
            }
        })

        InitManager.init(SnakeskinPlatform.SOFTWARE)

        //RobotBase.main(*args) //TODO fix this
    }
}