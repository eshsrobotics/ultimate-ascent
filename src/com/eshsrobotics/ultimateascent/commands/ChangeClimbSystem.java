/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshsrobotics.ultimateascent.commands;

import com.eshsrobotics.ultimateascent.OI;

/**
 *
 * @author local user
 */
public class ChangeClimbSystem extends CommandBase
{

    protected void initialize() {
    }

    protected void execute()
    {
        OI.dualClimb = true;
                
    }

    protected boolean isFinished() 
    {
        return OI.dualClimb;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
    
}
