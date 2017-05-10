package org.usfirst.frc.team558.robot;


public class RobotMap {
	
	//Joysticks and Buttons
			//Joystick USB Ports
			public static int driveJoystickPort = 0;
			public static int operatorJoystickPort = 1;
			
			
			//Driver Joystick Axes, Buttons, and Sensitivities 
			public static int quickTurnButton = 2;
			public static int creepModeFwdBtn = 5;
			public static int creepModeRevBtn = 6;
			public static int breakOnDriverButton = 3;
			public static int breakOffDriverButton = 4;
			public static int currentModeClimb = 1;
			
			public static int turnAxis = 0;
			public static int throttleForwardAxis = 3; // Climber Side
			public static int throttleReverseAxis = 2; // Gear Side
			
			public static double creepModeFwdThrottle = .3;
			public static double creepModeRevThrottle = .65;
			public static double quickturnSensitivity = .95;
			public static double normalTurnSensitivity = .75;
			
			
			
			//Operator Joystick Axes and Buttons
			public static int breakOnButton = 6;
			public static int breakOffButton = 5;
			public static int placeGearButton = 1;
			public static int climberButton = 2;
			
			public static int gearIntakeAxis = 1;
			
			
		//Speed Controllers
			
			//Drive TalonSRXs
			public static int leftDriveMaster = 16;
			public static int leftDriveSlave1 = 1;
			public static int leftDriveSlave2 = 2;
			
			public static int rightDriveMaster = 15;
			public static int rightDriveSlave1 = 13;
			public static int rightDriveSlave2 = 14;
			
			
			//Gear Intake TalonSRXs
			public static int gearIntakeChannel1 = 12;
			public static int gearIntakeChannel2= 3;
			
			//Climber TalonSRX
			public static int climberMotorChannel = 4;
			
			
			
		//Solenoids
			
			//Climber Brakes
			public static int pinBreakSolenoidChannel1 = 0;
			public static int pinBreakSolenoidChannel2 = 1;
			
			public static int diskBreakSolenoidChannel2 = 3;
			
			//Gear Placer
			public static int placerSolenoidChannel1 = 2;
			
			
			
			
		// Digital Inputs
			
			//IR Gear Sensor
			public static int highGearSensorChannel = 0;
			public static int lowGearSensorChannel = 1;
			
			
			
		//Proportional Gains
			
			public static double turn160Gain = .025;
			public static double turn60Gain = .04;
			public static double turn90Gain = .05;
			public static double drive57Gain = .009;
			public static double drive85Gain = .0085;
			public static double drive71Gain = .0089;
			
	
}
