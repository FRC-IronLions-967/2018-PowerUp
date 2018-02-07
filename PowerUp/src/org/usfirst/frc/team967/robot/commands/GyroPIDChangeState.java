package org.usfirst.frc.team967.robot.commands;

import org.usfirst.frc.team967.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroPIDChangeState extends Command {

	String state;
	
    public GyroPIDChangeState(String State) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kDriveBaseSubsystem);
    	state = State;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.kDriveBaseSubsystem.pidChangeState(state);
    	
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
