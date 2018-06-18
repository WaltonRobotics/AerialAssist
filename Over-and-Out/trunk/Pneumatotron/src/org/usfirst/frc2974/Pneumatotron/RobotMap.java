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

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc2974.Pneumatotron.subsystems.FixedOutput;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into to a variable name. This provides
 * flexibility changing wiring, makes checking the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	final static int cyclesPerRev = 128;       //cycles per revolution for the encoders - 63R128
	public static Solenoid shooterRelease;
	public static Solenoid shooterShaftA;
	public static Solenoid shooterShaftB;
	public static Compressor compressor;
	public static Talon drivetrainRight_1;
	public static Talon drivetrainRight_2;
	public static Talon drivetrainLeft_1;
	public static Talon drivetrainLeft_2;
	public static Encoder encoderRight;
	public static PIDController controllerRight;
	public static Encoder encoderLeft;
	public static PIDController controllerLeft;
	public static FixedOutput fixedPIDLeft;
	public static FixedOutput fixedPIDRight;
	public static Talon intakeRoller;
	public static Talon intakeLift;
	public static DigitalInput highSwitch;
	public static DigitalInput lowSwitch;
	public static DigitalInput magneticLatchDetector;
	public static Solenoid shifterSolenoid;
	public static AnalogChannel pressure;

	public static void init() {
		//BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		shooterRelease = new Solenoid(1, 3);//latch
		LiveWindow.addActuator("Shooter", "Release", shooterRelease);

		shooterShaftA = new Solenoid(1, 1);
		LiveWindow.addActuator("Shooter", "ShaftA", shooterShaftA);

		shooterShaftB = new Solenoid(1, 2);
		LiveWindow.addActuator("Shooter", "ShaftB", shooterShaftB);

		shifterSolenoid = new Solenoid(1, 8);

		compressor = new Compressor(14, 1);

		drivetrainRight_1 = new Talon(1, 1);
		drivetrainRight_2 = new Talon(1, 2);
//	LiveWindow.addActuator("Drivetrain", "Right", drivetrainRight);
//        
		drivetrainLeft_1 = new Talon(1, 3);
		drivetrainLeft_2 = new Talon(1, 4);
//	LiveWindow.addActuator("Drivetrain", "Left", drivetrainLeft);

		intakeLift = new Talon(1, 5);
		intakeRoller = new Talon(1, 6);

		pressure = new AnalogChannel(1);

		highSwitch = new DigitalInput(12);
		lowSwitch = new DigitalInput(11);
		magneticLatchDetector = new DigitalInput(13);

		fixedPIDRight = new FixedOutput(drivetrainRight_1, drivetrainRight_2);
		fixedPIDLeft = new FixedOutput(drivetrainLeft_1, drivetrainLeft_2);

		encoderRight = new Encoder(1, 2);
		encoderLeft = new Encoder(3, 4);
		double circ = Math.PI * 4;
		double dist = (circ / cyclesPerRev) / 3;
		encoderRight.setDistancePerPulse(dist);//four inch wheels
		encoderLeft.setDistancePerPulse(dist);//four inch wheels //Math.PI / (cyclesPerRev / 4.0)
		encoderLeft.setReverseDirection(true);
		encoderRight.setPIDSourceParameter(Encoder.PIDSourceParameter.kRate);
		encoderLeft.setPIDSourceParameter(Encoder.PIDSourceParameter.kRate);

		controllerRight = new PIDController(0.001, 0, 0, encoderRight, fixedPIDRight);
		controllerLeft = new PIDController(0.001, 0, 0, encoderLeft, fixedPIDLeft);
		controllerRight.setOutputRange(-1, 1);
		controllerLeft.setOutputRange(-1, 1);
		controllerRight.setInputRange(-700, 700);
		controllerLeft.setInputRange(-700, 700);

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
	}
}
