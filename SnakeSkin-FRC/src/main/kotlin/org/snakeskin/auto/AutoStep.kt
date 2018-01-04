package org.snakeskin.auto

import org.snakeskin.ability.ATickable

open class AutoStep: ATickable {
    open fun entry() {}
    open fun action() { done = true }
    open fun exit() {}

    var done = false

    var state = State.ENTRY
    private set

    enum class State {
        ENTRY,
        ACTION,
        EXIT,
        CONTINUE
    }

    override fun tick() {
        when (state) {
            State.ENTRY -> {
                entry()
                state = State.ACTION
            }
            State.ACTION -> {
                action()
                if (done) {
                    state = State.EXIT
                }
            }
            State.EXIT -> {
                exit()
                state = State.CONTINUE
            }
            else -> {}
        }
    }

    fun doContinue() = state == State.CONTINUE

    fun reset() {
        state = State.ENTRY
        done = false
    }
}