package org.snakeskin.runtime.impl

import org.snakeskin.executor.IExecutor
import org.snakeskin.executor.impl.NullExecutor
import org.snakeskin.hid.IHIDValueProviderFactory
import org.snakeskin.hid.impl.NullHIDValueProviderFactory
import org.snakeskin.rt.IRealTimeExecutor
import org.snakeskin.rt.impl.NullRealTimeExecutor
import org.snakeskin.runtime.IRuntimePlatformBinding

object NullRuntimePlatformBinding : IRuntimePlatformBinding {
    override fun getTimestampSeconds(): Double {
        //no-op
        return 0.0
    }

    override fun blockMilliseconds(ms: Long) {
        //no-op
    }

    override fun getSystemVbusVolts(): Double {
        //no-op
        return 0.0
    }

    override fun allocatePrimaryExecutor(): IExecutor {
        //no-op
        return NullExecutor
    }

    override fun allocateSingleUseExecutor(): IExecutor {
        //no-op
        return NullExecutor
    }

    override fun allocateRealTimeExecutor(rateSeconds: Double): IRealTimeExecutor {
        //no-op
        return NullRealTimeExecutor
    }

    override fun allocateHIDValueProviderFactory(id: Int): IHIDValueProviderFactory {
        //no-op
        return NullHIDValueProviderFactory
    }

}