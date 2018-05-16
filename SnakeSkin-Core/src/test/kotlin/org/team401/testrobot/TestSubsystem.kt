package org.team401.testrobot

import org.snakeskin.dsl.*

/*
 * snakeskin - Created on 5/16/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 5/16/18
 */

object TestSubsystem : Subsystem("Test") {
    enum class TestStates {
        SOME_STATE,
        SOME_OTHER_STATE
    }

    override fun setup() {
        on("SomeEvent") {
            testMachine.setState(TestStates.SOME_STATE)
        }
    }

    val testMachine = stateMachine {
        state(TestStates.SOME_STATE) {
            entry {

            }

            action {

            }

            exit {

            }
        }
    }
}