package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;
import org.usfirst.frc.team558.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;



public class CrossBaseline extends CommandGroup {

    public CrossBaseline() {
    	
       	requires(Robot.driveTrain);
       	requires(Robot.gyro);

        addSequential(new DriveWithEncoder(50, .5, 3, RobotMap.drive71Gain));
        addSequential(new TurnWithGyro(90, .6, RobotMap.turn90Gain));
        addSequential(new DriveWithEncoder(60, .5, 3, RobotMap.drive71Gain));
        addSequential(new TurnWithGyro(-90, .6, RobotMap.turn90Gain));
        addSequential(new DriveWithEncoder(80, .5, 3, RobotMap.drive71Gain));
        
    }
}
