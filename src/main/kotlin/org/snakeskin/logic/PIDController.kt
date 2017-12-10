package org.snakeskin.logic

import org.snakeskin.ability.AUpdatable

/*
 * snakeskin - Created on 12/2/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 12/2/17
 */

/**
 * This class is based on the 'SynchronousPID' class written by FRC Team 254 (The Cheesy Poofs)
 * Several modifications are made here to make it compatible with certain features of Kotlin
 * such as default parameters and property access syntax.  It is also fully thread-safe.
 */
class PIDController(p: Double = 0.0, i: Double = 0.0, d: Double = 0.0, f: Double = 0.0): AUpdatable<Double> {
    private val pLock = Any()
    var p = 0.0
        get() = synchronized(pLock) {field}
        set(value) = synchronized(pLock) {field = value}

    private val iLock = Any()
    var i = 0.0
        get() = synchronized(iLock) {field}
        set(value) = synchronized(iLock) {field = value}

    private val dLock = Any()
    var d = 0.0
        get() = synchronized(dLock) {field}
        set(value) = synchronized(dLock) {field = value}

    private val fLock = Any()
    var f = 0.0
        get() = synchronized(fLock) {field}
        set(value) = synchronized(fLock) {field = value}

    init {
        this.p = p
        this.i = i
        this.d = d
        this.f = f
    }

    private val minimumInputLock = Any()
    var minimumInput = -1.0
        get() = synchronized(minimumInputLock) {field}
        set(value) = synchronized(minimumInputLock) {field = value}

    private val maximumInputLock = Any()
    var maximumInput = 1.0
        get() = synchronized(maximumInputLock) {field}
        set(value) = synchronized(maximumInputLock) {field = value}

    private val minimumOutputLock = Any()
    var minimumOutput = -1.0
        get() = synchronized(minimumOutputLock) {field}
        set(value) = synchronized(minimumOutputLock) {field = value}

    private val maximumOutputLock = Any()
    var maximumOutput = 1.0
        get() = synchronized(maximumOutputLock) {field}
        set(value) = synchronized(maximumOutputLock) {field = value}

    private val prevErrorLock = Any()
    private var prevError = 0.0
        get() = synchronized(prevErrorLock) {field}
        set(value) = synchronized(prevErrorLock) {field = value}

    private val totalErrorLock = Any()
    private var totalError = 0.0
        get() = synchronized(totalErrorLock) {field}
        set(value) = synchronized(totalErrorLock) {field = value}

    private val setpointLock = Any()
    var setpoint = 0.0
        get() = synchronized(setpointLock) {field}
        set(value) {
            synchronized(setpointLock) {
                val curMinimumInput = minimumInput
                val curMaximumInput = maximumInput
                if (curMaximumInput > curMinimumInput) {
                    if (value > curMaximumInput) {
                        field = curMaximumInput
                    } else if (value < curMinimumInput) {
                        field = curMinimumInput
                    } else {
                        field = value
                    }
                } else {
                    field = value
                }
            }
        }

    private val errorLock = Any()
    var error = 0.0
        get() = synchronized(errorLock) {field}
        private set(value) = synchronized(errorLock) {field = value}

    private val resultLock = Any()
    var result = 0.0
        get() = synchronized(resultLock) {field}
        private set(value) = synchronized(resultLock) {field = value}

    private val lastInputLock = Any()
    private var lastInput = Double.NaN
        get() = synchronized(lastInputLock) {field}
        set(value) = synchronized(lastInputLock) {field = value}

    private val deadbandLock = Any()
    var deadband = 0.0
        get() = synchronized(deadbandLock) {field}
        set(value) = synchronized(deadbandLock) {field = value}

    private val continuousLock = Any()
    var continuous = false
        get() = synchronized(continuousLock) {field}
        set(value) = synchronized(continuousLock) {field = value}

    fun pid(input: Double): Double {
        //Grab current values for each of our thread-safe variables
        val curP = p
        val curI = i
        val curD = d
        val curF = f
        val curMinimumInput = minimumInput
        val curMaximumInput = maximumInput
        val curMinimumOutput = minimumOutput
        val curMaximumOutput = maximumOutput
        val curSetpoint = setpoint
        val curContinuous = continuous
        val curDeadband = deadband
        val curPrevError = prevError
        var curTotalError = totalError
        var curError = curSetpoint - input
        var curResult: Double

        error = curError //UPDATE error
        lastInput = input

        if (curContinuous) {
            if (Math.abs(curError) > (curMaximumInput - curMinimumInput) / 2) {
                curError += (if ((curMaximumInput - curMinimumInput) * curError > 0) -1 else 1).toDouble()
                error = curError //UPDATE error
            }
        }

        curTotalError += if (curError * curP < curMaximumOutput && curError * curP > curMinimumOutput) curError else 0.0
        totalError = curTotalError //UPDATE totalError

        val proportionalError = if (Math.abs(curError) < curDeadband) 0.0 else curError

        curResult = curP * proportionalError + curI * curTotalError + curD * (curError - curPrevError)
        curResult += curF
        prevError = curError

        if (curResult > maximumOutput)
            curResult = maximumOutput
        else if (curResult < minimumOutput)
            curResult = minimumOutput

        result = curResult //UPDATE result

        return result
    }

    override fun update(newValue: Double) {
        pid(newValue)
    }

    fun onTarget(tolerance: Double): Boolean {
        val curLastInput = lastInput
        val curSetpoint = setpoint

        return curLastInput != Double.NaN && Math.abs(curLastInput - curSetpoint) < tolerance
    }

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