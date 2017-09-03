package org.team401.snakeskin

import org.team401.snakeskin.dsl.HumanControls
import org.team401.snakeskin.dsl.buildSubsystem

/*
 * snakeskin - Created on 9/3/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 9/3/17
 */

private fun test() {
    buildSubsystem {
        stateMachine("myMachine") {
            state("someState") {
                rejectIf {
                    true
                }

                entry {

                }

                action {

                }

                exit {

                }
            }

            disabled {
                //rejectIf not allowed

                action (50) {

                }
            }

            default {
                //rejectIf not allowed
            }
        }
    }

    HumanControls.f310(1) {
        whenButton(3) {
            pressed {
                //Now with
            }

            released {
                //SUB LAMBDAS!
            }
        }
    }
}