// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc2974.Simple.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2974.Simple.RobotMap;
import org.usfirst.frc2974.Simple.commands.Drive;

/**
 *
 */
public class Drivetrain extends Subsystem {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	Talon left = RobotMap.drivetrainLeft;
	Talon right = RobotMap.drivetrainRight;
	Talon left_2 = RobotMap.drivetrainLeft_2;
	Talon right_2 = RobotMap.drivetrainRight_2;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
		setDefaultCommand(new Drive());
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}

	public void drive(double r, double l) {
		right.set(r);
		right_2.set(r);
		left.set(l);
		left_2.set(l);
	}
}
