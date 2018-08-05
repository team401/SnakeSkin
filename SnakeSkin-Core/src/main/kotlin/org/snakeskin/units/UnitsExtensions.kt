package org.snakeskin.units

import org.snakeskin.units.measure.distance.angular.*
import org.snakeskin.units.measure.distance.linear.*
import org.snakeskin.units.measure.time.*
import org.snakeskin.units.measure.velocity.angular.*
import org.snakeskin.units.measure.velocity.linear.*

/**
 * @author Cameron Earle
 * @version 8/5/18
 *
 * Extensions for providing easy use of units with the following syntax
 *
 * val someVal = 1.23.Inches
 * val otherVal = someVal toUnit Centimeters
 */
//Angular distance
val Degrees = AngularDistanceUnit.Standard.DEGREES
val Number.Degrees
    get() = AngularDistanceMeasureDegrees(this.toDouble())

val Radians = AngularDistanceUnit.Standard.RADIANS
val Number.Radians
    get() = AngularDistanceMeasureRadians(this.toDouble())

val Revolutions = AngularDistanceUnit.Standard.REVOLUTIONS
val Number.Revolutions
    get() = AngularDistanceMeasureRevolutions(this.toDouble())


//Linear distance
val Centimeters = LinearDistanceUnit.Standard.CENTIMETERS
val Number.Centimeters
    get() = LinearDistanceMeasureCentimeters(this.toDouble())

val Feet = LinearDistanceUnit.Standard.FEET
val Number.Feet
    get() = LinearDistanceMeasureFeet(this.toDouble())

val Inches = LinearDistanceUnit.Standard.INCHES
val Number.Inches
    get() = LinearDistanceMeasureInches(this.toDouble())

val Meters = LinearDistanceUnit.Standard.METERS
val Number.Meters
    get() = LinearDistanceMeasureMeters(this.toDouble())

val Miles = LinearDistanceUnit.Standard.MILES
val Number.Miles
    get() = LinearDistanceMeasureMiles(this.toDouble())


//Time
val Hours = TimeUnit.Standard.HOURS
val Number.Hours
    get() = TimeMeasureHours(this.toDouble())

val Milliseconds = TimeUnit.Standard.MILLISECONDS
val Number.Milliseconds
    get() = TimeMeasureMilliseconds(this.toDouble())

val Minutes = TimeUnit.Standard.MINUTES
val Number.Minutes
    get() = TimeMeasureMinutes(this.toDouble())

val Seconds = TimeUnit.Standard.SECONDS
val Number.Seconds
    get() = TimeMeasureSeconds(this.toDouble())


//Angular velocity
val DegreesPerSecond = AngularVelocityUnit.Standard.DEGREES_PER_SECOND
val Number.DegreesPerSecond
    get() = AngularVelocityMeasureDegreesPerSecond(this.toDouble())

val RadiansPerSecond = AngularVelocityUnit.Standard.RADIANS_PER_SECOND
val Number.RadiansPerSecond
    get() = AngularVelocityMeasureRadiansPerSecond(this.toDouble())

val RevolutionsPerMinute = AngularVelocityUnit.Standard.REVOLUTIONS_PER_MINUTE
val Number.RevolutionsPerMinute
    get() = AngularVelocityMeasureRevolutionsPerMinute(this.toDouble())

val RevolutionsPerSecond = AngularVelocityUnit.Standard.REVOLUTIONS_PER_SECOND
val Number.RevolutionsPerSecond
    get() = AngularVelocityMeasureRevolutionsPerSecond(this.toDouble())


//Linear velocity
val CentimetersPerMinute = LinearVelocityUnit.Standard.CENTIMETERS_PER_MINUTE
val Number.CentimetersPerMinute
    get() = LinearVelocityMeasureCentimetersPerMinute(this.toDouble())

val CentimetersPerSecond = LinearVelocityUnit.Standard.CENTIMETERS_PER_SECOND
val Number.CentimetersPerSecond
    get() = LinearVelocityMeasureCentimetersPerSecond(this.toDouble())

val FeetPerMinute = LinearVelocityUnit.Standard.FEET_PER_MINUTE
val Number.FeetPerMinute
    get() = LinearVelocityMeasureFeetPerMinute(this.toDouble())

val FeetPerSecond = LinearVelocityUnit.Standard.FEET_PER_SECOND
val Number.FeetPerSecond
    get() = LinearVelocityMeasureFeetPerSecond(this.toDouble())

val InchesPerMinute = LinearVelocityUnit.Standard.INCHES_PER_MINUTE
val Number.InchesPerMinute
    get() = LinearVelocityMeasureInchesPerMinute(this.toDouble())

val InchesPerSecond = LinearVelocityUnit.Standard.INCHES_PER_SECOND
val Number.InchesPerSecond
    get() = LinearVelocityMeasureInchesPerSecond(this.toDouble())

val MetersPerMinute = LinearVelocityUnit.Standard.METERS_PER_MINUTE
val Number.MetersPerMinute
    get() = LinearVelocityMeasureMetersPerMinute(this.toDouble())

val MetersPerSecond = LinearVelocityUnit.Standard.METERS_PER_SECOND
val Number.MetersPerSecond
    get() = LinearVelocityMeasureMetersPerSecond(this.toDouble())

val MilesPerHour = LinearVelocityUnit.Standard.MILES_PER_HOUR
val Number.MilesPerHour
    get() = LinearVelocityMeasureMilesPerHour(this.toDouble())