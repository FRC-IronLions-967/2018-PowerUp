package org.usfirst.frc.team967.robot.commands;

import org.usfirst.frc.team967.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeArms extends Command {

	String Position;
	
    public IntakeArms(String position) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kIntakeSubsystem);
    	Position = position;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Position == "open") {
    		Robot.kIntakeSubsystem.armShifterOpen();
    	}
    	else if (Position == "closed") {
    		Robot.kIntakeSubsystem.armShifterClosed();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
