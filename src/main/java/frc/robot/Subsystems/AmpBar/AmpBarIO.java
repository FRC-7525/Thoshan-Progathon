package frc.robot.Subsystems.AmpBar;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

public interface AmpBarIO {
	public void setPosition(Angle position);

	public void setWheelSpeed(AngularVelocity wheelspeed);

	public void logData();
}
