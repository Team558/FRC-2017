package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;
import org.usfirst.frc.team558.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;



public class CrossBaselineStraight extends CommandGroup {

    public CrossBaselineStraight() {

       	requires(Robot.driveTrain);
       	requires(Robot.gyro);
       	
        addSequential(new DriveWithEncoder(90, .5, 5, RobotMap.drive71Gain));
       
        
    }
}
