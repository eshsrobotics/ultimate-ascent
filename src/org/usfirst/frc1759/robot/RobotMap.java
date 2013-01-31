// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.


package org.usfirst.frc1759.robot;
    
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import java.util.Vector;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveTrainLeftMotor;
    public static SpeedController driveTrainRightMotor;
    public static RobotDrive driveTrainRobotDrive;
    public static AnalogChannel driveTrainUltrasonic;
    public static Servo visionTiltServo;
    public static Servo visionPanServo;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftMotor = new Victor(1, 1);
	LiveWindow.addActuator("DriveTrain", "LeftMotor", (Victor) driveTrainLeftMotor);
        
        driveTrainRightMotor = new Victor(1, 2);
	LiveWindow.addActuator("DriveTrain", "RightMotor", (Victor) driveTrainRightMotor);
        
        driveTrainRobotDrive = new RobotDrive(driveTrainLeftMotor, driveTrainRightMotor);
	
        driveTrainRobotDrive.setSafetyEnabled(false);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);
        

        driveTrainUltrasonic = new AnalogChannel(1, 1);
	LiveWindow.addSensor("DriveTrain", "Ultrasonic", driveTrainUltrasonic);
        
        visionTiltServo = new Servo(1, 3);
	LiveWindow.addActuator("Vision", "TiltServo", visionTiltServo);
        
        visionPanServo = new Servo(1, 4);
	LiveWindow.addActuator("Vision", "PanServo", visionPanServo);
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
