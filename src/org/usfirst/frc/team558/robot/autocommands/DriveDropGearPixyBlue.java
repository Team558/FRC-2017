package org.usfirst.frc.team558.robot.autocommands;

import org.usfirst.frc.team558.robot.Robot;
import org.usfirst.frc.team558.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;




public class DriveDropGearPixyBlue extends CommandGroup {

    public DriveDropGearPixyBlue() {
    	requires(Robot.driveTrain);
    	requires(Robot.gearIntakeMotors);
    	requires(Robot.gearIntakeSol);
    	requires(Robot.pixyCam);
    	requires(Robot.gyro);

        addSequential(new DriveWithEncoder(44, .5, 2, RobotMap.drive57Gain));
        addSequential(new DriveWithPixyAndEncoder(50, .5, 2, RobotMap.drive57Gain));
        addSequential(new DropGear(.5));  
        addSequential(new DriveWithEncoder(-32, .5, 2, RobotMap.drive57Gain));
        addSequential(new ResetGearIntake(.5));
        addSequential(new TurnWithGyro(90, .6, RobotMap.turn90Gain));
        addSequential(new DriveWithEncoder(60, .5, 2, RobotMap.drive71Gain));
        addSequential(new TurnWithGyro(-90, .6, RobotMap.turn90Gain));
        addSequential(new DriveWithEncoder(80, .6, 2, RobotMap.drive71Gain));
        
        
    }
}
