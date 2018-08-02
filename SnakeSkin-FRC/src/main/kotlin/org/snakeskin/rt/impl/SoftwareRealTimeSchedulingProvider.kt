package org.snakeskin.rt.impl

import org.snakeskin.factory.ExecutorFactory
import org.snakeskin.rt.RealTimeSchedulingProvider
import java.util.concurrent.TimeUnit

/**
 * @author Cameron Earle
 * @version 8/1/18
 */
class SoftwareRealTimeSchedulingProvider(override val task: Runnable): RealTimeSchedulingProvider {
    private val executor = ExecutorFactory.getExecutor("RT Virtual Software")

    override fun startPeriodic(rate: Double) {
        executor.scheduleAtFixedRate(task, 0L, (rate / 1000L).toLong(), TimeUnit.MILLISECONDS)
    }
}