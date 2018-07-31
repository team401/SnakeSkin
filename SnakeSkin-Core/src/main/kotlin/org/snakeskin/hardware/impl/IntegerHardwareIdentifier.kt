package org.snakeskin.hardware.impl

import org.snakeskin.hardware.HardwareIdentifier

/**
 * @author Cameron Earle
 * @version 7/30/2018
 *
 * Represents a hardware identifier that can be expressed as a single integer
 * This covers most hardware modules
 */
data class IntegerHardwareIdentifier(val id: Int): HardwareIdentifier