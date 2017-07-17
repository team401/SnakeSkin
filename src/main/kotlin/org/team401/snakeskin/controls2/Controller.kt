package org.team401.snakeskin.controls2

import edu.wpi.first.wpilibj.Joystick
import org.team401.snakeskin.controls2.mappings.Extreme3D
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

    class HardwareAxis(val axis: Int, val invert: Boolean = false)
    class HardwareButton(val button: Int)
    class HardwareHat(val hat: Int)
    interface AxesDefinitions
    interface ButtonsDefinitions
    interface HatsDefinitions

    abstract val Axes: AxesDefinitions
    abstract val Buttons: ButtonsDefinitions
    abstract val Hats: HatsDefinitions

    protected fun addHardwareAxis(newAxis: HardwareAxis): HardwareAxis {
        axes.put(newAxis.axis, Axis { joystick.getRawAxis(newAxis.axis) })
        return newAxis
    }

    protected fun addHardwareButton(newButton: HardwareButton): HardwareButton {
        buttons.put(newButton.button, Button { joystick.getRawButton(newButton.button) })
        return newButton
    }

    protected fun addHardwareHat(newHat: HardwareHat): HardwareHat {
        hats.put(newHat.hat, Hat { joystick.getPOV(newHat.hat) })
        return newHat
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
}