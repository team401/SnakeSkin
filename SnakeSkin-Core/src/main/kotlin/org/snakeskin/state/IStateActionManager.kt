package org.snakeskin.state

/**
 * Interface for implementations of state action managers.
 * State action managers are responsible for starting and stopping the action loop of a state
 */
interface IStateActionManager {
    /**
     * Perform any registration tasks required for the action manager
     */
    fun register() {}

    /**
     * Starts the action loop of the state
     */
    fun startAction()

    /**
     * Stops the action loop of the state
     */
    fun stopAction()

    /**
     * Blocks until the current iteration of the action loop is complete
     */
    fun awaitDone()
}