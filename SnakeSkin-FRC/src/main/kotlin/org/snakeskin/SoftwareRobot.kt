package org.snakeskin

import edu.wpi.first.wpilibj.RobotBase
import org.snakeskin.debug.DebuggerShell
import org.snakeskin.hardware.Environment
import org.snakeskin.hardware.Hardware

/**
 * @author Cameron Earle
 * @version 10/3/2018
 *
 */
object SoftwareRobot {
    @JvmStatic
    fun main(args: Array<String>) {
        Hardware.configureEnvironment(Environment.SOFTWARE)

        Thread {
            val shell = DebuggerShell(System.`in`, System.out)
            shell.init()
            shell.run()
        }.start()

        RobotBase.main(*args)
    }
}