package org.usfirst.frc.team967.robot.commands;

import org.usfirst.frc.team967.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStright extends Command {
	
	private double counts;
	private double power;
	
    public DriveStright(double Distance, double Power) {
    	requires(Robot.kDriveBaseSubsystem);
    	counts = Distance;
    	power = Power;
    	Robot.kDriveBaseSubsystem.zeroEncoders();
    	if(counts > 0){
    		power = -power;
    	}
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.kDriveBaseSubsystem.pidSetPoint(Robot.kDriveBaseSubsystem.getYaw());
    	Robot.kDriveBaseSubsystem.pidChangeState("Enable");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.kDriveBaseSubsystem.move(power + 2*Robot.kDriveBaseSubsystem.PIDOutput, power + -2*Robot.kDriveBaseSubsystem.PIDOutput);
//    	Robot.kDriveBaseSubsystem.driveDistance(counts);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.kDriveBaseSubsystem.driveDistance(counts);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kDriveBaseSubsystem.zeroEncoders();
    	Robot.kDriveBaseSubsystem.pidChangeState("Disable");
    	Robot.kDriveBaseSubsystem.move(0, 0);
    	Robot.kDriveBaseSubsystem.countsmeet = true;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {

    }
}