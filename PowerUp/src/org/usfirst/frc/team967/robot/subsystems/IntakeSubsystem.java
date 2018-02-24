package org.usfirst.frc.team967.robot.subsystems;

import org.usfirst.frc.team967.robot.RobotMap;
import org.usfirst.frc.team967.robot.commands.IntakePower;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {

	private WPI_TalonSRX leftIntake;
	private WPI_TalonSRX rightIntake;
	
	private DoubleSolenoid armShifter;
	
	public double Position = 0;
	
	public IntakeSubsystem() {
		leftIntake = new WPI_TalonSRX(RobotMap.leftIntake);
		rightIntake = new WPI_TalonSRX(RobotMap.rightIntake);
		
		armShifter = new DoubleSolenoid(RobotMap.pcm, RobotMap.armOpen,RobotMap.armClosed);
	}
	
	public void intakePower(double power) {
		rightIntake.set(power);
		leftIntake.set(-power);
	}
	
	public void armShifterOpen() {
		armShifter.set(DoubleSolenoid.Value.kForward);
	}
	
	public void armShifterClosed() {
		armShifter.set(DoubleSolenoid.Value.kReverse);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new IntakePower());
    }
}

