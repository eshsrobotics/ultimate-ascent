package com.eshsrobotics.ultimateascent.commands;

import com.eshsrobotics.ultimateascent.OI;
import com.eshsrobotics.ultimateascent.RobotMap;


/**
 * Default command for Climber subsystem. Responsible for control of the climbing mechanism. Can currently extend and
 * retract the tape measures along with raising and lowering them through the use of a joystick.
 *
 * @author Benjamin Landers, Zachary Latta, David Tung
 */
public class ClimberDefault extends CommandBase
{
    /**
     * The speed at which the climbing motors should move when a
     */
    public static final float CLIMB_SPEED = -1f;
    public static final int DEGREE_LIMIT = 25; 

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
       // System.out.println("Gyro : "+climber.gyro.getAngle());
        climber.leftS.set(-oi.cameraJ.getThrottle()/2 +.5);
        climber.rightS.set(oi.cameraJ.getThrottle()/2 +.5);
        if(RobotMap.gyroEnabled)
        {
            if(!OI.dualClimb)
            {
    
                if(oi.cameraJ.getTrigger())
                { //button for while on 
                    climber.leftM.set(-oi.cameraJ.getY()+climber.gyro.getAngle()/DEGREE_LIMIT);
                    climber.rightM.set((-oi.cameraJ.getY()-climber.gyro.getAngle()/DEGREE_LIMIT));
                    climber.rightSecondaryM.set(0);
                    climber.leftSecondaryM.set(0);
                }else
                {
                    climber.gyro.reset();
                    if(!oi.cameraJ.getRawButton(OI.cameraButtonRight))
                    {
                        climber.leftM.set(-oi.cameraJ.getY());
                        climber.leftSecondaryM.set((-oi.cameraJ.getY() > OI.JOYSTICK_THRESHOLD) ? -1 : 0);
                    }
    
                    if(!oi.cameraJ.getRawButton(OI.cameraButtonLeft))
                    {
                        climber.rightM.set((-oi.cameraJ.getY()));
                        climber.rightSecondaryM.set((-oi.cameraJ.getY() > OI.JOYSTICK_THRESHOLD) ? -1 : 0);
                    }
                }
            }
            else
            {

                if(oi.leftJ.getTrigger() || oi.rightJ.getTrigger())
                { //button to full reverse
                    climber.leftM.set(-oi.leftJ.getY()+climber.gyro.getAngle()/DEGREE_LIMIT);
                    climber.rightM.set((-oi.rightJ.getY()-climber.gyro.getAngle()/DEGREE_LIMIT));
                    climber.rightSecondaryM.set(0);
                    climber.leftSecondaryM.set(0);
                }else
                {
                    climber.gyro.reset();
                    climber.leftM.set(-oi.leftJ.getY());
                    climber.leftSecondaryM.set((-oi.leftJ.getY()  > OI.JOYSTICK_THRESHOLD) ? -1 : 0);
                    climber.rightM.set((-oi.rightJ.getY()));
                    climber.rightSecondaryM.set((-oi.rightJ.getY() > OI.JOYSTICK_THRESHOLD) ? -1 : 0);
                }
                
            }    
        }
        else
        {
            if(!OI.dualClimb)
            {
                if(!oi.cameraJ.getRawButton(OI.cameraButtonRight))
                {
                    climber.leftM.set(-oi.cameraJ.getY());
                    climber.leftSecondaryM.set((-oi.cameraJ.getY() > OI.JOYSTICK_THRESHOLD) ? -1 : 0);
                }
    
                if(!oi.cameraJ.getRawButton(OI.cameraButtonLeft))
                {
                    climber.rightM.set((-oi.cameraJ.getY())/2);
                    climber.rightSecondaryM.set((-oi.cameraJ.getY() > OI.JOYSTICK_THRESHOLD) ? -1 : 0);
                }
    
                if(oi.cameraJ.getTrigger())
                { //button to full reverse
                    climber.leftM.set(CLIMB_SPEED);
                    climber.rightM.set(CLIMB_SPEED);
    
                    climber.leftSecondaryM.set(0);
                    climber.rightSecondaryM.set(0);
                }
            }
            else
            {
                climber.leftM.set(-oi.leftJ.getY());
                climber.leftSecondaryM.set((-oi.leftJ.getY() > OI.JOYSTICK_THRESHOLD) ? -1 : 0);
    
                climber.rightM.set(-oi.rightJ.getY());
                climber.rightSecondaryM.set((-oi.rightJ.getY() > OI.JOYSTICK_THRESHOLD) ? -1 : 0);
    
                if(oi.leftJ.getTrigger() || oi.rightJ.getTrigger())
                { //button to full reverse
                    climber.leftM.set(CLIMB_SPEED);
                    climber.rightM.set(CLIMB_SPEED);
    
                    climber.leftSecondaryM.set(0);
                    climber.rightSecondaryM.set(0);
                }
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
