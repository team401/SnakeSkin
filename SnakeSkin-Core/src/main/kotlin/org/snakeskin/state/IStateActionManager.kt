package org.snakeskin.state

/**
 * Interface for implementations of state action managers.
 * State action managers are responsible for starting and stopping the action loop of a state
 */
interface IStateActionManager {
    /**
     * Starts the action loop of the state
     */
    fun startAction()

    /**
     * Stops the action loop of the state
     */
    fun stopAction()
}