package org.snakeskin.controls.channel

import org.snakeskin.controls.Button

class ButtonChannel {
    companion object {
        const val DEFAULT_VALUE = false
    }

    /**
     * The controller that will be used to get the axis value
     */
    private var button: Button? = null

    /**
     * Reads the value of the button
     */
    fun read(): Boolean {
        return button?.read() ?: DEFAULT_VALUE
    }

    /**
     * Binds a controller provider to this channel
     */
    fun bind(button: Button) {
        this.button = button
    }
}