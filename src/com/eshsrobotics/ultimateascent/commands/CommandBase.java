package com.eshsrobotics.ultimateascent.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.eshsrobotics.ultimateascent.OI;
import com.eshsrobotics.ultimateascent.RobotMap;
import com.eshsrobotics.ultimateascent.subsystems.Climber;
import com.eshsrobotics.ultimateascent.subsystems.DriveTrain;
import com.eshsrobotics.ultimateascent.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.Gyro;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 *
 * @author Author
 */
public abstract class CommandBase extends Command
{

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
    public static DriveTrain chassis = new DriveTrain(RobotMap.leftDriveMotor,
            RobotMap.rightDriveMotor, RobotMap.driveG);
    public static Climber climber = new Climber(RobotMap.leftClimbMotor,
            RobotMap.rightClimbMotor, RobotMap.rightSecondaryMotor,
            RobotMap.leftSecondaryMotor, RobotMap.leftServo, RobotMap.rightServo,
            RobotMap.climbG);

    public static void init()
    {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();


        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(exampleSubsystem);
    }

    public CommandBase(String name)
    {
        super(name);
    }

    public CommandBase()
    {
        super();
    }
}
