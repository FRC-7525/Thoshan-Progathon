package frc.robot.Subsystems.Shooter;

import edu.wpi.first.units.measure.AngularVelocity;

public interface ShooterIO {
	void setWheelSpeed(AngularVelocity wheelSpeed);

	void logData();
}
