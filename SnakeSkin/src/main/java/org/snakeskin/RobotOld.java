package org.snakeskin;/*
 * snakeskin - Created on 9/16/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 9/16/17
 */


import edu.wpi.first.wpilibj.SampleRobot;
import org.snakeskin.auto.AutoManager;
import org.snakeskin.event.EventRouter;
import org.snakeskin.event.Events;
import org.snakeskin.logging.LogLevel;
import org.snakeskin.logging.LoggerManager;
import org.snakeskin.registry.Subsystems;

import java.lang.reflect.Method;

/**
 * @author Cameron Earle
 * @version 7/16/17
 */

/*
SampleRobot is a great class to use for prebuilt Robot.java files like this, as it doesn't waste a thread with iterators
that we aren't going to end up using.  It provides "on-start" methods that let us start up our own custom actions
 */
public class RobotOld extends SampleRobot {
    private Class noparams[] = {};

    @Override
    public void robotInit() {
        //The first thing we need to do is run the "preStartup" init tasks
        InitManager.preStartup();

        //Now, we set the main thread to throw uncaught exceptions to the logger
        LoggerManager.logCurrentThread();

        //Now, we need to load the "SETUP" class.  This class is responsible for loading most of the user defined classes
        Class<?> clazz = null;
        Method setupMethod = null;
        try {
            clazz = Class.forName("SETUPKt");
            setupMethod = clazz.getDeclaredMethod("setup", noparams);
        } catch (ClassNotFoundException e) {
            LoggerManager.logMessage("Could not find SETUP.kt, looking for SETUP.java!", LogLevel.WARNING);
            try {
                clazz = Class.forName("SETUP");
                setupMethod = clazz.getDeclaredMethod("setup", noparams);
            } catch (ClassNotFoundException f) {
                LoggerManager.logMessage("Could not find SETUP.java, this IS a problem!", LogLevel.ERROR);
            } catch (NoSuchMethodException f) {
                LoggerManager.logMessage("Could not find 'public static void setup()'", LogLevel.ERROR);
            }
        } catch (NoSuchMethodException e) {
            LoggerManager.logMessage("Could not find 'fun setup()' in SETUP.kt, this IS a problem!", LogLevel.ERROR);
        }

        try {
            if (setupMethod != null) {
                setupMethod.invoke(null, (Object[]) null); //Now, we'll run the "setup" method that is responsible for configuring the robot
            }
        } catch (Exception e) {
            LoggerManager.logThrowable(new Exception("Exception encountered while running setup script", e));
        }



        //Now that the setup has been completed, we can run the "postStartup" init tasks
        InitManager.postStartup();
    }

    @Override
    public void disabled() {
        //If the auto script is running for some reason, we should stop it
        AutoManager.stop();
        //Publish the available autonomous modes to SmartDashboard
        AutoManager.publish();
        //At this point the robot is disabled, so we should fire the "DISABLED" event to let everyone know that
        EventRouter.fireEvent(Events.DISABLED);
    }

    @Override
    public void autonomous() {
        //Autonomous has now started, so we need to notify everyone of that
        EventRouter.fireEvent(Events.ENABLED);
        EventRouter.fireEvent(Events.AUTO_ENABLED);
        //Now, we need to start the auto script
        AutoManager.start();
    }

    @Override
    public void operatorControl() {
        //First, we stop the auto script
        AutoManager.stop();
        //Teleop has now started, so we need to notify everyone of that
        EventRouter.fireEvent(Events.ENABLED);
        EventRouter.fireEvent(Events.TELEOP_ENABLED);
    }

    @Override
    public void test() {
        Subsystems.testAll(); //Run all subsystem tests
    }
}