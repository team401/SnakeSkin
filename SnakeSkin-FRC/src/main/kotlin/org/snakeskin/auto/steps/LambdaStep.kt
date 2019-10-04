package org.snakeskin.auto.steps

import org.snakeskin.measure.time.TimeMeasureSeconds

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
class LambdaStep(val lambda: () -> Unit): SingleStep() {
    override fun entry(currentTime: TimeMeasureSeconds) {
        lambda()
    }
}