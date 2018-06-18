package org.usfirst.frc2974.Pneumatotron.commands.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2974.Pneumatotron.Robot;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Alex
 */
public class LowerPastLimitSwitch extends Command {

	boolean done = false;
	private int count = 0;

	public LowerPastLimitSwitch() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.intake);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		done = false;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.intake.lift(-Robot.oi.INTAKE_LIFT_MAGNITUDE);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (!Robot.intake.isHighHit()) {
			count++;
		} else {
			count = 0;
		}
		if (count > 10) {
			done = true;
		}
		return done;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.intake.lift(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
