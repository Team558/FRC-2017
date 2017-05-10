package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


//This class still needs work, proper proportional gains were not found to accurately use
// a tolerance to end the command and instead a set time was used. 


public class TurnWithGyro extends Command {

	private double desiredAngle;
	private double error;
	private double mKp;
	private double tolerance = 1;
	private double pidSpeed;
	private double mMaxSpeed;
	
    public TurnWithGyro(double aAngle, double aMaxSpeed, double aKp) {
        requires(Robot.driveTrain);
        requires(Robot.gyro);
        this.desiredAngle = aAngle;
        this.mMaxSpeed = aMaxSpeed;
        this.mKp = aKp;
        setTimeout(2);
        
    }

    protected void initialize() {
    	Robot.gyro.ResetGyro();
    
    }


    protected void execute() {
    	error = Math.abs(Math.abs(desiredAngle) - Math.abs(Robot.gyro.GetAngle()));
    	
    	if (mKp * error >= mMaxSpeed){
    		pidSpeed = mMaxSpeed;
    	}
    	else {
    		pidSpeed = mKp * error;
    	}

  
    	if (Robot.gyro.GetAngle() > desiredAngle)
        {
    		Robot.driveTrain.drive(-pidSpeed, pidSpeed);
        }
        else
        {
        	Robot.driveTrain.drive(pidSpeed, -pidSpeed);
        }
    	
    	
    }


    protected boolean isFinished() {
    	return isTimedOut(); //((Math.abs(error) <= tolerance) || isTimedOut());
    }


    protected void end() {
    	Robot.driveTrain.drive(0, 0);
    	Robot.gyro.ResetGyro();
    }


    protected void interrupted() {
    }
}