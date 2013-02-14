/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshsrobotics.ultimateascent.commands;

/**
 *Command for autonomous
 * @author Benjamin Landers
 */
public class AutonomousCommand extends CommandBase {

    public AutonomousCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(chassis);
        requires(climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        while(true)
        {
            for(int i = 0; i < 180; i+=10)
            {
            climber.leftS.setPosition(i);
            System.out.println(i);
            while(!oi.climbJ.getTrigger());
            }
            
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
    }
}
