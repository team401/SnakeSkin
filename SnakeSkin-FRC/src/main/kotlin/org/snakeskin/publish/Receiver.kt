package org.snakeskin.publish

import edu.wpi.first.wpilibj.Sendable
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import kotlin.reflect.KProperty

/**
 * @author Cameron Earle
 * @version 1/8/18
 */
@Suppress("UNCHECKED_CAST")
class Receiver<T>(defaultValue: T) {
    private var value = defaultValue
    private val lock = Any()

    private fun receive(name: String): T {
        when (value) {
            is Boolean -> return SmartDashboard.getBoolean(name, value as Boolean) as T
            is Byte -> return SmartDashboard.getNumber(name, (value as Byte).toDouble()).toByte() as T
            is Short -> return SmartDashboard.getNumber(name, (value as Short).toDouble()).toShort() as T
            is Int -> return SmartDashboard.getNumber(name, (value as Int).toDouble()).toInt() as T
            is Long -> return SmartDashboard.getNumber(name, (value as Long).toDouble()).toLong() as T
            is Float -> return SmartDashboard.getNumber(name, (value as Float).toDouble()).toFloat() as T
            is Double -> return SmartDashboard.getNumber(name, (value as Double)) as T
            is ByteArray -> return SmartDashboard.getRaw(name, (value as ByteArray)) as T
            is Sendable -> return SmartDashboard.getData(name) as T
            is String -> return SmartDashboard.getString(name, (value as String)) as T
            else -> {
                throw ClassCastException("Invalid type passed for key ${name}")
            }
        }
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        synchronized(lock) {
            return receive(property.name)
        }
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        synchronized(lock) {
            this.value = value
        }
    }
}