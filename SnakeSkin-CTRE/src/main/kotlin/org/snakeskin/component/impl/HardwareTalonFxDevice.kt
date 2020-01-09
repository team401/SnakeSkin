package org.snakeskin.component.impl

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.DemandType
import com.ctre.phoenix.motorcontrol.TalonFXControlMode
import com.ctre.phoenix.motorcontrol.can.TalonFX
import org.snakeskin.component.CTREFeedforwardScalingMode
import org.snakeskin.component.ITalonFxDevice
import org.snakeskin.component.provider.IFollowableProvider
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRevolutions
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRevolutionsPerSecond
import org.snakeskin.runtime.SnakeskinRuntime

class HardwareTalonFxDevice(val device: TalonFX, val ffMode: CTREFeedforwardScalingMode = CTREFeedforwardScalingMode.ScaleVbusSystem): ITalonFxDevice {
    private val sensorTicksPerRevolution = 2048.0 //Constant for Falcon 500 integrated encoder

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
            is HardwareTalonFxDevice -> device.follow(master.device)
        }
    }

    override fun unfollow() {
        //CTRE devices unfollow when a 0.0 percent output command is sent
        device.set(TalonFXControlMode.PercentOutput, 0.0)
    }

    override fun setPercentOutput(percentOut: Double) {
        device.set(TalonFXControlMode.PercentOutput, percentOut)
    }

    override fun getPercentOutput(): Double {
        return device.motorOutputPercent
    }

    override fun stop() {
        setPercentOutput(0.0)
    }

    override fun getInputVoltage(): Double {
        return device.busVoltage
    }

    override fun getOutputVoltage(): Double {
        return device.motorOutputVoltage
    }

    override fun getAngularPosition(): AngularDistanceMeasureRevolutions {
        val ticks = device.selectedSensorPosition.toDouble()
        return AngularDistanceMeasureRevolutions(ticks / sensorTicksPerRevolution)
    }

    override fun setAngularPosition(angle: AngularDistanceMeasureRevolutions) {
        val ticks = (angle.value * sensorTicksPerRevolution).toInt()
        device.selectedSensorPosition = ticks
    }

    override fun getAngularVelocity(): AngularVelocityMeasureRevolutionsPerSecond {
        val ticks = device.selectedSensorVelocity.toDouble()
        return AngularVelocityMeasureRevolutionsPerSecond((ticks / sensorTicksPerRevolution) * 10.0) //Multiply by 10 to convert deciseconds (100 ms) to seconds
    }

    override fun getOutputCurrent(): Double {
        return device.statorCurrent
    }

    override fun setAngularPositionSetpoint(setpoint: AngularDistanceMeasureRevolutions, ffVolts: Double) {
        val ticks = setpoint.value * sensorTicksPerRevolution
        val ffPercent = scaleFfVolts(ffVolts)
        device.set(ControlMode.Position, ticks, DemandType.ArbitraryFeedForward, ffPercent)    }

    override fun setAngularVelocitySetpoint(setpoint: AngularVelocityMeasureRevolutionsPerSecond, ffVolts: Double) {
        val ticksPer100Ms = (setpoint.value * sensorTicksPerRevolution) / 10.0 //Divide by 10 to convert seconds to deciseconds (100 ms)
        val ffPercent = scaleFfVolts(ffVolts)
        device.set(ControlMode.Velocity, ticksPer100Ms, DemandType.ArbitraryFeedForward, ffPercent)
    }
}