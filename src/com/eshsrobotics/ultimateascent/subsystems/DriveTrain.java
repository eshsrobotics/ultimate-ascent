/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshsrobotics.ultimateascent.subsystems;

import com.eshsrobotics.ultimateascent.commands.DriveCommand;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Benjamin Landers
 */
public class DriveTrain extends Subsystem
{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public DriveTrain(int left, int right)
    {
        
    }
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
       setDefaultCommand(new DriveCommand());
    }
}

