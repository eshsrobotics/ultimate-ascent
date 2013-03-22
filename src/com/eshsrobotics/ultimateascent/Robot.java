package com.eshsrobotics.ultimateascent;

import com.eshsrobotics.ultimateascent.commands.AutonomousCommand;
import com.eshsrobotics.ultimateascent.commands.CommandBase;
import com.eshsrobotics.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
    public final String TAG = "Robot";

    public static Date date = new Date();

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit()
    {
        Log.d(TAG, "Robot initialization started.");

        autonomousCommand = new AutonomousCommand();
        Log.v(TAG, "Autonomous command initialized.");

        // Initialize all subsystems
        CommandBase.init();
        Log.d(TAG, "All subsystems initialized successfully.");
    }

    public void autonomousInit()
    {
        Log.d(TAG, "Autonomous mode initialization started.");

        autonomousCommand.start();
        Log.d(TAG, "Autonomous command started.");
    }

    public void autonomousPeriodic()
    {
        Log.v(TAG, "Begin autonomous periodic iteration:");

        Scheduler.getInstance().run();
    }

    public void teleopInit()
    {
        Log.d(TAG, "Teleop mode initialization started.");

        autonomousCommand.cancel();
        Log.d(TAG, "Autonomous command stopped.");
        CommandBase.climber.gyro.reset();
        Log.d(TAG, "Gyro reset.");

        OI.dualClimb = false;
        Log.d(TAG, "Dual climb set to false.");
    }

    public void teleopPeriodic()
    {
        Log.v(TAG, "Begin teleop periodic iteration:");

        Scheduler.getInstance().run();
    }

    /**
     * For when a terrible failure occurs.
     */
    public static void wtf(String tag, Throwable t)
    {
        System.exit(10);
    }
}
