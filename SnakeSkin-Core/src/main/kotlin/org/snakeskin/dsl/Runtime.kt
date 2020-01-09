package org.snakeskin.dsl

import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.measure.time.TimeMeasureSeconds
import org.snakeskin.runtime.SnakeskinPlatform
import org.snakeskin.runtime.SnakeskinRuntime

/**
 * Reads the current timestamp from the runtime, in seconds
 */
fun readTimestamp() = SnakeskinRuntime.timestamp

/**
 * Reads the current voltage from the runtime, in volts
 */
fun readVoltage() = SnakeskinRuntime.voltage

/**
 * Runs a task in the background
 */
fun runTask(task: () -> Unit) {
    SnakeskinRuntime.executeTask(ExceptionHandlingRunnable(task))
}

/**
 * Returns true if the running platform is hardware (currently FRC roboRIO), and false otherwise
 */
inline val isHardware: Boolean
get() = SnakeskinRuntime.platform == SnakeskinPlatform.FRC_ROBORIO