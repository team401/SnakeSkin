package org.snakeskin.factory

import java.util.concurrent.ThreadFactory

/*
 * snakeskin - Created on 5/16/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 5/16/18
 */
object DaemonThreadFactory: ThreadFactory {
    override fun newThread(r: Runnable?) = Thread(r).apply {
        isDaemon = true
    }
}