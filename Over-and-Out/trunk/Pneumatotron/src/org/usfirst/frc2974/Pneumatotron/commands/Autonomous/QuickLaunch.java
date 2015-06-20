/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2974.Pneumatotron.commands.Autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2974.Pneumatotron.Robot;

/**
 *
 * @author Alex
 */
public class QuickLaunch extends Command {

    private boolean hotGoal = false, finished = false;
    private int mode = 0;
    private int timeSecs = 1; //NEW
    private Timer t = new Timer();

    public QuickLaunch(boolean hotGoalEnabled) {
        requires(Robot.shooter);
        hotGoal = hotGoalEnabled;
    }
//    private final long FIRE_DONE = 1000;
//    private final long TIME_TO_LATCH = 2000;
//    private boolean isFinished = false; //setOnce = false,
//    private long tLast = System.currentTimeMillis();
//
//    public final long getChangeMillis() {
//        return System.currentTimeMillis() - tLast;
//    }
//
//    public void setLastTime() {
//        tLast = System.currentTimeMillis();
//    }

// Called just before this Command runs the first time
    public void initialize() {
        //setLastTime();
//        isFinished = false;
        Robot.shooter.setLatch();
        Robot.shooter.charge();
        //setTimeout(1.5);
        if (hotGoal) {
            hotGoal = Robot.dash.getHotGoalEnabled();
        }
        finished = false;
        mode = 0;
        t.stop();
        t.reset();
    }

// Called repeatedly when this Command is scheduled to run
    public void execute() {
        if (Robot.shooter.goodToShoot()) {
            if (mode == 0) {
                if (Robot.intake.isLowHit()) {
                    if (!hotGoal) {
                        Robot.shooter.releaseLatch();
                        Robot.shooter.charge();
                        mode++;
                        t.start();
                        System.out.println("I shootz");
                    } else {
                        if (Robot.server.getRightStatus() || Robot.oi.ds.getMatchTime() > 5) {
                            Robot.shooter.releaseLatch();
                            Robot.shooter.charge();
                            mode++;
                            t.start();
                            System.out.println("Hot Goal!");
                        } else {
                        }
                    }
                }
            } //            else {
            //            }
            //        } 
            else if (mode == 1) {
                if (t.get() > timeSecs) {
                    finished = true;
                    end();
                    System.out.println("Times Up!");
                }
            }
        } else { //NEW
        } //NEW
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished || !Robot.oi.ds.isAutonomous();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.shooter.discharge();
        Robot.shooter.releaseLatch();
        mode = 0;
        finished = false;
        t.stop();
        t.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
//
//// Called just before this Command runs the first time
//    public void initialize() {
//        setLastTime();
//        isFinished = false; //setOnce = 
//        if (Robot.intake.isLowHit()) {
//            Robot.shooter.releaseLatch();
//            //setOnce = true;
//        }
//    }
//// Called repeatedly when this Command is scheduled to run
//
//    public void execute() {
//        if (Robot.shooter.goodToShoot()) {
//            if (Robot.shooter.isLatched() && Robot.intake.isLowHit()) {
//                setLastTime();
//                Robot.shooter.releaseLatch();
//            } else if (getChangeMillis() > TIME_TO_LATCH) {
//                Robot.shooter.setLatch();
//                isFinished = true;
//            } else if (getChangeMillis() > FIRE_DONE) {
//                Robot.shooter.discharge();
//                //System.out.println("Autonomous Shoot Launch Done!");
//            } else {
//            }
//        } else {
//        }
//    }

//******************************************************************************
//            if (Robot.shooter.isLatched()) {
//                if (Robot.intake.isLowHit()) {
//                    setLastTime();
//                    Robot.shooter.releaseLatch();
//                    Robot.shooter.charge();
//                }
//            } else if (getChangeMillis() > TIME_TO_LATCH) {
//                Robot.shooter.setLatch();
//                isFinished = true;
//            } else if (getChangeMillis() > FIRE_DONE) {
//                Robot.shooter.discharge();
//                //System.out.println("Autonomous Shoot Launch Done!");
//            } else {
//            }