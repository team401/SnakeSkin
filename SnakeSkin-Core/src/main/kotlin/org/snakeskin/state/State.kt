package org.snakeskin.state

import org.snakeskin.executor.ExceptionHandlingRunnable
import org.snakeskin.measure.time.TimeMeasureSeconds

/**
 * @author Cameron Earle
 * @version 8/3/17
 *
 * @param name The name of the state
 * @param entry The entry actions of the state
 * @param actionManager The object that manages the execution of this state's action loop
 * @param exit The exit actions of the state
 * @param rate The rate, in ms, to run the action loop at
 * @param rejectionConditions The rejection conditions for this state, which will prevent it being switched to
 * @param timeout The timeout length, in ms, to active the timeout
 * @param timeoutTo The state to timeout to
 */
data class State<T>(val name: T,
                    var entry: ExceptionHandlingRunnable = ExceptionHandlingRunnable.EMPTY,
                    var actionManager: IStateActionManager = EmptyStateActionManager,
                    var exit: ExceptionHandlingRunnable = ExceptionHandlingRunnable.EMPTY,
                    var rejectionConditions: () -> Boolean = {false},
                    var timeout: TimeMeasureSeconds = TimeMeasureSeconds(-1.0),
                    var timeoutTo: Any = ""
)