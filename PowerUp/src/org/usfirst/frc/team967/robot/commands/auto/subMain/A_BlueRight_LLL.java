package org.usfirst.frc.team967.robot.commands.auto.subMain;

import org.usfirst.frc.team967.robot.commands.AutoEndResets;
import org.usfirst.frc.team967.robot.commands.AutoStartUpResets;
import org.usfirst.frc.team967.robot.commands.DriveStright;
import org.usfirst.frc.team967.robot.commands.GyroPIDTurnToAngle;
import org.usfirst.frc.team967.robot.commands.ZeroEncodersDriveBase;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class A_BlueRight_LLL extends CommandGroup {

    public A_BlueRight_LLL() {
    	
    	addSequential(new AutoStartUpResets());
    	addSequential(new DriveStright(4000,.5)); // Change value to reflect distance 
    	addSequential(new GyroPIDTurnToAngle(-90)); // Needs Testing 
    	addSequential(new DriveStright(500,.5)); // Change value to reflect distance
    	addSequential(new AutoEndResets());
    	
    	
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
