/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshsrobotics.ultimateascent.commands;

/**
 *
 * @author Ben
 */
public class ClimberDefault extends CommandBase
{

    public ClimberDefault()
    {
        // Use requires() here to declare subsystem dependencies
        requires(climber);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        if(oi.climbJ.getRawButton(9))
            climber.angleFromOperator++;
        if(oi.climbJ.getRawButton(11))
            climber.angleFromOperator--;
        climber.leftS.setAngle(climber.angleFromOperator);
        climber.rightS.setAngle(climber.angleFromOperator);
        climber.leftM.set(-oi.firstJ.getY());
        climber.rightM.set(-oi.secondJ.getY());
        climber.leftSecondaryM.set((-oi.firstJ.getY()>0)?-oi.firstJ.getY():0);
        climber.rightSecondaryM.set((-oi.secondJ.getY()>0)?-oi.secondJ.getY():0);
        if(oi.climbJ.getTrigger()){ //button to full reverse
         climber.leftM.set(-1);
         climber.rightM.set(-1); 
         
         climber.leftSecondaryM.set(0);
         climber.rightSecondaryM.set(0);
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
        climber.leftM.set(0);
        climber.rightM.set(0);
        climber.leftSecondaryM.set(0);
        climber.rightSecondaryM.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
        end();
    }
    
}
