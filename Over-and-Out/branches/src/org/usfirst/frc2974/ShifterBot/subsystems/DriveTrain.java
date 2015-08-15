// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc2974.ShifterBot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2974.ShifterBot.RobotMap;
import org.usfirst.frc2974.ShifterBot.commands.*;

/**
 *
 */
public class DriveTrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    Talon rightTop = RobotMap.driveTrainRightTop;
    Talon rightLow = RobotMap.driveTrainRightLow;
    Talon leftTop = RobotMap.driveTrainLeftTop;
    Talon leftLow = RobotMap.driveTrainLeftLow;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private double prevRight = 0, prevLeft = 0;
    private final double ACCEL_CONST = .2;

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new Drive());
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void drive(double left, double right) {
        if (Math.abs(prevRight - right) > ACCEL_CONST) {
            if (prevRight > right) {
                right = prevRight - ACCEL_CONST;//limit the speed on deceleration
            } else {
                right = prevRight + ACCEL_CONST;//limit the speed on acceleration
            }
        }
        if (Math.abs(prevLeft - left) > ACCEL_CONST) {
            if (prevLeft > left) {
                left = prevLeft - ACCEL_CONST;//limit the speed on deceleration
            } else {
                left = prevLeft + ACCEL_CONST;//limit the speed on acceleration
            }
        }
        rightTop.set(right); //wheels face opposite directions
        rightLow.set(right);
        leftTop.set(-left);
        leftLow.set(-left);
        prevLeft = left;
        prevRight = right;
    }
}
