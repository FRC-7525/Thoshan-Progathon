package frc.robot.Subsystems.Shooter;

import static frc.robot.Subsystems.Shooter.ShooterConstant.*;

import edu.wpi.first.units.measure.AngularVelocity;
import org.team7525.subsystem.SubsystemStates;

public enum ShooterStates implements SubsystemStates {
	IDLE(IDLE_SPEED),
	PASSING(PASSING_SPEED),
	SHOOTING(SHOOTING_SPEED),
	BEING_FED(BEING_FED_SPEED);

	private AngularVelocity wheelSpeed;

	ShooterStates(AngularVelocity wheelSpeed) {
		this.wheelSpeed = wheelSpeed;
	}

	public AngularVelocity getWheelSpeed() {
		return wheelSpeed;
	}
}
