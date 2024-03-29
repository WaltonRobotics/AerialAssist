// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc2974.Pneumatotron.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2974.Pneumatotron.Robot;
import org.usfirst.frc2974.Pneumatotron.RobotMap;

/**
 * Uses very, VERY complicated state system ;) It creates a series of nested classes that implement the nested State
 * interface Each has an initial behavior and a continuous execution, though some of these are empty This is employed
 * for ease of use with a scheduler (StateContext) that mimics command base.
 */
public class Fire extends Command {

	private StateContext context;

	public Fire() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
		requires(Robot.shooter);
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		context = new StateContext();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		context.execute();
	}

	/**
	 * Make this return true when this Command no longer needs to run execute()
	 *
	 * @return false
	 */
	protected boolean isFinished() {
		return Robot.oi.ds.isAutonomous();
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

	public interface State {

		public void initialize();

		public void execute(StateContext context);
	}

	public class StateContext {

		private State state;
		private long tLast;

		/**
		 * Standard constructor
		 */
		public StateContext() {
			setState(new Init());
		}

		/**
		 * Setter method for the state. Normally only called by classes implementing the State interface.
		 *
		 * @param newState the new state of this context
		 */
		public final void setState(State newState) {
			state = newState;
			newState.initialize();
			tLast = System.currentTimeMillis();
		}

		/**
		 *
		 */
		public final void execute() {
			state.execute(this);
		}

		public final long getMillis() {
			return System.currentTimeMillis() - tLast;
		}

		public void setLastTime() {
			tLast = System.currentTimeMillis();
		}
	}

	public class Init implements State {

		public void initialize() {
		}

		public void execute(StateContext context) {
			context.setState(new Relaxed());
		}
	}

	/**
	 * Sets shooter latch and waits for Charge button and Fire buttons.
	 *
	 * Leads to either Jog class or Charge class.
	 */
	public class Relaxed implements State {

		public void initialize() {
			//This keeps latch on by default. To keep off by default, move to Charge
			Robot.shooter.setLatch();
		}

		public void execute(StateContext context) {
			if (Robot.oi.bCharge.get()) {
				context.setState(new Charge());
			} else if (Robot.oi.bUnlatch.get()) {
				context.setState(new OpenLatch());
			} else if (Robot.oi.bQuickTruss.get()) {
				context.setState(new ScrewItAndThrow());
			} else {
			}
		}
	}

	/**
	 * Opens the valve to the cylinders. Activates Ready when the cylinders are filled.
	 */
	public class Charge implements State {

		private final long CHARGE_READY = 1500;
		private final long CHARGE_DELAY = 200;

		public void initialize() {
			// Robot.shooter.setLatch();
		}

		public void execute(StateContext context) {
			long millis = context.getMillis();
			if (millis > CHARGE_READY) {
				context.setState(new Ready());
			} else if (millis > CHARGE_DELAY && !Robot.shooter.isCharged()) {
				Robot.shooter.charge();
			}
		}
	}

	/**
	 * The cylinders are filled and ready to be fired! Leads to Launch or Discharge
	 */
	public class Ready implements State {

		public void initialize() {
		}

		public void execute(StateContext context) {
			if (Robot.oi.bDischarge.get()) {
				context.setState(new Discharge());
			} else if (Robot.oi.bFire.get()) {
				context.setState(new Launch());
			}
		}
	}

	/**
	 * The shooter is in the state of launching the ball. Leads to Discharge.
	 */
	public class Launch implements State {

		private final long FIRE_DONE = 1000;

		public void initialize() {
			if (Robot.shooter.getPressure() > 30) {
				Robot.shooter.releaseLatch();
			}
		}

		public void execute(StateContext context) {
			if (context.getMillis() > FIRE_DONE) {
				context.setState(new Discharge());
			}
		}
	}

	/**
	 * Releases the stored air pressure in the cylinders.
	 *
	 * Goes to relaxed
	 */
	public class Discharge implements State {

		private final long RELAX_DELAY = 1500;
		private final long LATCH_DELAY = 300;

		public void initialize() {
			Robot.shooter.discharge();
		}

		public void execute(StateContext context) {
			if (RobotMap.magneticLatchDetector.get()) {
				long millis = context.getMillis();
				if (millis > RELAX_DELAY) {
					context.setState(new Relaxed());
				} else if (millis > LATCH_DELAY && Robot.shooter.isLatched()) {
					Robot.shooter.releaseLatch();
				}
			} else {
				context.setLastTime();
			}
		}
	}

	public class OpenLatch implements State {

		public void initialize() {
			Robot.shooter.releaseLatch();
		}

		public void execute(StateContext context) {
			if (!Robot.oi.bUnlatch.get()) {
				Robot.shooter.setLatch();
				context.setState(new Relaxed());
			}
		}
	}

	public class ScrewItAndThrow implements State {

		private final long FIRE_DELAY = 1500;

		public void initialize() {
			Robot.shooter.releaseLatch();
			Robot.shooter.charge();
		}

		public void execute(StateContext context) {
			if (context.getMillis() > FIRE_DELAY) {
				context.setState(new Discharge());
			}
		}
	}

//    public class MinimalShot implements State {
//
//        private final long FIRE_DELAY = 250;
//
//        public void initialize() {
//            Robot.shooter.releaseLatch();
//            Robot.shooter.charge();
//        }
//
//        public void execute(StateContext context) {
//            if (context.getMillis() > FIRE_DELAY) {
//                context.setState(new Discharge());
//            }
//        }
//    }

	/**
	 * Created to fix a possible situation where the latch is below the bolt.
	 *
	 * Quickly fires one of the shooter's cylinders
	 *
	 * @author Queen Leucinthia IIIsty
	 */
	public class Jog implements State {

		private final long START_DELAY = 100;
		private final long FINAL_DELAY = 500;

		public void initialize() {
			Robot.shooter.releaseLatch();
			Robot.shooter.jog();
		}

		public void execute(StateContext context) {
			long millis = context.getMillis();
			if (millis > FINAL_DELAY) {
				Robot.shooter.unjog();
			} else if (millis > START_DELAY) {
				context.setState(new Relaxed());
			}
		}
	}
}