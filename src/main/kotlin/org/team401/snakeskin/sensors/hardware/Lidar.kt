package org.team401.snakeskin.sensors.hardware

import edu.wpi.first.wpilibj.I2C
import org.team401.snakeskin.Unit
import org.team401.snakeskin.sensors.DistanceSensor
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicReference

/*
 * SnakeSkin - Created on 6/2/17
 * Author: Zachary Kozar
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

/**
 * @author Zachary Kozar
 * @version 6/2/17
 */
class Lidar(port: I2C.Port, hardware: Hardware, unit: Unit, period: Int = 20) : DistanceSensor {

    enum class Hardware(val address: Int, val mainRegister: Int, val vRead: Int,
                        val vWrite: Int, val r2ByteRead: Int, val reset: Int) {
        LIDARLITE_V3(0x62, 0x00, 0x04, 0x00, 0x8F, 0x00)
    }

    private class PollTask(private val bus: I2C, private val hardware: Hardware, private val unit: Unit) : Runnable {
        val latestData = AtomicReference<Data>(Data(0.0, Unit.CENTIMETERS))
        val buffer = byteArrayOf(0, 0)
        val writeBuffer = byteArrayOf(hardware.r2ByteRead.toByte())

        override fun run() {
            bus.write(hardware.mainRegister, hardware.vRead)

            try {
                Thread.sleep(20)
            } catch (e: InterruptedException) { }

            bus.writeBulk(writeBuffer)
            bus.readOnly(buffer, 2)

            latestData.set(Data(((buffer[0].toInt() shl 8) + buffer[1]).toDouble(), unit))

            try {
                Thread.sleep(10)
            } catch (e: InterruptedException) { }
        }
    }

    data class Data(val nativeUnit: Double, val unit: Unit) {
        val distance = getDistance(unit)

        fun getDistance(unit: Unit) = nativeUnit * 2.54 * unit.multiplier
    }

    private val executor: ScheduledThreadPoolExecutor
    private val task: PollTask
    private val future: ScheduledFuture<*>

    init {
        val bus = I2C(port, hardware.address)
        task = PollTask(bus, hardware, unit)
        executor = ScheduledThreadPoolExecutor(1)
        bus.write(hardware.mainRegister, hardware.reset)
        future = executor.scheduleAtFixedRate(task, 0, period.toLong(), TimeUnit.MILLISECONDS)
    }

    override fun getDistance(): Double {
        return task.latestData.get().distance
    }
}