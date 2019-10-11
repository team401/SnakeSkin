package org.snakeskin.component.impl

import com.ctre.phoenix.ErrorCode
import com.ctre.phoenix.motorcontrol.*
import org.snakeskin.component.ICTREGearbox
import org.snakeskin.component.ICTRESmartGearbox
import org.snakeskin.measure.time.TimeMeasureSeconds

/**
 * @author Cameron Earle
 * @version 1/29/2019
 *
 */
@Deprecated("Replaced with new component system")
open class CTRESmartGearbox<M: IMotorControllerEnhanced>(
        val master: M, vararg val slaves: IMotorController,
        nativeUnitsToRadians: Double = (2 * Math.PI) / 4096.0,
        nativeUnitsToRadiansPerSecond: Double = (20.0 * Math.PI) / 4096.0
): ICTRESmartGearbox, ICTREGearbox by CTREGearbox<M>(master, *slaves,
        nativeUnitsToRadians = nativeUnitsToRadians, nativeUnitsToRadiansPerSecond = nativeUnitsToRadiansPerSecond) {

    override fun setFeedbackSensor(device: FeedbackDevice, pidIdx: Int, timeoutMs: Int): ErrorCode {
        return master.configSelectedFeedbackSensor(device, pidIdx, timeoutMs)
    }

    override fun getMasterCurrentAmps(): Double {
        return master.outputCurrent
    }

    override fun setForwardLimitSwitch(source: LimitSwitchSource, normal: LimitSwitchNormal, timeoutMs: Int): ErrorCode {
        return master.configForwardLimitSwitchSource(source, normal, timeoutMs)
    }

    override fun setReverseLimitSwitch(source: LimitSwitchSource, normal: LimitSwitchNormal, timeoutMs: Int): ErrorCode {
        return master.configReverseLimitSwitchSource(source, normal, timeoutMs)
    }

    override fun setCurrentLimit(continuousAmps: Double, peakLimit: Double, peakDuration: TimeMeasureSeconds, timeoutMs: Int): ErrorCode {
        if (continuousAmps == 0.0) {
            master.enableCurrentLimit(false)
        } else {
            master.enableCurrentLimit(true)
        }

        return ErrorCode.worstOne(
            master.configContinuousCurrentLimit(continuousAmps.toInt(), timeoutMs),
            master.configPeakCurrentLimit(peakLimit.toInt(), timeoutMs),
            master.configPeakCurrentDuration(peakDuration.toMilliseconds().value.toInt(), timeoutMs)
        )
    }

    override fun getSensorCollection(): SensorCollection {
        return master.sensorCollection
    }
}