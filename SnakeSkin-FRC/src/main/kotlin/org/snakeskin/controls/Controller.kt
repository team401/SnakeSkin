package org.snakeskin.controls

import edu.wpi.first.wpilibj.Joystick
import org.snakeskin.controls.impl.HardwareControllerProvider
import org.snakeskin.controls.impl.SoftwareControllerProvider
import org.snakeskin.controls.mappings.IMappingDefinitions
import org.snakeskin.exception.ItemNotFoundException
import org.snakeskin.hardware.Environment
import org.snakeskin.hardware.Hardware
import org.snakeskin.logic.LockingDelegate
import java.util.concurrent.atomic.AtomicReference

/**
 * @author Cameron Earle
 * @version 7/16/17
 */
abstract class Controller(internal val id: Int, enabled: Boolean = true) {
    private val enabledRef = AtomicReference<Boolean>(enabled)

    /**
     * Controls whether or not the current controller is "enabled".
     * This can be set on the fly during runtime to enable or disable certain controllers.
     * A disabled controller ignores all inputs and outputs the default value for every input
     *
     * Disabled controllers will not throw warnings on the Driver Station about missing IDs,
     * so this can be used to have multiple control mappings
     */
    var enabled: Boolean
        get() = enabledRef.get()
        set(value) = enabledRef.set(value)

    private val provider: ControllerProvider = if (Hardware.environment == Environment.SOFTWARE) {
        SoftwareControllerProvider()
    } else {
        HardwareControllerProvider(Joystick(id))
    }

    internal val axes = hashMapOf<Int, Axis>()
    internal val buttons = hashMapOf<Int, Button>()
    internal val hats = hashMapOf<Int, Hat>()

    /**
     * Gets the software controller provider for simulation, or null if the system is in hardware mode
     */
    fun getSoftwareProvider(): SoftwareControllerProvider? {
        return provider as? SoftwareControllerProvider
    }

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

    internal val buttonPressedListeners = hashMapOf<Int, () -> Unit>()
    internal val buttonReleasedListeners = hashMapOf<Int, () -> Unit>()
    internal val hatChangeListeners = hashMapOf<Int, (Int) -> Unit>()

    abstract val Mapping: IMappingDefinitions

    fun readAxis(axis: Int) = getAxis(axis).read()

    fun readButton(button: Int) = getButton(button).read()

    fun readHat(hat: Int) = getHat(hat).read()

    protected fun addAxis(axis: Int, invert: Boolean = false): Int {
        axes[axis] = Axis(
                provider = provider,
                axis = axis,
                factoryInvert = invert,
                enabled = enabledRef
        )
        return axis
    }

    protected fun addButton(button: Int): Int {
        buttons[button] = Button(
                provider = provider,
                button = button,
                enabled = enabledRef
        )
        return button
    }

    protected fun addHat(hat: Int): Int {
        hats[hat] = Hat(
                provider = provider,
                hat = hat,
                enabled = enabledRef
        )
        return hat
    }

    fun getAxis(axis: Int): Axis {
        if (axes.containsKey(axis)) {
            return axes[axis]!!
        } else {
            throw ItemNotFoundException("Could not find axis $axis on controller $id")
        }
    }

    fun getButton(button: Int): Button {
        if (buttons.containsKey(button)) {
            return buttons[button]!!
        } else {
            throw ItemNotFoundException("Could not find button $button on controller $id")
        }
    }

    fun getHat(hat: Int): Hat {
        if (hats.containsKey(hat)) {
            return hats[hat]!!
        } else {
            throw ItemNotFoundException("Could not find hat $hat on controller $id")
        }
    }

    fun registerButtonPressListener(button: Int, action: () -> Unit) = buttonPressedListeners.put(button, action)
    fun registerButtonReleaseListener(button: Int, action: () -> Unit) = buttonReleasedListeners.put(button, action)
    fun registerHatChangeListener(hat: Int, action: (Int) -> Unit) = hatChangeListeners.put(hat, action)
}