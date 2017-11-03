package org.snakeskin.logic

import org.snakeskin.ability.AWaitable
import java.util.concurrent.CountDownLatch

/*
 * snakeskin - Created on 11/3/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

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