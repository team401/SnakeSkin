package org.snakeskin.controls.impl

import org.snakeskin.controls.ControllerProvider
import java.util.concurrent.ConcurrentHashMap

/**
 * @author Cameron Earle
 * @version 7/30/2018
 *
 *
 * Implements a virtual controller in software.
 *
 * Axes, Buttons, and Hats are stored in corresponding Maps, referenced by input id.
 *
 * Axes that are never set, but are accessed will return constant default values defined in this class
 */
@Deprecated("This is replaced by HAL simulation")
class SoftwareControllerProvider: ControllerProvider {
    companion object {
        const val AXIS_DEFAULT = 0.0
        const val BUTTON_DEFAULT = false
        const val HAT_DEFAULT = 0
    }

    private val axes = ConcurrentHashMap<Int, Double>()
    private val buttons = ConcurrentHashMap<Int, Boolean>()
    private val hats = ConcurrentHashMap<Int, Int>()

    fun setAxis(id: Int, value: Double) {
        axes[id] = value
    }

    fun setButton(id: Int, value: Boolean) {
        buttons[id] = value
    }

    fun setHat(id: Int, value: Int) {
        hats[id] = value
    }

    override fun readAxis(id: Int): Double {
        return axes.getOrDefault(id, AXIS_DEFAULT)
    }

    override fun readButton(id: Int): Boolean {
        return buttons.getOrDefault(id, BUTTON_DEFAULT)
    }

    override fun readHat(id: Int): Int {
        return hats.getOrDefault(id, HAT_DEFAULT)
    }
}