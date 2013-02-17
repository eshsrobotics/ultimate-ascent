/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshsrobotics.ultimateascent.commands;

/**
 * @author Benjamin Landers
 */
public class ClimbCommand extends CommandBase
{
    public ClimbCommand()
    {
        requires(chassis);
    }

    protected void initialize()
    {
        System.out.println("Climb command initialized.");
    }

    protected void execute()
    {
    }

    protected boolean isFinished()
    {
        return oi.endClimbB.get();
    }

    protected void end()
    {
        System.out.println("Climb command ended.");
    }

    protected void interrupted()
    {
        System.out.println("Climb command interrupted.");
    }
}