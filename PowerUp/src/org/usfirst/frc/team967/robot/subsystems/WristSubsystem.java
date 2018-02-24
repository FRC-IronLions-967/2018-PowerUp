package org.usfirst.frc.team967.robot.subsystems;

import org.usfirst.frc.team967.robot.RobotMap;
import org.usfirst.frc.team967.robot.commands.IntakeWrist;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;


public class WristSubsystem extends Subsystem {
	
	private WPI_TalonSRX wristIntake;

	public WristSubsystem() {
		wristIntake = new WPI_TalonSRX(RobotMap.wrist);
	}
	
	public void intakeWrist(double position) {
		wristIntake.set(position);	
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new IntakeWrist());
    }
}

