package org.team401.snakeskin

import org.team401.snakeskin.dsl.Components
import org.team401.snakeskin.dsl.buildSubsystem

/*
 * snakeskin - Created on 8/17/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 8/17/17
 */
fun main(args: Array<String>) {
    buildSubsystem {
        stateMachine("SomeMachine") {
        }
    }
}