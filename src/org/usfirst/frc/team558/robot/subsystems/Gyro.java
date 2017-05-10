package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.kauailabs.navx.frc.*;


public class Gyro extends Subsystem {

	AHRS gyro = new AHRS(SPI.Port.kMXP);

	
    public void initDefaultCommand() {
    }
    
    
    public double GetAngle(){
    	return gyro.getYaw();
    }
    
    
    public void ResetGyro(){
    	gyro.reset();
    }
}

