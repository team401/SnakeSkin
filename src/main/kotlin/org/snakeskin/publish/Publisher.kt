package org.snakeskin.publish

import edu.wpi.first.wpilibj.Sendable
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard

/*
 * snakeskin - Created on 10/20/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 10/20/17
 */
class Publisher {
    private val numbers = hashMapOf<String, () -> Double>()
    private val booleans = hashMapOf<String, () -> Boolean>()
    private val strings = hashMapOf<String, () -> String>()
    private val sendables = hashMapOf<String, () -> Sendable>()

    @Synchronized fun publishNumber(name: String, getter: () -> Double) = numbers.put(name, getter)
    @Synchronized fun publishBoolean(name: String, getter: () -> Boolean) = booleans.put(name, getter)
    @Synchronized fun publishString(name: String, getter: () -> String) = strings.put(name, getter)
    @Synchronized fun publishSendable(name: String, getter: () -> Sendable) = sendables.put(name, getter)

    @Synchronized internal fun publish() {
        numbers.forEach {
            name, getter ->
            SmartDashboard.putNumber(name, getter())
        }
        booleans.forEach {
            name, getter ->
            SmartDashboard.putBoolean(name, getter())
        }
        strings.forEach {
            name, getter ->
            SmartDashboard.putString(name, getter())
        }
        sendables.forEach {
            name, getter ->
            SmartDashboard.putData(name, getter())
        }
    }

    @Synchronized internal fun populated() =
            numbers.isNotEmpty()
            || booleans.isNotEmpty()
            || strings.isNotEmpty()
            || sendables.isNotEmpty()
}