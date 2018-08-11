package org.snakeskin

import org.snakeskin.compiler.PatchingClassLoader
import org.snakeskin.debug.DebuggerShell
import org.snakeskin.hardware.Environment
import org.snakeskin.hardware.Hardware
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
object SoftwareMain {
    @JvmStatic
    fun main(args: Array<String>) {
        Hardware.environment = Environment.SOFTWARE
        Hardware.setTimeSource(SoftwareTimeSource())
        InitManager.init()

        val shell = DebuggerShell(System.`in`, System.out)
        shell.init()
        shell.run()
    }
}