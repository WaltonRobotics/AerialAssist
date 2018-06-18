/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2974.Pneumatotron;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Alex
 */
public class Dashboard {

	//    private double p = .001, i = 0, d = 0, ff = 0;
	/*
	 * DONE Non latching button,
	 * DONE magnetic intake latch,
	 * DONE shoot on command,
	 * DONE pressure checks
	 * DONE pressure deadband
	 * DONE autonomous - check pressure
	 * DONE autonomous - latch, release, pressurize
	 * DONE finish autonomous adjustability
	 *
	 * check if dropping and latching when cylinder switch is hit results in immediate catch
	 * shooter doesn't shoot intake,
	 * gentler turning,
	 */
	public Dashboard() {
		SmartDashboard.putNumber("AutoForwardFeet", 6);
		SmartDashboard.putNumber("AutoForwardSpeed", 1);
		SmartDashboard.putNumber("AutonDelaySecs", 1);
		SmartDashboard.putBoolean("Running HotGoal", true);
//        SmartDashboard.putBoolean("Is_PID_Drive", false);
		//SmartDashboard.putNumber("MiniShotDelayMillis", 250);
	}

	public void update() {
		SmartDashboard.putBoolean("SwitchHigh", Robot.intake.isHighHit());
		SmartDashboard.putBoolean("SwitchLow", Robot.intake.isLowHit());
		double pressure = Robot.shooter.getPressure();
		SmartDashboard.putNumber("Pressure in PSI", pressure);
		SmartDashboard.putBoolean("GoodToShoot", Robot.shooter.goodToShoot());
		SmartDashboard.putBoolean("IsHighGear", Robot.driveTrain.isHighGear());
		SmartDashboard.putBoolean("Compressor On", !RobotMap.compressor.getPressureSwitchValue());
		SmartDashboard.putBoolean("CylinderA", RobotMap.shooterShaftA.get());
		SmartDashboard.putBoolean("CylinderB", RobotMap.shooterShaftB.get());
		SmartDashboard.putBoolean("Latch", !RobotMap.shooterRelease.get());
		SmartDashboard.putNumber("IntakeRoller", RobotMap.intakeRoller.get());
		SmartDashboard.putNumber("EncoderRight", RobotMap.encoderRight.get());
		SmartDashboard.putNumber("Encoder Left", RobotMap.encoderLeft.get());
		SmartDashboard.putBoolean("Magnetic Latch", RobotMap.magneticLatchDetector.get());
		SmartDashboard.putBoolean("Running HotGoal", getHotGoalEnabled());
		//SmartDashboard.

		/*
		 * Autonomous stuff
		 */
		SmartDashboard.putNumber("AutoForwardFeet", (getAutonInches() / 12));
		SmartDashboard.putNumber("AutoForwardSpeed", getAutonSpeed());
		SmartDashboard.putNumber("AutonDelaySecs", getAutonDelaySecs());

//        SmartDashboard.putBoolean("Is_PID_Drive", getIsPIDDrive());
//        SmartDashboard.putNumber("P:", p);
//        SmartDashboard.putNumber("I:", i);
//        SmartDashboard.putNumber("D:", d);
//        SmartDashboard.putNumber("FF:", ff);

		Robot.oi.dsLCD.println(DriverStationLCD.Line.kUser1, 1, "PSI: " + pressure);
		Robot.oi.dsLCD.println(DriverStationLCD.Line.kUser2, 1, "Is Ready:" + Robot.shooter.goodToShoot());
		Robot.oi.dsLCD.updateLCD();

//        SmartDashboard.putNumber("MiniShotDelayMillis", getMiniShotDelayMillis());
	}

	public double getAutonInches() {
		return SmartDashboard.getNumber("AutoForwardFeet") * 12;
	}

	public double getAutonSpeed() {
		return (double) SmartDashboard.getNumber("AutoForwardSpeed");
	}

	public double getAutonDelaySecs() {
		return SmartDashboard.getNumber("AutonDelaySecs");
	}

	public boolean getHotGoalEnabled() {
		return SmartDashboard.getBoolean("Running HotGoal");
	}
//    public double getMiniShotDelayMillis(){
//        return SmartDashboard.getNumber("MiniShotDelayMillis");
//    }
//    public boolean getIsPIDDrive() {
//        return SmartDashboard.getBoolean("Is_PID_Drive");
//    }
//    
//    public void getPIDValues(){
//        return 
//    }
}
//        SmartDashboard.putData("Auton_DualBall", new Auton_DualBall());
//        SmartDashboard.putData("Auton_SingleBall", new Auton_InitialDriveAndShoot());
//SmartDashboard.putNumber("AutoArmRaiseTime", 2);
//SmartDashboard.putNumber("RollerSpeed", 1);
//
//    public double getAutonArmRaiseDelay() {
//        return SmartDashboard.getNumber("AutoArmRaiseTime");
//    }
//
//    public double getRollerSpeed() {
//        return SmartDashboard.getNumber("RollerSpeed");
//    }
//
//SmartDashboard.putNumber("AutoArmRaiseTime", getAutonArmRaiseDelay());
//SmartDashboard.putNumber("RollerSpeed", getRollerSpeed());
//

//SmartDashboard.putBoolean("AutoDisabledShooting", false);