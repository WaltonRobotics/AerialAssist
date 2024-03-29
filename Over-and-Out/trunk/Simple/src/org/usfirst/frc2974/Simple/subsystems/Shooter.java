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

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2974.Simple.RobotMap;
import org.usfirst.frc2974.Simple.commands.Shoot;

/**
 *
 */
public class Shooter extends Subsystem {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	Solenoid latch = RobotMap.shooterLatch;
	Solenoid shaft_1 = RobotMap.shooterShaft_1;
	Solenoid shaft_2 = RobotMap.shooterShaft_2;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
		setDefaultCommand(new Shoot());
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}

	public void shaft() {
		shaft_1.set(true);
		shaft_2.set(true);
	}

	public void latch(boolean b) {
		latch.set(b);
	}

	public void discharge() {
		latch.set(false);
		shaft_1.set(false);
		shaft_2.set(false);
	}
}
