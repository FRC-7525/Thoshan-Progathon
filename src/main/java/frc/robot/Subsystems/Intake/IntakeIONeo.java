package frc.robot.Subsystems.Intake;

import static edu.wpi.first.units.Units.RotationsPerSecond;

import org.littletonrobotics.junction.Logger;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

public class IntakeIONeo implements IntakeIO {
    
    SparkMax Wheelmotor;
    SparkMax Pivotmotor;
    PIDController wheelController;
    PIDController pivotcController;
    AngularVelocity targetspeed;
    Angle targetposition;

    public IntakeIONeo() {
        Wheelmotor = new SparkMax(15, MotorType.kBrushless);
        Pivotmotor = new SparkMax(16, MotorType.kBrushless);

        wheelController = new PIDController(0.1, 0, 0);
        pivotcController = new PIDController(0.1, 0, 0);

    }
    
    
    
    @Override
    public void setWheelSpeed(AngularVelocity wheelSpeed) {
        targetspeed = wheelSpeed;
        
        Wheelmotor.set(wheelController.calculate(Wheelmotor.getAbsoluteEncoder().getVelocity() / 60, wheelSpeed.in(RotationsPerSecond)));
    }
    @Override
    public void setPosition(Angle position) {
        targetposition = position;

        Pivotmotor.set(pivotcController.calculate(Pivotmotor.getAbsoluteEncoder().getPosition()));
    }
    @Override
    public void logData() {
        Logger.recordOutput("Intake/Wheel speed", Wheelmotor.getAbsoluteEncoder().getVelocity());
        Logger.recordOutput("Intake/Pivot position", Pivotmotor.getAbsoluteEncoder().getPosition());
        Logger.recordOutput("Intake/target speed", targetspeed);
        Logger.recordOutput("Intake/target position", targetposition);
    }



}
