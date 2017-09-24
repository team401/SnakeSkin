package org.team401.snakeskin.registry

import org.team401.snakeskin.ability.AWaitable
import org.team401.snakeskin.subsystem.Subsystem

/*
 * snakeskin - Created on 7/16/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/16/17
 */

object Subsystems: Registry<Subsystem>() {
    override fun initAll() {
        registry.forEach {
            it.init()
        }
    }
}