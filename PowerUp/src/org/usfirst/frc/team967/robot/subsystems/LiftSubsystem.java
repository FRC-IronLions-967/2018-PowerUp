package org.usfirst.frc.team967.robot.subsystems;

import org.usfirst.frc.team967.robot.RobotConstraints;
import org.usfirst.frc.team967.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LiftSubsystem extends Subsystem implements PIDOutput {

	private WPI_TalonSRX liftLead;
	private WPI_TalonSRX liftFollow;
	
	private DigitalInput limitSwitchTop;
	private DigitalInput limitSwitchBottom;
	
	private PIDController liftController;
	private final double kP = RobotConstraints.LiftSubsystem_kP;
	private final double kI = RobotConstraints.LiftSubsystem_kI;
	private final double kD = RobotConstraints.LiftSubsystem_kD;
	private final double kToleranceDegrees = RobotConstraints.LiftSubsystem_kTolerance;
	
	private PIDSource input;
	public double PIDOutput;
	
    public LiftSubsystem(){
    	liftLead = new WPI_TalonSRX(RobotMap.liftLead);
    	liftFollow = new WPI_TalonSRX(RobotMap.liftFollow);
    	
    	limitSwitchTop = new DigitalInput(RobotMap.limitSwitchTop);
    	limitSwitchBottom = new DigitalInput(RobotMap.limitSwitchBottom);
    	
    	liftController = new PIDController(kP, kI, kD, input, liftLead);
    	liftController.disable();
    	liftController.setInputRange(0, 0);
    	liftController.setOutputRange(-1, 1);
    	liftController.setAbsoluteTolerance(kToleranceDegrees);
    	liftController.setContinuous(false);
    	
    }

//    public void limit() {
//    	boolean isClosed = limitSwitchTop.get();
//    	SmartDashboard.putBoolean("limit", isClosed);
//    }
    
    
    
    public void moveLift(double power) {
    	liftLead.set(power);
    	liftFollow.set(power);
    }
    
    
    public void pidSetSetpoint(double input) {
    	liftController.setSetpoint(input);
    }
    
    public boolean isPidDone() {
		if(liftController.getSetpoint() == 1) {
			return true;
		}
		else {
			return false;
		}
    }
    
    public void pidStart() {
    	liftController.enable();
    }
    
    public void pidStop() {
    	liftController.disable();
    }
    
	public void pidWrite(double output) {
		PIDOutput = output;
		
	}
	
	public void initDefaultCommand() {}
    
    public void log() {}
}

