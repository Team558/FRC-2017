package org.usfirst.frc.team558.robot.subsystems;

import edu.wpi.first.wpilibj.*;

import java.util.Arrays;

public class PDPController {
	
	public PowerDistributionPanel pdp = new PowerDistributionPanel();
	
	
	public double compressorCurrentLimit = 10000;
	public double gearIntakeCurrentLimit = 10000;
	public double drivetrainCurrentLimit = 10000;
	private double currentError;
	private double cKp = .02;
	private double limiter;
	
	private double timeError;
	private double startTime;
	private double presentTime;
	private double tKp = 0.2;
	
	
	private int index = 0;
	private double[] pdpData;

	
	public PDPController(){
		pdpData = new double[25];
		startTime = Timer.getFPGATimestamp();
	
	}

	public double GetTotalCurrent(){
		return (pdp.getCurrent(0) + pdp.getCurrent(1) + pdp.getCurrent(2) + pdp.getCurrent(3) + pdp.getCurrent(4) + pdp.getCurrent(5) + pdp.getCurrent(6) + pdp.getCurrent(7) + pdp.getCurrent(8) + pdp.getCurrent(9) + pdp.getCurrent(10) + pdp.getCurrent(11) + pdp.getCurrent(12) + pdp.getCurrent(13) + pdp.getCurrent(14) + pdp.getCurrent(15)) - 28.5;
	}
	
	public double GetChannelCurrent(int channel){
		return pdp.getCurrent(channel);
	}
	
	public void StorePDPData(){
		if (index > 24){
			index = 0;
		}
		pdpData[index] = this.GetTotalCurrent();
		index += 1;
	}
	
	public double GetAverageTotalCurrent(){
		double sum = Arrays.stream(pdpData).sum();
		double length = pdpData.length;
		return (sum/length);
	}
	
	
	//Sends signal to compressor to shut down if current limit is exceeded
	public boolean CompressorFlag(){
		return (this.GetAverageTotalCurrent() < this.compressorCurrentLimit);
	}
	
	

	//Sends signal to intake to shut down if current limit is exceeded
	public boolean GearIntakeFlag(){
		return (this.GetAverageTotalCurrent() < this.gearIntakeCurrentLimit);
	}
	


	//Reduces allowable power to drivetrain if current limit is exceeded
	//Scales with amount over limit and time since limit was surpased
	public double DrivetrainLimiterWithTimeScale(){
		if (this.GetAverageTotalCurrent() > this.drivetrainCurrentLimit){
			presentTime = Timer.getFPGATimestamp();
			timeError = Math.abs(presentTime - startTime);
			
			currentError = Math.abs(this.GetAverageTotalCurrent() - this.drivetrainCurrentLimit);
			limiter = 1 - (currentError * cKp) - (timeError * tKp);
		}
		else{
			startTime = Timer.getFPGATimestamp();
			limiter = 1;
		}
		
		return limiter;
		
	}

	
	
	//*** Methods for monitoring class***
	public double GetTimeError(){
		return this.timeError;
	}
	
	public double GetCurrentError(){
		return this.currentError;
	}
		
	public double GetStartTime(){
		return this.startTime;
	}
	
	public double GetPresentTime(){
		return this.presentTime;
	}
	
	public double GetIndex(){
		return this.index;
	}
	
	
	
	
}