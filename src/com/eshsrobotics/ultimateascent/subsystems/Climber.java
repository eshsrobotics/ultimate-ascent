/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshsrobotics.ultimateascent.subsystems;

import com.eshsrobotics.ultimateascent.commands.ClimberDefault;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Benjamin Landers
 */
public class Climber extends Subsystem
{
    public Jaguar leftM, rightM;
    public Servo leftS, rightS;
    public int angleFromOperator = 0;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Climber(int leftM, int rightM, int leftS, int rightS)
    {
        //initialize Jaguars
        this.leftM = new Jaguar(leftM);
        this.rightM = new Jaguar(rightM);
        //initialize servos
        this.leftS = new Servo(leftS);
        this.rightS = new Servo(rightS);
        
    }
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
       setDefaultCommand(new ClimberDefault());
    }
}
