package org.snakeskin.logic

import org.snakeskin.ability.IWaitable

/**
 * @author Cameron Earle
 * @version 8/15/17
 */
object NullWaitable: IWaitable {
    override fun waitFor() {}
}