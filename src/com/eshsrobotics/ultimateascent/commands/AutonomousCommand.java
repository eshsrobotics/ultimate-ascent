package com.eshsrobotics.ultimateascent.commands;

/**
 * Command for autonomous
 *
 * @author Benjamin Landers
 */
public class AutonomousCommand extends CommandBase
{
    public AutonomousCommand()
    {
        requires(chassis);
        requires(climber);
    }

    protected void initialize()
    {
        System.out.println("Autonomous command initialized.");
    }

    protected void execute()
    {
    }

    protected boolean isFinished()
    {
        return false;
    }

    protected void end()
    {
        System.out.println("Autonomous command ended.");
    }

    protected void interrupted()
    {
        System.out.println("Autonomous command interrupted.");
    }
}
