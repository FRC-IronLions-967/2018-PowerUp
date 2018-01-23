package org.usfirst.frc.team967.robot.subsystems;

import java.text.DecimalFormat;

import org.usfirst.frc.team967.lib.util.MatchData;
import org.usfirst.frc.team967.robot.RobotConstraints;
import org.usfirst.frc.team967.robot.RobotMap;
import org.usfirst.frc.team967.robot.commands.T_ArcadeDrive;

import com.ctre.phoenix.motorcontrol.can.*;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveBaseSubsystem extends Subsystem implements PIDOutput{
	
	private AHRS gyro;
	private PIDController pidController;
	
	public double PIDOutput;
	
	static final double kP = RobotConstraints.DriveSubsystem_kP;
	static final double kI = RobotConstraints.DriveSubsystem_kI;
	static final double kD = RobotConstraints.DriveSubsystem_kD;
	
	static final double kToleranceDegrees = RobotConstraints.DriveSubsystem_kToleranceDegrees;
	
	private WPI_TalonSRX driveLeftLead;
	private WPI_TalonSRX driveLeftFollow;
	
	private WPI_TalonSRX driveRightLead;
	private WPI_TalonSRX driveRightFollow;
		
	private static final double deadBand = RobotConstraints.DriveSubsystem_deadBand;
	
	private DigitalInput limitSwitch;
	
	private DecimalFormat df = new DecimalFormat("#.##");
	//follows (x*.9)^2
	private double[] turnLookUp = new double[]{	 0
												,0.000081
												,0.000324
												,0.000729
												,0.001296
												,0.002025
												,0.002916
												,0.003969
												,0.005184
												,0.006561
												,0.0081
												,0.009801
												,0.011664
												,0.013689
												,0.015876
												,0.018225
												,0.020736
												,0.023409
												,0.026244
												,0.029241
												,0.0324
												,0.035721
												,0.039204
												,0.042849
												,0.046656
												,0.050625
												,0.054756
												,0.059049
												,0.063504
												,0.068121
												,0.0729
												,0.077841
												,0.082944
												,0.088209
												,0.093636
												,0.099225
												,0.104976
												,0.110889
												,0.116964
												,0.123201
												,0.1296
												,0.136161
												,0.142884
												,0.149769
												,0.156816
												,0.164025
												,0.171396
												,0.178929
												,0.186624
												,0.194481
												,0.2025
												,0.210681
												,0.219024
												,0.227529
												,0.236196
												,0.245025
												,0.254016
												,0.263169
												,0.272484
												,0.281961
												,0.2916
												,0.301401
												,0.311364
												,0.321489
												,0.331776
												,0.342225
												,0.352836
												,0.363609
												,0.374544
												,0.385641
												,0.3969
												,0.408321
												,0.419904
												,0.431649
												,0.443556
												,0.455625
												,0.467856
												,0.480249
												,0.492804
												,0.505521
												,0.5184
												,0.531441
												,0.544644
												,0.558009
												,0.571536
												,0.585225
												,0.599076
												,0.613089
												,0.627264
												,0.641601
												,0.6561
												,0.670761
												,0.685584
												,0.700569
												,0.715716
												,0.731025
												,0.746496
												,0.762129
												,0.777924
												,0.793881
												,0.81};
	
	
	public DriveBaseSubsystem() {
		
		driveLeftLead = new WPI_TalonSRX(RobotMap.driveLeftLead);
		driveLeftFollow = new WPI_TalonSRX(RobotMap.driveLeftFollow);
		driveRightLead = new WPI_TalonSRX(RobotMap.driveRightLead);
		driveRightFollow = new WPI_TalonSRX(RobotMap.driveRightFollow);
		
		driveRightLead.setInverted(true);
		driveRightFollow.setInverted(true);
		
		limitSwitch = new DigitalInput(0);
		
		try { 
			 gyro = new AHRS(SPI.Port.kMXP); // setting the navx to the mxp port 
	     } 
		 catch (RuntimeException ex )  // catching if an error was called.
		 {
			 DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true); // sending a message to the driver station telling that the navx is not working.
	     }
		
		gyro.zeroYaw();
		
		pidController = new PIDController(kP, kI, kD, gyro, this);
		pidController.disable();
		pidController.setInputRange(-180.0f, 180.0f);
		pidController.setOutputRange(-1.0, 1.0);
		pidController.setAbsoluteTolerance(kToleranceDegrees);
		pidController.setContinuous(true);
		
				
	}
    
    public void tankDrive(double left, double right) {
    	left = left*Math.abs(left);
    	right = right*Math.abs(right);
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
       
    public void arcadeDriveLookUp(double yAxis, double xAxisCurve) {	 
		double x = Math.abs(xAxisCurve);
		//square the values for better control at low speeds
		yAxis = yAxis*Math.abs(yAxis);
		double xAxis = turnLookUp[(int)(Double.valueOf(df.format(x))*100)];
		if(xAxisCurve > 0){
			xAxis = -xAxis;
		}
		if((yAxis < deadBand) && (yAxis > -deadBand)){ yAxis=0;}
    	if((xAxis < deadBand) && (xAxis > -deadBand)){ xAxis=0;}
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
    	driveLeftFollow.set(leftPower);
    	driveRightLead.set( rightPower);
    	driveRightFollow.set(rightPower);
    	SmartDashboard.putNumber("Left Drive Power",leftPower);
    	SmartDashboard.putNumber("Right Drive Power", -rightPower);
    }
    
    public void pidEnable() {
    	pidController.enable();
    }
    
    public void pidDisable() {
    	pidController.disable();
    }
    
    public void pidSetPoint(double input){
		pidController.setSetpoint(input);
    }
    
    public void pidWrite(double output) {
    	if(pidController.getDeltaSetpoint() < 0) {
    		PIDOutput = output;
    	}
    	else {
    		PIDOutput = -output;
    	}
    }
    
    public boolean pidDone() {
    	if(Math.abs(Math.abs(pidController.getSetpoint()) - Math.abs(gyro.getYaw())) < 7){
    		int Timer = 0;
			if(Timer > 5) {
    			Timer = 0;
    			return true;
    		}
    		else {
    			Timer++;
    			return false;
    		}
    	}
    	else {
    		return false;
    	}
    }
    
    
    public void lookup() {
    	MatchData.OwnedSide side = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH_NEAR);
        if (side == MatchData.OwnedSide.LEFT) {
        	SmartDashboard.putBoolean("SwitchNearLEFT", side == MatchData.OwnedSide.LEFT);
        } else if (side == MatchData.OwnedSide.RIGHT) {
        	SmartDashboard.putBoolean("SwitchNearRIGHT", side == MatchData.OwnedSide.RIGHT);
        } else {
            // Unknown
        }
    }
    
    public boolean resetYaw(){	
		gyro.zeroYaw();
		int yawTimer = 0;
		if(yawTimer > 10){
			yawTimer = 0;
			return true;
		}
		else{
			yawTimer ++;
			return false;
		}	
	}
    
    public double getYaw(){
		return gyro.getYaw();
    }
    
    public void gyroZero() {
    	gyro.zeroYaw();
    }
    
    public void limit() {
    	boolean isClosed = limitSwitch.get();
    	SmartDashboard.putBoolean("limit", isClosed);
    }
      
    public void initDefaultCommand() {
        setDefaultCommand(new T_ArcadeDrive());
    }
    
    public void log() {
    	SmartDashboard.putBoolean(  "IMU_Connected",        gyro.isConnected());
    	SmartDashboard.putNumber(   "IMU_Yaw",              gyro.getYaw());
        SmartDashboard.putNumber(   "IMU_Pitch",            gyro.getPitch());
        SmartDashboard.putNumber(   "IMU_Roll",             gyro.getRoll());
    }
}