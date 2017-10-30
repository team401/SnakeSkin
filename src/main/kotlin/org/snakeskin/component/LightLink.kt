package org.snakeskin.component

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

class LightLink(address: Int = 0x42, port: I2C.Port = I2C.Port.kMXP): Component {
    companion object {
        private val LL_LOCK = Any()
    }

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
        const val BLINK = 0x02
        const val SIGNAL = 0x03
        const val RACE = 0x04
        const val BOUNCE = 0x05
        const val SPLIT = 0x06
        const val BREATHE = 0x07
        const val RAINBOW = 0x08
    }

    object Speed {
        const val SLOW = 0x01
        const val FAST = 0x02
    }

    private fun buildCommand(strip: Int, color: Int, action: Int, speed: Int): ByteArray {
        //SPEC v2
        val array = ByteArray(6)
        array[0] = (0x00).toByte()      //START
        array[1] = (strip + 1).toByte() //STRIP
        array[2] = (color).toByte()     //COLOR
        array[3] = (action).toByte()    //ACTION
        array[4] = (speed).toByte()
        array[5] = (0xFF).toByte()      //FINISH
        return array
    }

    fun set(color: Int, action: Int, speed: Int, strip: Int = 0) {
        synchronized(LL_LOCK) {
            i2c.writeBulk(buildCommand(strip, color, action, speed))
        }
    }

    fun off() {
        set(Color.BLACK, Action.SOLID, Speed.SLOW)
    }

    fun blink(color: Int, speed: Int = Speed.SLOW) {
        set(color, Action.BLINK, speed)
    }

    fun signal(color: Int) {
        set(color, Action.SIGNAL, Speed.FAST)
    }

    fun race(color: Int, speed: Int = Speed.SLOW) {
        set(color, Action.RACE, speed)
    }

    fun bounce(color: Int, speed: Int = Speed.SLOW) {
        set(color, Action.BOUNCE, speed)
    }

    fun split(color: Int, speed: Int = Speed.SLOW) {
        set(color, Action.SPLIT, speed)
    }

    fun breathe(color: Int, speed: Int = Speed.SLOW) {
        set(color, Action.BREATHE, speed)
    }

    fun rainbow(speed: Int = Speed.SLOW) {
        set(Color.BLACK, Action.RAINBOW, speed)
    }
}