package org.snakeskin

import edu.wpi.first.wpilibj.IterativeRobot
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner
import io.github.lukehutch.fastclasspathscanner.matchprocessor.MethodAnnotationMatchProcessor
import org.snakeskin.annotation.Setup
import org.snakeskin.auto.AutoManager
import org.snakeskin.event.EventRouter
import org.snakeskin.event.Events
import org.snakeskin.exception.StartupException
import org.snakeskin.logging.LoggerManager
import org.snakeskin.registry.Subsystems
import java.lang.reflect.Executable
import java.lang.reflect.Method

/*
 * snakeskin - Created on 12/14/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 12/14/17
 */

class Robot: IterativeRobot() {
    override fun testPeriodic() {}
    override fun autonomousPeriodic() {}
    override fun robotPeriodic() {}
    override fun teleopPeriodic() {}
    override fun disabledPeriodic() {}

    override fun robotInit() {
        //First, we'll run the "pre-startup" init tasks
        InitManager.preStartup()

        //Now, tell the logger to log this thread, so any errors on startup are logged
        LoggerManager.logMainThread()

        //Begin by finding the 'setup' method
        val setupMethods = arrayListOf<Method>()

        val scanner = FastClasspathScanner()
        scanner.matchClassesWithMethodAnnotation(Setup::class.java) {
            _, executable ->
            if (executable is Method) {
                setupMethods.add(executable)
            }
        }

        //If there are not setup methods, crash the code here (this event will be logged as a crash)
        if (setupMethods.isEmpty()) {
            throw StartupException("No 'setup' methods found!  Make sure they are annotated with the '@Setup' annotation!")
        }

        //Run each setup method
        setupMethods.forEach {
            it.invoke(null, null)
        }

        //Now that the setup has been completed, we can run the "postStartup" init tasks
        InitManager.postStartup()
    }

    override fun disabledInit() {
        //If the auto script is running for some reason, we should stop it
        AutoManager.stop()
        //Publish the available autonomous modes to SmartDashboard
        AutoManager.publish()
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
}