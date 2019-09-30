package org.snakeskin

import edu.wpi.first.wpilibj.RobotBase

/**
 * @author Cameron Earle
 * @version 10/31/2018
 *
 * Main class used by the new version of WPILib
 */
object SnakeskinMain {
    @JvmStatic
    fun main(args: Array<String>) {
        RobotBase.startRobot { FrcRoborioRobot() }
    }
}