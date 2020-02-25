package org.snakeskin.component.impl

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.DemandType
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import org.snakeskin.component.CTREFeedforwardScalingMode
import org.snakeskin.component.ITalonSrxDevice
import org.snakeskin.component.provider.IFollowableProvider
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRadians
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRadiansPerSecond
import org.snakeskin.runtime.SnakeskinRuntime

class HardwareTalonSrxDevice(val device: TalonSRX, sensorTicksPerRevolution: Double = 4096.0, val ffMode: CTREFeedforwardScalingMode = CTREFeedforwardScalingMode.ScaleVbusSystem) : ITalonSrxDevice {
    private val sensorTicksPerRadian = sensorTicksPerRevolution / (2.0 * Math.PI)

    private fun scaleFfVolts(voltage: Double): Double {
        return when (ffMode) {
            CTREFeedforwardScalingMode.Scale12V -> voltage / 12.0
            CTREFeedforwardScalingMode.ScaleVbusSystem -> {
                val vbus = SnakeskinRuntime.voltage
                return voltage / vbus
            }
            CTREFeedforwardScalingMode.ScaleVbusDevice -> {
                val vbus = device.busVoltage
                voltage / vbus
            }
        }
    }

    override fun follow(master: IFollowableProvider) {
        when (master) {
            is HardwareTalonSrxDevice -> device.follow(master.device)
            is HardwareVictorSpxDevice -> device.follow(master.device)
        }
    }

    override fun unfollow() {
        //CTRE devices unfollow when a 0.0 percent output command is sent
        device.set(ControlMode.PercentOutput, 0.0)
    }

    override fun setPercentOutput(percentOut: Double) {
        device.set(ControlMode.PercentOutput, percentOut)
    }

    override fun getPercentOutput(): Double {
        return device.motorOutputPercent
    }

    override fun getOutputVoltage(): Double {
        return device.motorOutputVoltage
    }

    override fun getInputVoltage(): Double {
        return device.busVoltage
    }

    override fun stop() {
        setPercentOutput(0.0)
    }

    override fun getAngularPosition(): AngularDistanceMeasureRadians {
        val ticks = device.selectedSensorPosition.toDouble()
        return AngularDistanceMeasureRadians(ticks / sensorTicksPerRadian)
    }

    override fun setAngularPosition(angle: AngularDistanceMeasureRadians) {
        val ticks = (angle.value * sensorTicksPerRadian).toInt()
        device.selectedSensorPosition = ticks
    }

    override fun getAngularVelocity(): AngularVelocityMeasureRadiansPerSecond {
        val ticks = device.selectedSensorVelocity.toDouble()
        return AngularVelocityMeasureRadiansPerSecond((ticks / sensorTicksPerRadian) * 10.0) //Multiply by 10 to convert deciseconds (100 ms) to seconds
    }

    override fun getOutputCurrent(): Double {
        return device.statorCurrent
    }

    override fun setAngularPositionSetpoint(setpoint: AngularDistanceMeasureRadians, ffVolts: Double) {
        val ticks = setpoint.value * sensorTicksPerRadian
        val ffPercent = scaleFfVolts(ffVolts)
        device.set(ControlMode.Position, ticks, DemandType.ArbitraryFeedForward, ffPercent)
    }

    override fun setAngularVelocitySetpoint(setpoint: AngularVelocityMeasureRadiansPerSecond, ffVolts: Double) {
        val ticksPer100Ms = (setpoint.value * sensorTicksPerRadian) / 10.0 //Divide by 10 to convert seconds to deciseconds (100 ms)
        val ffPercent = scaleFfVolts(ffVolts)
        device.set(ControlMode.Velocity, ticksPer100Ms, DemandType.ArbitraryFeedForward, ffPercent)
    }

    override fun setProfiledSetpoint(setpoint: AngularDistanceMeasureRadians, ffVolts: Double) {
        val ticks = setpoint.value * sensorTicksPerRadian
        val ffPercent = scaleFfVolts(ffVolts)
        device.set(ControlMode.MotionMagic, ticks, DemandType.ArbitraryFeedForward, ffPercent)
    }

    override fun invert(invert: Boolean) {
        device.inverted = invert
    }

    override fun invertInput(invert: Boolean) {
        device.setSensorPhase(invert)
    }
}