package org.snakeskin.auto

import com.ctre.phoenix.ILoopable
import org.snakeskin.annotation.PreStartup
import org.snakeskin.dsl.autoStep

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
    override fun entry() = loopable?.onStart() ?: Unit
    override fun action() {
        loopable?.onLoop()
        done = loopable?.isDone ?: true
    }
    override fun exit() = loopable?.onStop() ?: Unit
}