package org.snakeskin.hardware

/**
 * @author Cameron Earle
 * @version 7/31/18
 *
 * Class for creating CTRE hardware objects.  This includes Talon SRX, Victor SPX,
 */
object CTREHardware {

    private inline fun <T> switch(hardware: () -> T, software: () -> T): T {
        return when (Hardware.environment) {
            Environment.HARDWARE -> hardware()
            Environment.SOFTWARE -> software()
        }
    }


}