package org.usfirst.frc.team558.robot.commands;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;





public class DetectGearSensor extends Command {

    public DetectGearSensor() {

        requires(Robot.irSensor);
    }


    protected void initialize() {
    }


    protected void execute() {
    	
    	if(Robot.irSensor.LowGearSensorRead()){
    		
    		Robot.oi.rumble(.95, .95);
    		
    	}
    	else if (Robot.irSensor.HighGearSensorRead()){
    		Robot.oi.rumble(.35, .35);
    	}
    	else{
    		
    		Robot.oi.rumble(0, 0);
    		
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
