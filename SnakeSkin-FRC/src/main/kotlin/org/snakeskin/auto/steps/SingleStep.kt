package org.snakeskin.auto.steps

import org.snakeskin.measure.time.TimeMeasureSeconds

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
abstract class SingleStep: AutoStep() {
    override fun action(currentTime: TimeMeasureSeconds, lastTime: TimeMeasureSeconds): Boolean { return true }
    override fun exit(currentTime: TimeMeasureSeconds) {}
}