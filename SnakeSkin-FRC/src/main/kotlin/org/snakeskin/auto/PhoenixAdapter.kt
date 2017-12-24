package org.snakeskin.auto

import com.ctre.phoenix.ILoopable

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

class PhoenixAdapter(val loopable: ILoopable?): AutoStep() {
    init {
        if (loopable == null) {
            throw IllegalArgumentException("Parameter 'loopable' cannot be null!")
        }
    }

    override fun entry() = loopable?.OnStart() ?: Unit
    override fun action() {
        loopable?.OnLoop()
        done = loopable?.IsDone() ?: true
    }
    override fun exit() = loopable?.OnStop() ?: Unit
}