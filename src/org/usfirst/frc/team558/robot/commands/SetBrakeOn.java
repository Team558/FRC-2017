package org.usfirst.frc.team558.robot.commands;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;




public class SetBrakeOn extends Command {

    public SetBrakeOn() {

        requires(Robot.brake);
    }


    protected void initialize() {
    }


    protected void execute() {
    	Robot.brake.BrakeOn();
    }


    protected boolean isFinished() {
        return false;
    }


    protected void end() {
    }


    
    protected void interrupted() {
    }
}
