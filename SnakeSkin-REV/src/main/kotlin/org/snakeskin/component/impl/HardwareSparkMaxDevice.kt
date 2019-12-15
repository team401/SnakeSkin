package org.snakeskin.component.impl

import com.revrobotics.CANSparkMax
import org.snakeskin.component.ISparkMaxDevice
import org.snakeskin.component.OutputVoltageReadingMode
import org.snakeskin.component.provider.IFollowableProvider
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRevolutions
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRevolutionsPerSecond
import org.snakeskin.runtime.SnakeskinRuntime

//TOOD finish this class
class HardwareSparkMaxDevice(val device: CANSparkMax, val voltageReadingMode: OutputVoltageReadingMode) : ISparkMaxDevice {
    private fun getOutputVoltageMultiplier(): Double {
        return when (voltageReadingMode) {
            OutputVoltageReadingMode.MultiplyVbusSystem -> SnakeskinRuntime.voltage
            OutputVoltageReadingMode.MultiplyVbusDevice -> device.busVoltage
        }
    }

    override fun follow(master: IFollowableProvider) {
        when (master) {
            is CANSparkMax -> device.follow(master)
        }
    }

    override fun unfollow() {
        //TODO check if this actually unfollows, or if we need to set 0 instead
        device.follow(CANSparkMax.ExternalFollower.kFollowerDisabled, 0)
    }

    override fun getInputVoltage(): Double {
        return device.busVoltage
    }

    override fun setPercentOutput(percentOut: Double) {
        device.set(percentOut)
    }

    override fun getPercentOutput(): Double {
        return device.appliedOutput
    }

    override fun stop() {
        device.stopMotor()
    }

    override fun getOutputVoltage(): Double {
        return device.appliedOutput * getOutputVoltageMultiplier()
    }

    override fun getAngularPosition(): AngularDistanceMeasureRevolutions {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setAngularPosition(angle: AngularDistanceMeasureRevolutions) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAngularVelocity(): AngularVelocityMeasureRevolutionsPerSecond {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOutputCurrent(): Double {
        return device.outputCurrent
    }

    override fun setAngularPositionSetpoint(setpoint: AngularDistanceMeasureRevolutions, ffVolts: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setAngularVelocitySetpoint(setpoint: AngularVelocityMeasureRevolutionsPerSecond, ffVolts: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}