package org.snakeskin.auto

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.NeutralMode
import org.snakeskin.auto.AutoStep
import org.snakeskin.component.Drivetrain
import org.snakeskin.logic.PIDController
import org.snakeskin.logic.PIDParameters
import org.snakeskin.logic.Timer

/*
 * snakeskin - Created on 12/26/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 12/26/17
 */

class Servo(val drivetrain: Drivetrain, val distance: Double, val yaw: Double, val distanceParams: PIDParameters, val yawParams: PIDParameters, val neutralModeWhenDone: NeutralMode = NeutralMode.Coast): AutoStep() {
    private var distanceOutput = 0.0
    private var yawOutput = 0.0
    private val stopTimer = Timer()

    private val distancePID = distanceParams.createController()
    private val yawPID = yawParams.createController()

    override fun entry() {
        drivetrain.zero()
        drivetrain.setNeutralMode(NeutralMode.Brake)
        distancePID.reset()
        yawPID.reset()
        stopTimer.reset()
        distancePID.setpoint = distance
        yawPID.setpoint = yaw
        distanceOutput = 0.0
        yawOutput = 0.0
    }

    override fun action() {
        if (!stopTimer.running) {
            distanceOutput = distancePID.pid(drivetrain.getDistance())
            yawOutput = yawPID.pid(drivetrain.getYaw())
            drivetrain.arcade(ControlMode.PercentOutput, distanceOutput, yawOutput)

        }

        if (distancePID.atSetpoint() && yawPID.atSetpoint()) {
            drivetrain.stop()
            done = stopTimer.check(100)
        } else {
            stopTimer.reset()
        }
    }

    override fun exit() {
        drivetrain.setNeutralMode(neutralModeWhenDone)
    }
}