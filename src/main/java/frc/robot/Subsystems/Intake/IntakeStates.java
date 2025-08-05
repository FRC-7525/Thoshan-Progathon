package frc.robot.Subsystems.Intake;

import static frc.robot.Subsystems.Intake.IntakeConstant.*;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import org.team7525.subsystem.SubsystemStates;

public enum IntakeStates implements SubsystemStates {
	IDLE(IDLE_SPEED, IDLE_ANGLE),
	INTAKING(INTAKING_SPEED, INTAKING_ANGLE),
	PASSING(PASSING_SPEED, PASSING_ANGLE);

	private AngularVelocity wheelSpeed;
	private Angle position;

	IntakeStates(AngularVelocity wheelSpeed, Angle position) {
		this.wheelSpeed = wheelSpeed;
		this.position = position;
	}

	public AngularVelocity getWheelSpeed() {
		return wheelSpeed;
	}

	public Angle getPostition() {
		return position;
	}
}
