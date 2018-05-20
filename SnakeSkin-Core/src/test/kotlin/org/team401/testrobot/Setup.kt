package org.team401.testrobot

import org.snakeskin.InitManager
import org.snakeskin.dsl.*
import org.snakeskin.registry.Subsystems

/*
 * snakeskin - Created on 5/16/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 5/16/18
 */

fun main(args: Array<String>) {
    InitManager.init() //Required for our testing, as the Robot class won't load it for us
    Thread.sleep(5000)
    send(CustomEvents.MY_CUSTOM_EVENT)
    Thread.sleep(100000)
}

@Setup
fun setup() {
    println("Test Robot!")
    Subsystems.add(TestSubsystem)
}