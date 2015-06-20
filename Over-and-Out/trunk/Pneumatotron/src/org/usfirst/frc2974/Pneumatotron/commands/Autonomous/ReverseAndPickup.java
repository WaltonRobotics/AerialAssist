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
public class ReverseAndPickup extends Command {

    double reverseDriveSpeed = -.6;//Robot.oi.auton_Speed;
    double offset = 0;

    public ReverseAndPickup(double offsetInput) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.driveTrain);
        requires(Robot.intake);

        offset = offsetInput;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.intake.rollIntakeInward();

        Robot.driveTrain.shiftToHigh(false); //sets to low gear
        Robot.driveTrain.enableEncoders();
        Robot.driveTrain.resetPrevious();
        Robot.driveTrain.driveManual(reverseDriveSpeed, reverseDriveSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.driveTrain.driveManual(reverseDriveSpeed, reverseDriveSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        boolean finish = (Math.abs(Robot.driveTrain.getDistanceRight())) > (Robot.dash.getAutonInches() + offset) || !Robot.oi.ds.isAutonomous();
        return finish;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("Finish Reverse/Pickup Drive");
        Robot.driveTrain.stopEncoders();
        //Robot.intake.disableRoller();
        Robot.driveTrain.deadStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
