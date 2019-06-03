package org.snakeskin.template

import org.snakeskin.measure.distance.linear.LinearDistanceMeasureInches

/**
 * @author Cameron Earle
 * @version 1/26/2019
 *
 */
interface TankDrivetrainGeometryTemplate {
    val wheelRadius: LinearDistanceMeasureInches
    val wheelbase: LinearDistanceMeasureInches
}