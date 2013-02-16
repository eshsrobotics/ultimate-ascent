package com.eshsrobotics.ultimateascent;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    //----------------Motors------------------------------------------------s
    public static final int leftDriveMotor = 4;
    public static final int rightDriveMotor = 3;
    
    public static final int leftClimbMotor = 1;
    public static final int rightClimbMotor = 2;
    
    public static final int rightSecondaryMotor = 7;
    public static final int leftSecondaryMotor = 8;
    
    public static final int leftServo = 5;
    public static final int rightServo = 6;
    
    //---------------------Senors-----------------------------------
    public static final int driveG = 1;
    public static final int climbG = 2;
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
}
