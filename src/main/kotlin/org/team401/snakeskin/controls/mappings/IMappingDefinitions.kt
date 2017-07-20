package org.team401.snakeskin.controls.mappings

import org.team401.snakeskin.controls.Controller

/*
 * snakeskin - Created on 7/20/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/20/17
 */

interface IMappingDefinitions {
    interface AxesDefinitions
    interface ButtonsDefinitions
    interface HatsDefinitions

    abstract val Axes: AxesDefinitions
    abstract val Buttons: ButtonsDefinitions
    abstract val Hats: HatsDefinitions
}