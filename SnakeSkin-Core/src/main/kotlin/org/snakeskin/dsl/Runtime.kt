package org.snakeskin.dsl

import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.runtime.SnakeskinRuntime

/**
 * The current timestamp, in seconds
 */
val timestampNow: TimeMeasureSeconds
get() = SnakeskinRuntime.timestamp

/**
 * The current system voltage, in volts
 */
val voltageNow: Double
get() = SnakeskinRuntime.voltage

/**
 * Runs a task in the background
 */
fun runTask(task: () -> Unit) {
    SnakeskinRuntime.executeTask(ExceptionHandlingRunnable(task))
}