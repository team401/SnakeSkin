package org.snakeskin.rt.impl

import edu.wpi.first.wpilibj.Notifier
import org.snakeskin.rt.RealTimeSchedulingProvider

/**
 * @author Cameron Earle
 * @version 8/1/18
 */
class HardwareRealTimeSchedulingProvider(override val task: Runnable): RealTimeSchedulingProvider {
    private val notifier = Notifier(task)

    override fun startPeriodic(rate: Double) {
        notifier.startPeriodic(rate)
    }
}