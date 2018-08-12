package edu.wpi.first.wpilibj.hal

import java.nio.ByteBuffer

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

    @JvmStatic fun nativeGetControlWord(): Int {
        return 0
    }

    @JvmStatic fun getControlWord(controlWord: ControlWord) {
        //TODO add robot state to sim env
        controlWord.update(false, false, false, false, false, true)
    }

    @JvmStatic private fun nativeGetAllianceStation(): Int {
        return 0
    }

    fun getAllianceStation(): AllianceStationID? {
        //TODO add alliance station to sim env
        return AllianceStationID.Red1
        /*
        when (nativeGetAllianceStation()) {
            0 -> return AllianceStationID.Red1
            1 -> return AllianceStationID.Red2
            2 -> return AllianceStationID.Red3
            3 -> return AllianceStationID.Blue1
            4 -> return AllianceStationID.Blue2
            5 -> return AllianceStationID.Blue3
            else -> return null
        }
        */
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
        return 0 //TODO implement
    }

    @JvmStatic fun getJoystickPOVs(joystickNum: Byte, povsArray: ShortArray): Short {
        return 0 //TODO implement
    }

    @JvmStatic fun getJoystickButtons(joystickNum: Byte, count: ByteBuffer): Int {
        return 0 //TODO implement
    }

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
        return 120.0 //TODO add match time simulation
    }

    @JvmStatic fun getSystemActive(): Boolean {
        return true
    }

    @JvmStatic fun getBrownedOut(): Boolean {
        return false //TODO add brownout simulation
    }

    @JvmStatic fun getMatchInfo(info: MatchInfoData): Int {
        //TODO add simulated match info
        return 0
    }

    @JvmStatic fun sendError(isError: Boolean, errorCode: Int, isLVCode: Boolean,
                           details: String, location: String, callStack: String,
                           printMsg: Boolean): Int {
        return 0
    }
}