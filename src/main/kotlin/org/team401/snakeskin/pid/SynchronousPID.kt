package org.team401.snakeskin.pid

/*
 * SnakeSkin - Created on 5/22/17
 * Author: Zachary Kozar
 *
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

import edu.wpi.first.wpilibj.util.BoundaryException

/**
 * @author Zachary Kozar
 *
 * @version 5/22/17
 *
 * This class implements a PID Control Loop.
 *
 * Does all computation synchronously (i.e. the calculate() function must be
 * called by the user from his own thread)
 */
class SynchronousPID(var p: Double, var i: Double, var d: Double) {

    private var maximumOutput = 1.0
    private var minimumOutput = -1.0
    private var maximumInput = 0.0
    private var minimumInput = 0.0

    // the prior sensor input (used to compute velocity)
    private var prevError = 0.0
    // the sum of the errors for use in the integral calc
    private var totalError = 0.0

    private var setpoint = 0.0

    var error = 0.0
        private set
    var result = 0.0
        private set

    private var lastInput = Double.NaN
    private var deadband = 0.0 // If the absolute error is less than deadband, treat error for proportional term as 0

    private var continuous = false // do the endpoints wrap around? eg. Absolute encoder

    /**
     * Read the input, calculate the output accordingly, and write to the
     * output. This should be called at a constant rate by the user (ex. in a
     * timed thread)
     *
     * @param input the input
     */
    fun calculate(input: Double): Double {
        lastInput = input
        error = setpoint - input
        if (continuous)
            if (Math.abs(error) > (maximumInput - minimumInput) / 2)
                error += (if ((maximumInput - minimumInput) * error > 0) -1 else 1).toDouble()

        totalError += if (error * p < maximumOutput && error * p > minimumOutput) error else 0.0

        // Don't blow away m_error so as to not break derivative
        val proportionalError = if (Math.abs(error) < deadband) 0.0 else error

        result = p * proportionalError + i * totalError + d * (error - prevError)
        prevError = error

        if (result > maximumOutput)
            result = maximumOutput
        else if (result < minimumOutput)
            result = minimumOutput

        return result
    }

    /**
     * Set the PID controller gain parameters. Set the proportional, integral,
     * and differential coefficients.
     *
     * @param p Proportional coefficient
     * @param i Integral coefficient
     * @param d Differential coefficient
     */
    fun setPID(p: Double, i: Double, d: Double) {
        this.p = p
        this.i = i
        this.d = d
    }

    /**
     * Set the PID controller to consider the input to be continuous, Rather
     * then using the max and min in as constraints, it considers them to be the
     * same point and automatically calculates the shortest route to the
     * setpoint.
     *
     * @param continuous Set to true turns on continuous, false turns off continuous
     */
    fun setContinuous(continuous: Boolean) {
        this.continuous = continuous
    }

    fun setDeadband(deadband: Double) {
        this.deadband = deadband
    }

    /**
     * Set the PID controller to consider the input to be continuous, Rather
     * then using the max and min in as constraints, it considers them to be the
     * same point and automatically calculates the shortest route to the
     * setpoint.
     */
    fun setContinuous() {
        this.setContinuous(true)
    }

    /**
     * Sets the maximum and minimum values expected from the input.
     *
     * @param minimumInput the minimum value expected from the input
     * @param maximumInput the maximum value expected from the output
     */
    fun setInputRange(minimumInput: Double, maximumInput: Double) {
        if (minimumInput > maximumInput)
            throw BoundaryException("Lower bound is greater than upper bound")

        this.minimumInput = minimumInput
        this.maximumInput = maximumInput
        setSetpoint(setpoint)
    }

    /**
     * Sets the minimum and maximum values to write.
     * @param minimumOutput the minimum value to write to the output
     * @param maximumOutput the maximum value to write to the output
     */
    fun setOutputRange(minimumOutput: Double, maximumOutput: Double) {
        if (minimumOutput > maximumOutput)
            throw BoundaryException("Lower bound is greater than upper bound")

        this.minimumOutput = minimumOutput
        this.maximumOutput = maximumOutput
    }

    /**
     * Set the setpoint for the PID controller
     * @param setpoint the desired setpoint
     */
    fun setSetpoint(setpoint: Double) {
        if (maximumInput > minimumInput)
            if (setpoint > maximumInput)
                this.setpoint = maximumInput
            else if (setpoint < minimumInput)
                this.setpoint = minimumInput
            else
                this.setpoint = setpoint
        else
            this.setpoint = setpoint
    }

    /**
     * Getters for setpoint and error between sensor data and setpoint
     */
    fun getSetpoint(): Double {
        return setpoint
    }

    /**
     * Return true if the error is within the tolerance
     *
     * @return true if the error is less than the tolerance
     */
    fun onTarget(tolerance: Double): Boolean {
        return lastInput != Double.NaN && Math.abs(lastInput - setpoint) < tolerance
    }

    /**
     * Reset all internal terms.
     */
    fun reset() {
        lastInput = Double.NaN
        prevError = 0.0
        totalError = 0.0
        result = 0.0
        setpoint = 0.0
    }

    fun resetIntegrator() {
        totalError = 0.0
    }
}