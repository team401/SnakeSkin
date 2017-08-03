package org.team401.snakeskin.registry

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

object Subsystems {
    private val subsystems = arrayListOf<Subsystem>()

    fun add(vararg subsystems: Subsystem) {
        this.subsystems.addAll(subsystems)
    }

    fun initAll() {
        subsystems.forEach {
            it.init()
        }
    }
}