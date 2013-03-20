package com.eshsrobotics.ultimateascent;

import com.eshsrobotics.ultimateascent.commands.AutonomousCommand;
import com.eshsrobotics.ultimateascent.commands.CommandBase;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit()
    {
        autonomousCommand = new AutonomousCommand();
        System.out.println("Autonomous command initialized. ");

        // Initialize all subsystems
        CommandBase.init();
        System.out.println("All subsystems initialized.");
    }

    public void autonomousInit()
    {
        autonomousCommand.start();
        System.out.println("Autonomous command started.");
    }

    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit()
    {
        autonomousCommand.cancel();
<<<<<<< HEAD
        Log.v(TAG, "Autonomous command stopped.");
        CommandBase.climber.gyro.reset();
        System.out.println("Gyro resetted");
=======
        System.out.println("Autonomous command stopped.");
>>>>>>> parent of 44d68ba... Added logging system.

        OI.dualClimb = false;
        System.out.println("Dual climb set to false.");
    }

    public void teleopPeriodic()
    {
        Scheduler.getInstance().run();
        
        System.out.println("," + CommandBase.oi.leftJ.getY() + 
                "," + CommandBase.oi.rightJ.getY() + 
                "," + CommandBase.oi.cameraJ.getY() + 
                "," + CommandBase.climber.leftM.getSpeed() + 
                "," +CommandBase.climber.rightM.getSpeed() + 
                "," + CommandBase.climber.gyro.getAngle() +
                "," + CommandBase.oi.cameraJ.getThrottle());
    }
}
