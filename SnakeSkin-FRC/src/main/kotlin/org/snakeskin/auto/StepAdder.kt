package org.snakeskin.auto

import org.snakeskin.auto.steps.AutoStep

/*
 * snakeskin - Created on 5/11/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
object StepAdder {
    var add: (AutoStep) -> Unit = {}
}