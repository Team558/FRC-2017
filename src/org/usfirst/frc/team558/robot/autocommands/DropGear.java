package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class DropGear extends Command {

    public DropGear(double atime) {
        requires(Robot.gearIntakeSol);
        
        setTimeout(atime);
    }


    protected void initialize() {
    }

    
    protected void execute() {
    	
    	Robot.gearIntakeSol.PushGearOut();
    	
    }

    
    protected boolean isFinished() {
        return isTimedOut();
    }

 
    protected void end() {
    	
    	
    }

    
    
    protected void interrupted() {
    }
}
