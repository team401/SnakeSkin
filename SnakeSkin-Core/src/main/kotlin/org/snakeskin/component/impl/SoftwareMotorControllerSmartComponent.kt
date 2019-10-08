package org.snakeskin.component.impl

import org.snakeskin.component.IAngularPositionVelocitySensorComponent
import org.snakeskin.component.IMotorControllerEnhancedComponent
import org.snakeskin.component.IMotorControllerSmartComponent
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRevolutions
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRevolutionsPerSecond

class SoftwareMotorControllerSmartComponent : IMotorControllerSmartComponent,
        IMotorControllerEnhancedComponent by SoftwareMotorControllerEnhancedComponent(),
        IAngularPositionVelocitySensorComponent by SoftwareAngularPositionVelocitySensorComponent() {
    override fun getOutputCurrent(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setAngularPositionSetpoint(setpoint: AngularDistanceMeasureRevolutions, ffVolts: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setAngularVelocitySetpoint(setpoint: AngularVelocityMeasureRevolutionsPerSecond, ffVolts: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}