package org.snakeskin.controls.channel

import org.snakeskin.controls.Hat
import org.snakeskin.logic.Direction

class HatChannel {
    companion object {
        const val DEFAULT_VALUE = Direction.CENTER
    }

    /**
     * The controller that will be used to get the axis value
     */
    private var hat: Hat? = null

    /**
     * The index to read from
     */
    private var index: Int = 0

    /**
     * Reads the value of the hat
     */
    fun read(): Int {
        return hat?.read() ?: DEFAULT_VALUE
    }

    /**
     * Binds a controller provider to this channel
     */
    fun bind(hat: Hat) {
        this.hat = hat
    }
}