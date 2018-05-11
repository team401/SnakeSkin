package org.snakeskin.auto.steps

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
abstract class AutoStep(var done: Boolean = false) {
    private val isSingleStep = done
    enum class State {
        ENTRY,
        ACTION,
        EXIT,
        CONTINUE
    }

    var state = State.ENTRY; private set

    fun reset() {
        state = State.ENTRY
        if (!isSingleStep) {
            done = false
        }
    }

    fun doContinue() = (state == State.CONTINUE)

    fun tick(currentTime: Double, lastTime: Double) {
        when (state) {
            State.ENTRY -> {
                entry(currentTime)
                state = State.ACTION
            }
            State.ACTION -> {
                action(currentTime, lastTime)
                if (done) {
                    state = State.EXIT
                }
            }
            State.EXIT -> {
                exit(currentTime)
                state = State.CONTINUE
            }
            else -> {}
        }
    }

    abstract fun entry(currentTime: Double)
    abstract fun exit(currentTime: Double)
    abstract fun action(currentTime: Double, lastTime: Double)
}