package frc.robot.Subsystems.AmpBar;

<<<<<<< HEAD
import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.Subsystems.AmpBar.AmpBarConstants.*;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import org.littletonrobotics.junction.Logger;

public class AmpBarIONeo implements AmpBarIO {

	SparkMax wheelMotor;
	SparkMax pivotMotor;
	PIDController wheelController;
	PIDController pivotController;
	AngularVelocity targetspeed;
	Angle targetposition;

	public AmpBarIONeo() {
		wheelMotor = new SparkMax(WHEEL_MOTOR_DEVICE_ID, MotorType.kBrushless);
		pivotMotor = new SparkMax(PIVOT_MOTOR_DEVICE_ID, MotorType.kBrushless);

		wheelController = WHEEL_CONTROLLER.get();
		pivotController = PIVOT_CONTROLLER.get();
	}

	@Override
	public void setPosition(Angle position) {
		pivotMotor.set(pivotController.calculate(pivotMotor.getAbsoluteEncoder().getPosition()));
		targetposition = position;
	}

	@Override
	public void setWheelSpeed(AngularVelocity wheelspeed) {
		wheelMotor.set(
			wheelController.calculate(
				wheelMotor.getAbsoluteEncoder().getVelocity() / 60,
				wheelspeed.in(RotationsPerSecond)
			)
		);
		targetspeed = wheelspeed;
	}

	@Override
	public void logData() {
		Logger.recordOutput("AmpBar/wheelspeed", wheelMotor.getAbsoluteEncoder().getVelocity());
		Logger.recordOutput("AmpBar/position", pivotMotor.getAbsoluteEncoder().getPosition());
		Logger.recordOutput("AmpBar/target speed", targetspeed);
		Logger.recordOutput("AmpBar/target position", targetposition);
	}
}
=======


import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.Subsystems.AmpBar.AmpBarConstants.*;

import org.littletonrobotics.junction.Logger;

public class AmpBarIONeo implements AmpBarIO{
    SparkMax wheelMotor;
    SparkMax pivotMotor;
    PIDController wheelController;
    PIDController pivotController;
    AngularVelocity targetspeed;
        Angle targetposition;
            
    public AmpBarIONeo() {
        wheelMotor = new SparkMax(WHEEL_MOTOR_DEVICE_ID, MotorType.kBrushless);
        pivotMotor = new SparkMax(PIVOT_MOTOR_DEVICE_ID, MotorType.kBrushless);
        
        wheelController = WHEEL_CONTROLLER.get();
        pivotController = PIVOT_CONTROLLER.get();
    }
        
    @Override
    public void setPosition(Angle position) {
        pivotMotor.set(pivotController.calculate(pivotMotor.getAbsoluteEncoder().getPosition()));
        targetposition = position;
    }

    @Override
    public void setWheelSpeed(AngularVelocity wheelspeed) {
        wheelMotor.set(wheelController.calculate(wheelMotor.getAbsoluteEncoder().getVelocity() / 60, wheelspeed.in(RotationsPerSecond)));
        targetspeed = wheelspeed;
    }

    @Override
    public void logData() {
        Logger.recordOutput("AmpBar/wheelspeed", wheelMotor.getAbsoluteEncoder().getVelocity());
        Logger.recordOutput("AmpBar/position", pivotMotor.getAbsoluteEncoder().getPosition());
        Logger.recordOutput("AmpBar/target speed", targetspeed);
        Logger.recordOutput("AmpBar/target position", targetposition);
    }
}

>>>>>>> c0b9b56 (Co-authored-by: PotmanNob <PotmanNob@users.noreply.github.com>)
