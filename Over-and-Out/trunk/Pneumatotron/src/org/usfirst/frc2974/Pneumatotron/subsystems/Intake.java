/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2974.Pneumatotron.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2974.Pneumatotron.RobotMap;
import org.usfirst.frc2974.Pneumatotron.commands.Roll;

/**
 * @author Admin
 */
public class Intake extends Subsystem {

	Talon roller = RobotMap.intakeRoller;
	Talon lift = RobotMap.intakeLift;
	DigitalInput low = RobotMap.lowSwitch;
	DigitalInput high = RobotMap.highSwitch;

	public void initDefaultCommand() {
		setDefaultCommand(new Roll(0));
	}

	/**
	 * Sets the winch to the inputted power (-1,1). <p>Any overflow of 'l' will simply snap to -1 or 1 respectively
	 *
	 * @param lCoefficient - lift coefficient
	 */
	public void lift(double lCoefficient) {
		if (isHighHit()) {//isLowHit()) {//
			setLift(Math.max(0, lCoefficient));
		} else if (isLowHit()) {//isHighHit()) {//
			setLift(Math.min(0, lCoefficient));
		} else {
			setLift(lCoefficient);
		}
	}

	private void setLift(double speed) {
		lift.set(-speed);
	}

	public boolean isHighHit() {
		return !high.get();
	}

	public boolean isLowHit() {
		return !low.get();
	}

	/**
	 * Sets the Roller motor to full power.
	 */
	public void rollIntakeInward() {
		setRoller(1);
	}

	public void rollIntakeOutward() {
		setRoller(-1);
	}

	public void rollIntakeSpecial(double speed) {
		setRoller(speed);
	}

	private void setRoller(double speed) {
		roller.set(speed);
	}

	/**
	 * Sets the Roller motor to zero power.
	 */
	public void disableRoller() {
		setRoller(0);
	}
}