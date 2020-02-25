package org.snakeskin.component.impl

import org.snakeskin.component.ITalonSrxDevice
import org.snakeskin.component.provider.IFollowableProvider
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRadians
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRadiansPerSecond

/**
 * No-op implementation of the Talon SRX
 */
open class NullTalonSrxDevice private constructor(): ITalonSrxDevice {
    companion object {
        val INSTANCE = NullTalonSrxDevice()
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

    override fun getAngularPosition(): AngularDistanceMeasureRadians {
        return AngularDistanceMeasureRadians(0.0)
    }

    override fun setAngularPosition(angle: AngularDistanceMeasureRadians) {
        //no-op
    }

    override fun getAngularVelocity(): AngularVelocityMeasureRadiansPerSecond {
        return AngularVelocityMeasureRadiansPerSecond(0.0)
    }

    override fun getOutputCurrent(): Double {
        return 0.0
    }

    override fun setAngularPositionSetpoint(setpoint: AngularDistanceMeasureRadians, ffVolts: Double) {
        //no-op
    }

    override fun setAngularVelocitySetpoint(setpoint: AngularVelocityMeasureRadiansPerSecond, ffVolts: Double) {
        //no-op
    }

    override fun setProfiledSetpoint(setpoint: AngularDistanceMeasureRadians, ffVolts: Double) {
        //no-op
    }

    override fun invertInput(invert: Boolean) {
        //no-op
    }

    override fun invert(invert: Boolean) {
        //no-op
    }
}