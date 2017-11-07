package org.snakeskin.registry

import org.snakeskin.Robot
import org.snakeskin.auto.Auto
import org.snakeskin.auto.AutoManager


/*
 * snakeskin - Created on 11/7/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 11/7/17
 */

object Auto: Registry<Auto>() {
    override fun initAll() {
        AutoManager.registerAutos(registry)
    }
}