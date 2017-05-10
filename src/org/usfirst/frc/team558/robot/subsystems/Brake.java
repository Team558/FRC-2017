package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team558.robot.RobotMap;

import edu.wpi.first.wpilibj.*;

public class Brake extends Subsystem {

	
	public boolean brake;
	public DoubleSolenoid pinBrake = new DoubleSolenoid(RobotMap.pinBreakSolenoidChannel1,RobotMap.pinBreakSolenoidChannel2); 
	public Solenoid diskBrake = new Solenoid(RobotMap.diskBreakSolenoidChannel2);
	
    public void initDefaultCommand() {
    
    }
    
    public void BrakeOn(){
    	pinBrake.set(DoubleSolenoid.Value.kReverse);
    	diskBrake.set(false);
    }
    
    public void BrakeOff(){
    	pinBrake.set(DoubleSolenoid.Value.kForward);
    	diskBrake.set(true);
    }
}

