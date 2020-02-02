package org.snakeskin.runtime.impl

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.RobotController
import edu.wpi.first.wpilibj.Timer
import org.snakeskin.executor.IExecutor
import org.snakeskin.executor.impl.ScheduledExecutorServiceExecutor
import org.snakeskin.hid.IHIDValueProviderFactory
import org.snakeskin.hid.impl.ControlSurfaceProviderFactoryWpi
import org.snakeskin.rt.IRealTimeExecutor
import org.snakeskin.rt.impl.NotifierRealTimeExecutor
import org.snakeskin.runtime.IRuntimePlatformBinding
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit

class RuntimePlatformBindingFrcWpiSim: IRuntimePlatformBinding {
    override fun getTimestampSeconds(): Double {
        return Timer.getFPGATimestamp()
    }

    override fun blockMilliseconds(ms: Long) {
        Thread.sleep(ms)
    }

    override fun getSystemVbusVolts(): Double {
        return RobotController.getBatteryVoltage()
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
        return NotifierRealTimeExecutor(rateSeconds)
    }

    override fun allocateHIDValueProviderFactory(id: Int): IHIDValueProviderFactory {
        val joystick = Joystick(id)

        return ControlSurfaceProviderFactoryWpi(joystick)
    }
}