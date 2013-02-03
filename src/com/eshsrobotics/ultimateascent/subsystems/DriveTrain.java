/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshsrobotics.ultimateascent.subsystems;

import com.eshsrobotics.ultimateascent.commands.DriveCommand;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Benjamin Landers
 */
public class DriveTrain extends Subsystem
{
    public Jaguar left, right;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public DriveTrain(int left, int right)
    {
        this.left = new Jaguar(left);
        this.right = new Jaguar(right);
        
    }
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
       setDefaultCommand(new DriveCommand());
    }
}

