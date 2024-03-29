// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc2974.Pneumatotron;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands and command groups
 * that allow control of the robot.
 */
public class OI {
	//drivetrain

	public final int INTAKE_LIFT_MAGNITUDE = -1;
	public final double INTAKE_LIFT_AUTO = -.8;
	public Joystick jLeft;
	public Joystick jRight;
	//shooter
	public Button bFire;
	public Button bCharge;
	public Button bDischarge;
	public Button bUnlatch;
	public Button bQuickTruss;
	//intake
	public Button bLift;
	public Button bLower;
	public Button bShiftUp;
	public Button bShiftDown;
	public Button bRollInward;
	public Button bRollOutward;
	public Button bStopRoll;
	public DriverStation ds = DriverStation.getInstance();
	public DriverStationLCD dsLCD = DriverStationLCD.getInstance();
	public double auton_Speed = .5;
	public int auton_DistanceInches = 10 * 12; //10 feet multiplied by 12 to get inches
	private Joystick xBoxCont;
	//    public double[][] autonArray = {
//        {0.0, 0.0}, //Forward Auton Distance, Forward Auton Feet
//        {0.0, 0.0}}; //Backward Auton Distance, Backward Auton Feet

	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	// Another type of button you can create is a DigitalIOButton, which is
	// a button or switch hooked up to the cypress module. These are useful if
	// you want to build a customized operator interface.
	// Button button = new DigitalIOButton(1);
	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.
	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:
	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());
	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());
	// Start the command when the button is released  and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public OI() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

		// SmartDashboard Buttons
		//SmartDashboard.putData("Fire", new Fire());
		//SmartDashboard.putData("Drive", new DriveWithJoysticks());
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

		jLeft = new Joystick(1);
		jRight = new Joystick(2);
		xBoxCont = new Joystick(3);

		bCharge = new JoystickButton(xBoxCont, 4);
		bRollInward = new JoystickButton(xBoxCont, 3); //1
		bRollOutward = new JoystickButton(xBoxCont, 2); //3
		bStopRoll = new JoystickButton(xBoxCont, 1); //2
		bUnlatch = new JoystickButton(xBoxCont, 5);
		bQuickTruss = new JoystickButton(xBoxCont, 6);

		bFire = new JoystickButton(jRight, 1);
		bDischarge = new JoystickButton(jRight, 4);

		bLift = new JoystickButton(jLeft, 3);
		bLower = new JoystickButton(jLeft, 2);

		bShiftUp = new JoystickButton(jRight, 3);
		bShiftDown = new JoystickButton(jRight, 2);
	}
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

	public boolean raiseIntake() {
		return (xBoxCont.getRawAxis(2) < -.5);
	}

	public boolean lowerIntake() {
		return (xBoxCont.getRawAxis(2) > .5);
	}
}
