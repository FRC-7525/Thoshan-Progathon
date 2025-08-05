package frc.robot.Subsystems.Climber;

import edu.wpi.first.units.measure.AngularVelocity;

public interface ClimberIO {
	void setMotorSpeed(AngularVelocity motorSpeed);

	void logData();
}
