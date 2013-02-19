/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshsrobotics.ultimateascent.commands;

/**
 *
 * @author Benjamin Landers
 */
public class DriveCommand extends CommandBase
{

    public DriveCommand()
    {
        requires(chassis);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        if(!oi.dualClimb)
        {
            chassis.left.set(-oi.firstJ.getY());//*oi.firstJ.getThrottle());
            chassis.right.set(oi.secondJ.getY());//*oi.secondJ.getThrottle());
        }else
        {
            chassis.right.set(0);
            chassis.left.set(0);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end()
    {
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
        chassis.left.set(0);
        chassis.right.set(0);
    }
}
