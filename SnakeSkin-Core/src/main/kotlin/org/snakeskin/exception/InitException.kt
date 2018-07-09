package org.snakeskin.exception

/**
 * @author Cameron Earle
 * @version 1/20/18
 */
class InitException(message: String, cause: Throwable?): RuntimeException(message, cause!!)