package org.snakeskin.component.impl

import org.snakeskin.component.ITalonFxDevice
import org.snakeskin.component.provider.IFollowableProvider
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRevolutions
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRevolutionsPerSecond

/**
 * No-op implementation of the Talon FX
 */
open class NullTalonFxDevice private constructor(): ITalonFxDevice {
    companion object {
        val INSTANCE = NullTalonFxDevice()
        val producer = { INSTANCE }
    }

    override fun follow(master: IFollowableProvider) {
        //no-op
    }

    override fun unfollow() {
        //no-op
    }

    override fun getInputVoltage(): Double {
        return 0.0
    }

    override fun setPercentOutput(percentOut: Double) {
        //no-op
    }

    override fun getPercentOutput(): Double {
        return 0.0
    }

    override fun stop() {
        //no-op
    }

    override fun getOutputVoltage(): Double {
        return 0.0
    }

    override fun getAngularPosition(): AngularDistanceMeasureRevolutions {
        return AngularDistanceMeasureRevolutions(0.0)
    }

    override fun setAngularPosition(angle: AngularDistanceMeasureRevolutions) {
        //no-op
    }

    override fun getAngularVelocity(): AngularVelocityMeasureRevolutionsPerSecond {
        return AngularVelocityMeasureRevolutionsPerSecond(0.0)
    }

    override fun getOutputCurrent(): Double {
        return 0.0
    }

    override fun setAngularPositionSetpoint(setpoint: AngularDistanceMeasureRevolutions, ffVolts: Double) {
        //no-op
    }

    override fun setAngularVelocitySetpoint(setpoint: AngularVelocityMeasureRevolutionsPerSecond, ffVolts: Double) {
        //no-op
    }

    override fun setProfiledSetpoint(setpoint: AngularDistanceMeasureRevolutions, ffVolts: Double) {
        //no-op
    }
}