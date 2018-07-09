package org.snakeskin.controls.mappings

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