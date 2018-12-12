package org.snakeskin.init

/**
 * @author Cameron Earle
 * @version 11/29/2018
 *
 * Interface to be implemented by any class that wants to do initialization.
 *
 * Note that implementations should be classes and not objects, as we will use reflection to make a unique instance
 *
 * Also, note that this is for internal initialization across modules only.  The InitManager will search for a specific
 * set of implementations and load them at runtime, and will not load ANY other implementation.  To run code in the
 * PreStartup and PostStartup contexts in user code, use the corresponding annotations on static methods.
 */
interface Initializer {
    fun preStartup()
    fun postStartup()
}