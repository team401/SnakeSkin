package org.team401.snakeskin.controls

import edu.wpi.first.wpilibj.Joystick
import org.team401.snakeskin.exception.ControlNotFoundException

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

abstract class Controller(private val id: Int) {
    private val joystick = Joystick(id)
    private val axes = hashMapOf<Int, Axis>()
    private val buttons = hashMapOf<Int, Button>()
    private val hats = hashMapOf<Int, Hat>()

    private val buttonPressedListeners = hashMapOf<Int, () -> Unit>()
    private val buttonReleasedListeners = hashMapOf<Int, () -> Unit>()
    private val hatChangeListeners = hashMapOf<Int, (Int) -> Unit>()

    interface AxesDefinitions
    interface ButtonsDefinitions
    interface HatsDefinitions

    abstract val Axes: AxesDefinitions
    abstract val Buttons: ButtonsDefinitions
    abstract val Hats: HatsDefinitions

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

    fun getButtonPressHandlers() = buttonPressedListeners.toMap()
    fun getButtonReleaseHandlers() = buttonReleasedListeners.toMap()
    fun getHatChangeHandlers() = hatChangeListeners.toMap()

    fun registerButtonPressListener(button: Int, action: () -> Unit) = buttonPressedListeners.put(button, action)
    fun registerButtonReleaseListener(button: Int, action: () -> Unit) = buttonReleasedListeners.put(button, action)
    fun registerHatChangeListener(hat: Int, action: (Int) -> Unit) = hatChangeListeners.put(hat, action)
}