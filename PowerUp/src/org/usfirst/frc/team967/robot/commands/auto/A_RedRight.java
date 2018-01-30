package org.usfirst.frc.team967.robot.commands.auto;

import org.usfirst.frc.team967.lib.util.MatchData;
import org.usfirst.frc.team967.robot.commands.auto.subMain.A_RedRight_LLL;
import org.usfirst.frc.team967.robot.commands.auto.subMain.A_RedRight_LRL;
import org.usfirst.frc.team967.robot.commands.auto.subMain.A_RedRight_RLR;
import org.usfirst.frc.team967.robot.commands.auto.subMain.A_RedRight_RRR;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class A_RedRight extends Command {

    public A_RedRight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	MatchData.OwnedSide positionOne = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH_NEAR);
    	MatchData.OwnedSide positionTwo = MatchData.getOwnedSide(MatchData.GameFeature.SCALE);
    	MatchData.OwnedSide positionThree = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH_NEAR);
    	
    	if (positionOne == MatchData.OwnedSide.LEFT && positionTwo == MatchData.OwnedSide.LEFT && positionThree == MatchData.OwnedSide.LEFT) {
    		new A_RedRight_LLL();
    	}
    	else if (positionOne == MatchData.OwnedSide.RIGHT && positionTwo == MatchData.OwnedSide.LEFT && positionOne == MatchData.OwnedSide.RIGHT) {
    		new A_RedRight_RLR();
    	}
    	else if (positionOne == MatchData.OwnedSide.LEFT && positionTwo == MatchData.OwnedSide.RIGHT && positionThree == MatchData.OwnedSide.LEFT) {
    		new A_RedRight_LRL();
    	}
    	else if (positionOne == MatchData.OwnedSide.RIGHT && positionTwo == MatchData.OwnedSide.RIGHT && positionThree == MatchData.OwnedSide.RIGHT) {
    		new A_RedRight_RRR();
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
