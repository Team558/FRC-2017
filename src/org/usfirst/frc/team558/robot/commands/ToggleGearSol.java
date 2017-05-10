package org.usfirst.frc.team558.robot.commands;

import org.usfirst.frc.team558.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;




public class ToggleGearSol extends Command {

    public ToggleGearSol() {
        requires(Robot.gearIntakeSol);
       }


       protected void initialize() {
       }


       protected void execute() {
       	Robot.gearIntakeSol.PushGearOut();
       }


       protected boolean isFinished() {
           return false;
       }


       protected void end() {
       }


       
       protected void interrupted() {
       	Robot.gearIntakeSol.ResetIntake();
       }
}
