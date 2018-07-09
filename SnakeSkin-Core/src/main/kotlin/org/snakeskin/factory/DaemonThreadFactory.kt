package org.snakeskin.factory

import java.util.concurrent.ThreadFactory

/**
 * @author Cameron Earle
 * @version 5/16/18
 */
object DaemonThreadFactory: ThreadFactory {
    override fun newThread(r: Runnable?) = Thread(r).apply {
        isDaemon = true
    }
}