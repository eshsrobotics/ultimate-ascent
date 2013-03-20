package com.eshsrobotics.ultimateascent;

import com.eshsrobotics.ultimateascent.commands.ChangeClimbSystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
    /**
     * Joystick threshold provides some margin from neutral joystick position.
     */
    public static final float JOYSTICK_THRESHOLD = 0.05f;

    public static boolean dualClimb = false;    /* when false, in Drive Mode */

    public static final int startClimbButtonFirst = 9;
    public static final int startClimbButtonSecond  = 10;
    public static final int endClimbButtonFirst  = 11;
    public static final int endClimbButtonSecond = 12;
    public static final int cameraButtonRight = 6;
    public static final int cameraButtonLeft = 5;

    public Joystick leftJ = new Joystick(1);
    public Joystick rightJ = new Joystick(2);
    public Joystick cameraJ = new Joystick(3);
    
    JoystickButton endClimb = new JoystickButton(cameraJ,endClimbButtonFirst);  
    JoystickButton startClimb = new JoystickButton(cameraJ,startClimbButtonFirst); 
    
    public OI()
    {
<<<<<<< HEAD
        Log.v(TAG, "Operator interface instantiated.");

        endClimb.whenPressed(new ChangeClimbSystem(false, endClimbButtonSecond));
        startClimb.whenPressed(new ChangeClimbSystem(true, startClimbButtonSecond));
=======
        System.out.println("Operator interface instantiated.");
        startClimbB.whenPressed(new ChangeClimbSystem());
>>>>>>> parent of 44d68ba... Added logging system.
    }
}

