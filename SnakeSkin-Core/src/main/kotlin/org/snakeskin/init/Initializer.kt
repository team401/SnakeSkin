package org.snakeskin.init

/**
 * @author Cameron Earle
 * @version 11/29/2018
 *
 * Interface to be implemented by any class that wants to do initialization.
 *
 * Note that implementations should be classes and not objects, as we will use reflection to make a unique instance
 */
interface Initializer {
    fun preStartup()
    fun postStartup()
}