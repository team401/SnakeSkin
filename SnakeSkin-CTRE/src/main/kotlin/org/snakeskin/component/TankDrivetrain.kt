package org.snakeskin.component

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.NeutralMode
import com.ctre.phoenix.sensors.PigeonIMU
import edu.wpi.first.wpilibj.Solenoid
import org.snakeskin.CTREConstants
import org.snakeskin.ShifterState
import org.snakeskin.logic.PIDParameters

/**
 * @author Cameron Earle
 * @version 12/25/17
 */
class TankDrivetrain(override val wheelRadius: Double, override val wheelbase: Double): Drivetrain {
    lateinit var left: Gearbox; private set
    lateinit var right: Gearbox; private set
    lateinit var imu: PigeonIMU; private set
    lateinit var shifter: Solenoid; private set
    override var invertLeft: Boolean = false; private set
    override var invertRight: Boolean = false; private set
    var invertShifter: Boolean = false; private set
    var shifterState: ShifterState = ShifterState.LOW; private set

    fun init(left: Gearbox, right: Gearbox, imu: PigeonIMU, shifter: Solenoid, invertLeft: Boolean = false, invertRight: Boolean = false, invertShifter: Boolean = false) {
        this.left = left
        this.right = right
        this.imu = imu
        this.shifter = shifter
        this.invertLeft = invertLeft
        this.invertRight = invertRight
        this.invertShifter = invertShifter

        this.left.setInverted(invertLeft)
        this.right.setInverted(invertRight)
    }

    override fun arcade(mode: ControlMode, translation: Double, rotation: Double) {
        left.set(mode, translation + rotation)
        right.set(mode, translation - rotation)
    }

    override fun tank(mode: ControlMode, left: Double, right: Double) {
        this.left.set(mode, left)
        this.right.set(mode, right)
    }

    override fun setCurrentLimit(continuousCurrent: Int, peakCurrent: Int, peakDuration: Int, timeout: Int) {
        left.setCurrentLimit(continuousCurrent, peakCurrent, peakDuration, timeout)
        right.setCurrentLimit(continuousCurrent, peakCurrent, peakDuration, timeout)
    }

    override fun setRampRate(closedLoop: Double, openLoop: Double, timeout: Int) {
        left.setRampRate(closedLoop, openLoop, timeout)
        right.setRampRate(closedLoop, openLoop, timeout)
    }

    override fun setNeutralMode(mode: NeutralMode) {
        left.setNeutralMode(mode)
        right.setNeutralMode(mode)
    }

    override fun stop() {
        left.stop()
        right.stop()
    }

    override fun getDistance(pidIdx: Int) = (left.getPosition(pidIdx) + right.getPosition(pidIdx)) / 2.0
    override fun getVelocity(pidIdx: Int) = (left.getVelocity(pidIdx) + right.getVelocity(pidIdx)) / 2.0
    override fun getYaw(): Double {
        val array = DoubleArray(3)
        imu.getYawPitchRoll(array)
        return array[0]
    }

    override fun setPosition(position: Int) {
        left.setPosition(position)
        right.setPosition(position)
    }

    override fun setYaw(yaw: Double, timeout: Int) {
        imu.setYaw(yaw, timeout)
    }

    override fun zero() {
        setPosition(0)
        setYaw(0.0)
    }

    override fun enableVoltageCompensation(enable: Boolean) {
        left.enableVoltageCompensation(enable)
        right.enableVoltageCompensation(enable)
    }

    override fun setOutputLimits(peakForward: Double, peakReverse: Double, nominalForward: Double, nominalReverse: Double, timeout: Int) {
        left.setOutputLimits(peakForward, peakReverse, nominalForward, nominalReverse, timeout)
        right.setOutputLimits(peakForward, peakReverse, nominalForward, nominalReverse, timeout)
    }

    fun shift(state: ShifterState) {
        shifterState = state
        val high = !invertShifter
        val low = invertShifter
        when (shifterState) {
            ShifterState.HIGH -> shifter.set(high)
            ShifterState.LOW -> shifter.set(low)
        }

    }

    fun low() = shift(ShifterState.LOW)
    fun high() = shift(ShifterState.HIGH)

    fun isHigh() = shifterState == ShifterState.HIGH
    fun isLow() = shifterState == ShifterState.LOW
}