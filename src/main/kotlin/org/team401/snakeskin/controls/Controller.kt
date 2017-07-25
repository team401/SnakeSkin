package org.team401.snakeskin.controls

import edu.wpi.first.wpilibj.Joystick
import org.team401.snakeskin.controls.mappings.IMappingDefinitions
import org.team401.snakeskin.event.EventRouter
import org.team401.snakeskin.exception.ControlNotFoundException
import org.team401.snakeskin.logic.MutableParameters
import org.team401.snakeskin.logic.Parameters

/*
 * snakeskin - Created on 7/16/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/16/17
 */

abstract class Controller(internal val id: Int) {
    private val joystick = Joystick(id)
    internal val axes = hashMapOf<Int, Axis>()
    internal val buttons = hashMapOf<Int, Button>()
    internal val hats = hashMapOf<Int, Hat>()

    internal val buttonPressedListeners = hashMapOf<Int, () -> Unit>()
    internal val buttonReleasedListeners = hashMapOf<Int, () -> Unit>()
    internal val hatChangeListeners = hashMapOf<Int, (Int) -> Unit>()

    abstract val Mapping: IMappingDefinitions

    fun readAxis(axis: Int) = getAxis(axis).read()
    fun readButton(button: Int) = getButton(button).read()
    fun readHat(hat: Int) = getHat(hat).read()

    protected fun addAxis(axis: Int, invert: Boolean = false): Int {
        axes.put(axis, Axis { joystick.getRawAxis(axis) })
        return axis
    }

    protected fun addButton(button: Int): Int {
        buttons.put(button, Button { joystick.getRawButton(button) })
        return button
    }

    protected fun addHat(hat: Int): Int {
        hats.put(hat, Hat { joystick.getPOV(hat) })
        return hat
    }

    fun getAxis(axis: Int): Axis {
        if (axes.containsKey(axis)) {
            return axes[axis]!!
        } else {
            throw ControlNotFoundException("Could not find axis $axis on controller $id")
        }
    }

    fun getButton(button: Int): Button {
        if (buttons.containsKey(button)) {
            return buttons[button]!!
        } else {
            throw ControlNotFoundException("Could not find button $button on controller $id")
        }
    }

    fun getHat(hat: Int): Hat {
        if (hats.containsKey(hat)) {
            return hats[hat]!!
        } else {
            throw ControlNotFoundException("Could not find hat $hat on controller $id")
        }
    }

    private val BUTTON_PRESSED = "snakeskin.controls.buttonPressed."
    private val BUTTON_RELEASED = "snakeskin.controls.buttonReleased."
    private val HAT_CHANGED = "snakeskin.controls.hatChanged."

    internal fun buttonPressed(button: Int): String {
        buttonPressedListeners.put(button) {
            EventRouter.fireEvent(BUTTON_PRESSED + "$id.$button", MutableParameters())
        }
        return BUTTON_PRESSED + "$id.$button"
    }

    internal fun buttonReleased(button: Int): String {
        buttonReleasedListeners.put(button) {
            EventRouter.fireEvent(BUTTON_RELEASED + "$id.$button", MutableParameters())
        }
        return BUTTON_RELEASED + "$id.$button"
    }

    internal fun hatChanged(hat: Int): String {
        hatChangeListeners.put(hat) {
            EventRouter.fireEvent(HAT_CHANGED + "$id.$hat", MutableParameters().apply {
                setNumber("value", it.toDouble())
            })
        }
        return HAT_CHANGED + "$id.$hat"
    }


    fun registerButtonPressListener(button: Int, action: () -> Unit) = buttonPressedListeners.put(button, action)
    fun registerButtonReleaseListener(button: Int, action: () -> Unit) = buttonReleasedListeners.put(button, action)
    fun registerHatChangeListener(hat: Int, action: (Int) -> Unit) = hatChangeListeners.put(hat, action)
}