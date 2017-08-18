package org.team401.snakeskin.dsl

import org.team401.snakeskin.controls.Controller
import org.team401.snakeskin.controls.mappings.Attack3
import org.team401.snakeskin.controls.mappings.CustomController
import org.team401.snakeskin.controls.mappings.Extreme3D
import org.team401.snakeskin.controls.mappings.GTWheel

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


object HumanControls {
    open class ControlsBuilder(private val controller: Controller) {
        fun whenButtonPressed(button: Int, action: () -> Unit) = controller.registerButtonPressListener(button, action)
        fun whenButtonReleased(button: Int, action: () -> Unit) = controller.registerButtonReleaseListener(button, action)
        fun whenHatChanged(hat: Int, action: (newValue: Int) -> Unit) = controller.registerHatChangeListener(hat, action)
    }

    //CUSTOM
    class CustomBuilder(private val custom: CustomController): Builder<CustomController>, ControlsBuilder(custom) {
        override fun build() = custom
    }
    fun custom(id: Int, numAxes: Int, numButtons: Int, numHats: Int, setup: CustomBuilder.() -> Unit = {}): CustomController {
        val builder = CustomBuilder(CustomController(id, numAxes, numButtons, numHats))
        builder.setup()
        return builder.build()
    }

    //EXTREME 3D
    class Extreme3DBuilder(private val extreme3d: Extreme3D): Builder<Extreme3D>, ControlsBuilder(extreme3d) {
        override fun build() = extreme3d

        val Axes = extreme3d.Mapping.Axes
        val Buttons = extreme3d.Mapping.Buttons
        val Hats = extreme3d.Mapping.Hats
    }
    fun extreme3d(id: Int, setup: Extreme3DBuilder.() -> Unit = {}): Extreme3D {
        val builder = Extreme3DBuilder(Extreme3D(id))
        builder.setup()
        return builder.build()
    }

    //ATTACK 3D
    class Attack3Builder(private val attack3: Attack3): Builder<Attack3>, ControlsBuilder(attack3) {
        override fun build() = attack3

        val Axes = attack3.Mapping.Axes
        val Buttons = attack3.Mapping.Buttons
    }
    fun attack3(id: Int, setup: Attack3Builder.() -> Unit = {}): Attack3 {
        val builder = Attack3Builder(Attack3(id))
        builder.setup()
        return builder.build()
    }


    //DRIVING FORCE GT
    class GTWheelBuilder(private val gtWheel: GTWheel): Builder<GTWheel>, ControlsBuilder(gtWheel) {
        override fun build() = gtWheel

        val Axes = gtWheel.Mapping.Axes
    }
    fun drivingForceGT(id: Int, setup: GTWheelBuilder.() -> Unit = {}): GTWheel {
        val builder = GTWheelBuilder(GTWheel(id))
        builder.setup()
        return builder.build()
    }


}

