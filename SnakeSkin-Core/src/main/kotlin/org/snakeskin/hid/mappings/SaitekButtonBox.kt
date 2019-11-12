package org.snakeskin.hid.mappings

import org.snakeskin.hid.HIDController

/**
 * @author Cameron Earle
 * @version 1/4/18
 */
class SaitekButtonBox(id: Int): HIDController(id) {
    object Axes {
        const val RollBlue = 0
        const val PitchBlue = 1
        const val YawBlue = 2
        const val RollRed = 3
        const val PitchRed = 4
        const val YawRed = 5
    }

    /**
     * Note - buttons 1-24 are labelled on the box and should just be accessed using the integer numbers themselves
     */
    object Buttons {
        const val ScrollClick = 25
        const val ScrollUp = 26
        const val ScrollDown = 27
        const val StickButton = 28
    }

    init {
        addAxis(Axes.RollBlue)
        addAxis(Axes.PitchBlue)
        addAxis(Axes.YawBlue)
        addAxis(Axes.RollRed)
        addAxis(Axes.PitchRed)
        addAxis(Axes.YawRed)

        for (i in 1..24) addButton(i)
        addButton(Buttons.ScrollClick)
        addButton(Buttons.ScrollUp)
        addButton(Buttons.ScrollDown)
        addButton(Buttons.StickButton)
    }
}