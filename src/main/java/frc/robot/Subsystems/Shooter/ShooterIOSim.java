package frc.robot.Subsystems.Shooter;

import static edu.wpi.first.units.Units.RotationsPerSecond;

import edu.wpi.first.math.controller.BangBangController;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import org.littletonrobotics.junction.Logger;

public class ShooterIOSim implements ShooterIO {

	FlywheelSim wheels;
	BangBangController motorController;
	AngularVelocity targetSpeed;

	public ShooterIOSim() {
		wheels = new FlywheelSim(
			LinearSystemId.createFlywheelSystem(DCMotor.getNEO(2), 1, 1),
			DCMotor.getNEO(2),
			null
		);

		motorController = new BangBangController();
		targetSpeed = RotationsPerSecond.zero();
	}

	@Override
	public void setWheelSpeed(AngularVelocity wheelSpeed) {
		wheels.setInputVoltage(
			12 *
			motorController.calculate(
				wheels.getAngularVelocityRPM() / 60,
				wheelSpeed.in(RotationsPerSecond)
			)
		);
	}

	@Override
	public void logData() {
		Logger.recordOutput("Shooter/wheelSpeed", wheels.getAngularVelocityRPM() / 60);
		Logger.recordOutput("Shooter/Target Speed", targetSpeed);
	}
}
