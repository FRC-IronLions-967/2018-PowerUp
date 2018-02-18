package org.usfirst.frc.team967.robot;

import org.usfirst.frc.team967.lib.util.AxisButton;
import org.usfirst.frc.team967.lib.util.POVButton;
import org.usfirst.frc.team967.robot.commands.GyroPIDTurnToAngle;
import org.usfirst.frc.team967.robot.commands.IntakeArms;
import org.usfirst.frc.team967.robot.commands.IntakePower;
import org.usfirst.frc.team967.robot.commands.IntakeWrist;
import org.usfirst.frc.team967.robot.commands.LiftMove;
import org.usfirst.frc.team967.robot.commands.ResetYaw;
import org.usfirst.frc.team967.robot.commands.ShiftLift;
import org.usfirst.frc.team967.robot.commands.T_ArcadeDrive;
import org.usfirst.frc.team967.robot.commands.ZeroEncodersDriveBase;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	private Joystick xbox0 = new Joystick(0);
	private Joystick xbox1 = new Joystick(1);
	
	public AxisButton xbox0_lT = new AxisButton(xbox0, 2, .75, 1);
    public AxisButton xbox0_rT = new AxisButton(xbox0, 3, .75, 1);
    
    public POVButton xbox0povC 	= new POVButton(xbox0, 0, -1);
    public POVButton xbox0povN 	= new POVButton(xbox0, 0, 0);
    public POVButton xbox0povNE = new POVButton(xbox0, 0, 45);
    public POVButton xbox0povE 	= new POVButton(xbox0, 0, 90);
    public POVButton xbox0povSE = new POVButton(xbox0, 0, 135);
    public POVButton xbox0povS 	= new POVButton(xbox0, 0, 180);
    public POVButton xbox0povSW = new POVButton(xbox0, 0, 225);
    public POVButton xbox0povW 	= new POVButton(xbox0, 0, 270);
    public POVButton xbox0povNW = new POVButton(xbox0, 0, 315);
    
    public AxisButton xbox1_lT = new AxisButton(xbox1, 2, .75, 1);
    public AxisButton xbox1_rT = new AxisButton(xbox1, 3, .75, 1);
    
    public POVButton xbox1povC 	= new POVButton(xbox1, 0, -1);
    public POVButton xbox1povN 	= new POVButton(xbox1, 0, 0);
    public POVButton xbox1povNE = new POVButton(xbox1, 0, 45);
    public POVButton xbox1povE 	= new POVButton(xbox1, 0, 90);
    public POVButton xbox1povSE = new POVButton(xbox1, 0, 135);
    public POVButton xbox1povS 	= new POVButton(xbox1, 0, 180);
    public POVButton xbox1povSW = new POVButton(xbox1, 0, 225);
    public POVButton xbox1povW 	= new POVButton(xbox1, 0, 270);
    public POVButton xbox1povNW = new POVButton(xbox1, 0, 315);
	
	public OI() {
		// Setting up the variables to the buttons on controller 0
    	JoystickButton xbox0_a = new JoystickButton(xbox0, 1);
    	JoystickButton xbox0_b = new JoystickButton(xbox0, 2);
    	JoystickButton xbox0_x = new JoystickButton(xbox0, 3);
    	JoystickButton xbox0_y = new JoystickButton(xbox0, 4);
    	JoystickButton xbox0_lb = new JoystickButton(xbox0, 5);
    	JoystickButton xbox0_rb = new JoystickButton(xbox0, 6);
    	JoystickButton xbox0_back = new JoystickButton(xbox0, 7);
    	JoystickButton xbox0_start = new JoystickButton(xbox0, 8);
    	JoystickButton xbox0_leftStickButton = new JoystickButton(xbox0, 9);
    	JoystickButton xbox0_rightStickButton = new JoystickButton(xbox0, 10);
		
		// Setting up the variables to the buttons on controller 1
    	JoystickButton xbox1_a = new JoystickButton(xbox1, 1);
    	JoystickButton xbox1_b = new JoystickButton(xbox1, 2);
    	JoystickButton xbox1_x = new JoystickButton(xbox1, 3);
    	JoystickButton xbox1_y = new JoystickButton(xbox1, 4);
    	JoystickButton xbox1_lb = new JoystickButton(xbox1, 5);
    	JoystickButton xbox1_rb = new JoystickButton(xbox1, 6);
    	JoystickButton xbox1_back = new JoystickButton(xbox1, 7);
    	JoystickButton xbox1_start = new JoystickButton(xbox1, 8);
    	JoystickButton xbox1_leftStickButton = new JoystickButton(xbox1, 9);
    	JoystickButton xbox1_rightStickButton = new JoystickButton(xbox1, 10);
		
    	//Setting the button variables to the commands for controller number 0
    	xbox0povN.whenPressed(new GyroPIDTurnToAngle(0));
    	xbox0povNE.whenPressed(new GyroPIDTurnToAngle(45));
    	xbox0povE.whenPressed(new GyroPIDTurnToAngle(90));
    	xbox0povSE.whenPressed(new GyroPIDTurnToAngle(135));
    	xbox0povS.whenPressed(new GyroPIDTurnToAngle(180));
    	xbox0povSW.whenPressed(new GyroPIDTurnToAngle(225));
    	xbox0povW.whenPressed(new GyroPIDTurnToAngle(270));
    	xbox0povNW.whenPressed(new GyroPIDTurnToAngle(315));
//     	xbox0_lT.whenPressed();
//     	xbox0_lT.whenReleased();
//     	xbox0_rT.whenPressed();
//     	xbox0_rT.whenReleased();
    	xbox0_a.whenPressed(new T_ArcadeDrive());
//    	xbox0_a.whenReleased();
    	xbox0_b.whenPressed(new ResetYaw());
//    	xbox0_b.whenPressed();
//    	xbox0_b.whenReleased();
//    	xbox0_x.whenPressed(new IntakeArms("open"));
////    	xbox0_x.whenReleased();
    	xbox0_y.whenPressed(new ZeroEncodersDriveBase());
//    	xbox0_y.whenReleased();
//     	xbox0_lb.whenPressed(new ShiftLift("high"));
//    	xbox0_rb.whenPressed(new ShiftLift("low"));
//    	xbox0_rb.whenReleased();
//    	xbox0_back.whenPressed();
//    	xbox0_back.whenReleased();
//    	xbox0_start.whenPressed();
//    	xbox0_start.whenReleased();
//    	xbox0_leftStickButton.whenPressed();
//    	xbox0_rightStickButton.whenPressed();
    	
    	//Setting the button variables to the commands for controller number 1
//    	xbox1povN.whenPressed();
//    	xbox1povE.whenPressed();
//    	xbox1povS.whenPressed();
//    	xbox1povW.whenPressed();
//     	xbox1_lT.whenPressed();
//     	xbox1_lT.whenReleased();
//     	xbox1_rT.whenPressed();
//     	xbox1_rT.whenReleased();
//    	xbox1_a.whenPressed(new IntakeWrist());
//    	xbox1_a.whenReleased();
//    	xbox1_b.whenPressed(new IntakePower());
//    	xbox1_b.whenReleased();
    	xbox1_x.whenPressed(new IntakeArms("open"));
//    	xbox0_x.whenReleased();
    	xbox1_y.whenPressed(new IntakeArms("closed"));
//    	xbox1_y.whenReleased();
     	xbox1_lb.whenPressed(new ShiftLift("high"));
    	xbox1_rb.whenPressed(new ShiftLift("low"));
//    	xbox1_rb.whenReleased();
    	xbox1_back.whenPressed(new LiftMove());
//    	xbox1_back.whenReleased();
//    	xbox1_start.whenPressed();
//    	xbox1_start.whenReleased();
    	xbox1_leftStickButton.whenPressed(new LiftMove());
    	xbox1_rightStickButton.whenPressed(new IntakePower()); 	
	}
	
	public void log(){
    	
    }
	
	public Joystick getXbox0() {
    	return xbox0;
    }
    
    public Joystick getXbox1() {
    	return xbox1;
    }
	
}
