package com.eshsrobotics.ultimateascent.commands;

import com.eshsrobotics.ultimateascent.util.Log;

/**
 * Default drive train command. Simple sets the speed of the jaguars to the input from the joysticks.
 *
 * @author Benjamin Landers
 */
public class DriveCommand extends CommandBase
{
    public final String TAG = "DriveCommand";

    public DriveCommand()
    {
        requires(chassis);
    }

    protected void initialize()
    {
        Log.v(TAG, "Drive command initialized.");
    }

    protected void execute()
    {
        if(!oi.dualClimb)
        {
            chassis.left.set(-oi.leftJ.getY());
            chassis.right.set(oi.rightJ.getY());
        }
        else
        {
            chassis.right.set(0);
            chassis.left.set(0);
        }
    }

    protected boolean isFinished()
    {
        return false;
    }

    protected void end()
    {
        Log.v(TAG, "Drive command ended.");
    }

    protected void interrupted()
    {
        chassis.left.set(0);
        chassis.right.set(0);

        Log.v(TAG, "Drive command interrupted.");
    }
}
