package org.snakeskin.dsl

import org.snakeskin.controls.Controller
import org.snakeskin.controls.mappings.*
import org.snakeskin.controls.mappings.*
import org.snakeskin.logic.scalers.Scaler

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
        fun whenButton(button: Int, setup: ButtonHandlerBuilder.() -> Unit) {
            val builder = ButtonHandlerBuilder(controller, button)
            builder.setup()
        }
        fun whenHatChanged(hat: Int, action: (newValue: Int) -> Unit) = controller.registerHatChangeListener(hat, action)

        fun invertAxis(axis: Int) = controller.getAxis(axis).invert()
        fun invertButton(button: Int) = controller.getButton(button).invert()

        fun deadbandAxis(axis: Int, deadband: Double) { controller.getAxis(axis).deadband = deadband }
        fun scaleAxis(axis: Int, scaling: Scaler) { controller.getAxis(axis).scaler = scaling}
    }

    class ButtonHandlerBuilder(private val controller: Controller, private val button: Int) {
        fun pressed(action: () -> Unit) = controller.registerButtonPressListener(button, action)
        fun released(action: () -> Unit) = controller.registerButtonReleaseListener(button, action)
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

    //F310
    class F310Builder(private val f310: F310): Builder<F310>, ControlsBuilder(f310) {
        override fun build() = f310

        val Axes = f310.Mapping.Axes
        val Buttons = f310.Mapping.Buttons
        val Hats = f310.Mapping.Hats
    }
    fun f310(id: Int, setup: F310Builder.() -> Unit = {}): F310 {
        val builder = F310Builder(F310(id))
        builder.setup()
        return builder.build()
    }

    //DUAL ACTION
    class DualActionBuilder(private val dualAction: DualAction): Builder<DualAction>, ControlsBuilder(dualAction) {
        override fun build() = dualAction

        val Axes = dualAction.Mapping.Axes
        val Buttons = dualAction.Mapping.Buttons
        val Hats = dualAction.Mapping.Hats
    }
    fun dualAction(id: Int, setup: DualActionBuilder.() -> Unit = {}): DualAction {
        val builder = DualActionBuilder(DualAction(id))
        builder.setup()
        return builder.build()
    }


}

