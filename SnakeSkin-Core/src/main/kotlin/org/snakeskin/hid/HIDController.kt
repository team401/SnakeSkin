package org.snakeskin.hid

import org.snakeskin.exception.ItemNotFoundException
import org.snakeskin.hid.channel.AxisChannel
import org.snakeskin.hid.channel.ButtonChannel
import org.snakeskin.hid.channel.HatChannel
import org.snakeskin.hid.listener.IControlSurfaceListener
import org.snakeskin.runtime.SnakeskinRuntime

abstract class HIDController(internal val id: Int) {
    private val factory = SnakeskinRuntime.createHIDFactory(id)

    internal val axes = hashMapOf<Int, HIDAxis>()
    internal val buttons = hashMapOf<Int, HIDButton>()
    internal val hats = hashMapOf<Int, HIDHat>()

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

    protected fun addAxis(axis: Int, invert: Boolean = false) {
        axes[axis] = HIDAxis(factory.createAxisValueProvider(axis), invert)
    }

    protected fun addButton(button: Int) {
        buttons[button] = HIDButton(factory.createButtonValueProvider(button))
    }

    protected fun addHat(hat: Int) {
        hats[hat] = HIDHat(factory.createHatValueProvider(hat))
    }

    /**
     * Gets the Axis object for the given axis index.  This object can be used to directly read the value of the axis.
     *
     * Note that the preferred pattern is to bind an AxisChannel to an axis and read the value that way
     * @see bindAxisChannel
     */
    fun getAxis(axis: Int): HIDAxis {
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
    fun getButton(button: Int): HIDButton {
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
    fun getHat(hat: Int): HIDHat {
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