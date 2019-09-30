package org.snakeskin.init

import org.snakeskin.runtime.SnakeskinModules
import org.snakeskin.runtime.SnakeskinRuntime

class RevInit: Initializer {
    override fun preStartup() {
        SnakeskinRuntime.registerModule(SnakeskinModules.REV)
    }

    override fun postStartup() {
        //no-op
    }
}