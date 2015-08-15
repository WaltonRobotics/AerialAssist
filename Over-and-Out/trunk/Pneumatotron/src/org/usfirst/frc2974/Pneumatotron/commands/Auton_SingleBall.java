/*/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2974.Pneumatotron.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc2974.Pneumatotron.commands.Autonomous.DelayMaker;
import org.usfirst.frc2974.Pneumatotron.commands.Autonomous.DriveToDist;
import org.usfirst.frc2974.Pneumatotron.commands.Autonomous.LowerIntakeAndSlowRoll;
import org.usfirst.frc2974.Pneumatotron.commands.Autonomous.PressurizeCylinders;
import org.usfirst.frc2974.Pneumatotron.commands.Autonomous.QuickLaunch;
import org.usfirst.frc2974.Pneumatotron.commands.Autonomous.SetLatch;

/**
 *
 * @author Walton Robotics
 */
public class Auton_SingleBall extends CommandGroup {

    public Auton_SingleBall(int driveOffsetInches, boolean hotGoal) {
        /*
         * BLOCK A - Lowers intake while charging catapult and driving forward.
         */
        //addParallel(new AutoIntakeSequence());
        addParallel(new LowerIntakeAndSlowRoll());
        addSequential(new DriveToDist(driveOffsetInches, false));
        /*
         * BLOCK B - Waits for the robot to stop.
         */
        addParallel(new PressurizeCylinders());
        addSequential(new DelayMaker());

        /*
         * BLOCK C - Fires catapult
         */
        addSequential(new QuickLaunch(hotGoal));
        addSequential(new SetLatch());
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
// /*
//         * BLOCK A - Lowers intake while charging catapult and driving forward.
//         */
//        addParallel(new LowerIntakeAndSlowRoll());
//        addParallel(new PressurizeCylinders());
//        addSequential(new DriveToDist(driveOffsetInches));
//        /*
//         * BLOCK B - Waits for the robot to stop.
//         */
//        addSequential(new DelayMaker(1));
//        /*
//         * BLOCK C - Fires catapult
//         */
//        addSequential(new Launch());
