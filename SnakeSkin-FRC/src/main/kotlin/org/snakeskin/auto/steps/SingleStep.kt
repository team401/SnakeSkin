package org.snakeskin.auto.steps

/*
 * snakeskin - Created on 5/11/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 5/11/18
 */
abstract class SingleStep: AutoStep(true) {
    override fun action(currentTime: Double, lastTime: Double) {}
    override fun exit(currentTime: Double) {}
}