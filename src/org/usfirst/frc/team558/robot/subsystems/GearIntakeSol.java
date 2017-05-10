package org.usfirst.frc.team558.robot.subsystems;

import org.usfirst.frc.team558.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;



public class GearIntakeSol extends Subsystem {
	
	Solenoid intakeSol = new Solenoid(RobotMap.placerSolenoidChannel1); 
	
	public void PushGearOut(){
		
		intakeSol.set(true);
		
	}
	
	public void ResetIntake(){
		
		intakeSol.set(false);
		
	}

    public void initDefaultCommand() {
    	
    }
}

