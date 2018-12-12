package org.snakeskin.controls.listener

import org.snakeskin.ability.AReadable

/**
 * @author Cameron Earle
 * @version 12/12/2018
 *
 */
interface ControlListener<S: AReadable<T>, T> {
    val surface: S
    val action: (T) -> Unit
}