package org.snakeskin.hid.channel

import org.snakeskin.hid.HIDAxis

/**
 * A channel for a controller axis.
 * Channels are used to retrieve values directly from controllers.  A controller binds itself to a channel,
 * and then a receiver (user code) can request the value from the channel
 */
class AxisChannel {
    companion object {
        const val DEFAULT_VALUE = 0.0
    }

    /**
     * The controller that will be used to get the axis value
     */
    private var axis: HIDAxis? = null

    /**
     * The index to read from
     */
    private var index: Int = 0

    /**
     * Reads the value of the axis
     */
    fun read(): Double {
        return axis?.read() ?: DEFAULT_VALUE
    }

    /**
     * Binds a controller provider to this channel
     */
    fun bind(axis: HIDAxis) {
        this.axis = axis
    }
}