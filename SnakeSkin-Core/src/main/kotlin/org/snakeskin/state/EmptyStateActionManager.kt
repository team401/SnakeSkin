package org.snakeskin.state

/**
 * Empty state action manager for states that don't provide an action loop
 */
object EmptyStateActionManager: IStateActionManager {
    override fun startAction() {}
    override fun stopAction() {}
    override fun awaitDone() {}
}