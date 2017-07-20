package org.team401.snakeskin.dsl

import org.team401.snakeskin.controls.Controller
import org.team401.snakeskin.controls.CustomController
import org.team401.snakeskin.controls.mappings.Extreme3D

/*
 * snakeskin - Created on 7/17/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/17/17
 */

infix fun Controller.readAxis(axis: Controller.() -> Int) = getAxis(axis()).read()
infix fun Controller.readButton(button: Int) = getButton(button).read()
infix fun Controller.readHat(hat: Int) = getHat(hat).read()

object HumanControls {
    open class ControlsBuilder(private val controller: Controller) {
        fun whenButtonPressed(button: Int, action: () -> Unit) = controller.registerButtonPressListener(button, action)
        fun whenButtonReleased(button: Int, action: () -> Unit) = controller.registerButtonReleaseListener(button, action)
        fun whenHatChanged(hat: Int, action: (newValue: Int) -> Unit) = controller.registerHatChangeListener(hat, action)
    }

    class CustomBuilder(private val custom: Controller): Builder<Controller>, ControlsBuilder(custom) {
        override fun build() = custom
    }
    fun custom(id: Int, setup: CustomBuilder.() -> Unit = {}): Controller {
        val builder = CustomBuilder(CustomController(id))
        builder.setup()
        return builder.build()
    }

    class Extreme3DBuilder(private val extreme3d: Extreme3D): Builder<Extreme3D>, ControlsBuilder(extreme3d) {
        override fun build() = extreme3d

        val Axes = extreme3d.Axes
        val Buttons = extreme3d.Buttons
        val Hats = extreme3d.Hats
    }
    fun extreme3d(id: Int, setup: Extreme3DBuilder.() -> Unit = {}): Extreme3D {
        val builder = Extreme3DBuilder(Extreme3D(id))
        builder.setup()
        return builder.build()
    }
}

