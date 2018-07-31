package org.snakeskin.hardware.impl

import org.snakeskin.hardware.Hardware
import org.snakeskin.hardware.MotorControllerPWM
import org.snakeskin.logic.LockingDelegate

/**
 * @author Cameron Earle
 * @version 7/31/18
 */
class SoftwareMotorControllerPWM: MotorControllerPWM {
    override val hardwareObj: Nothing? = null

    var value by LockingDelegate(0.0)
    var enabled by LockingDelegate(false)

    var invert by LockingDelegate(false)

    var safety by LockingDelegate(true)
    var watchdogExpiration by LockingDelegate(0.02)
    var watchdogLast by LockingDelegate(0.0)

    fun checkWatchdog(): Boolean {
        val current = Hardware.getRelativeTime()

        return current - watchdogLast <= watchdogExpiration
    }

    override fun feed() {
        watchdogLast = Hardware.getRelativeTime()
        enabled = true
    }

    override fun disable() {
        enabled = false
    }

    override fun stopMotor() {
        enabled = false
        set(0.0)
    }

    override fun set(value: Double) {
        feed()
        if (inverted) {
            this.value = -value
        } else {
            this.value = value
        }
    }

    override fun get(): Double {
        if (!safety || (enabled && checkWatchdog())) return value
        return 0.0
    }

    override var expiration: Double
        get() = watchdogExpiration
        set(value) {watchdogExpiration = value}

    override val isAlive: Boolean
        get() = !safety || (enabled && checkWatchdog())

    override var isSafetyEnabled: Boolean
        get() = safety
        set(value) {safety = value}

    override var inverted: Boolean
        get() = invert
        set(value) {invert = value}

}