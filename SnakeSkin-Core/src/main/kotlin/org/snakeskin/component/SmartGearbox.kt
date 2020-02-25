package org.snakeskin.component

import org.snakeskin.component.provider.IAngularPositionMotorControlProvider
import org.snakeskin.component.provider.IAngularProfileMotorControlProvider
import org.snakeskin.component.provider.IAngularVelocityMotorControlProvider
import org.snakeskin.component.provider.IFollowProvider
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRadians
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRevolutions
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRadiansPerSecond
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRevolutionsPerSecond

/**
 * Represents a gearbox with "servo" capabilities, meaning it can accept position or velocity commands.
 * Specifically, the hardware comprising the gearbox must be able to accept these commands.  This implies a
 * smart master controller with an attached sensor
 *
 * @param master The master motor controller, which also provides the sensor
 * @param slaves The series of slave motor controllers
 * @param ratioToSensor The gearing ratio between the sensor and the output.  Commanded values will be multiplied by this value, and readings will be divided.
 */
class SmartGearbox(private val master: IMotorControllerSmartComponent,
                   vararg slaves: IMotorControllerEnhancedComponent,
                   ratioToSensor: Double = 1.0) :
        Gearbox(master, *slaves, ratioToSensor = ratioToSensor),
        IAngularPositionMotorControlProvider,
        IAngularVelocityMotorControlProvider,
        IAngularProfileMotorControlProvider
{
    //Closed loop
    override fun setAngularPositionSetpoint(setpoint: AngularDistanceMeasureRadians, ffVolts: Double) {
        master.setAngularPositionSetpoint(setpoint * ratioToSensor, ffVolts)
    }

    override fun setAngularVelocitySetpoint(setpoint: AngularVelocityMeasureRadiansPerSecond, ffVolts: Double) {
        master.setAngularVelocitySetpoint(setpoint * ratioToSensor, ffVolts)
    }

    override fun setProfiledSetpoint(setpoint: AngularDistanceMeasureRadians, ffVolts: Double) {
        master.setProfiledSetpoint(setpoint * ratioToSensor, ffVolts)
    }
}