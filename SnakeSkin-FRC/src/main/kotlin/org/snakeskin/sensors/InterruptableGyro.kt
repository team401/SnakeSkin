package org.snakeskin.sensors

import edu.wpi.first.wpilibj.interfaces.Gyro

/**
 * @author Zachary Kozar
 * @version 5/22/17
 *
 * A gyro with more precise controls on calibration.
 */
interface InterruptableGyro : Gyro {

    fun startCalibrate()

    fun endCalibrate()

    fun cancelCalibrate()

    fun getCenter(): Double

    fun getCalibrationSampleTime(): Double
}