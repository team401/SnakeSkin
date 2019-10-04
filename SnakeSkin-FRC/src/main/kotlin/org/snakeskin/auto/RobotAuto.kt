package org.snakeskin.auto

import edu.wpi.first.wpilibj.DriverStation
import org.snakeskin.auto.steps.AutoStep
import org.snakeskin.auto.steps.SequentialSteps
import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.executor.IExecutorTaskHandle
import org.snakeskin.measure.MeasureUnitless
import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.runtime.SnakeskinRuntime
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

/**
 * @author Cameron Earle
 * @version 5/11/18
 *
 * Defines an auto loop that has several conveniences for using on an FRC robot.
 */
abstract class RobotAuto(override val rate: TimeMeasureSeconds = TimeMeasureSeconds(0.02), val preRate: TimeMeasureSeconds = TimeMeasureSeconds(0.1)): AutoLoop() {
    private val executor = SnakeskinRuntime.primaryExecutor
    private var preTaskHandle: IExecutorTaskHandle? = null

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
    open fun preAuto() {
        preTaskHandle?.stopTask(false) //If the user doesn't override the default, cancel the task
    }

    /**
     * Assembles the auto sequence.  This method must return before the auto sequence can be executed,
     * so it is important to do minimal processing in this method.  Process intensive tasks should be done
     * asynchronously or in the preAuto function.
     */
    abstract fun assembleAuto(): SequentialSteps

    override fun startTasks() {
        val ds = DriverStation.getInstance()
        //If the pre rate is defined
        if (preRate > MeasureUnitless(0.0)) {
            preTaskHandle = executor.schedulePeriodicTask(ExceptionHandlingRunnable {
                if (ds.isDisabled) {
                    preAuto()
                }
            }, preRate)
        }
    }

    override fun stopTasks() {
        preTaskHandle?.stopTask(true)
    }

    override fun entry(currentTime: TimeMeasureSeconds) {
        done = false
        preAuto()
        sequence.clear()
        sequenceIdx = 0
        sequence.addAll(assembleAuto().steps)
        sequence.forEach {
            it.reset()
        }
    }

    override fun action(currentTime: TimeMeasureSeconds, lastTime: TimeMeasureSeconds) {
        if (sequenceIdx < sequence.size) {
            sequence[sequenceIdx].tick(currentTime, lastTime)
            if (sequence[sequenceIdx].doContinue()) {
                sequenceIdx++
            }
        } else {
            done = true
        }
    }

    override fun exit(currentTime: TimeMeasureSeconds) {
        sequence.forEach {
            if (!it.doContinue()) {
                it.exit(currentTime)
            }
        }
    }
}