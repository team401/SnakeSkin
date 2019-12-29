package org.snakeskin.dsl

import org.snakeskin.hid.HIDController
import org.snakeskin.hid.channel.AxisChannel
import org.snakeskin.hid.channel.ButtonChannel
import org.snakeskin.hid.channel.HatChannel
import org.snakeskin.hid.listener.AxisThresholdListener
import org.snakeskin.hid.listener.ButtonEdgeListener
import org.snakeskin.hid.listener.ButtonHoldListener
import org.snakeskin.hid.listener.HatChangeListener
import org.snakeskin.hid.mappings.*
import org.snakeskin.logic.scalars.IScalar
import org.snakeskin.measure.time.TimeMeasureSeconds

object HumanControls {
    open class ControlsBuilder(private val controller: HIDController) {
        fun whenButton(button: Int, setup: ButtonHandlerBuilder.() -> Unit) {
            val builder = ButtonHandlerBuilder(controller, button)
            builder.setup()
        }

        fun whenAxis(axis: Int, setup: AxisHandlerBuilder.() -> Unit) {
            val builder = AxisHandlerBuilder(controller, axis)
            builder.setup()
        }

        fun whenHatChanged(hat: Int, action: (newValue: Int) -> Unit) = controller.registerListener(HatChangeListener(controller.getHat(hat), action))

        fun invertAxis(axis: Int) = controller.getAxis(axis).invert()
        fun invertButton(button: Int) = controller.getButton(button).invert()

        fun deadbandAxis(axis: Int, deadband: Double) { controller.getAxis(axis).deadband = deadband }
        fun scaleAxis(axis: Int, scaling: IScalar) { controller.getAxis(axis).scalar = scaling }

        fun bindAxis(axis: Int, channel: AxisChannel) { controller.bindAxisChannel(axis, channel) }
        fun bindButton(button: Int, channel: ButtonChannel) { controller.bindButtonChannel(button, channel) }
        fun bindHat(hat: Int, channel: HatChannel) { controller.bindHatChannel(hat, channel) }
    }

    class ButtonHandlerBuilder(private val controller: HIDController, private val button: Int) {
        fun heldFor(duration: TimeMeasureSeconds, action: (Boolean) -> Unit) = controller.registerListener(ButtonHoldListener(controller.getButton(button), duration, action))
        fun pressed(action: (Boolean) -> Unit) = controller.registerListener(ButtonEdgeListener(controller.getButton(button), ButtonEdgeListener.EdgeType.Pressed, action))
        fun released(action: (Boolean) -> Unit) = controller.registerListener(ButtonEdgeListener(controller.getButton(button), ButtonEdgeListener.EdgeType.Released, action))
    }

    class AxisHandlerBuilder(private val controller: HIDController, private val axis: Int) {
        fun crosses(threshold: Double, action: (Double) -> Unit) = controller.registerListener(AxisThresholdListener(controller.getAxis(axis), threshold, AxisThresholdListener.CrossDirection.Outward, action))
        fun returns(threshold: Double, action: (Double) -> Unit) = controller.registerListener(AxisThresholdListener(controller.getAxis(axis), threshold, AxisThresholdListener.CrossDirection.Inward, action))
    }

    //CUSTOM
    class CustomBuilder(private val custom: CustomController): IBuilder<CustomController>, ControlsBuilder(custom) {
        override fun build() = custom
    }
    fun custom(id: Int, numAxes: Int, numButtons: Int, numHats: Int, setup: CustomBuilder.() -> Unit = {}): CustomController {
        val builder = CustomBuilder(CustomController(id, numAxes, numButtons, numHats))
        builder.setup()
        return builder.build()
    }

    //EXTREME 3D
    class Extreme3DBuilder(private val extreme3d: Extreme3D): IBuilder<Extreme3D>, ControlsBuilder(extreme3d) {
        override fun build() = extreme3d

        val Axes = Extreme3D.Axes
        val Buttons = Extreme3D.Buttons
        val Hats = Extreme3D.Hats
    }
    fun extreme3d(id: Int, setup: Extreme3DBuilder.() -> Unit = {}): Extreme3D {
        val builder = Extreme3DBuilder(Extreme3D(id))
        builder.setup()
        return builder.build()
    }

    //ATTACK 3D
    class Attack3Builder(private val attack3: Attack3): IBuilder<Attack3>, ControlsBuilder(attack3) {
        override fun build() = attack3

        val Axes = Attack3.Axes
        val Buttons = Attack3.Buttons
    }
    fun attack3(id: Int, setup: Attack3Builder.() -> Unit = {}): Attack3 {
        val builder = Attack3Builder(Attack3(id))
        builder.setup()
        return builder.build()
    }

    //F310
    class F310Builder(private val f310: F310): IBuilder<F310>, ControlsBuilder(f310) {
        override fun build() = f310

        val Axes = F310.Axes
        val Buttons = F310.Buttons
        val Hats = F310.Hats
    }
    fun f310(id: Int, setup: F310Builder.() -> Unit = {}): F310 {
        val builder = F310Builder(F310(id))
        builder.setup()
        return builder.build()
    }

    //DUAL ACTION
    class DualActionBuilder(private val dualAction: DualAction): IBuilder<DualAction>, ControlsBuilder(dualAction) {
        override fun build() = dualAction

        val Axes = DualAction.Axes
        val Buttons = DualAction.Buttons
        val Hats = DualAction.Hats
    }
    fun dualAction(id: Int, setup: DualActionBuilder.() -> Unit = {}): DualAction {
        val builder = DualActionBuilder(DualAction(id))
        builder.setup()
        return builder.build()
    }

    //T16000M
    class T16000MBuilder(private val t16000m: T16000M): IBuilder<T16000M>, ControlsBuilder(t16000m) {
        override fun build() = t16000m

        val Axes = T16000M.Axes
        val Buttons = T16000M.Buttons
        val Hats = T16000M.Hats
    }
    fun t16000m(id: Int, setup: T16000MBuilder.() -> Unit = {}): T16000M {
        val builder = T16000MBuilder(T16000M(id))
        builder.setup()
        return builder.build()
    }

    //SAITEK HEAVY EQUIPMENT SIDE PANEL
    class SaitekButtonBoxBuilder(private val saitekButtonBox: SaitekButtonBox): IBuilder<SaitekButtonBox>, ControlsBuilder(saitekButtonBox) {
        override fun build() = saitekButtonBox

        val Axes = SaitekButtonBox.Axes
        val Buttons = SaitekButtonBox.Buttons
    }
    fun saitekButtonBox(id: Int, setup: SaitekButtonBoxBuilder.() -> Unit = {}): SaitekButtonBox {
        val builder=  SaitekButtonBoxBuilder(SaitekButtonBox(id))
        builder.setup()
        return builder.build()
    }
}

