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

    public static final int startClimbButton = 1;
    public static final int endClimbButton = 1;

    public static boolean dualClimb = false;

    public Joystick firstJ = new Joystick(1);
    public Joystick secondJ = new Joystick(2);
    public Joystick climbJ = new Joystick(3);
    public JoystickButton startClimbB = new JoystickButton(firstJ, startClimbButton);
    public JoystickButton endClimbB = new JoystickButton(firstJ, endClimbButton);

    public OI()
    {
        System.out.println("Operator interface instantiated.");
        startClimbB.whenPressed(new ChangeClimbSystem());
    }
}

