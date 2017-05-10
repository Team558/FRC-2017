package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;



public class DriveWithEncoder extends Command {

	private double mTime;
	private double mSpeed;
	private double mDistance;
	private double mKp;
	
	private double error;
	private double tolerance = .5;
	private double pidSpeed;
	
	
	 /**
     * Drive robot based off set encoder distance
     * 
     * @param aDistance
     *            Distance for robot to travel in inches
     * @param aSpeed
     *            Max speed for robot to travel -1 to 1
     * @param aTime
     *            Max time till timed out in seconds
     * @param aKp
     * 			  Proportional constant for desired distance
     */
    
    public DriveWithEncoder(double aDistance, double aSpeed, double aTime, double aKp) {
        
    	requires(Robot.driveTrain);
        
        this.mDistance = aDistance;
        this.mSpeed = aSpeed;
        this.mTime = aTime;
        this.mKp = aKp;
        
        setTimeout(mTime);
        
    }
    

    
    protected void initialize() {
    	Robot.driveTrain.resetEncoders();
    }

    
    
    protected void execute() {
    	
    	error = Math.abs(mDistance - Robot.driveTrain.GetAverageEncoderDistance());
    	
    	if (mKp * error >= mSpeed){
    		pidSpeed = mSpeed;
    	}
    	else {
    		pidSpeed = mKp * error;
    	}

  
    	if (Robot.driveTrain.GetAverageEncoderDistance() < mDistance)
        {
    		Robot.driveTrain.drive(-pidSpeed, -pidSpeed);
        }
        else
        {
        	Robot.driveTrain.drive(pidSpeed, pidSpeed);
        }
    	
    }

    
    protected boolean isFinished() {
    	return ((Math.abs(error) <= tolerance) || isTimedOut());
    }

    
    
    protected void end() {
    	
    	Robot.driveTrain.drive(0, 0);
    	Robot.driveTrain.resetEncoders();
    	
    }

    
    protected void interrupted() {
    }
}
