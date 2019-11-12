package org.snakeskin.runtime.impl

import org.snakeskin.executor.IExecutor
import org.snakeskin.hid.IHIDValueProviderFactory
import org.snakeskin.rt.IRealTimeExecutor
import org.snakeskin.runtime.IRuntimePlatformBinding

class RuntimePlatformBindingSoftware: IRuntimePlatformBinding {
    override fun blockMilliseconds(ms: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun allocatePrimaryExecutor(): IExecutor {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun allocateSingleUseExecutor(): IExecutor {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun allocateRealTimeExecutor(rateSeconds: Double): IRealTimeExecutor {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTimestampSeconds(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun allocateHIDValueProviderFactory(id: Int): IHIDValueProviderFactory {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}