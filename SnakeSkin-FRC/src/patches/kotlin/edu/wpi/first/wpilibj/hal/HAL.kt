package edu.wpi.first.wpilibj.hal

import org.snakeskin.hardware.DriverStation
import org.snakeskin.hardware.Hardware
import org.snakeskin.hardware.RoboRIO
import java.nio.ByteBuffer
import java.util.*

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
@Suppress("UNUSED_PARAMETER")
object HAL: JNIWrapper() {
    @JvmStatic fun waitForDSData() {
        Thread.sleep(20)
    }

    @JvmStatic fun initialize(timeout: Int, mode: Int): Boolean {
        //Create the RoboRIO and DriverStation objects on HAL init
        Hardware.addHardware("roborio", RoboRIO())
        Hardware.addHardware("driverstation", DriverStation())

        return true
    }

    @JvmStatic fun observeUserProgramStarting() {}

    @JvmStatic fun observeUserProgramDisabled() {}

    @JvmStatic fun observeUserProgramAutonomous() {}

    @JvmStatic fun observeUserProgramTeleop() {}

    @JvmStatic fun observeUserProgramTest() {}


    @JvmStatic fun report(resource: Int, instanceNumber: Int) {
        report(resource, instanceNumber, 0, "")
    }

    @JvmStatic fun report(resource: Int, instanceNumber: Int, context: Int) {
        report(resource, instanceNumber, context, "")
    }

    /**
     * Report the usage of a resource of interest. <br></br>
     *
     *
     * Original signature: `uint32_t report(tResourceType, uint8_t, uint8_t, const
     * char*)`
     *
     * @param resource       one of the values in the tResourceType above (max value 51). <br></br>
     * @param instanceNumber an index that identifies the resource instance. <br></br>
     * @param context        an optional additional context number for some cases (such as module
     * number). Set to 0 to omit. <br></br>
     * @param feature        a string to be included describing features in use on a specific
     * resource. Setting the same resource more than once allows you to change
     * the feature string.
     */
    @JvmStatic fun report(resource: Int, instanceNumber: Int, context: Int, feature: String): Int {
        return 0
    }

    /**
     * Not used by our implementation
     */
    @JvmStatic private fun nativeGetControlWord(): Int {
        return 0
    }

    @JvmStatic fun getControlWord(controlWord: ControlWord) {
        val ds = DriverStation.getFromHardwareRepository()
        controlWord.update(ds.mode.enabled, ds.mode.auto, ds.mode.test, ds.mode.estopped, ds.fms, ds.connected)
    }

    /**
     * Not used by our implementation
     */
    @JvmStatic private fun nativeGetAllianceStation(): Int {
        return 0
    }

    fun getAllianceStation(): AllianceStationID? {
        val ds = DriverStation.getFromHardwareRepository()
        return ds.allianceStation
    }

    @JvmStatic fun isNewControlData(): Boolean {
        return true
    }

    @JvmStatic fun releaseDSMutex() {}

    @JvmStatic fun waitForDSDataTimeout(timeout: Double): Boolean {
        val ms = (timeout * 1000L).toLong()
        Thread.sleep(ms)
        return ms >= 20
    }

    @JvmStatic var kMaxJoystickAxes = 12
    @JvmStatic var kMaxJoystickPOVs = 12

    @JvmStatic fun getJoystickAxes(joystickNum: Byte, axesArray: FloatArray): Short {
        val ds = DriverStation.getFromHardwareRepository()
        val joystick = ds.getJoystick(joystickNum.toInt())

        val numAxes = joystick.numAxes()

        for (i in 0 until numAxes) {
            axesArray[i] = joystick.getAxis(i).toFloat()
        }

        return numAxes.toShort()
    }

    @JvmStatic fun getJoystickPOVs(joystickNum: Byte, povsArray: ShortArray): Short {
        val ds = DriverStation.getFromHardwareRepository()
        val joystick = ds.getJoystick(joystickNum.toInt())

        val numHats = joystick.numHats()

        for (i in 0 until numHats) {
            povsArray[i] = joystick.getHat(i).toShort()
        }

        return numHats.toShort()
    }

    @JvmStatic fun getJoystickButtons(joystickNum: Byte, count: ByteBuffer): Int {
        val ds = DriverStation.getFromHardwareRepository()
        val joystick = ds.getJoystick(joystickNum.toInt())

        val numButtons = joystick.numButtons()
        count.put(0, numButtons.toByte())

        val bits = BitSet(32)

        for (i in 1..numButtons) {
            bits.set(i - 1, joystick.getButton(i))
        }

        return bits.toLongArray()[0].toInt()
    }

    /**
     * Simulated joysticks don't support outputs
     */
    @JvmStatic fun setJoystickOutputs(joystickNum: Byte, outputs: Int, leftRumble: Short,
                                    rightRumble: Short): Int {
        return 0
    }

    @JvmStatic fun getJoystickIsXbox(joystickNum: Byte): Int {
        return 0
    }

    @JvmStatic fun getJoystickType(joystickNum: Byte): Int {
        return 0
    }

    @JvmStatic fun getJoystickName(joystickNum: Byte): String {
        return "Generic"
    }

    @JvmStatic fun getJoystickAxisType(joystickNum: Byte, axis: Byte): Int {
        return 0
    }

    @JvmStatic fun getMatchTime(): Double {
        val ds = DriverStation.getFromHardwareRepository()
        return ds.matchTime
    }

    @JvmStatic fun getSystemActive(): Boolean {
        return true
    }

    @JvmStatic fun getBrownedOut(): Boolean {
        return false //TODO add brownout simulation
    }

    /**
     * Implementation only applies game specific message, other data is forced to 0
     */
    @JvmStatic fun getMatchInfo(info: MatchInfoData): Int {
        val ds = DriverStation.getFromHardwareRepository()
        info.setData("Simulation", ds.gameSpecificMessage, 0, 0, 0)
        return 0
    }

    @JvmStatic fun sendError(isError: Boolean, errorCode: Int, isLVCode: Boolean,
                           details: String, location: String, callStack: String,
                           printMsg: Boolean): Int {
        //TODO report this to stdout somehow?
        return 0
    }
}