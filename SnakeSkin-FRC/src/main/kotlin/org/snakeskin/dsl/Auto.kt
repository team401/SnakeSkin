package org.snakeskin.dsl

import org.snakeskin.auto.RobotAuto
import org.snakeskin.auto.steps.*
import org.snakeskin.measure.time.TimeMeasureSeconds

/**
 * @author Cameron Earle
 * @version 8/9/2018
 *
 */
abstract class AutoStepBuilder<T: AutoStep>: Builder<T> {
    protected val steps = arrayListOf<AutoStep>()

    private fun addStep(autoStep: AutoStep) {
        steps.add(autoStep)
    }

    fun parallel(setup: ParallelAutoStepBuilder.() -> Unit) {
        val parallelBuilder = ParallelAutoStepBuilder()
        parallelBuilder.setup()
        addStep(parallelBuilder.build())
    }

    fun sequential(setup: SequentialAutoStepBuilder.() -> Unit) {
        val sequentialBuilder = SequentialAutoStepBuilder()
        sequentialBuilder.setup()
        addStep(sequentialBuilder.build())
    }

    fun step(action: () -> Unit) {
        addStep(LambdaStep(action))
    }

    fun step(autoStep: AutoStep) {
        addStep(autoStep)
    }

    fun delay(amount: TimeMeasureSeconds) {
        addStep(DelayStep(amount))
    }

    fun debug(output: Any) {
        addStep(LambdaStep { println(output) })
    }

    fun waitFor(timeout: TimeMeasureSeconds = TimeMeasureSeconds(-1.0), condition: () -> Boolean) {
        addStep(WaitStep(timeout, condition))
    }
}

class ParallelAutoStepBuilder: AutoStepBuilder<ParallelSteps>() {
    override fun build(): ParallelSteps {
        return ParallelSteps(*steps.toTypedArray())
    }
}

class SequentialAutoStepBuilder: AutoStepBuilder<SequentialSteps>() {
    override fun build(): SequentialSteps {
        return SequentialSteps(*steps.toTypedArray())
    }
}

/**
 * Creates an auto routine.  This would be called inside of the "assembleAuto" function.
 * It is used in the following context:
 *
 * override fun assembleAuto(): SequentialSteps {
 *     return auto {
 *         ...
 *     }
 * }
 */
fun auto(setup: SequentialAutoStepBuilder.() -> Unit): SequentialSteps {
    val builder = SequentialAutoStepBuilder()
    builder.setup()
    return builder.build()
}