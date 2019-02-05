package org.snakeskin.component

import org.snakeskin.template.PIDFTemplate

/**
 * @author Cameron Earle
 * @version 2/3/2019
 *
 * Represents a "smart" gearbox.  A smart gearbox is generally comprised of motor controllers on the CAN bus, as to allow
 * two way communications.  It is comprised of a master and multiple slaves, and it has a sensor.
 *
 * Some common functions include configuring brake/coast mode, configuring current limits, setting a deadband, etc.
 */
interface ISmartGearbox<T>: ISensoredGearbox {
    /**
     * Common neutral behavior enumerations.
     *
     * @property BRAKE A motor controller in BRAKE mode should shunt the output channels to stop the motor quickly
     * @property COAST A motor controller in COAST mode should leave the output channels open to let the motor coast to a stop
     */
    enum class CommonNeutralMode {
        BRAKE,
        COAST
    }

    /**
     * Common control modes between motor controllers.  Note that not all motor controllers support all of these
     * functions, so some may not be implemented.
     *
     * @property PERCENTAGE A percentage output of the voltage bus.  This is an open loop control mode
     * @property POSITION A position to go to.  This is a closed loop control mode.
     * @property VELOCITY A velocity to target.  This is a closed loop control mode.
     */
    enum class CommonControlMode {
        PERCENTAGE,
        POSITION,
        VELOCITY
    }

    /**
     * Sets the neutral mode of the gearbox.  This configures the setting on ALL attached motor controllers
     *
     * @return false if there was an error
     */
    fun setNeutralMode(mode: CommonNeutralMode): Boolean

    /**
     * Sets the ramp rate of the gearbox.  The ramp rate is the number of seconds it should take to go from 0.0 to 1.0
     * output given an instantaneous change in setpoint.  Essentially smooths out the output of the motor.
     * Note that this configures the ramp rate for both open and closed loop control modes.
     *
     * @return false if there was an error
     */
    fun setRampRate(secondsFromNeutralToFull: Double): Boolean

    /**
     * Sets the neutral deadband, or in other words the percentage on either side of zero to ignore.
     * Note that this implementation will configure the deadband for both open and closed loop control modes.
     *
     * @return false if there was an error
     */
    fun setDeadband(deadbandPercent: Double): Boolean

    /**
     * Sets the setpoint of the gearbox with the given control mode.
     *
     * In position mode, the setpoint should be in radians (as measured by the sensor)
     * In velocity mode, the setpoint should be in radians per second (as measured by the sensor)
     */
    fun set(controlMode: CommonControlMode, setpoint: Double)

    /**
     * Sets the setpoint of the gearbox with the given control mode and arbitrary feed forward.
     *
     * The arbitrary feed forward should be in volts, with a maximum value of 12.0
     *
     * In position mode, the setpoint should be in radians (as measured by the sensor)
     * In velocity mode, the setpoint should be in radians per second (as measured by the sensor)
     */
    fun set(controlMode: CommonControlMode, setpoint: Double, arbFF: Double)

    /**
     * Gets the current battery voltage ("vbus") in volts, as read by the master
     */
    fun getMasterVbus(): Double

    /**
     * Gets the current "percent vbus" output of the motor controller.  In other words, the percentage of the battery
     * voltage that is being applied to the motor.  -1.0 < x < 1.0
     */
    fun getOutputPercent(): Double

    /**
     * Gets the output voltage of the gearbox, in volts
     */
    fun getOutputVoltage(): Double

    /**
     * Gets the output current of the master of the gearbox, in amps
     */
    fun getMasterOutputCurrent(): Double

    /**
     * Configures the PIDF gains into the specified slot
     *
     * @return false if there was an error
     */
    fun setPIDF(kP: Double = 0.0, kI: Double = 0.0, kD: Double = 0.0, kF: Double = 0.0, slot: Int = 0): Boolean

    /**
     * Configures the PIDF template into the specified slot
     *
     * @return false if there was an error
     */
    fun setPIDF(template: PIDFTemplate, slot: Int = 0): Boolean
}