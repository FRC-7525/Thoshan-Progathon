package frc.robot.Subsystems.Shooter;

import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.Subsystems.Shooter.ShooterConstant.*;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import edu.wpi.first.math.controller.BangBangController;
import edu.wpi.first.units.measure.AngularVelocity;
import org.littletonrobotics.junction.Logger;

<<<<<<< HEAD
public class ShooterIONeo implements ShooterIO {
=======
import static frc.robot.Subsystems.Shooter.ShooterConstant.*;

public class ShooterIONeo implements ShooterIO{
>>>>>>> c0b9b56 (Co-authored-by: PotmanNob <PotmanNob@users.noreply.github.com>)

	SparkMax leftMotor;
	SparkMax rightMotor;
	BangBangController leftMotorController;
	BangBangController rightMotorController;
	AngularVelocity targetSpeed;

	SparkBaseConfig sparkMaxConfig;

<<<<<<< HEAD
	public ShooterIONeo() {
		leftMotor = new SparkMax(LEFT_MOTOR_ID, MotorType.kBrushless);
		rightMotor = new SparkMax(RIGHT_MOTOR_ID, MotorType.kBrushless);
=======
    SparkBaseConfig sparkMaxConfig;
    public ShooterIONeo() {
        leftMotor = new SparkMax(LEFT_MOTOR_ID, MotorType.kBrushless);
        rightMotor = new SparkMax(RIGHT_MOTOR_ID, MotorType.kBrushless);
>>>>>>> c0b9b56 (Co-authored-by: PotmanNob <PotmanNob@users.noreply.github.com>)

		leftMotorController = new BangBangController();
		rightMotorController = new BangBangController();
		// leftMotor.configureAsync(SparkBaseConfig.IdleMode.kCoast, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
	}

	@Override
	public void setWheelSpeed(AngularVelocity wheelSpeed) {
		targetSpeed = wheelSpeed;

		leftMotor.set(
			leftMotorController.calculate(
				leftMotor.getAbsoluteEncoder().getVelocity() / 60,
				wheelSpeed.in(RotationsPerSecond)
			)
		);
		rightMotor.set(
			rightMotorController.calculate(
				rightMotor.getAbsoluteEncoder().getVelocity() / 60,
				wheelSpeed.in(RotationsPerSecond)
			)
		);
	}

	@Override
	public void logData() {
		Logger.recordOutput(
			"Shooter/left wheel Speed",
			leftMotor.getAbsoluteEncoder().getVelocity()
		);
		Logger.recordOutput(
			"Shooter/right wheel Speed",
			rightMotor.getAbsoluteEncoder().getVelocity()
		);
		Logger.recordOutput("Shooter/Target Speed", targetSpeed);
	}
}
