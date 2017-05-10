package org.usfirst.frc.team558.robot.util;

public class Util {
	
	private Util(){
		
	}

	public static double limit(double v, double limit){
		return (Math.abs(v) < limit) ? v : limit * (v < 0 ? -1 : 1);
	}
	
	
}
