package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class DriveWithPixyAndEncoder extends Command {
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
    public DriveWithPixyAndEncoder(double aDistance, double aSpeed, double aTime, double aKp) {
        requires(Robot.driveTrain);
        requires(Robot.pixyCam);
        
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
    	Robot.pixyCam.read();
    	double offset = Robot.pixyCam.getLastOffset();
    	double camError = offset - 160;
    	double kPc = .01;
    	double scaleRight = 1 - (camError * kPc);
    	double scaleLeft = 1 + (camError * kPc);
    	
    	
    	error = Math.abs(mDistance - Robot.driveTrain.GetAverageEncoderDistance());
    	
    	if (mKp * error >= mSpeed){
    		pidSpeed = mSpeed;
    	}
    	else {
    		pidSpeed = mKp * error;
    	}

  
    	if (Robot.driveTrain.GetAverageEncoderDistance() < mDistance)
        {
    		Robot.driveTrain.drive(-pidSpeed * scaleLeft, -pidSpeed * scaleRight);
        }
        else
        {
        	Robot.driveTrain.drive(pidSpeed * scaleLeft, pidSpeed * scaleRight);
        }
    	
    }
    protected boolean isFinished() {
    	return ((Math.abs(error) <= tolerance) || isTimedOut());
    }

    
    
    protected void end() {
    }

  
    
    protected void interrupted() {
    }
}
