/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2974.Pneumatotron.subsystems;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Talon;

/**
 * @author Walton Robotics
 */
public class FixedOutput implements PIDOutput {

	Talon front;
	Talon back;

	public FixedOutput(Talon f, Talon b) {
		front = f;
		back = b;
	}

	public void pidWrite(double output) {
		front.pidWrite(output);
		back.pidWrite(output);
	}
}
