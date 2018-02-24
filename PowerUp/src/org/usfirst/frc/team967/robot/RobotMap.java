package org.usfirst.frc.team967.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static final int pcm = 1;
	
	// Drive Subsystem
	
	/* Last years robot map
	public static final int driveLeftLead = 3;
	public static final int driveLeftFollow = 5;
	public static final int driveRightLead = 14;
	public static final int driveRightFollow = 1;	
	*/
	
	public static final int driveLeftLead = 12;
	public static final int driveLeftFollow = 13;
	public static final int driveLeftFollowTwo = 14;
	public static final int driveRightLead = 3;
	public static final int driveRightFollow = 15;	
	public static final int driveRightFollowTwo = 2;
	
	
	// Lift Subsystem
	public static final int liftLead = 4;
	public static final int liftFollow = 5;
	public static final int limitSwitchTop = 1;
	public static final int limitSwitchBottom = 2;
	
	public static final int liftHigh = 6;
	public static final int liftLow = 1;
	
	public static final int busterBrakeIn = 5;
	public static final int busterBrakeOut = 2;
	
	//Intake
	public static final int leftIntake = 30;
	public static final int rightIntake = 20;
	public static final int armOpen = 7;
	public static final int armClosed = 0;
	
	//Wrist
	public static final int wrist = 1;
	
}
