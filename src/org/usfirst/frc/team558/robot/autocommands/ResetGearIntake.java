package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetGearIntake extends Command {

    public ResetGearIntake(double atime) {
        
        requires(Robot.gearIntakeSol);
        setTimeout(atime);
    }

    
    protected void initialize() {
    	
    	Robot.gearIntakeSol.ResetIntake();
    	
    }

    
    protected void execute() {
    }

    
    protected boolean isFinished() {
        return isTimedOut();
    }

    
    protected void end() {
    }

    
    protected void interrupted() {
    }
}
