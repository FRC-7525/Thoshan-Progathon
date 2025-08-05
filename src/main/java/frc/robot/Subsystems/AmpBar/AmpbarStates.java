package frc.robot.Subsystems.AmpBar;

import static frc.robot.Subsystems.AmpBar.AmpBarConstants.*;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import org.team7525.subsystem.SubsystemStates;

public enum AmpbarStates implements SubsystemStates {
	SCORING(SCORRING_POSITION, SCORRINGT_VELOCITY),
	IDLE(IDLE_POSITION, IDLE_VELOCITY),
	LOADING(LOADING_POSITION, LOADING_VELOCITY);

	private Angle poistion;
	private AngularVelocity wheelSpeed;

	private AmpbarStates(Angle position, AngularVelocity wheelSpeed) {
		this.poistion = position;
		this.wheelSpeed = wheelSpeed;
	}

	public Angle getPosition() {
		return poistion;
	}

	public AngularVelocity getwheelSpeed() {
		return wheelSpeed;
	}
}
