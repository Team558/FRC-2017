package org.usfirst.frc.team558.robot.commands;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;



public class PowerClimber extends Command {

    public PowerClimber() {
        
    	requires(Robot.climber);
    	
    }


    protected void initialize() {
    }


    protected void execute() {
    	
    	Robot.climber.climberOn();
    	
    }


    protected boolean isFinished() {
        return false;
    }


    protected void end() {
    }


    
    protected void interrupted() {
    	
    	Robot.climber.climberOff();
    	
    }
}
