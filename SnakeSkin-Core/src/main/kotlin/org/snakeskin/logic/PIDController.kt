package org.snakeskin.logic

import org.snakeskin.ability.AUpdatable

/*
 * snakeskin - Created on 12/23/2017
 * Author: Preston Childress
 *
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Preston Childress
 * @version 12/23/2017
 */

/**
 * This is an adapted version of CTRE's PID controller.  The implementation is subject to change,
 * however the API will remain the same.  This class is fully thread safe
 */
class PIDController(p: Double = 0.0,
                    i: Double = 0.0,
                    d: Double = 0.0,
                    f: Double = 0.0,
                    allowedError: Double = 0.0,
                    iMagnitude: Double = Double.MAX_VALUE,
                    iZone: Double = Double.MAX_VALUE,
                    outMagnitude: Double = 1.0): AUpdatable<Double> {

    //Proportional, integral, derivative, and feedforward gains
    var p: Double by LockingDelegate(p)
    var i: Double by LockingDelegate(i)
    var d: Double by LockingDelegate(d)
    var f: Double by LockingDelegate(f)

    var allowedError: Double by LockingDelegate(allowedError) //Acceptable error (aka tolerance) for the controller.

    var iMagnitude: Double by LockingDelegate(iMagnitude) //Maximum allowed output magnitude from integral term
    var iZone: Double by LockingDelegate(iZone) //Range around setpoint where integral accumulator should be active. Only takes positive range values.

    var outMagnitude: Double by LockingDelegate(outMagnitude) //Maximum allowed output magnitude from the controller

    var setpoint: Double by LockingDelegate(setpoint)
    var output: Double by LockingDelegate(0.0)
        private set

    private var iAccum = 0.0
    private var prevError = 0.0
    private var error = 0.0
    private var out = 0.0

    @Synchronized fun pid(input: Double): Double {
        error = setpoint - input
        iAccum += i * error
        iAccum = if (iAccum > iMagnitude) iMagnitude else iAccum
        iAccum = if (iAccum < -iMagnitude) -iMagnitude else iAccum
        iAccum = if (Math.abs(error) > iZone) 0.0 else iAccum

        out = (p * error) + iAccum + (d * (error - prevError)) + f

        prevError = error

        if (Math.abs(error) > allowedError) {
            if (out > outMagnitude) out = outMagnitude
            if (out < -outMagnitude) out = -outMagnitude
        } else {
            out = 0.0
        }
        output = out
        return out
    }

    @Synchronized fun resetIAccum() {
        iAccum = 0.0
    }

    @Synchronized fun atSetpoint() = Math.abs(error) < allowedError

    @Synchronized fun reset() {
        resetIAccum()
        output = 0.0
        prevError = 0.0
        error = 0.0
        out = 0.0
    }

    override fun update(newValue: Double){
        pid(newValue)
    }
}