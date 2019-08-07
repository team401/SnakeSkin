package org.snakeskin

import edu.wpi.first.hal.FRCNetComm
import edu.wpi.first.hal.HAL
import edu.wpi.first.wpilibj.IterativeRobotBase
import edu.wpi.first.wpilibj.TimedRobot
import org.snakeskin.auto.AutoManager
import org.snakeskin.controls.ControlPoller
import org.snakeskin.event.EventRouter
import org.snakeskin.event.Events
import org.snakeskin.hardware.Environment
import org.snakeskin.hardware.Hardware
import org.snakeskin.hardware.impl.HardwareTimeSource
import org.snakeskin.init.InitManager
import org.snakeskin.registry.Subsystems

/**
 * @author Cameron Earle
 * @version 12/14/17
 *
 * Implements the old "IterativeRobot" that waits for driver station data.  Also removes the annoying overrun messages
 */
class Robot: IterativeRobotBase(1.0) { //Use a number much bigger than 20 ms to avoid spamming overrun messages
    init {
        HAL.report(FRCNetComm.tResourceType.kResourceType_Framework, FRCNetComm.tInstances.kFramework_ROS) //Who's Marshall?
    }

    override fun startCompetition() {
        robotInit()

        HAL.observeUserProgramStarting()

        val thread = Thread.currentThread()
        while (!thread.isInterrupted) {
            m_ds.waitForData()
            loopFunc()
        }
    }

    override fun testPeriodic() {}
    override fun disabledPeriodic() {}
    override fun robotPeriodic() {}

    override fun robotInit() {
        //Configure the environment to be hardware (RoboRIO), and set the timesource to the FPGA
        Hardware.configureEnvironment(Environment.HARDWARE)
        Hardware.setTimeSource(HardwareTimeSource())

        //Run the Init Manager to initialize the user code
        InitManager.init()
    }

    override fun disabledInit() {
        //If the auto script is running for some reason, we should stop it
        AutoManager.stop()
        //Publish the available autonomous modes to SmartDashboard
        //AutoManager.publish()
        //At this point the robot is disabled, so we should fire the "DISABLED" event to let everyone know that
        EventRouter.fireEvent(Events.DISABLED)
    }

    override fun teleopInit() {
        //First, we stop the auto script
        AutoManager.stop()
        //Teleop has now started, so we need to notify everyone of that
        EventRouter.fireEvent(Events.ENABLED)
        EventRouter.fireEvent(Events.TELEOP_ENABLED)
    }

    override fun autonomousInit() {
        //Autonomous has now started, so we need to notify everyone of that
        EventRouter.fireEvent(Events.ENABLED)
        EventRouter.fireEvent(Events.AUTO_ENABLED)
        //Now, we need to start the auto script
        AutoManager.start()
    }

    override fun testInit() {
        //Run all subsystem tests
        Subsystems.testAll()
    }

    /**
     * This method is fired when the robot receives a packet from the Driver Station, containing controller states.
     * Therefore, it makes sense to react to these controller state changes in this method rather than their own thread
     */
    override fun teleopPeriodic() {
        ControlPoller.update() //Update the control poller
    }

    override fun autonomousPeriodic() {
        if (ControlPoller.pollInAutonomous) { //If we've enabled autonomous control polling
            ControlPoller.update() //Update the control poller
        }
    }
}