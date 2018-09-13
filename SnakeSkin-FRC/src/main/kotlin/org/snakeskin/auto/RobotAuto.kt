package org.snakeskin.auto

import edu.wpi.first.wpilibj.DriverStation
import org.snakeskin.auto.steps.AutoStep
import org.snakeskin.auto.steps.SequentialSteps
import org.snakeskin.factory.ExecutorFactory
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

/**
 * @author Cameron Earle
 * @version 5/11/18
 *
 * Defines an auto loop that has several conveniences for using on an FRC robot.
 */
abstract class RobotAuto(override val rate: Long = 5L, val preRate: Long = 100L): AutoLoop() {
    private val executor = ExecutorFactory.getExecutor("Auto Pre Tasks") //This will be used to execute pre tasks
    private var preFuture: ScheduledFuture<*>? = null

    private val sequence = arrayListOf<AutoStep>()
    private var sequenceIdx = 0

    /**
     * Adds an array of steps to the sequence
     */
    @JvmName("addArray")
    protected fun add(steps: Array<AutoStep>) {
        sequence.addAll(steps)
    }

    /**
     * Runs certain tasks prior to auto's execution, at the rate defined by property "preRate"
     * If the preRate is <= 0, this function will not be called
     */
    open fun preAuto() {}

    /**
     * Assembles the auto sequence.  This method must return before the auto sequence can be executed,
     * so it is important to do minimal processing in this method.  Process intensive tasks should be done
     * asynchronously or in the preAuto function.
     */
    abstract fun assembleAuto(): SequentialSteps

    override fun startTasks() {
        val ds = DriverStation.getInstance()
        //If the prerate is defined
        if (preRate > 0L) {
            preFuture = executor.scheduleAtFixedRate({
                if (ds.isDisabled) {
                    preAuto()
                }
            }, 0L, preRate, TimeUnit.MILLISECONDS)
        }
    }

    override fun stopTasks() {
        preFuture?.cancel(true)
    }

    override fun entry(currentTime: Double) {
        done = false
        preAuto()
        sequence.clear()
        sequenceIdx = 0
        sequence.addAll(assembleAuto().steps)
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