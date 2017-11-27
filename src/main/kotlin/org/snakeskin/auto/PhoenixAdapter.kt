package org.snakeskin.auto

import com.ctre.ILoopable

/*
 * snakeskin - Created on 11/26/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 11/26/17
 */

class PhoenixAdapter(loopable: ILoopable?): AutoStep() {
    init {
        if (loopable != null) {
            entry = loopable::OnStart
            action = loopable::OnLoop
            exit = loopable::OnStop
            done = loopable.IsDone()
        }
    }
}