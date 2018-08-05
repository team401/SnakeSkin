package org.snakeskin.units

import org.snakeskin.units.measure.distance.angular.AngularDistanceMeasureCTREMagEncoder
import org.snakeskin.units.measure.time.TimeMeasure100Ms
import org.snakeskin.units.measure.velocity.angular.AngularVelocityMeasureCTREMagEncoder

/**
 * @author Cameron Earle
 * @version 8/5/18
 */
val MagEncoderTicks = AngularDistanceUnitCTREMagEncoder
val Number.MagEncoderTicks
    get() = AngularDistanceMeasureCTREMagEncoder(this.toDouble())

val OneHundredMilliseconds = TimeUnit100Ms
val Number.OneHundredMilliseconds
    get() = TimeMeasure100Ms(this.toDouble())

val MagEncoderTicksPer100Ms = AngularVelocityUnitCTREMagEncoder
val Number.MagEncoderTicksPer100Ms
    get() = AngularVelocityMeasureCTREMagEncoder(this.toDouble())