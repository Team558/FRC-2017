package org.usfirst.frc.team558.robot.subsystems;

import org.usfirst.frc.team558.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;




public class Climber extends Subsystem {

	CANTalon climbMotor = new CANTalon(RobotMap.climberMotorChannel);
	
	public Climber(){
		
		climbMotor.changeControlMode(TalonControlMode.PercentVbus);
		climbMotor.EnableCurrentLimit(true);
		climbMotor.setCurrentLimit(40);
		
	}
	
	public void climberOn(){
		
		climbMotor.set(1);
		
		
	}
	
	public void climberOff(){
		
		climbMotor.set(0);
		
	}
	
	
    public void initDefaultCommand() {

    }
}

