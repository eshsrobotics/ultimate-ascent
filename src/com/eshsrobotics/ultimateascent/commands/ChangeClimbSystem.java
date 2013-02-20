package com.eshsrobotics.ultimateascent.commands;

import com.eshsrobotics.ultimateascent.OI;

public class ChangeClimbSystem extends CommandBase
{
    protected void initialize()
    {
    }

    protected void execute()
    {
        OI.dualClimb = true;

    }

    protected boolean isFinished()
    {
        return OI.dualClimb;
    }

    protected void end()
    {
    }

    protected void interrupted()
    {
    }
}
