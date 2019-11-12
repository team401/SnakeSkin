package org.snakeskin.hid

import org.snakeskin.hid.listener.*
import org.snakeskin.hid.state.*
import org.snakeskin.runtime.SnakeskinRuntime
import org.snakeskin.utility.value.AsyncBoolean

object HIDUpdater {
    private val handlerExecutor = SnakeskinRuntime.primaryExecutor

    private val states = arrayListOf<IControlSurfaceState>()

    /**
     * Whether or not to poll the controls in the autonomous mode.
     * An example of where this is useful is the "Sandstorm" period in the 2019 game
     */
    var pollInAutonomous by AsyncBoolean(false)

    private fun createStateForListener(listener: IControlSurfaceListener): IControlSurfaceState {
        return when (listener) {
            is ButtonEdgeListener -> ButtonEdgeState(listener)
            is ButtonHoldListener -> ButtonTimedState(listener)
            is HatChangeListener -> HatState(listener)
            is AxisThresholdListener -> AxisThresholdState(listener)
            else -> throw IllegalArgumentException("State for listener type ${listener.javaClass.name} not found!")
        }
    }

    fun update() {
        val timestamp = SnakeskinRuntime.timestamp
        states.forEach {
            if (it.update(timestamp.value)) { //If the controller state changed
                handlerExecutor.scheduleSingleTaskNow(it.action) //Run the action
            }
        }
    }

    fun addController(controller: HIDController) {
        controller.listeners.forEach {
            states.add(createStateForListener(it))
        }
    }
}