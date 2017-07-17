package org.team401.snakeskin.subsystem

import org.team401.snakeskin.dsl.toMode
import org.team401.snakeskin.dsl.toState
import org.team401.snakeskin.registry.Subsystems

/*
 * snakeskin - Created on 7/16/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/16/17
 */

fun setup() {

}

fun main(args: Array<String>) {
    MySubsystem toState "low"
    MySubsystem toMode "openloop"
    Subsystems.add(
            MySubsystem,
            MySubsystem,
            MySubsystem
    )
}