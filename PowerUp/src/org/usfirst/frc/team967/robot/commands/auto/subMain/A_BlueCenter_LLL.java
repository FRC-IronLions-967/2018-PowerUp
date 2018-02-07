package org.usfirst.frc.team967.robot.commands.auto.subMain;

import org.usfirst.frc.team967.robot.commands.GyroPIDChangeState;
import org.usfirst.frc.team967.robot.commands.GyroPIDEnable;
import org.usfirst.frc.team967.robot.commands.GyroPIDTurnToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class A_BlueCenter_LLL extends CommandGroup {

    public A_BlueCenter_LLL() {
    	
    	addSequential(new GyroPIDEnable());
    	addSequential(new GyroPIDTurnToAngle(50));
    	addSequential(new GyroPIDChangeState());
    	
    	
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
