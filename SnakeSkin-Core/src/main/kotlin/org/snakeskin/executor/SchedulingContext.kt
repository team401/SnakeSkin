package org.snakeskin.executor

import java.util.concurrent.ScheduledFuture

/**
 * @author Cameron Earle
 * @version 7/10/2018
 *
 */
interface SchedulingContext {
    fun schedule(): ScheduledFuture<*>
}