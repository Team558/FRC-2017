
package org.usfirst.frc.team558.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team558.robot.autocommands.*;
import org.usfirst.frc.team558.robot.subsystems.*;

public class Robot extends IterativeRobot {

	//Subsystems
	public static DriveTrain driveTrain = new DriveTrain();
	public static GearIntakeSol gearIntakeSol = new GearIntakeSol();
	public static GearIntakeMotor gearIntakeMotors = new GearIntakeMotor();
	public static Brake brake = new Brake();
	public static Climber climber = new Climber();
	
	//Sensors
	public static PixyCam pixyCam = new PixyCam();
	public static Gyro gyro = new Gyro();
	public static GearSensor irSensor = new GearSensor();
	
	//PDPController
	public static PDPController pdpController = new PDPController();
	
	//Compressor Handler
	public static Compressor pcm = new Compressor();
	public static Relay compressor = new Relay(0);
	
	//Operator Interface
	public static OI oi;
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<Command>();
	
	
	@Override
	public void robotInit() {
		oi = new OI();
		CameraServer.getInstance().startAutomaticCapture();
		
		
		//Encoder and Gyro Only Autos
		chooser.addDefault("Do Nothing", new DoNothing());
		chooser.addObject("DoubleGearAuto", new DoubleGearAuto());
		chooser.addObject("Robot On Straight Drop Gear" , new DriveDropGear());
		chooser.addObject("Robot On Right Drop Gear" , new DriveAndDropGearRightSide());
		chooser.addObject("Robot On Left Drop Gear" , new DriveAndDropGearLeftSide());
		
		//Pixy Controlled Autos
		chooser.addObject("PIXY Robot On Straight Drop Gear Blue Side" , new DriveDropGearPixyBlue());
		chooser.addObject("PIXY Robot On Straight Drop Gear Red Side" , new DriveDropGearPixyRed());
		chooser.addObject("PIXY Robot On Right Drop Gear" , new DriveAndDropGearRightSidePixy());
		chooser.addObject("PIXY Robot On Left Drop Gear" , new DriveAndDropGearLeftSidePixy());
		
		
		SmartDashboard.putData("Auto mode", chooser);
	}


	@Override
	public void disabledInit() {
		
		Robot.oi.rumble(0, 0);
		

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void autonomousInit() {
		autonomousCommand = (Command) chooser.getSelected();
		
		Robot.driveTrain.resetEncoders();
		Robot.gyro.ResetGyro();
		Robot.driveTrain.EnableBrakeMode();
		Robot.brake.BrakeOff();
		
		
				if (autonomousCommand != null)
				autonomousCommand.start();
	}

	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		Robot.pixyCam.read();
		this.CompressorHandler();
		
	}

	@Override
	public void teleopInit() {

		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		Robot.driveTrain.SetRampRate();
		Robot.gyro.ResetGyro();
		Robot.driveTrain.resetEncoders();
		Robot.driveTrain.DisableBrakeMode();
		Robot.brake.BrakeOff();
		

		
	}

	
	@Override
	public void teleopPeriodic() {
	Scheduler.getInstance().run();
		
		Robot.pdpController.StorePDPData();
		Robot.pixyCam.read();
		this.CompressorHandler();
		this.MonitorPDPController();
		this.DashboardOutputs();
		
	}

	
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	public void CompressorHandler(){
		
		if(Robot.pdpController.CompressorFlag()){
			if (!pcm.getPressureSwitchValue()){
				compressor.set(Value.kForward);
			}
			else {
				compressor.set(Value.kOff);
			}
		}
		else {
			compressor.set(Value.kOff);
		}
		
	}
	
	public void DashboardOutputs(){
		SmartDashboard.putNumber("Left Encoder", Robot.driveTrain.GetLeftEncoder());
		SmartDashboard.putNumber("Right Encoder", Robot.driveTrain.GetRightEncoder());
		SmartDashboard.putNumber("Average Encoder", Robot.driveTrain.GetAverageEncoderDistance());
		SmartDashboard.putNumber("Pixy Offset" , Robot.pixyCam.getLastOffset());
		SmartDashboard.putNumber("Gyro Value", Robot.gyro.GetAngle());
		SmartDashboard.putBoolean("High Sensor" , Robot.irSensor.HighGearSensorRead());
		SmartDashboard.putBoolean("Low Sensor" , Robot.irSensor.LowGearSensorRead());
		SmartDashboard.putNumber("Left Drive", Robot.driveTrain.GetLeftDrive());
		SmartDashboard.putNumber("Right Drive", Robot.driveTrain.GetRightDrive());
		
	}
	
	public void MonitorPDPController(){
		SmartDashboard.putNumber("Average Current", pdpController.GetAverageTotalCurrent());
		SmartDashboard.putNumber("Total Current", pdpController.GetTotalCurrent());
		SmartDashboard.putNumber("Drivetrain Limiter", pdpController.DrivetrainLimiterWithTimeScale());
		SmartDashboard.putBoolean("Compressor Flag", pdpController.CompressorFlag());
		SmartDashboard.putBoolean("Gear Intake Flag", pdpController.GearIntakeFlag());
		
		
		
	}
}
