package org.snakeskin.dsl

import org.snakeskin.auto.AutoStep
import org.snakeskin.auto.LambdaAutoStep

/*
 * snakeskin - Created on 11/7/17
 * Author: Cameron Earle
 *
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 11/7/17
 */

fun autoStep(setup: AutoStepBuilder.() -> Unit): AutoStep {
    val builder = AutoStepBuilder()
    builder.setup()
    return builder.build()
}

class AutoStepBuilder: Builder<AutoStep> {
    private val builder = LambdaAutoStep()
    override fun build() = builder

    fun entry(action: () -> Unit) {
        builder.entry = action
    }

    fun action(action: () -> Unit) {
        builder.action = action
    }

    fun exit(action: () -> Unit) {
        builder.exit = action
    }

    fun done() {
        builder.done = true
    }
}