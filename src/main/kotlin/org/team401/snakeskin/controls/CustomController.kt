package org.team401.snakeskin.controls

import org.team401.snakeskin.controls.mappings.IMappingDefinitions

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
    override val Mapping: IMappingDefinitions = object: IMappingDefinitions {
        override val Axes: IMappingDefinitions.AxesDefinitions = object: IMappingDefinitions.AxesDefinitions {}
        override val Buttons: IMappingDefinitions.ButtonsDefinitions = object: IMappingDefinitions.ButtonsDefinitions {}
        override val Hats: IMappingDefinitions.HatsDefinitions = object: IMappingDefinitions.HatsDefinitions {}
    }
}