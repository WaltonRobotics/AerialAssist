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
public class DriveToDist extends Command {

    int offset = 0;
    double speedToDrive = Robot.oi.auton_Speed;

    public DriveToDist(int offsetInput, boolean isBackwards) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.driveTrain);
        offset = Math.abs(offsetInput);
        if (isBackwards) {
            speedToDrive *= -1;
        }
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.driveTrain.shiftToHigh(false); //sets to low gear
        Robot.driveTrain.autoReset();
        Robot.driveTrain.driveManual(speedToDrive, speedToDrive);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.driveTrain.driveManual(speedToDrive, speedToDrive);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        boolean finish = Math.abs(Robot.driveTrain.getDistanceRight()) > (Robot.dash.getAutonInches() + offset) || !Robot.oi.ds.isAutonomous();
        return finish;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("Finish Autonomous Drive");
        Robot.driveTrain.stopEncoders();
        Robot.driveTrain.deadStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}