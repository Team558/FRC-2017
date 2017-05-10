package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;



public class InGear extends Command {

    public InGear(double atime) {
        requires(Robot.gearIntakeMotors);
        
        
        setTimeout(atime);
    }


    protected void initialize() {
    }


    protected void execute() {
    	
    	Robot.gearIntakeMotors.SetGearIntake(.65);
    	
    }


    protected boolean isFinished() {
        return isTimedOut();
    }


    protected void end() {
    	
    	Robot.gearIntakeMotors.GearIntakeStop();
    	
    }


    
    protected void interrupted() {
    }
}
