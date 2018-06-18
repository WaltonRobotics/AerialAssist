/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2974.Pneumatotron.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc2974.Pneumatotron.commands.Autonomous.ReverseAndPickup;

/**
 * @author Alex
 */
public class Auton_DualBall extends CommandGroup {

	public Auton_DualBall() {
		/*
		 * BLOCK A - Lowers intake, drives, and fires.
		 */
		addSequential(new Auton_SingleBall(0, false));
		/*
		 * BLOCK B - Drives back to start point + 2ft with intake down and roller on.
		 */
		addSequential(new ReverseAndPickup(36));
		/*
		 * BLOCK C - Raises arm to help ball into catapult, charges, and drives forward + 2 feet.
		 */
		addSequential(new Auton_DualPart2(36));
	}
}
// Add Commands here:
// e.g. addSequential(new Command1());
//      addSequential(new Command2());
// these will run in order.
// To run multiple commands at the same time,
// use addParallel()
// e.g. addParallel(new Command1());
//      addSequential(new Command2());
// Command1 and Command2 will run in parallel.
// A command group will require all of the subsystems that each member
// would require.
// e.g. if Command1 requires chassis, and Command2 requires arm,
// a CommandGroup containing them would require both the chassis and the
// arm.
//
//
//        addParallel(new PressurizeCylinders());
//        //addParallel(new RaiseArmSlightly());
//        addSequential(new DriveToDist(12));
//        /*
//         * BLOCK D - Returns intake to lowest position.
//         */
//        //addSequential(new LowerIntakeAndSlowRoll(), (Robot.dash.getAutonArmRaiseDelay() + .5));
//        /*
//         * BLOCK E - Fires Shot.
//         */
//        addSequential(new Launch());
