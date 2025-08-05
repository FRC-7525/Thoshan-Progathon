package frc.robot.Subsystems.Intake;

import static frc.robot.GlobalConstants.ROBOT_MODE;

import org.team7525.subsystem.Subsystem;

public class Intake extends Subsystem<IntakeStates> {

	IntakeIO io;
	private static Intake instance;

	private Intake() {
		super("Intake", IntakeStates.IDLE);
		this.io = switch (ROBOT_MODE) {
			case REAL -> new IntakeIONeo();
			case SIM -> new IntakeIOSim();
			case TESTING -> new IntakeIONeo();
		};
	}

	public static Intake getInstance() {
		if (instance == null) {
			instance = new Intake();
		}
		return instance;
	}

	@Override
	protected void runState() {
		io.setPosition(getState().getPostition());
		io.setWheelSpeed(getState().getWheelSpeed());
		io.logData();
	}
}
