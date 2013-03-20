package com.eshsrobotics.ultimateascent.commands;

/**
 * Default drive train command. Simple sets the speed of the jaguars to the input from the joysticks.
 *
 * @author Benjamin Landers
 */
public class DriveCommand extends CommandBase
{
    public DriveCommand()
    {
        requires(chassis);
    }

    protected void initialize()
    {
        System.out.println("Drive command initialized.");
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
        System.out.println("Drive command ended.");
    }

    protected void interrupted()
    {
        chassis.left.set(0);
        chassis.right.set(0);

        System.out.println("Drive command interrupted.");
    }
}
