/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshsrobotics.ultimateascent.subsystems;

import com.eshsrobotics.ultimateascent.commands.ClimberDefault;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Benjamin Landers
 */
public class Climber extends Subsystem
{
    public Jaguar leftM, rightM;
    public Servo leftS, rightS, leftSecondaryM, rightSecondaryM;
    public int angleFromOperator = 0;
    public Gyro gyro;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Climber(int leftM, int rightM,int leftSecondaryM,int rightSecondaryM
            , int leftS, int rightS, int gyro)
    {
        //initialize Jaguars
        this.leftM = new Jaguar(leftM);
        this.rightM = new Jaguar(rightM);
        this.leftSecondaryM = new Servo(leftSecondaryM); // hacking a bit here
        this.rightSecondaryM = new Servo(rightSecondaryM);//using servo class
        //initialize servos                                 for vex motors
        this.leftS = new Servo(leftS);
        this.rightS = new Servo(rightS);
        //init gyro
        //this.gyro = new Gyro(gyro);
        
    }
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
       setDefaultCommand(new ClimberDefault());
    }
}
