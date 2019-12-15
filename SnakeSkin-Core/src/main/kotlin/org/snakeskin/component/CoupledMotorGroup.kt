package org.snakeskin.component

import org.snakeskin.component.provider.IFollowProvider
import org.snakeskin.component.provider.IPercentOutputMotorControlProvider

/**
 * A group of motors that are mechanically coupled in some way.  This class only serves to group motor controllers
 * together, and thus only provides basic functionality
 */
class CoupledMotorGroup: IPercentOutputMotorControlProvider {
    private class DirectControlProvider(val controllers: Array<out IMotorControllerDirectComponent>): IPercentOutputMotorControlProvider {
        override fun getOutputVoltage(): Double {
            return controllers[0].getOutputVoltage()
        }

        override fun getPercentOutput(): Double {
            return controllers[0].getPercentOutput()
        }

        override fun setPercentOutput(percentOut: Double) {
            controllers.forEach {
                it.setPercentOutput(percentOut)
            }
        }

        override fun stop() {
            controllers.forEach {
                it.stop()
            }
        }
    }

    private class MasterSlaveControlProvider(val master: IMotorControllerEnhancedComponent, val slaves: Array<out IFollowProvider>): IPercentOutputMotorControlProvider {
        fun couple() {
            slaves.forEach {
                it.follow(master)
            }
        }

        fun decouple() {
            slaves.forEach {
                it.unfollow()
            }
        }

        override fun getOutputVoltage(): Double {
            return master.getOutputVoltage()
        }

        override fun getPercentOutput(): Double {
            return master.getPercentOutput()
        }

        override fun setPercentOutput(percentOut: Double) {
            master.setPercentOutput(percentOut)
        }

        override fun stop() {
            master.stop()
        }
    }

    private val controlProvider: IPercentOutputMotorControlProvider

    /**
     * Creates an angular gearbox from a series of direct motor controllers
     */
    constructor(vararg directControllers: IMotorControllerDirectComponent) {
        controlProvider = DirectControlProvider(directControllers)
    }

    /**
     * Creates an angular gearbox from a master motor controller and a series of slave motor controllers
     * Additionally, couples the gearbox at the time of creation
     */
    constructor(master: IMotorControllerEnhancedComponent, vararg slaves: IFollowProvider) {
        controlProvider = MasterSlaveControlProvider(master, slaves)
        controlProvider.couple()
    }

    override fun getOutputVoltage() = controlProvider.getOutputVoltage()
    override fun getPercentOutput() = controlProvider.getPercentOutput()
    override fun setPercentOutput(percentOut: Double) = controlProvider.setPercentOutput(percentOut)
    override fun stop() = controlProvider.stop()

    /**
     * If this gearbox is a master-slave gearbox, this method links the slaves to the master
     * If this gearbox is a direct gearbox, this method does nothing
     */
    fun couple() {
        if (controlProvider is MasterSlaveControlProvider) {
            controlProvider.couple()
        }
    }

    /**
     * If this gearbox is a master-slave gearbox, this method decouples the slaves from the master
     * If this gearbox is a direct gearbox, this method does nothing
     */
    fun decouple() {
        if (controlProvider is MasterSlaveControlProvider) {
            controlProvider.decouple()
        }
    }
}