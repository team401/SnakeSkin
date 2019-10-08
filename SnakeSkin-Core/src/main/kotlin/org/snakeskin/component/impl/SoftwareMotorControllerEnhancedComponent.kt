package org.snakeskin.component.impl

import org.snakeskin.component.IMotorControllerEnhancedComponent
import org.snakeskin.component.provider.IFollowableProvider

class SoftwareMotorControllerEnhancedComponent : IMotorControllerEnhancedComponent {
    override fun follow(master: IFollowableProvider) {
        //no-op
    }

    override fun setPercentOutput(percentOut: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPercentOutput(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getInputVoltage(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOutputVoltage(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}