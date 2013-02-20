package com.eshsrobotics.ultimateascent.commands;

/**
 * Default command for Climber subsystem. Responsible for control of the climbing mechanism. Can currently extend and
 * retract the tape measures along with raising and lowering them through the use of a joystick.
 *
 * @author Benjamin Landers, Zachary Latta
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
        climber.leftS.set(-oi.climbJ.getThrottle() / 4.5 + .25);
        System.out.println(oi.climbJ.getThrottle());
        climber.rightS.set(oi.climbJ.getThrottle() / 6 + .15);

        if(!oi.dualClimb)
        {
            if(!oi.climbJ.getRawButton(12))
            {
                climber.leftM.set(-oi.climbJ.getY());
                climber.leftSecondaryM.set((-oi.climbJ.getY() / 2 > 0.05) ? -1 : 0);
            }

            if(!oi.climbJ.getRawButton(11))
            {
                climber.rightM.set(-oi.climbJ.getY());
                climber.rightSecondaryM.set((-oi.climbJ.getY() > 0.05) ? -1 : 0);
            }

            if(oi.climbJ.getTrigger())
            { //button to full reverse
                climber.leftM.set(-1);
                climber.rightM.set(-1);

                climber.leftSecondaryM.set(0);
                climber.rightSecondaryM.set(0);
            }
        }
        else
        {


            climber.leftM.set(-oi.firstJ.getY());
            climber.leftSecondaryM.set((-oi.firstJ.getY() / 2 > 0.05) ? -1 : 0);

            climber.rightM.set(-oi.secondJ.getY());
            climber.rightSecondaryM.set((-oi.secondJ.getY() > 0.05) ? -1 : 0);

            if(oi.firstJ.getTrigger())
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
