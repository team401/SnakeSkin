package org.team401.robot;/*
 * snakeskin - Created on 7/16/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */


import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SampleRobot;
import org.team401.snakeskin.InitManagerKt;
import org.team401.snakeskin.event.EventRouter;
import org.team401.snakeskin.event.Events;
import org.team401.snakeskin.logic.MutableParameters;
import org.team401.snakeskin.registry.Subsystems;

import java.lang.reflect.Method;

/**
 * @author Cameron Earle
 * @version 7/16/17
 */

/*
SampleRobot is a great class to use for prebuilt Robot.java files like this, as it doesn't waste a thread with iterators
that we aren't going to end up using.  It provides "on-start" methods that let us start up our own custom actions
 */
public class Robot extends SampleRobot {
    private Class noparams[] = {};

    Method autoScript = null;

    private boolean invokeAuto() {
        try {
            autoScript.invoke(null, null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void robotInit() {
        //The first thing we need to do is run the "preStartup" init tasks
        InitManagerKt.preStartup();

        //Now, we need to load the "SETUP" class.  This class is responsible for loading most of the user defined classes
        Class<?> clazz = null;
        Method setupMethod = null;
        try {
            clazz = Class.forName("SETUPKt");
            setupMethod = clazz.getDeclaredMethod("setup", noparams);
        } catch (ClassNotFoundException e) {
            System.err.println("Could not find SETUP.kt, looking for SETUP.java!");
            try {
                clazz = Class.forName("SETUP");
                setupMethod = clazz.getDeclaredMethod("setup", noparams);
            } catch (ClassNotFoundException f) {
                System.err.println("Could not find SETUP.java, this IS a problem!");
            } catch (NoSuchMethodException f) {
                System.err.println("Could not find 'public static void setup()'");
            }
        } catch (NoSuchMethodException e) {
            System.err.println("Could not find 'fun setup()' in SETUP.kt, this IS a problem!");
        }

        try {
            autoScript = clazz.getDeclaredMethod("auto", noparams);
        } catch (Exception e) {
            System.err.println("Unable to load auto method!");
        }

        try {
            setupMethod.invoke(null, null); //Now, we'll run the "setup" method that is responsible for configuring the robot
        } catch (Exception e) {
            System.err.println("Unable to invoke 'setup()'");
            e.printStackTrace();
        }

        //Now that the setup has been completed, we can run the "postStartup" init tasks
        InitManagerKt.postStartup();
    }

    @Override
    public void disabled() {
        //At this point the robot is disabled, so we should fire the "DISABLED" event to let everyone know that
        EventRouter.INSTANCE.fireEvent(Events.DISABLED, new MutableParameters());
    }

    @Override
    public void autonomous() {
        //Autonomous has now started, so we need to notify everyone of that
        EventRouter.INSTANCE.fireEvent(Events.ENABLED, new MutableParameters());
        EventRouter.INSTANCE.fireEvent(Events.AUTO_ENABLED, new MutableParameters());
        //Now, we need to start the auto script
        //TODO Insert auto script start here
    }

    @Override
    public void operatorControl() {
        //TODO Stop auto script here
        //Teleop has now started, so we need to notify everyone of that
        EventRouter.INSTANCE.fireEvent(Events.ENABLED, new MutableParameters());
        EventRouter.INSTANCE.fireEvent(Events.TELEOP_ENABLED, new MutableParameters());
    }
}
