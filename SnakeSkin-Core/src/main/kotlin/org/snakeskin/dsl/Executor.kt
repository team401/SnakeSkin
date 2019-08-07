package org.snakeskin.dsl

import org.snakeskin.factory.ExecutorFactory

/**
 * @author Cameron Earle
 * @version 8/7/2019
 *
 */

private val executor = ExecutorFactory.getExecutor()

/**
 * Submits a task to be run in the background, on the thread pool
 */
fun background(action: () -> Unit) {
    executor.submit(action)
}