package org.team401.snakeskin.sensors.hardware

import edu.wpi.first.wpilibj.*
import edu.wpi.first.wpilibj.hal.FRCNetComm
import edu.wpi.first.wpilibj.hal.HAL
import edu.wpi.first.wpilibj.livewindow.LiveWindow
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable
import org.team401.snakeskin.sensors.InterruptableGyro
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.experimental.and

/*
 * SnakeSkin - Created on 5/26/17
 * Author: Zachary Kozar
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

/**
 * @author Zachary Kozar
 * @version 5/26/17
 */
class ADXRS450_Gyro : GyroBase(), InterruptableGyro, PIDSource, LiveWindowSendable {

    companion object {
        private const val kSamplePeriod = 0.001
        private const val kDegreePerSecondPerLSB = 0.0125
        private const val kCalibrationSampleTime = 5.0
        private const val kPIDRegister = 0x0C
    }

    var spi: SPI?

    var isCalibrating: Boolean = false
    var lastCenter: Double = 0.0

    init {
        val port = SPI.Port.kOnboardCS0
        val temp = SPI(SPI.Port.kOnboardCS0)
        temp.setClockRate(3000000)
        temp.setMSBFirst()
        temp.setSampleDataOnRising()
        temp.setClockActiveHigh()
        temp.setChipSelectActiveLow()
        spi = temp

        if ((readRegister(kPIDRegister) and 0xff00) != 0x5200) {
            free()
            DriverStation.reportError("could not find ADXRS450 gyro on SPI port ${port.value}", false)
        } else {
            spi!!.initAccumulator(kSamplePeriod, 0x20000000, 4, 0x0c00000e, 0x04000000, 10, 16, true, true)

            HAL.report(FRCNetComm.tResourceType.kResourceType_ADXRS450, port.value)
            LiveWindow.addSensor("ADXRS450_Gyro", port.value, this)
        }
    }

    @Synchronized override fun calibrate() {
        if (spi == null)
            return

        startCalibrate()

        Timer.delay(kCalibrationSampleTime)

        endCalibrate()
    }

    @Synchronized override fun startCalibrate() {
        if (spi == null)
            return

        if (!isCalibrating) {
            isCalibrating = true
            spi!!.setAccumulatorCenter(0)
            spi!!.resetAccumulator()
        }
    }

    @Synchronized override fun endCalibrate() {
        if (spi == null)
            return

        if (isCalibrating) {
            isCalibrating = false
            lastCenter = spi!!.accumulatorAverage
            spi!!.setAccumulatorCenter(Math.round(lastCenter).toInt())
            spi!!.resetAccumulator()
        }
    }

    @Synchronized override fun cancelCalibrate() {
        if (spi == null)
            return

        if (isCalibrating) {
            isCalibrating = false
            spi!!.setAccumulatorCenter(Math.round(lastCenter).toInt())
            spi!!.resetAccumulator()
        }
    }

    override fun getCenter(): Double {
        return lastCenter
    }

    override fun getCalibrationSampleTime(): Double {
        return kCalibrationSampleTime
    }

    private fun calcParity(value: Int): Boolean {
        var temp = value
        var parity = false
        while (temp != 0) {
            parity = !parity
            temp = temp and temp - 1
        }
        return parity
    }

    private fun readRegister(reg: Int): Int {
        val cmdhi = 0x8000 or (reg shl 1)
        val parity = calcParity(cmdhi)

        val buf = ByteBuffer.allocateDirect(4)
        buf.order(ByteOrder.BIG_ENDIAN)
        buf.put(0, (cmdhi shr 8).toByte())
        buf.put(1, (cmdhi and 0xff).toByte())
        buf.put(2, 0.toByte())
        buf.put(3, if (parity) 0 else 1)

        spi!!.write(buf, 4)
        spi!!.read(false, buf, 4)

        if ((buf.get(0) and 0xe0.toByte()).toInt() == 0)
            return 0
        return (buf.getInt(0) shr 5) and 0xffff
    }

    override fun reset() {
        spi?.resetAccumulator()
    }

    /**
     * Delete (free) the spi port used for the gyro and onStop accumulating.
     */
    override fun free() {
        spi?.free()
        spi = null
    }

    override fun getAngle(): Double {
        if (spi == null)
            return 0.0
        return spi!!.accumulatorValue.toDouble() * kDegreePerSecondPerLSB * kSamplePeriod
    }

    override fun getRate(): Double {
        if (spi == null)
            return 0.0
        return spi!!.accumulatorValue.toDouble() * kDegreePerSecondPerLSB
    }
}