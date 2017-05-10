package org.usfirst.frc.team558.robot.subsystems;

import org.usfirst.frc.team558.robot.Robot;
import org.usfirst.frc.team558.robot.RobotMap;
import org.usfirst.frc.team558.robot.commands.*;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;


public class GearIntakeMotor extends Subsystem {
	
	CANTalon intakeMotor1 = new CANTalon(RobotMap.gearIntakeChannel1);
    CANTalon intakeMotor2 = new CANTalon(RobotMap.gearIntakeChannel2);
	
	public GearIntakeMotor(){
    	
    	intakeMotor1.changeControlMode(TalonControlMode.PercentVbus);
		intakeMotor2.changeControlMode(TalonControlMode.PercentVbus);
    	
    }
    
    public void SetGearIntake(double speed){
    	if(Robot.pdpController.GearIntakeFlag()){
    		intakeMotor1.set(-speed);
    		intakeMotor2.set(speed);
    	}
    	else{
    		this.GearIntakeStop();
    	}
    }
    
    public void GearIntakeStop(){
    	
    	intakeMotor1.set(0);
    	intakeMotor2.set(0);
    	
    }
	

    public void initDefaultCommand() {
    	setDefaultCommand(new GearIn());
    }
}

