package org.snakeskin.controls

import org.snakeskin.controls.listener.*
import org.snakeskin.controls.state.*
import org.snakeskin.factory.ExecutorFactory
import org.snakeskin.hardware.Hardware
import org.snakeskin.utility.value.AsyncBoolean
import java.util.*

/**
 * @author Cameron Earle
 * @version 7/16/17
 */
object ControlPoller {
    private val handlerExecutor = ExecutorFactory.getExecutor("ControlPoller Handler")

    private val states = Vector<ControlSurfaceState<*>>()

    /**
     * Whether or not to poll the controls in the autonomous mode.
     * This should be enabled to support the "Sandstorm" period in the 2019 game
     */
    var pollInAutonomous by AsyncBoolean(false)

    private fun createStateForListener(listener: ControlListener<*, *>): ControlSurfaceState<*> {
        return when (listener) {
            is ButtonEdgeListener -> ButtonEdgeState(listener)
            is ButtonHoldListener -> ButtonTimedState(listener)
            is HatChangeListener -> HatState(listener)
            is AxisThresholdListener -> AxisThresholdState(listener)
            else -> throw IllegalArgumentException("State for listener type ${listener.javaClass.name} not found!")
        }
    }

    fun update() {
        val timestamp = Hardware.getRelativeTime()
        states.forEach {
            if (it.update(timestamp)) { //If the controller state changed
                handlerExecutor.submit(it) //Run the action
            }
        }
    }

    fun addController(controller: Controller) {
        controller.listeners.forEach {
            states.add(createStateForListener(it))
        }
    }
}