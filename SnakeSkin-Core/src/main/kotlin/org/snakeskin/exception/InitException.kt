package org.snakeskin.exception

/*
 * snakeskin - Created on 1/20/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 1/20/18
 */

class InitException(message: String, cause: Throwable?): RuntimeException(message, cause!!)