package org.snakeskin.component

import com.ctre.phoenix.ErrorCode
import com.ctre.phoenix.motorcontrol.*
import org.snakeskin.units.measure.time.TimeMeasure

/**
 * @author Cameron Earle
 * @version 1/29/2019
 *
 */
interface ICTRESmartGearbox: ICTREGearbox {
    fun setFeedbackSensor(device: FeedbackDevice, pidIdx: Int = 0, timeoutMs: Int = 0): ErrorCode
    fun getMasterCurrentAmps(): Double
    fun setForwardLimitSwitch(source: LimitSwitchSource, normal: LimitSwitchNormal, timeoutMs: Int = 0): ErrorCode
    fun setReverseLimitSwitch(source: LimitSwitchSource, normal: LimitSwitchNormal, timeoutMs: Int = 0): ErrorCode
    fun setCurrentLimit(continuousAmps: Double, peakLimit: Double, peakDuration: TimeMeasure, timeoutMs: Int = 0): ErrorCode
    fun getSensorCollection(): SensorCollection
}