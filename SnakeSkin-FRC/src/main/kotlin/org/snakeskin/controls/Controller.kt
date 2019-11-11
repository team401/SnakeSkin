package org.snakeskin.controls

import edu.wpi.first.wpilibj.Joystick
import org.snakeskin.controls.channel.AxisChannel
import org.snakeskin.controls.channel.ButtonChannel
import org.snakeskin.controls.channel.HatChannel
import org.snakeskin.controls.listener.IControlSurfaceListener
import org.snakeskin.controls.mappings.IMappingDefinitions
import org.snakeskin.exception.ItemNotFoundException
import org.snakeskin.hid.impl.WPIJoystickAxisValueProvider
import org.snakeskin.hid.impl.WPIJoystickButtonValueProvider
import org.snakeskin.hid.impl.WPIJoystickHatValueProvider

/**
 * @author Cameron Earle
 * @version 7/16/17
 */
abstract class Controller(internal val id: Int) {
    private val joystick = Joystick(id) //TODO this is TEMPORARY.  Replace this with a proper factory for simulation.

    internal val axes = hashMapOf<Int, Axis>()
    internal val buttons = hashMapOf<Int, Button>()
    internal val hats = hashMapOf<Int, Hat>()

    /**
     * The number of axes in this controller
     * Axes are zero-indexed
     */
    val numAxes: Int
        get() = axes.size

    /**
     * The number of buttons in this controller
     * Buttons are one-indexed
     */
    val numButtons: Int
        get() = buttons.size

    /**
     * The number of hats in this controller
     * Hats are zero-indexed
     */
    val numHats: Int
        get() = hats.size

    internal val listeners = arrayListOf<IControlSurfaceListener>()

    abstract val Mapping: IMappingDefinitions

    fun readAxis(axis: Int) = getAxis(axis).read()

    fun readButton(button: Int) = getButton(button).read()

    fun readHat(hat: Int) = getHat(hat).read()

    protected fun addAxis(axis: Int, invert: Boolean = false): Int {
        axes[axis] = Axis(WPIJoystickAxisValueProvider(joystick, axis), invert) //TODO inject
        return axis
    }

    protected fun addButton(button: Int): Int {
        buttons[button] = Button(WPIJoystickButtonValueProvider(joystick, button)) //TODO inject
        return button
    }

    protected fun addHat(hat: Int): Int {
        hats[hat] = Hat(WPIJoystickHatValueProvider(joystick, hat)) //TODO inject
        return hat
    }

    /**
     * Gets the Axis object for the given axis index.  This object can be used to directly read the value of the axis.
     *
     * Note that the preferred pattern is to bind an AxisChannel to an axis and read the value that way
     * @see bindAxisChannel
     */
    fun getAxis(axis: Int): Axis {
        if (axes.containsKey(axis)) {
            return axes[axis]!!
        } else {
            throw ItemNotFoundException("Could not find axis $axis on controller $id")
        }
    }

    /**
     * Gets the Button object for the given button index.  This object can be used to directly read the value of the button.
     *
     * Note that the preferred pattern is to bind a ButtonChannel to a button and read the value that way
     * @see bindButtonChannel
     */
    fun getButton(button: Int): Button {
        if (buttons.containsKey(button)) {
            return buttons[button]!!
        } else {
            throw ItemNotFoundException("Could not find button $button on controller $id")
        }
    }

    /**
     * Gets the Hat object for the given hat index.  This object can be used to directly read the value of the hat.
     *
     * Note that the preferred pattern is to bind a HatChannel to a hat and read the value that way
     * @see bindHatChannel
     */
    fun getHat(hat: Int): Hat {
        if (hats.containsKey(hat)) {
            return hats[hat]!!
        } else {
            throw ItemNotFoundException("Could not find hat $hat on controller $id")
        }
    }

    fun registerListener(listener: IControlSurfaceListener) {
        listeners.add(listener)
    }

    fun bindAxisChannel(axis: Int, channel: AxisChannel) {
        channel.bind(getAxis(axis))
    }

    fun bindButtonChannel(button: Int, channel: ButtonChannel) {
        channel.bind(getButton(button))
    }

    fun bindHatChannel(hat: Int, channel: HatChannel) {
        channel.bind(getHat(hat))
    }
}