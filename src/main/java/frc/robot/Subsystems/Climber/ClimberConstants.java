package frc.robot.Subsystems.Climber;

import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.GlobalConstants.ROBOT_MODE;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.AngularVelocity;
import java.util.function.Supplier;

public class ClimberConstants {

	public static final AngularVelocity IDLE_MOTOR_SPEED = RotationsPerSecond.of(0);
	public static final AngularVelocity CLIMBING_MOTOR_SPEED = RotationsPerSecond.of(-1);
	public static final AngularVelocity SHOOT_OUT_MOTOR_SPEED = RotationsPerSecond.of(1);

	public static final int MOTOR_DEVICE_ID = 1;
	public static final Supplier<PIDController> MOTOR_CONTROLLER = () ->
		switch (ROBOT_MODE) {
			case REAL -> new PIDController(0.1, 0, 0);
			case SIM -> new PIDController(0.1, 0, 0);
			case TESTING -> new PIDController(0.1, 0, 0);
		};
}
