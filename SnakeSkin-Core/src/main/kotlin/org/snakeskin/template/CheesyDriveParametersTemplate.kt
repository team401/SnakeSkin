package org.snakeskin.template

import org.snakeskin.logic.scalars.IScalar

/**
 * @author Cameron Earle
 * @version 12/8/2018
 *
 */
interface CheesyDriveParametersTemplate {
    val highWheelNonLinearity: Double
    val lowWheelNonLinearity: Double
    val highNegInertiaScalar: Double
    val lowNegInertiaThreshold: Double
    val lowNegInertiaTurnScalar: Double
    val lowNegInertiaCloseScalar: Double
    val lowNegInertiaFarScalar: Double
    val highSensitivity: Double
    val lowSensitivity: Double
    val quickStopDeadband: Double
    val quickStopWeight: Double
    val quickStopScalar: Double
    val lowSinCount: Int
    val highSinCount: Int
    val outputScalar: Double
    val quickTurnScalar: IScalar
}