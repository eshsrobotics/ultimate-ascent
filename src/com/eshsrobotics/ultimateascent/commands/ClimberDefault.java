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
        climber.leftS.set(1 - .93 * oi.climbJ.getThrottle() / 6 - .10);
        climber.rightS.set(oi.climbJ.getThrottle() / 6 + .15);
        System.out.println(oi.climbJ.getThrottle());
        climber.leftM.set(-oi.climbJ.getY() / 2 + oi.climbJ.getX() / 2);
        climber.rightM.set(-oi.climbJ.getY() / 2 - oi.climbJ.getX() / 2);
        climber.leftSecondaryM.set((-oi.climbJ.getY() / 2 + oi.climbJ.getX() / 2 < -.1) ? -1 : 0);
        climber.rightSecondaryM.set((-oi.climbJ.getY() / 2 - oi.climbJ.getX() / 2 < -.1) ? -1 : 0);

        // Reverse
        if (oi.climbJ.getTrigger())
        {
            climber.leftM.set(-1);
            climber.rightM.set(-1);

            climber.leftSecondaryM.set(0);
            climber.rightSecondaryM.set(0);
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
