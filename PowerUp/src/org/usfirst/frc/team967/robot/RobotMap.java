package org.usfirst.frc.team967.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// Drive Subsystem
	public static final int driveLeftLead = 5;
	public static final int driveLeftFollow = 3;
	public static final int driveRightLead = 1;
	public static final int driveRightFollow = 14;	
	
	// Lift Subsystem
	public static final int liftLead = 0;
	public static final int liftFollow = 0;
	public static final int limitSwitchTop = 1;
	public static final int limitSwitchBottom = 2;
}
