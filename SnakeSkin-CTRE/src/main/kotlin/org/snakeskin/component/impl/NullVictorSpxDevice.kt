package org.snakeskin.component.impl

import org.snakeskin.component.IVictorSpxDevice
import org.snakeskin.component.provider.IFollowableProvider

/**
 * No-op implementation of the Victor SPX
 */
open class NullVictorSpxDevice private constructor(): IVictorSpxDevice {
    companion object {
        val INSTANCE = NullVictorSpxDevice()
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

    override fun invertOutput(invert: Boolean) {
        //no-op
    }
}