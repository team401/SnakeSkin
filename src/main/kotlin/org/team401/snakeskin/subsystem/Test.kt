package org.team401.snakeskin.subsystem

import edu.wpi.first.wpilibj.TalonSRX
import org.team401.snakeskin.controls.mappings.Extreme3D
import org.team401.snakeskin.dsl.*
import org.team401.snakeskin.dsl.subsystem
import org.team401.snakeskin.event.Events

/*
 * SnakeSkin - Created on 7/4/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/4/17
 */

val MyController = HumanControls.extreme3d(1) {
    whenButtonPressed(Buttons.BASE_BOTTOM_LEFT) {

    }
}

val MySubsystem = subsystem {
    val left = TalonSRX(0)
    val right = TalonSRX(1)

    setup {
        left.isSafetyEnabled = false
        right.isSafetyEnabled = false //Because screw safety
    }

    on (Events.AUTO_ENABLED) {
        STATE = "somestate"
        MODE = "somemode"
    }

    state ("low") {
        //Shift operation
    }

    state ("high") {
        //Shift operation
    }

    loop { //Main drive loop
        when (MODE) {
            "openloop" -> {
                //get joystick
                left.set(1.0)
                right.set(1.0)
            }
            "closedloop" -> {
                //spicy pid memes here
            }
        }
    }
}