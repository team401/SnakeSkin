package org.team401.snakeskin.factory

import org.team401.snakeskin.logging.LoggerManager
import java.util.concurrent.ThreadFactory

/*
 * snakeskin - Created on 8/26/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 8/26/17
 */

object LoggedThreadFactory : ThreadFactory {
    override fun newThread(r: Runnable?): Thread {
        return Thread(r).apply {
            uncaughtExceptionHandler = LoggerManager.getExceptionHandler()
        }
    }

}