package org.snakeskin.logic

import org.snakeskin.ability.AWaitable
import java.util.concurrent.CountDownLatch

/*
 * snakeskin - Created on 8/1/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 8/1/17
 */
open class TickedWaitable: AWaitable {
    private val ticker = CountDownLatch(1)

    override fun waitFor() = ticker.await()

    internal fun tick() = ticker.countDown()
}