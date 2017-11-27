package org.snakeskin.auto

/*
 * snakeskin - Created on 11/7/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 11/7/17
 */
open class AutoStep(var entry: () -> Unit = Auto.EMPTY_LAMBDA,
                    var action: () -> Unit = Auto.EMPTY_LAMBDA,
                    var exit: () -> Unit = Auto.EMPTY_LAMBDA,
                    var done: Boolean = false)