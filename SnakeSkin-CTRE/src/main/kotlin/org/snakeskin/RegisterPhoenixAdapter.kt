package org.snakeskin

import com.ctre.phoenix.ILoopable
import org.snakeskin.annotation.PreStartup
import org.snakeskin.auto.Auto
import org.snakeskin.auto.PhoenixAdapter

/*
 * snakeskin - Created on 1/1/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 1/1/18
 */

@PreStartup fun registerPhoenixAdapter() {
    Auto.adapters.registerAdapter(ILoopable::class.java) {
        PhoenixAdapter(it as ILoopable)
    }
}