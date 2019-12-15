package org.snakeskin.template

import org.snakeskin.measure.distance.linear.LinearDistanceMeasureInches

/**
 * A template for the geometry of a differential drivetrain.
 */
interface DifferentialDrivetrainGeometry  {
    /**
     * The measured wheelbase of the drivetrain, in inches
     */
    val wheelbase: LinearDistanceMeasureInches

    /**
     * The measured wheel radius of the drivetrain, in inches
     */
    val wheelRadius: LinearDistanceMeasureInches
}