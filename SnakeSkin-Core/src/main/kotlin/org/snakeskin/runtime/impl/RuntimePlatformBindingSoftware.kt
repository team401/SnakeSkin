package org.snakeskin.runtime.impl

import org.snakeskin.executor.IExecutor
import org.snakeskin.executor.impl.ScheduledExecutorServiceExecutor
import org.snakeskin.hid.IHIDValueProviderFactory
import org.snakeskin.hid.impl.NullHIDValueProviderFactory
import org.snakeskin.rt.IRealTimeExecutor
import org.snakeskin.rt.impl.NullRealTimeExecutor
import org.snakeskin.runtime.IRuntimePlatformBinding
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit

class RuntimePlatformBindingSoftware: IRuntimePlatformBinding {
    override fun blockMilliseconds(ms: Long) {
        Thread.sleep(ms)
    }

    override fun getSystemVbusVolts(): Double {
        return 0.0
    }

    override fun allocatePrimaryExecutor(): IExecutor {
        val pool = ScheduledThreadPoolExecutor(8)
        pool.setKeepAliveTime(10, TimeUnit.SECONDS)
        pool.allowCoreThreadTimeOut(true)

        return ScheduledExecutorServiceExecutor(pool)
    }

    override fun allocateSingleUseExecutor(): IExecutor {
        val executor = ScheduledThreadPoolExecutor(1)

        return ScheduledExecutorServiceExecutor(executor)
    }

    override fun allocateRealTimeExecutor(rateSeconds: Double): IRealTimeExecutor {
        return NullRealTimeExecutor
    }

    override fun getTimestampSeconds(): Double {
        return System.nanoTime() * 1e-9
    }

    override fun allocateHIDValueProviderFactory(id: Int): IHIDValueProviderFactory {
        return NullHIDValueProviderFactory
    }
}