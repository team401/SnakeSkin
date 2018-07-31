package org.snakeskin.hardware

import org.snakeskin.InitManager
import org.snakeskin.hardware.impl.SoftwareTimeSource

/**
 * @author Cameron Earle
 * @version 7/30/2018
 *
 * Main class to initialize a software (emulated) environment.
 *
 * Executes the following steps:
 * 1. Set Hardware Environment to SOFTWARE
 * 2. Bootstrap InitManager
 * 3. Launch management console if argument provided
 */
fun main(args: Array<String>) {
    Hardware.environment = Environment.SOFTWARE
    Hardware.setTimeSource(SoftwareTimeSource())
    InitManager.init()
    if (args.any { it.toLowerCase() == "console" }) {
        //Todo launch console here
    } else {
        Thread.currentThread().join() //Wait forever
    }
}