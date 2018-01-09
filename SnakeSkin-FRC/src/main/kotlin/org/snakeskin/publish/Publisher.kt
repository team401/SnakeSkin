package org.snakeskin.publish

import edu.wpi.first.wpilibj.Sendable
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import kotlin.reflect.KProperty

/*
 * SnakeSkin - Created on 1/8/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 1/8/18
 */


class Publisher<T>(initialValue: T) {
    private var value = initialValue

    private fun publish(name: String) {
        when (value) {
            is Boolean -> SmartDashboard.putBoolean(name, value as Boolean)
            is Number -> SmartDashboard.putNumber(name, (value as Number).toDouble())
            is Sendable -> SmartDashboard.putData(name, value as Sendable)
            is ByteArray -> SmartDashboard.putRaw(name, value as ByteArray)
            else -> SmartDashboard.putString(name, value.toString())
        }
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>) = value

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = value
        var data =
        publish(property.name)
    }
}