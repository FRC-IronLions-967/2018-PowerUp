package org.usfirst.frc.team967.robot;

public class RobotConstraints {

	public static final double DriveSubsystem_deadBand = .15;
	public static final double DriveSubsystem_kP = 0.003; // 0.018
	public static final double DriveSubsystem_kI = 0;
	public static final double DriveSubsystem_kD = 0.00128; // .02
	public static final double DriveSubsystem_kToleranceDegrees = 2.0f;
	
	public static final double LiftSubsystem_kP = 0;
	public static final double LiftSubsystem_kI = 0;
	public static final double LiftSubsystem_kD = 0;
	public static final double LiftSubsystem_kTolerance = 1f;
	
	public RobotConstraints() {}
}
