package com.eshsrobotics.ultimateascent.subsystems;

import com.eshsrobotics.ultimateascent.commands.ClimberDefault;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Provides abstraction to the Climber subsystem of the robot.
 *
 * @author Benjamin Landers
 */
public class Climber extends Subsystem
{
    public Jaguar leftM, rightM;
    public Servo leftS, rightS;
    public Victor leftSecondaryM, rightSecondaryM;
    public Gyro gyro;
    public int angleFromOperator = 0;

    public Climber(int leftM, int rightM, int leftSecondaryM, int rightSecondaryM, int leftS, int rightS, int gyro)
    {
        this.leftM = new Jaguar(leftM);
        this.rightM = new Jaguar(rightM);
        this.leftSecondaryM = new Victor(leftSecondaryM);
        this.rightSecondaryM = new Victor(rightSecondaryM);
        this.leftS = new Servo(leftS);
        this.rightS = new Servo(rightS);
        this.gyro = new Gyro(gyro);
        this.gyro.setSensitivity(.007);
        System.out.println("Sensitivity set");
        this.gyro.reset();

        System.out.println("Climber subsystem instantiated.");
    }

    public void initDefaultCommand()
    {
        setDefaultCommand(new ClimberDefault());

        System.out.println("Climber subsystem default command set to ClimberDefault().");
    }
}
