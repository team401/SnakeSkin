package org.snakeskin.template

import org.snakeskin.units.LinearDistanceUnit
import org.snakeskin.units.measure.distance.linear.LinearDistanceMeasure

/**
 * @author Cameron Earle
 * @version 9/12/18
 */
interface TankDrivetrainGeometryTemplate {
    /**
     * The geometric (measured in CAD or with a tape measure) wheelbase of the robot.  This does NOT include wheel scrub
     */
    val wheelbase: LinearDistanceMeasure

    /**
     * The geometric (measured on the robot or with math) wheel radius of the robot.  This should be as accurate as possible
     *
     * An example calibration for this would be to push the robot some distance, and do the math to calculate the actual radius
     */
    val wheelRadius: LinearDistanceMeasure
}