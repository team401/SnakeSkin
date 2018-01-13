package org.snakeskin.auto

/*
 * snakeskin - Created on 1/13/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 1/13/18
 */

data class AutoLoop(var entry: () -> Unit = {},
                    var action: () -> Unit = {},
                    var exit: () -> Unit = {},
                    var rate: Long = 10)