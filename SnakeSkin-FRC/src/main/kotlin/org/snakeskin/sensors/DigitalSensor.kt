package org.snakeskin.sensors

import edu.wpi.first.wpilibj.DigitalInput

/**
 * @author Cameron Earle
 * @version 9/11/17
 */
open class DigitalSensor(override var inverted: Boolean = false, dio: DigitalInput): BooleanSensor(inverted, {dio.get()})