package com.eshsrobotics.ultimateascent.subsystems;

import com.eshsrobotics.ultimateascent.commands.DriveCommand;
import com.eshsrobotics.ultimateascent.util.Log;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Provides abstraction to the drive mechanism of the robot.
 *
 * @author Benjamin Landers
 */
public class DriveTrain extends Subsystem
{
    public final String TAG = "DriveTrain";

    public Jaguar left, right;
    public Gyro gyro;

    public DriveTrain(int left, int right, int gyro)
    {
        this.left = new Jaguar(left);
        this.right = new Jaguar(right);
        this.gyro = new Gyro(gyro);

        Log.v(TAG, "Drive train subsystem instantiated.");
    }

    public void initDefaultCommand()
    {
        setDefaultCommand(new DriveCommand());

        Log.v(TAG, "Drive train default command set to DriveCommand().");
    }
}

