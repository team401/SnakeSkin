package org.snakeskin.template

import org.snakeskin.units.measure.distance.linear.LinearDistanceMeasure

/**
 * @author Cameron Earle
 * @version 1/26/2019
 *
 */
interface TankDrivetrainGeometryTemplate {
    val wheelRadius: LinearDistanceMeasure
    val wheelbase: LinearDistanceMeasure
}