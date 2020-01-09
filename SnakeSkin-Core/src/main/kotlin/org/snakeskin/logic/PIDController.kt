package org.snakeskin.logic

import org.snakeskin.utility.value.AsyncDouble
import kotlin.math.abs

/**
 * @author Cameron Earle
 * @version 12/23/2017
 *
 * This is an adapted version of CTRE's PID controller.  The implementation is subject to change,
 * however the API will remain the same.  This class is fully thread safe
 */
@Deprecated("Implementation is overly complex.  Consider using WPILib's options.")
class PIDController(p: Double = 0.0,
                    i: Double = 0.0,
                    d: Double = 0.0,
                    f: Double = 0.0,
                    allowedError: Double = 0.0,
                    iMagnitude: Double = Double.MAX_VALUE,
                    iZone: Double = Double.MAX_VALUE,
                    outMagnitude: Double = 1.0) {

    //Proportional, integral, derivative, and feedforward gains
    var p: Double by AsyncDouble(p)
    var i: Double by AsyncDouble(i)
    var d: Double by AsyncDouble(d)
    var f: Double by AsyncDouble(f)

    var allowedError: Double by AsyncDouble(allowedError) //Acceptable error (aka tolerance) for the controller.

    var iMagnitude: Double by AsyncDouble(iMagnitude) //Maximum allowed output magnitude from integral term
    var iZone: Double by AsyncDouble(iZone) //Range around setpoint where integral accumulator should be active. Only takes positive range values.

    var outMagnitude: Double by AsyncDouble(outMagnitude) //Maximum allowed output magnitude from the controller

    var setpoint: Double by AsyncDouble(setpoint)
    var output: Double by AsyncDouble(0.0)
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
        iAccum = if (abs(error) > iZone) 0.0 else iAccum

        out = (p * error) + iAccum + (d * (error - prevError)) + f

        prevError = error

        if (abs(error) > allowedError) {
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

    @Synchronized fun atSetpoint() = abs(error) < allowedError

    @Synchronized fun reset() {
        resetIAccum()
        output = 0.0
        prevError = 0.0
        error = 0.0
        out = 0.0
    }

    fun update(newValue: Double){
        pid(newValue)
    }
}