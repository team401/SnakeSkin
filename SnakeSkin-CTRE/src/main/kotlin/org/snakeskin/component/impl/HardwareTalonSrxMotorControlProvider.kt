package org.snakeskin.component.impl

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.DemandType
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import org.snakeskin.component.ITalonSrxMotorControllerSmart
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureDegrees
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRadians
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRevolutions
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRadiansPerSecond
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRevolutionsPerHundredMilliseconds

class HardwareTalonSrxMotorControlProvider(val talon: TalonSRX, val sensorTicksPerRev: Double = 4096.0) : ITalonSrxMotorControllerSmart {
    override fun setPercentOutput(percentOut: Double) {
        talon.set(ControlMode.PercentOutput, percentOut)
    }

    override fun getPercentOutput(): Double {
        return talon.motorOutputPercent
    }

    override fun getInputVoltage(): Double {
        return talon.busVoltage
    }

    override fun getOutputVoltage(): Double {
        return talon.motorOutputVoltage
    }

    override fun stop() {
        setPercentOutput(0.0)
    }

    override fun getRotationalPosition(): AngularDistanceMeasureDegrees {
        return AngularDistanceMeasureRevolutions(talon.selectedSensorPosition / sensorTicksPerRev).toDegrees()
    }

    override fun setRotationalPosition(angle: AngularDistanceMeasureRadians) {
        talon.selectedSensorPosition = (angle.toRevolutions().value * sensorTicksPerRev).toInt()
    }

    override fun getRotationalVelocity(): AngularVelocityMeasureRadiansPerSecond {
        return AngularVelocityMeasureRevolutionsPerHundredMilliseconds(talon.selectedSensorVelocity / sensorTicksPerRev).toRadiansPerSecond()
    }

    override fun setAngularPositionSetpoint(setpoint: AngularDistanceMeasureRadians, ffVolts: Double) {
        //TODO ffVolts needs to be converted to a percent from vbus.  For now, we'll just scale out of 12
        val pOut = ffVolts / 12.0
        talon.set(ControlMode.Position, setpoint.toRevolutions().value * sensorTicksPerRev, DemandType.ArbitraryFeedForward, pOut)
    }

    override fun setAngularVelocitySetpoint(setpoint: AngularVelocityMeasureRadiansPerSecond, ffVolts: Double) {
        //TODO see above
        val pOut = ffVolts / 12.0
        talon.set(ControlMode.Velocity, setpoint.toRevolutionsPerHundredMilliseconds().value * sensorTicksPerRev, DemandType.ArbitraryFeedForward, pOut)
    }
}