package org.snakeskin.publish

import edu.wpi.first.wpilibj.Sendable
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import kotlin.reflect.KProperty

/**
 * @author Cameron Earle
 * @version 1/8/18
 */
class Publisher<T>(initialValue: T) {
    private var value = initialValue
    private val lock = Any()

    private fun publish(name: String) {
        when (value) {
            is Boolean -> SmartDashboard.putBoolean(name, value as Boolean)
            is Number -> SmartDashboard.putNumber(name, (value as Number).toDouble())
            is Sendable -> SmartDashboard.putData(name, value as Sendable)
            is ByteArray -> SmartDashboard.putRaw(name, value as ByteArray)
            else -> SmartDashboard.putString(name, value.toString())
        }
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        synchronized(lock) {
            return value
        }
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        synchronized(lock) {
            this.value = value
            publish(property.name)
        }
    }
}