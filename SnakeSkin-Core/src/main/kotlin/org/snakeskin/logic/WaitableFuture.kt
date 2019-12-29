package org.snakeskin.logic

import org.snakeskin.ability.IWaitable
import java.util.concurrent.CountDownLatch

/**
 * @author Cameron Earle
 * @version 11/3/17
 */
class WaitableFuture: IWaitable {
    private val waitLatch = CountDownLatch(1)

    private lateinit var waitable: IWaitable

    fun initWaitable(waitable: IWaitable) {
        this.waitable = waitable
        waitLatch.countDown()
    }

    override fun waitFor() {
        waitLatch.await()
        waitable.waitFor()
    }
}