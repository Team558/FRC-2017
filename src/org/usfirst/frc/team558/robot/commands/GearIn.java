package org.usfirst.frc.team558.robot.commands;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;



public class GearIn extends Command {

    public GearIn() {
        
    	requires(Robot.gearIntakeMotors);
    }

    
    protected void initialize() {
    }

    
    protected void execute() {
    	double gearMotorAxis = Robot.oi.GearInOut();
    	
    	if(gearMotorAxis > .3){
    		
    		Robot.gearIntakeMotors.SetGearIntake(.65);
    		
    	}
    	else if(gearMotorAxis < -.3){
    		
    		Robot.gearIntakeMotors.SetGearIntake(-.65);
    		
    	}
    	else{
    		
    		Robot.gearIntakeMotors.GearIntakeStop();
    		
    	}
    	
    }

    
    protected boolean isFinished() {
        return false;
    }

    
    protected void end() {
    }

    
    
    protected void interrupted() {
    }
}
