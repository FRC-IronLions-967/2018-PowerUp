package org.usfirst.frc.team967.robot.commands.auto;

import org.usfirst.frc.team967.robot.commands.PIDTurnToAngle;
import org.usfirst.frc.team967.robot.commands.T_ArcadeDrive;
import org.usfirst.frc.team967.robot.commands.moveDirect;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class A_BlueLeft extends CommandGroup {

    public A_BlueLeft() {
    		addSequential(new PIDTurnToAngle(60));
    		addSequential(new PIDTurnToAngle(120));
    		addSequential(new PIDTurnToAngle(180));
    		addSequential(new PIDTurnToAngle(240));
    		addSequential(new PIDTurnToAngle(300));
    		addSequential(new PIDTurnToAngle(360));
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
