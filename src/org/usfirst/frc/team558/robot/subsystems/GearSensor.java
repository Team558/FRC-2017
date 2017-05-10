package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team558.robot.RobotMap;
import org.usfirst.frc.team558.robot.commands.DetectGearSensor;

import edu.wpi.first.wpilibj.DigitalInput;

public class GearSensor extends Subsystem {

    DigitalInput gearSensor = new DigitalInput(RobotMap.highGearSensorChannel);
    DigitalInput intakeSensor = new DigitalInput(RobotMap.lowGearSensorChannel);
    
    public boolean LowGearSensorRead(){
    	return !intakeSensor.get();
    }
    public boolean HighGearSensorRead(){
    	return gearSensor.get();
    }
    
    
    public void initDefaultCommand() {
        setDefaultCommand(new DetectGearSensor());
    	
    }
}

