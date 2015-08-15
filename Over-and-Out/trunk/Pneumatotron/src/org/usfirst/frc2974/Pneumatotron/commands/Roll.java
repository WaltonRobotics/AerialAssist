/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2974.Pneumatotron.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2974.Pneumatotron.Robot;

/**
 *
 * @author Admin
 */
public class Roll extends Command {

    double rollSpeed = 0;

    public Roll(double speed) {
        requires(Robot.intake);
        rollSpeed = speed;
    }

    protected void initialize() {
    }

    /**
     * Two basic threads: lifting thread and roller thread if the top button is
     * pressed, the intake raises, and if the bottom button is pressed, the
     * intake lowers
     *
     * The roller is toggled on a rising edge. If the trigger is pressed, it is
     * enabled. It cannot be disabled now until the trigger is released. Once
     * on, if the trigger is pressed, it will disable. It cannot be enabled now
     * until the trigger is released.
     */
    protected void execute() {
        if (Robot.oi.raiseIntake()) {
            Robot.intake.lift(Robot.oi.INTAKE_LIFT_MAGNITUDE);
        } else if (Robot.oi.lowerIntake()) {
            Robot.intake.lift(-Robot.oi.INTAKE_LIFT_MAGNITUDE);
        } else {
            Robot.intake.lift(0);
        }

        if (Robot.oi.bRollInward.get()) {
            Robot.intake.rollIntakeInward();
        } else if (Robot.oi.bRollOutward.get()) {
            Robot.intake.rollIntakeOutward();
        } else if (Robot.oi.bStopRoll.get()) {
            Robot.intake.disableRoller();
        } else {
        }
    }

    protected boolean isFinished() {
        return Robot.oi.ds.isAutonomous();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
//        } else {
//            if (Robot.oi.bLift.get()) {// ||) {(Robot.oi.raiseIntake()
//                Robot.intake.lift(.5);
//            } else if (Robot.oi.bLower.get()) {// || ) {Robot.oi.lowerIntake()
//                Robot.intake.lift(-.5);
//            } else {
//                Robot.intake.lift(0);
//            }
//        }
//
//            if (!prevRollButton) {
//                if (prevRoller) {
//                    Robot.intake.disableRoller();       //if it was enabled, disable it
//                } else {
//                    Robot.intake.rollIntakeInward();        //if it was disabled, enable it
//                }
//                prevRoller = !prevRoller;               //the toggle value is toggled
//            }
//            prevRollButton = true;                      //records state for edge detection
//
//detects rising edge : if the button is on in the current frame but off in the previous frame
//
//            prevRollButton = false;
//
//double lift;
//    boolean prevRollButton = false;
//    boolean prevRoller = false;