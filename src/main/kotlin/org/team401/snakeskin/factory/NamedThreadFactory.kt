package org.team401.snakeskin.factory

import java.util.concurrent.ThreadFactory

/*
 * snakeskin - Created on 7/20/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/20/17
 */

internal class NamedThreadFactory(val threadName: String): ThreadFactory {
    override fun newThread(r: Runnable?) = Thread(r).apply {
        name = threadName
    }

}