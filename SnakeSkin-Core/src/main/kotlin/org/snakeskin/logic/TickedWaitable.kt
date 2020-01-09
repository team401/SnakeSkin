package org.snakeskin.logic

import org.snakeskin.ability.IWaitable
import java.util.concurrent.CountDownLatch

/**
 * @author Cameron Earle
 * @version 8/1/17
 */
open class TickedWaitable: IWaitable {
    private val ticker = CountDownLatch(1)

    override fun waitFor() = ticker.await()

    /**
     * To be called only by the source of the waitable.  Calling this function from the receiving code
     * defeats the purpose of the waitable
     */
    fun tick() = ticker.countDown()
}