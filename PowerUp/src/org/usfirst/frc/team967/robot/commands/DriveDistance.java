package org.usfirst.frc.team967.robot.commands;

import org.usfirst.frc.team967.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command {

	private double counts;
	private double power;
	
    public DriveDistance(double distance, double Power) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kDriveBaseSubsystem);
    	counts = distance;
    	power = Power; 	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.kDriveBaseSubsystem.zeroEncoders();
    	if(counts > 0) {
    		Robot.kDriveBaseSubsystem.arcadeDrive(-power, 0);
    	} else {
    		Robot.kDriveBaseSubsystem.arcadeDrive(power, 0);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.kDriveBaseSubsystem.driveDistance(counts);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.kDriveBaseSubsystem.driveDistance(counts);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kDriveBaseSubsystem.zeroEncoders();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
