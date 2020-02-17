package org.snakeskin.component

import org.snakeskin.component.provider.IFollowProvider
import org.snakeskin.component.provider.IInvertableInputProvider
import org.snakeskin.component.provider.IInvertableOutputProvider
import org.snakeskin.component.provider.IPercentOutputMotorControlProvider
import org.snakeskin.measure.MeasureUnitless
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRevolutions
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRevolutionsPerSecond

/**
 * Represents a gearbox.  A gearbox combines a coupled motor group with a feedback sensor.
 */
open class Gearbox: IPercentOutputMotorControlProvider, IAngularPositionVelocitySensorComponent, IInvertableOutputProvider, IInvertableInputProvider {
    private val motorGroup: CoupledMotorGroup
    private val sensor: IAngularPositionVelocitySensorComponent

    /**
     * The total gearing ratio between the sensor and the output.  Sensor readings are divided by this value.
     *
     * This value is stored as a unitless measure to make it easier to work with when dividing measured values
     */
    val ratioToSensor: MeasureUnitless

    /**
     * Creates an angular gearbox from a series of direct motor controllers and a sensor
     * @param ratioToSensor The total gearing ratio between the sensor and the output.  Sensor readings are divided by this value.
     * @param sensor The sensor component to use
     * @param directControllers The series of direct motor controllers
     */
    constructor(sensor: IAngularPositionVelocitySensorComponent, vararg directControllers: IMotorControllerDirectComponent, ratioToSensor: Double = 1.0) {
        motorGroup = CoupledMotorGroup(*directControllers)
        this.sensor = sensor
        this.ratioToSensor = MeasureUnitless(ratioToSensor)
    }

    /**
     * Creates an angular gearbox from a master motor controller, a series of slave motor controllers, and a sensor
     * @param ratioToSensor The total gearing ratio between the sensor and the output.  Sensor readings are divided by this value.
     * @param sensor The sensor component to use
     * @param master The master motor controller
     * @param slaves The series of slave motor controllers
     */
    constructor(sensor: IAngularPositionVelocitySensorComponent, master: IMotorControllerEnhancedComponent, vararg slaves: IMotorControllerEnhancedComponent, ratioToSensor: Double = 1.0) {
        motorGroup = CoupledMotorGroup(master, *slaves)
        this.sensor = sensor
        this.ratioToSensor = MeasureUnitless(ratioToSensor)
    }

    /**
     * Creates an angular gearbox from a smart master motor controller, and a series of slave motor controllers.
     * The master controller also functions as the sensor in this configuration.
     *
     * @param ratioToSensor The total gearing ratio between the sensor and the output.  Sensor readings are divided by this value.
     * @param master The master motor controller, which also doubles as the sensor
     * @param slaves The series of slave motor controllers
     */
    constructor(master: IMotorControllerSmartComponent, vararg slaves: IMotorControllerEnhancedComponent, ratioToSensor: Double = 1.0) {
        motorGroup = CoupledMotorGroup(master, *slaves)
        this.sensor = master
        this.ratioToSensor = MeasureUnitless(ratioToSensor)
    }

    //Motor control
    override fun getOutputVoltage() = motorGroup.getOutputVoltage()
    override fun getPercentOutput() = motorGroup.getPercentOutput()
    override fun setPercentOutput(percentOut: Double) = motorGroup.setPercentOutput(percentOut)
    override fun stop() = motorGroup.stop()

    //Sensor
    override fun getAngularPosition(): AngularDistanceMeasureRevolutions {
        return sensor.getAngularPosition() / ratioToSensor
    }

    override fun getAngularVelocity(): AngularVelocityMeasureRevolutionsPerSecond {
        return sensor.getAngularVelocity() / ratioToSensor
    }

    override fun setAngularPosition(angle: AngularDistanceMeasureRevolutions) {
        sensor.setAngularPosition(angle * ratioToSensor)
    }

    override fun invertOutput(invert: Boolean) {
        motorGroup.invertOutput(invert)
    }

    override fun invertInput(invert: Boolean) {
        sensor.invertInput(invert)
    }

    /**
     * If this gearbox is a master-slave gearbox, this method links the slaves to the master
     * If this gearbox is a direct gearbox, this method does nothing
     */
    fun couple() {
        motorGroup.couple()
    }

    /**
     * If this gearbox is a master-slave gearbox, this method decouples the slaves from the master
     * If this gearbox is a direct gearbox, this method does nothing
     */
    fun decouple() {
        motorGroup.decouple()
    }
}