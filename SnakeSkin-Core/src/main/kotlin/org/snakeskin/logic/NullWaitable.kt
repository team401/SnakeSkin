package org.snakeskin.logic

import org.snakeskin.ability.AWaitable

/**
 * @author Cameron Earle
 * @version 8/15/17
 */
class NullWaitable: AWaitable {
    override fun waitFor() {}
}