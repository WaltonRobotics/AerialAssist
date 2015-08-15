/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2974.Pneumatotron.commands.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2974.Pneumatotron.Robot;

/**
 *
 * @author Alex
 */
public class RaiseArmSlightly extends Command {

    public RaiseArmSlightly() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.intake);
        //setTimeout(Robot.dash.getAutonArmRaiseDelay());
        //**********************************************************************
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if (Robot.intake.isLowHit()) {
            Robot.intake.lift(.5);
        }
        Robot.intake.rollIntakeInward();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (Robot.intake.isLowHit()) {
            Robot.intake.lift(.5);
        }
        Robot.intake.rollIntakeInward();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.intake.lift(0);
        Robot.intake.disableRoller();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
