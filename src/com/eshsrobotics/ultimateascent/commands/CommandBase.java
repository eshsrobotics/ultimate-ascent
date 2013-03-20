package com.eshsrobotics.ultimateascent.commands;

import com.eshsrobotics.ultimateascent.OI;
import com.eshsrobotics.ultimateascent.RobotMap;
import com.eshsrobotics.ultimateascent.subsystems.Climber;
import com.eshsrobotics.ultimateascent.subsystems.DriveTrain;
import com.eshsrobotics.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.command.Command;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 *
 * @author Benjamin Landers, Zachary Latta
 */
public abstract class CommandBase extends Command
{
    public static final String TAG = "CommandBase";

    public static OI oi;
    public static DriveTrain chassis = new DriveTrain(RobotMap.leftDriveMotor,
            RobotMap.rightDriveMotor, RobotMap.driveG);
    public static Climber climber = new Climber(RobotMap.leftClimbMotor,
            RobotMap.rightClimbMotor, RobotMap.rightSecondaryMotor,
            RobotMap.leftSecondaryMotor, RobotMap.leftServo, RobotMap.rightServo,
            RobotMap.climbG);

    public CommandBase()
    {
        super();
    }

    public CommandBase(String name)
    {
        super(name);
    }

    public static void init()
    {
        oi = new OI();

        Log.v(TAG, "Command base initialized.");
    }
}
