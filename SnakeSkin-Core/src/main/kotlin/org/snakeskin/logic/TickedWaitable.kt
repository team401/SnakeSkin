package org.snakeskin.logic

import org.snakeskin.ability.AWaitable
import java.util.concurrent.CountDownLatch

/**
 * @author Cameron Earle
 * @version 8/1/17
 */
open class TickedWaitable: AWaitable {
    private val ticker = CountDownLatch(1)

    override fun waitFor() = ticker.await()

    internal fun tick() = ticker.countDown()
}