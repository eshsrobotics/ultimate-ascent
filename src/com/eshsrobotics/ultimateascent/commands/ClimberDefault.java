package com.eshsrobotics.ultimateascent.commands;

import com.eshsrobotics.ultimateascent.OI;

/**
 * Default command for Climber subsystem. Responsible for control of the climbing mechanism. Can currently extend and
 * retract the tape measures along with raising and lowering them through the use of a joystick.
 *
 * @author Benjamin Landers, Zachary Latta, David Tung
 */
public class ClimberDefault extends CommandBase
{
    public ClimberDefault()
    {
        requires(climber);
    }

    protected void initialize()
    {
        System.out.println("Default climber command initialized.");
    }

    protected void execute()
    {
        // Left climber motor direction has been flipped to match hardware configuration.
        // Throttle to climber motor commands have been tuned based on integration tests.
        // Difference in left and right climber motor command constants compensate for the
        // discrepancy in strength of left and right climber motors.
        climber.leftS.set(-oi.cameraJ.getThrottle() / 4.5 + .25);
        climber.rightS.set(oi.cameraJ.getThrottle() / 6 + .15);

        if(!OI.dualClimb)
        {
            if(!oi.cameraJ.getRawButton(OI.cameraButtonRight))
            {
                climber.leftM.set(-oi.cameraJ.getY());
                climber.leftSecondaryM.set((-oi.cameraJ.getY() / 2 > OI.JOYSTICK_THRESHOLD) ? -1 : 0);
            }

            if(!oi.cameraJ.getRawButton(OI.cameraButtonLeft))
            {
                climber.rightM.set(-oi.cameraJ.getY());
                climber.rightSecondaryM.set((-oi.cameraJ.getY() > OI.JOYSTICK_THRESHOLD) ? -1 : 0);
            }

            if(oi.cameraJ.getTrigger())
            { //button to full reverse
                climber.leftM.set(-1);
                climber.rightM.set(-1);

                climber.leftSecondaryM.set(0);
                climber.rightSecondaryM.set(0);
            }
        }
        else
        {
            climber.leftM.set(-oi.leftJ.getY());
            climber.leftSecondaryM.set((-oi.leftJ.getY() / 2 > OI.JOYSTICK_THRESHOLD) ? -1 : 0);

            climber.rightM.set(-oi.rightJ.getY());
            climber.rightSecondaryM.set((-oi.rightJ.getY() > OI.JOYSTICK_THRESHOLD) ? -1 : 0);

            if(oi.leftJ.getTrigger() || oi.rightJ.getTrigger())
            { //button to full reverse
                climber.leftM.set(-1);
                climber.rightM.set(-1);

                climber.leftSecondaryM.set(0);
                climber.rightSecondaryM.set(0);
            }
        }
    }

    protected boolean isFinished()
    {
        return false;
    }

    protected void end()
    {
        climber.leftM.set(0);
        climber.rightM.set(0);
        climber.leftSecondaryM.set(0);
        climber.rightSecondaryM.set(0);

        System.out.println("Default climber command ended.");
    }

    protected void interrupted()
    {
        System.out.println("Default climber command interrupted.");

        end();
    }
}
