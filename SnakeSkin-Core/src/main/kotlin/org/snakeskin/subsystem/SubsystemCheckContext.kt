package org.snakeskin.subsystem

/**
 * @author Cameron Earle
 * @version 2/22/2019
 *
 */
class SubsystemCheckContext(private val passCallback: (name: String) -> Unit, private val failCallback: (name: String, reason: String) -> Unit) {
    private var activeCheck = ""

    fun start(name: String) {
        activeCheck = name
    }

    fun pass() {
        passCallback(activeCheck)
    }

    fun fail(reason: String) {
        failCallback(activeCheck, reason)
    }
}