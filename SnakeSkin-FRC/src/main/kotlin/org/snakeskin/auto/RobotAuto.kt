package org.snakeskin.auto

import edu.wpi.first.wpilibj.DriverStation
import org.snakeskin.auto.steps.AutoStep
import org.snakeskin.factory.ExecutorFactory
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

/*
 * snakeskin - Created on 5/11/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
abstract class RobotAuto(override val rate: Long = 5L, override val preRate: Long = 100L): AutoLoop() {
    private val executor = ExecutorFactory.getExecutor("Auto")
    private var future: ScheduledFuture<*>? = null

    private val sequence = arrayListOf<AutoStep>()
    private var sequenceIdx = 0
    private val adder: (AutoStep) -> Unit = { sequence.add(it) }

    open fun preAuto() {}
    abstract fun assembleAuto(add: (AutoStep) -> Unit)

    override fun startTasks() {
        val ds = DriverStation.getInstance()
        executor.scheduleAtFixedRate({
            if (ds.isDisabled) {
                preAuto()
            }
        }, 0L, preRate, TimeUnit.MILLISECONDS)
    }

    override fun stopTasks() {
        future?.cancel(true)
    }

    override fun entry(currentTime: Double) {
        StepAdder.add = adder
        done = false
        preAuto()
        sequence.clear()
        sequenceIdx = 0
        assembleAuto(adder)
        sequence.forEach {
            it.reset()
        }
    }

    override fun action(currentTime: Double, lastTime: Double) {
        if (sequenceIdx < sequence.size) {
            sequence[sequenceIdx].tick(currentTime, lastTime)
            if (sequence[sequenceIdx].doContinue()) {
                sequenceIdx++
            }
        } else {
            done = true
        }
    }

    override fun exit(currentTime: Double) {
        sequence.forEach {
            if (!it.doContinue()) {
                it.exit(currentTime)
            }
        }
    }
}