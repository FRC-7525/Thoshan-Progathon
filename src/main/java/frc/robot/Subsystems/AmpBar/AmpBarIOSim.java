package frc.robot.Subsystems.AmpBar;

import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.GlobalConstants.UPDATE_PERIOD;
import static frc.robot.Subsystems.AmpBar.AmpBarConstants.*;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import org.littletonrobotics.junction.Logger;

public class AmpBarIOSim implements AmpBarIO {

	SingleJointedArmSim armsim;
	FlywheelSim wheelsim;
	PIDController pivotController;
	PIDController wheelController;
	AngularVelocity targetspeed;
	Angle targetposition;

	public AmpBarIOSim() {
		armsim = new SingleJointedArmSim(
			LinearSystemId.createSingleJointedArmSystem(DCMotor.getNEO(2), 0.05, 0.05),
			DCMotor.getNEO(2),
			0.05,
			.378,
			-Units.degreesToRadians(114.163329),
			0,
			true,
			-Units.degreesToRadians(114.163329)
		);
		wheelsim = new FlywheelSim(
			LinearSystemId.createFlywheelSystem(DCMotor.getNEO(1), 1, 1),
			DCMotor.getNEO(1)
		);

		pivotController = PIVOT_CONTROLLER.get();
		wheelController = WHEEL_CONTROLLER.get();
	}

	@Override
	public void setPosition(Angle position) {
		armsim.setInputVoltage(pivotController.calculate(armsim.getAngleRads()));
		targetposition = position;
	}

	@Override
	public void setWheelSpeed(AngularVelocity wheelspeed) {
		wheelsim.setInputVoltage(
			wheelController.calculate(
				wheelsim.getAngularVelocityRPM() / 60,
				wheelspeed.in(RotationsPerSecond)
			)
		);
		targetspeed = wheelspeed;
	}

	@Override
	public void logData() {
		armsim.update(UPDATE_PERIOD);

		Logger.recordOutput("AmpBar/wheelspeed", armsim.getAngleRads());
		Logger.recordOutput("AmpBar/position", wheelsim.getAngularVelocityRPM());
		Logger.recordOutput("AmpBar/target speed", targetspeed);
		Logger.recordOutput("AmpBar/target position", targetposition);
		Logger.recordOutput(
			"AmpBar/Amp Bar Pose3d",
			new Pose3d(ZEROED_PIVOT_TRANSLATION, new Rotation3d(0, armsim.getAngleRads(), 0))
		);
	}
}
