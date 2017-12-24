package org.snakeskin.logic

import org.snakeskin.ability.AWaitable

/*
 * snakeskin - Created on 8/15/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 8/15/17
 */

class NullWaitable: AWaitable {
    override fun waitFor() {}
}