package org.usfirst.frc.team967.robot.subsystems;

import org.usfirst.frc.team967.robot.RobotConstraints;
import org.usfirst.frc.team967.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LiftSubsystem extends Subsystem {

	private WPI_TalonSRX liftLead;
	private WPI_TalonSRX liftFollow;
	
	private DigitalInput limitSwitchTop;
	private DigitalInput limitSwitchBottom;
	
	private PIDController liftController;
	private final double kP = RobotConstraints.LiftSubsystem_kP;
	private final double kI = RobotConstraints.LiftSubsystem_kI;
	private final double kD = RobotConstraints.LiftSubsystem_kD;
	private final double kToleranceDegrees = RobotConstraints.LiftSubsystem_kTolerance;
	
    public LiftSubsystem(){
    	liftLead = new WPI_TalonSRX(RobotMap.liftLead);
    	liftFollow = new WPI_TalonSRX(RobotMap.liftFollow);
    	
    	limitSwitchTop = new DigitalInput(RobotMap.limitSwitchTop);
    	limitSwitchBottom = new DigitalInput(RobotMap.limitSwitchBottom);
    	
    	liftFollow.follow(liftLead);
    }
    
    public void limit() {
    	boolean isTop = limitSwitchTop.get();
    	boolean isBottom = limitSwitchBottom.get();
    }
    
    public void moveLift(double power) {
    	liftLead.set(power);
//    	liftFollow.set(power);
    }
    
	public void initDefaultCommand() {}
    
    public void log() {}
}

