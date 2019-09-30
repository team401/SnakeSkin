package org.snakeskin.init

import org.snakeskin.runtime.SnakeskinModules
import org.snakeskin.runtime.SnakeskinRuntime

class CtreInit: Initializer {
    override fun preStartup() {
        SnakeskinRuntime.registerModule(SnakeskinModules.CTRE)
    }

    override fun postStartup() {
    }
}