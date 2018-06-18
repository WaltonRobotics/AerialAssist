/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2974.Pneumatotron.commands.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2974.Pneumatotron.Robot;

/**
 * @author Chris
 */
public class DelayMaker extends Command {

	/**
	 * @param secs the amount of time in seconds to delay
	 */
	public DelayMaker() {//double secs
		setTimeout(Robot.dash.getAutonDelaySecs());
	}

	protected void initialize() {
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
