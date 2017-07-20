package org.team401.snakeskin.controls

/*
 * snakeskin - Created on 7/18/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/18/17
 */

class CustomController(id: Int): Controller(id) {
    override val Axes: AxesDefinitions = object: AxesDefinitions{}
    override val Buttons: ButtonsDefinitions = object: ButtonsDefinitions{}
    override val Hats: HatsDefinitions = object: HatsDefinitions{}
}