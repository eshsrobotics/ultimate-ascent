package com.eshsrobotics.ultimateascent.commands;

import com.eshsrobotics.ultimateascent.OI;

public class ChangeClimbSystem extends CommandBase
{
    boolean begin;
    int secondButton;
    public ChangeClimbSystem(boolean begin, int secondButton)
    {
        this.begin = begin;
        this.secondButton = secondButton;
    }
    protected void initialize()
    {
    }

    protected void execute()
    {

    }

    protected boolean isFinished()
    {
        if(oi.cameraJ.getRawButton(secondButton))
        {
            OI.dualClimb = begin;
        }
        return true;
    }

    protected void end()
    {
    }

    protected void interrupted()
    {
    }
}
