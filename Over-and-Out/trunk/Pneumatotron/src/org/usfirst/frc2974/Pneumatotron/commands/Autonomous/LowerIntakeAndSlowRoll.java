/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2974.Pneumatotron.commands.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2974.Pneumatotron.Robot;

/**
 *
 * @author Walton Robotics
 */
public class LowerIntakeAndSlowRoll extends Command {

    public LowerIntakeAndSlowRoll() {
        /*
         * Requires intake subsystem(takes soul control of it) to run this command
         */
        requires(Robot.intake);
    }

    protected void initialize() {
    }

    protected void execute() {
        if (!Robot.intake.isLowHit()) { //If intake has not hit bottom sensor...
            Robot.intake.lift(-Robot.oi.INTAKE_LIFT_AUTO); //...keep going down at half power...
            Robot.intake.rollIntakeSpecial(.5); //...and keep rolling intake at half speed
        }
//        if (Robot.intake.isHighHit() || Robot.intake.isLowHit()) {
//            Robot.intake.lift(0);
//        }
    }

    protected boolean isFinished() {
        /*
         * This command finishes when either the bottom limit switch is hit(the intake
         * has completed it's goal of going to its lowest point)or the autonomous 
         * period has ended. This autonomous check makes it a smooth transition into
         * teleop even if autonomous is interrupted in the middle of the command.
         */
        return Robot.intake.isLowHit() || !Robot.oi.ds.isAutonomous();
    }

    /*
     * Is called after isFinished returns true.
     */
    protected void end() {
        Robot.intake.lift(0); //Intake is set to zero to stop it from going any further
        Robot.intake.disableRoller(); //The roller is set to zero to stop rolling
    }

    protected void interrupted() {
    }
}
