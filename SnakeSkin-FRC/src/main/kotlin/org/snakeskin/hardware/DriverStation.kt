package org.snakeskin.hardware

import edu.wpi.first.wpilibj.hal.AllianceStationID
import org.snakeskin.logic.LockingDelegate

/**
 * @author Cameron Earle
 * @version 8/12/18
 *
 * Simulation Environment for the Driver Station.
 *
 * Allows users to set robot state (disabled, teleop, etc.), DS connection status (is the DS talking to the robot),
 * as well as joystick data.
 */
class DriverStation: IHardware {
    companion object {
        /**
         * Gets the instance of this class from the Hardware Repository.
         */
        fun getFromHardwareRepository(): DriverStation {
            return Hardware.getHardware("driverstation") as DriverStation
        }
    }

    /**
     * Represents the possible modes the robot can be in
     * @param enabled If this mode is an enabled mode
     * @param auto If this mode is an autonomous mode
     * @param test If this mode is a test mode
     * @param estopped If this mode is an estopped mode
     *
     * This enum has 5 values that represent all legal combinations of these parameters
     */
    enum class Mode(val enabled: Boolean, val auto: Boolean, val test: Boolean, val estopped: Boolean) {
        DISABLED(false, false, false, false),
        TELEOP_ENABLED(true, false, false, false),
        AUTO_ENABLED(true, true, false, false),
        TEST_ENABLED(true, false, true, false),
        ESTOP(false, false, false, true)
    }

    /**
     * Represents a simulated joystick.  Joysticks contain axes, buttons, and hats.
     * Contains functions for getting and setting axes, buttons, and hats, as well as
     * functions for obtaining the number of each.
     *
     * Axes, buttons, and hats are created automatically as the "set" methods are called, and this updates the count accordingly
     * For example, the calls:
     *
     * someJoystick.setAxis(0, 1.0)
     * someJoystick.setAxis(5, -1.0)
     *
     * would have the effect of creating two axes, storing their values, and updating the "numAxes" to 6 (number is determined from highest ID)
     *
     * If an axis, button, or hat has not been created, and it is requested by a "get" method, a default value will be returned:
     * Axis:   0.0
     * Button: false
     * Hat:    -1
     */
    class Joystick {
        private val axes = HashMap<Int, Double>()
        private val buttons = HashMap<Int, Boolean>()
        private val hats = HashMap<Int, Int>()

        /**
         * Sets the given axis to the given value
         * @param axis The ID of the axis
         * @param value The value to set
         */
        @Synchronized fun setAxis(axis: Int, value: Double) {
            axes[axis] = value
        }

        /**
         * Creates (if not already present) and sets the given button to the given value
         * @param button The ID of the button
         * @param value The value to set
         */
        @Synchronized fun setButton(button: Int, value: Boolean) {
            buttons[button] = value
        }

        /**
         * Creates (if not already present) and sets the given hat to the given value
         * @param hat The ID of the hat
         * @param value The value to set
         */
        @Synchronized fun setHat(hat: Int, value: Int) {
            hats[hat] = value
        }

        /**
         * Gets the value of the given axis, or returns 0.0 if the axis has not been created
         * @param axis The ID of the axis
         * @return The value
         */
        @Synchronized fun getAxis(axis: Int): Double {
            return axes.getOrDefault(axis, 0.0)
        }

        /**
         * Gets the value of the given button, or returns false if the button has not been created
         * @param button The ID of the button
         * @return The value
         */
        @Synchronized fun getButton(button: Int): Boolean {
            return buttons.getOrDefault(button, false)
        }

        /**
         * Gets the value of the given hat, or returns -1 if the hat has not been created
         * @param hat The ID of the hat
         * @return The value
         */
        @Synchronized fun getHat(hat: Int): Int {
            return hats.getOrDefault(hat, -1)
        }

        /**
         * Gets the effective number of axes in this joystick (the highest ID plus 1)
         * @return The number of axes
         */
        @Synchronized fun numAxes(): Int {
            //Maximum value in keys plus 1 (axes are zero indexed)
            return axes.keys.max()?.plus(1) ?: 0
        }

        /**
         * Gets the effective number of buttons in this joystick (the highest ID)
         * @return The number of buttons
         */
        @Synchronized fun numButtons(): Int {
            //Maximum value in keys (buttons are 1 indexed)
            return buttons.keys.max() ?: 0
        }

        /**
         * Gets the effective number of hats in this joystick (the highest ID plus 1)
         * @return The number of hats
         */
        @Synchronized fun numHats(): Int {
            //Maximum value in keys plus 1 (hats are zero indexed)
            return hats.keys.max()?.plus(1) ?: 0
        }
    }

    /**
     * Represents whether or not the Driver Station is connected to the Robot.
     * Setting this to false would have the same effect as disconnecting from the Robot Network in a physical environment
     */
    var connected by LockingDelegate(true)

    /**
     * Represents whether or ot the Driver Station is connected to FMS.
     * Setting this to true would make the robot behave as it would when connected to FMS
     */
    var fms by LockingDelegate(false)

    /**
     * Represents the current mode of the robot.
     * Setting this to one of the options in the Mode class will have the effect of setting the mode on a physical
     * Driver Station, and if applicable, clicking the "Enable" button
     */
    var mode by LockingDelegate(Mode.DISABLED)

    /**
     * Represents the alliance station that the Driver Station is in.
     * Changing this would have the same effect as changing the option in the dropdown menu on a physical Driver Station
     */
    var allianceStation by LockingDelegate(AllianceStationID.Red1)

    /**
     * Represents the match time, in seconds, that the Driver Station has selected
     * Changing this has the effect of changing the time sent to the robot.  This makes sense for simulating a practice match
     */
    var matchTime by LockingDelegate(120.0)

    /**
     * Represents the game specific message string.
     * Changing this has the effect of changing the value in the text box on a physical Driver Station
     */
    var gameSpecificMessage by LockingDelegate("")

    /**
     * Internal storage for joystick objects
     */
    private val joysticks = hashMapOf<Int, Joystick>()

    /**
     * Creates a new joystick at the ID specified.
     * This has the same effect as plugging in a joystick to a physical Driver Station and setting its ID
     */
    @Synchronized fun connectJoystick(id: Int) {
        joysticks[id] = Joystick()
    }

    /**
     * Disconnects a joystick at the ID specified.
     * This has the same effect as unplugging a joystick from a Physical Driver Station
     */
    @Synchronized fun disconnectJoystick(id: Int) {
        joysticks.remove(id)
    }

    /**
     * Gets a joystick at the given ID from the Driver Station.  This is used to manipulate individual joysticks
     * If the requested joystick is not connected, an empty joystick is provided with all values set to 0
     */
    @Synchronized fun getJoystick(id: Int): Joystick {
        return if (joysticks.containsKey(id)) {
            joysticks[id]!!
        } else {
            Joystick()
        }
    }
}