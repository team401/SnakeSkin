package org.team401.snakeskin.component

import edu.wpi.first.wpilibj.I2C

/*
 * snakeskin - Created on 9/23/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 9/23/17
 */

class LightLink(val address: Int = 0x42, val port: I2C.Port = I2C.Port.kMXP): Component {
    private val i2c = I2C(port, address)

    object Color {
        const val RED = 0x01
        const val ORANGE = 0x02
        const val YELLOW = 0x03
        const val GREEN = 0x04
        const val BLUE = 0x05
        const val VIOLET = 0x06
        const val WHITE = 0x07
        const val BLACK = 0x08
    }

    object Action {
        const val SOLID = 0x01
        const val BLINK = 0x02 //BLINK_SLOW
        const val STROBE = 0x03 //BLINK_FAST
    }

    private fun buildCommand(strip: Int, color: Int, action: Int): ByteArray {
        //SPEC v1
        val array = ByteArray(5)
        array[0] = (0x00).toByte()      //START
        array[1] = (strip + 1).toByte() //STRIP
        array[2] = (color).toByte()     //COLOR
        array[3] = (action).toByte()    //ACTION
        array[4] = (0xFF).toByte()      //FINISH
        return array
    }

    fun set(color: Int, action: Int, strip: Int = 0) {
        i2c.writeBulk(buildCommand(strip, color, action))
    }
}