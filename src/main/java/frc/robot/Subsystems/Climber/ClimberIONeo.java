package frc.robot.Subsystems.Climber;

<<<<<<< HEAD
import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.Subsystems.Climber.ClimberConstants.*;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.AngularVelocity;
import org.littletonrobotics.junction.Logger;

public class ClimberIONeo implements ClimberIO {

	SparkMax motor;
	PIDController motorcontroller;

	AngularVelocity targetspeed;

	public ClimberIONeo() {
		motor = new SparkMax(MOTOR_DEVICE_ID, MotorType.kBrushless);
		motorcontroller = MOTOR_CONTROLLER.get();
	}

	@Override
	public void setMotorSpeed(AngularVelocity motorSpeed) {
		motor.set(
			motorcontroller.calculate(
				motor.getAbsoluteEncoder().getVelocity() / 60,
				motorSpeed.in(RotationsPerSecond)
			)
		);
		targetspeed = motorSpeed;
	}

	@Override
	public void logData() {
		Logger.recordOutput("Climber/Target speed", targetspeed);
		Logger.recordOutput("Climber/Motor speed", motor.getAbsoluteEncoder().getVelocity());
	}
=======
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.AngularVelocity;

import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.Subsystems.Climber.ClimberConstants.*;

import org.littletonrobotics.junction.Logger;

public class ClimberIONeo implements ClimberIO{
    SparkMax motor;
    PIDController motorcontroller;

    AngularVelocity targetspeed;


    public ClimberIONeo() {
        motor = new SparkMax(MOTOR_DEVICE_ID, MotorType.kBrushless);
        motorcontroller = MOTOR_CONTROLLER.get();


    }



    @Override
    public void setMotorSpeed(AngularVelocity motorSpeed) {
       motor.set(motorcontroller.calculate(motor.getAbsoluteEncoder().getVelocity() / 60, motorSpeed.in(RotationsPerSecond)));
       targetspeed = motorSpeed;
    }



    @Override
    public void logData() {
        Logger.recordOutput("Climber/Target speed", targetspeed);
        Logger.recordOutput("Climber/Motor speed", motor.getAbsoluteEncoder().getVelocity());
    }
    
>>>>>>> 03ccaa8 (ffdfsfd)
}
