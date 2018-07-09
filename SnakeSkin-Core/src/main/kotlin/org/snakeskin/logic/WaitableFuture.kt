package org.snakeskin.logic

import org.snakeskin.ability.AWaitable
import java.util.concurrent.CountDownLatch

/**
 * @author Cameron Earle
 * @version 11/3/17
 */
class WaitableFuture: AWaitable {
    private val waitLatch = CountDownLatch(1)

    private lateinit var waitable: AWaitable

    fun initWaitable(waitable: AWaitable) {
        this.waitable = waitable
        waitLatch.countDown()
    }

    override fun waitFor() {
        waitLatch.await()
        waitable.waitFor()
    }
}