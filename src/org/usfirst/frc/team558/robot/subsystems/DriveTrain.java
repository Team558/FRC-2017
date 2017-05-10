package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team558.robot.Robot;
import org.usfirst.frc.team558.robot.RobotMap;
import org.usfirst.frc.team558.robot.commands.ElmCityDrive;

import com.ctre.*;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;



public class DriveTrain extends Subsystem {
	
	CANTalon leftDriveMaster = new CANTalon(RobotMap.leftDriveMaster);
	CANTalon leftDriveSlave1 = new CANTalon(RobotMap.leftDriveSlave1);
	CANTalon leftDriveSlave2 = new CANTalon(RobotMap.leftDriveSlave2);
	CANTalon rightDriveMaster = new CANTalon(RobotMap.rightDriveMaster);
	CANTalon rightDriveSlave1 = new CANTalon(RobotMap.rightDriveSlave1);
	CANTalon rightDriveSlave2 = new CANTalon(RobotMap.rightDriveSlave2);

	
	public DriveTrain(){
		
		// DriveTrain Master
		this.leftDriveMaster.changeControlMode(TalonControlMode.PercentVbus);
		this.rightDriveMaster.changeControlMode(TalonControlMode.PercentVbus);
		
		// DriveTrain Encoders
		
		this.leftDriveMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		this.leftDriveMaster.reverseSensor(false);
		this.rightDriveMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		this.rightDriveMaster.reverseSensor(true);
		this.leftDriveMaster.configEncoderCodesPerRev((int)(128/1.7382));
		this.rightDriveMaster.configEncoderCodesPerRev((int)(128/1.7382));
		
		// Slave DriveTrain
		this.leftDriveSlave1.changeControlMode(TalonControlMode.Follower);
		this.leftDriveSlave1.set(this.leftDriveMaster.getDeviceID());
		this.leftDriveSlave2.changeControlMode(TalonControlMode.Follower);
		this.leftDriveSlave2.set(this.leftDriveMaster.getDeviceID());
		
		this.rightDriveSlave1.changeControlMode(TalonControlMode.Follower);
		this.rightDriveSlave1.set(this.rightDriveMaster.getDeviceID());
		this.rightDriveSlave2.changeControlMode(TalonControlMode.Follower);
		this.rightDriveSlave2.set(this.rightDriveMaster.getDeviceID());
		
	}
	
	public void drive(double leftPower, double rightPower){
		this.leftDriveMaster.set(leftPower * Robot.pdpController.DrivetrainLimiterWithTimeScale());
		this.rightDriveMaster.set(-rightPower * Robot.pdpController.DrivetrainLimiterWithTimeScale());
	}
   
    public void initDefaultCommand() {
       setDefaultCommand(new ElmCityDrive());
    }
    
    public double GetLeftEncoder(){
    	return this.leftDriveMaster.getPosition();
    }
    
    public double GetRightEncoder(){
    	return this.rightDriveMaster.getPosition();
    }
    
    public double GetAverageEncoderDistance(){
    	return ((this.leftDriveMaster.getPosition() + this.rightDriveMaster.getPosition())/2);
    }
    
    public void resetEncoders() {
    	this.leftDriveMaster.setPosition(0.0);
    	this.rightDriveMaster.setPosition(0.0);
    }
    
    public double GetLeftDrive(){
    	
    	return this.leftDriveMaster.get();
    	
    }
    
    public double GetRightDrive(){
    	
    	return this.rightDriveMaster.get();
    	
    }
    
    public void SetRampRate(){
    	this.leftDriveMaster.setVoltageRampRate(60);
		this.rightDriveMaster.setVoltageRampRate(60);
    }
    
    public void EnableBrakeMode(){
    	this.leftDriveMaster.enableBrakeMode(true);
    	this.leftDriveSlave1.enableBrakeMode(true);
    	this.leftDriveSlave2.enableBrakeMode(true);
    	
    	this.rightDriveMaster.enableBrakeMode(true);
    	this.rightDriveSlave1.enableBrakeMode(true);
    	this.rightDriveSlave2.enableBrakeMode(true);
    }
    
    
    public void DisableBrakeMode(){
    	this.leftDriveMaster.enableBrakeMode(false);
    	this.leftDriveSlave1.enableBrakeMode(false);
    	this.leftDriveSlave2.enableBrakeMode(false);
    	
    	this.rightDriveMaster.enableBrakeMode(false);
    	this.rightDriveSlave1.enableBrakeMode(false);
    	this.rightDriveSlave2.enableBrakeMode(false);
    }
    
    
    
    //Method no longer in use, was used when climber was attached to drivetrain
    public void EnableCurrentModeClimbing(){
    	this.leftDriveMaster.setCurrentLimit(35);
    	this.leftDriveSlave1.setCurrentLimit(35);
    	this.leftDriveSlave2.setCurrentLimit(35);
    	
    	this.rightDriveMaster.setCurrentLimit(35);
    	this.rightDriveSlave1.setCurrentLimit(35);
    	this.rightDriveSlave2.setCurrentLimit(35);
    	
    	this.leftDriveMaster.EnableCurrentLimit(true);
    	this.leftDriveSlave1.EnableCurrentLimit(true);
    	this.leftDriveSlave2.EnableCurrentLimit(true);
    	
    	this.rightDriveMaster.EnableCurrentLimit(true);
    	this.rightDriveSlave1.EnableCurrentLimit(true);
    	this.rightDriveSlave2.EnableCurrentLimit(true);
    	
    	
    	
    }
    

    //Method no longer in use, was used when climber was attached to drivetrain
    public void DisableCurrentModeClimbing(){
    	
    	this.leftDriveMaster.EnableCurrentLimit(false);
    	this.leftDriveSlave1.EnableCurrentLimit(false);
    	this.leftDriveSlave2.EnableCurrentLimit(false);
    	
    	
    	this.rightDriveMaster.EnableCurrentLimit(false);
    	this.rightDriveSlave1.EnableCurrentLimit(false);
    	this.rightDriveSlave2.EnableCurrentLimit(false);
    	
    }
    
    
}

