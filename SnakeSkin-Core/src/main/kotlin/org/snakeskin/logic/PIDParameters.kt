package org.snakeskin.logic

/**
 * @author Cameron Earle
 * @version 12/26/17
 */
@Deprecated("Implementation is overly complex.  Consider using WPILib's options.")
class PIDParameters(val p: Double = 0.0,
                    val i: Double = 0.0,
                    val d: Double = 0.0,
                    val f: Double = 0.0,
                    val allowedError: Double = 0.0,
                    val iMagnitude: Double = Double.MAX_VALUE,
                    val iZone: Double = Double.MAX_VALUE,
                    val outMagnitude: Double = 1.0) {

    fun createController() = PIDController(p, i, d, f, allowedError, iMagnitude, iZone, outMagnitude)
}