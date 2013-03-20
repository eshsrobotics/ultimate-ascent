package com.eshsrobotics.ultimateascent;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
    public static boolean gyroEnabled = true;
    //---------------------Motors---------------------
    public static final int leftDriveMotor = 5;
    public static final int rightDriveMotor = 1;

    public static final int leftClimbMotor = 6;
    public static final int rightClimbMotor = 2;

    public static final int rightSecondaryMotor = 4;
    public static final int leftSecondaryMotor = 8;

    public static final int leftServo = 7;
    public static final int rightServo = 3;

    //---------------------Sensors---------------------
    public static final int driveG = 2;
    public static final int climbG = 1;
    
}
