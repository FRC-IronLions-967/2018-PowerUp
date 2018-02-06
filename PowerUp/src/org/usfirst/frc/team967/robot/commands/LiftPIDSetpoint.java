package org.usfirst.frc.team967.robot.commands;

import org.usfirst.frc.team967.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftPIDSetpoint extends Command {

	private int pos;
	
    public LiftPIDSetpoint(int Pos) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kLiftSubsystem);
    	pos = Pos;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.kLiftSubsystem.changeSetpoint(pos);
    	Robot.kLiftSubsystem.pidStart();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.kLiftSubsystem.moveLift(Robot.kLiftSubsystem.PIDOutput);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.kLiftSubsystem.isPidDone();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kLiftSubsystem.pidStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.kLiftSubsystem.pidStop();
    }
}
