package com.eshsrobotics.ultimateascent.commands;

import com.eshsrobotics.ultimateascent.util.Log;

/**
 * Command for autonomous
 *
 * @author Benjamin Landers
 */
public class AutonomousCommand extends CommandBase
{
    public final String TAG = "AutonomousCommand";

    public AutonomousCommand()
    {
        requires(chassis);
        requires(climber);
    }

    protected void initialize()
    {
        Log.v(TAG, "Autonomous command initialized.");
    }

    protected void execute()
    {
        Log.v(TAG, "LOL I DON'T DO ANYTHING.");
    }

    protected boolean isFinished()
    {
        return false;
    }

    protected void end()
    {
        Log.v(TAG, "Autonomous command ended.");
    }

    protected void interrupted()
    {
        Log.v(TAG, "Autonomous command interrupted.");
    }
}
