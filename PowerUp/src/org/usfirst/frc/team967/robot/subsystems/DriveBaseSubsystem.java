package org.usfirst.frc.team967.robot.subsystems;

import java.text.DecimalFormat;

import org.usfirst.frc.team967.robot.RobotConstraints;
import org.usfirst.frc.team967.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveBaseSubsystem extends Subsystem {
	
	private static final double deadBand = RobotConstraints.DriveSubsystem_deadBand;
	private WPI_TalonSRX driveLeftLead;
	private WPI_TalonSRX driveLeftFollow;
	
	private WPI_TalonSRX driveRightLead;
	private WPI_TalonSRX driveRightFollow;
	
	
	public DriveBaseSubsystem() {
		
		driveLeftLead = new WPI_TalonSRX(RobotMap.driveLeftLead);
		driveLeftFollow = new WPI_TalonSRX(RobotMap.driveLeftFollow);
		driveRightLead = new WPI_TalonSRX(RobotMap.driveLeftLead);
		driveRightFollow = new WPI_TalonSRX(RobotMap.driveLeftFollow);
				
		driveLeftFollow.follow(driveLeftLead);
		driveRightFollow.follow(driveRightLead);
		
				
	}
    
    public void tankDrive(double left, double right) {
    	move(left,right);
    }
    
    public void arcadeDrive(double yAxis, double xAxis) {
    //square the values for better control at low speeds
    yAxis = yAxis*Math.abs(yAxis);
    xAxis = xAxis*Math.abs(xAxis);
    
	if((yAxis< deadBand) && (yAxis > -deadBand)){ yAxis=0;}
    if((xAxis< deadBand) && (xAxis > -deadBand)){ xAxis=0;}
    double L = yAxis + xAxis;
    double R = yAxis - xAxis;
    double max = Math.abs(L);
    if(Math.abs(R) > max) max = Math.abs(R);
    if((Math.abs(yAxis) <= 1) && (Math.abs(xAxis) <= 1) && (max < 1)){
      	move(L,R);
    }else
    	move(L/max, R/max);
    }
    
    public void move(double leftPower, double rightPower) {
    	driveLeftLead.set(leftPower);
    	driveRightLead.set(-rightPower);
    }
    
    public void initDefaultCommand() {
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void log() {
    	
    }
}