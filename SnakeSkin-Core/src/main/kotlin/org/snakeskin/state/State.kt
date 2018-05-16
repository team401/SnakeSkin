package org.snakeskin.state

/*
 * snakeskin - Created on 8/3/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 8/3/17
 */
data class State(val name: Any,
                 var entry: () -> Unit,
                 var action: () -> Unit,
                 var exit: () -> Unit,
                 var rate: Long = 20,
                 var rejectionConditions: () -> Boolean = {false},
                 var timeout: Long = -1L,
                 var timeoutTo: Any = "")