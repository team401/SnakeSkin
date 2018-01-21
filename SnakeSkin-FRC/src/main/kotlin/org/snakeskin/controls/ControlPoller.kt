package org.snakeskin.controls

import edu.wpi.first.wpilibj.DriverStation
import org.snakeskin.SnakeskinConstants
import org.snakeskin.factory.ExecutorFactory
import org.snakeskin.logic.History
import java.util.*
import java.util.concurrent.TimeUnit

/*
 * snakeskin - Created on 7/16/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/16/17
 */

object ControlPoller {
    private val pollingExecutor = ExecutorFactory.getExecutor("Controls Polling")
    private val handlerExecutor = ExecutorFactory.getExecutor("Controls Handling")

    private class ControllerTracker(private val controller: Controller) {
        class ChangeReport {
            val pressedButtons = arrayListOf<Int>()
            val releasedButtons = arrayListOf<Int>()
            val changedHats = hashMapOf<Int, Int>()
        }

        val bpHandlers = controller.buttonPressedListeners
        val brHandlers = controller.buttonReleasedListeners
        val hatHandlers = controller.hatChangeListeners

        val trackedPressButtons = hashMapOf<Int, History<Boolean>>()
        val trackedReleaseButtons = hashMapOf<Int, History<Boolean>>()
        val trackedHats = hashMapOf<Int, History<Int>>()

        init {
            bpHandlers.keys.forEach {
                trackedPressButtons.put(it, History())
            }
            brHandlers.keys.forEach {
                trackedReleaseButtons.put(it, History())
            }
            hatHandlers.keys.forEach {
                trackedHats.put(it, History())
            }
        }

        fun track(): ChangeReport {
            val changeReport = ChangeReport()
            if (DriverStation.getInstance().isEnabled && DriverStation.getInstance().isOperatorControl) {
                trackedPressButtons.forEach {
                    button, history ->
                    history.update(controller.getButton(button).read())
                    if (history.current == true) {
                        if (history.last == false || history.last == null) {
                            changeReport.pressedButtons.add(button)
                        }
                    }
                }
                trackedReleaseButtons.forEach {
                    button, history ->
                    history.update(controller.getButton(button).read())
                    if (history.current == false) {
                        if (history.last == true) {
                            changeReport.releasedButtons.add(button)
                        }
                    }
                }
                trackedHats.forEach {
                    hat, history ->
                    history.update(controller.getHat(hat).read())
                    if (history.current != null && history.last != null) {
                        if (history.current != history.last) {
                            changeReport.changedHats.put(hat, history.current!!)
                        }
                    }
                }
            }
            return changeReport
        }
    }

    private val controllers = Vector<ControllerTracker>()

    private val task = {
        controllers.forEach { //Iterate each controller
            val controller = it
            val report = it.track()
            report.pressedButtons.forEach {
                handlerExecutor.submit {
                    controller.bpHandlers[it]?.invoke()
                }
            }
            report.releasedButtons.forEach {
                handlerExecutor.submit { controller.brHandlers[it]?.invoke() }
            }
            report.changedHats.forEach {
                handlerExecutor.submit { controller.hatHandlers[it.key]?.invoke(it.value) }
            }
        }
    }

    fun init() {
        pollingExecutor.scheduleAtFixedRate(task, 0, SnakeskinConstants.CONTROLLER_POLL_RATE, TimeUnit.MILLISECONDS)
    }

    fun addController(controller: Controller) {
        controllers.add(ControllerTracker(controller))
    }
}