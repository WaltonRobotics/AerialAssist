/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2974.Pneumatotron.commands.Autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc2974.Pneumatotron.Robot;
import org.usfirst.frc2974.Pneumatotron.commands.Autonomous.DriveToDist;
import org.usfirst.frc2974.Pneumatotron.commands.Autonomous.LowerIntake;
import org.usfirst.frc2974.Pneumatotron.commands.Autonomous.RaiseIntakeToTop;
import org.usfirst.frc2974.Pneumatotron.commands.Autonomous.RollIntakeOut;

/**
 *
 * @author Alex
 */
public class Auton_LowGoal extends CommandGroup {

    public Auton_LowGoal() {
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
//        addParallel(new DriveToDist(0, true));
//        addParallel(new LowerIntake(Robot.dash.getAutonDelaySecs()));
//        addSequential(new RaiseIntakeToTop());
//
//        addSequential(new RollIntakeOut());
    }
}
