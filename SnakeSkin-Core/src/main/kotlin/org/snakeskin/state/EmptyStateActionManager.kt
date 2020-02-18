package org.snakeskin.state

import org.snakeskin.measure.time.TimeMeasureSeconds

/**
 * Empty state action manager for states that don't provide an action loop
 */
object EmptyStateActionManager: IStateActionManager {
    override val rate = TimeMeasureSeconds(0.0)
    override val asyncTransition = false
    override fun startAction() {}
    override fun stopAction() {}
    override fun awaitDone() {}
}