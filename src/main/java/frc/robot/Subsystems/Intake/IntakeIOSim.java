package frc.robot.Subsystems.Intake;

import static edu.wpi.first.units.Units.Degree;
import static edu.wpi.first.units.Units.RotationsPerSecond;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import static frc.robot.Subsystems.Intake.IntakeConstant.*;

public class IntakeIOSim implements IntakeIO {
    
    FlywheelSim wheelsim;
    SingleJointedArmSim armSim;
    PIDController positionController;
    PIDController speedPidController;
    AngularVelocity targetSpeed;
    Angle targetPosition;
    

    public IntakeIOSim() {
        wheelsim = new FlywheelSim(LinearSystemId.createFlywheelSystem(DCMotor.getNEO(1), 1,1), DCMotor.getNEO(1), 
        null);
        armSim = new SingleJointedArmSim(LinearSystemId.createSingleJointedArmSystem(DCMotor.getNEO(1), 1, 1), DCMotor.getNEO(1), 1, 1, 1, 1, true, 1, null);
        
        speedPidController = WHEEL_CONTROLLER.get();
        positionController = PIVOT_CONTROLLER.get();
        targetSpeed = RotationsPerSecond.zero();
        targetPosition = Degree.zero();

    }
    @Override
    public void setWheelSpeed(AngularVelocity wheelSpeed) {
        wheelsim.setInputVoltage(speedPidController.calculate(wheelsim.getAngularVelocityRPM() / 60, wheelSpeed.in(RotationsPerSecond)));
        targetSpeed = wheelSpeed;
    }

    @Override
    public void setPosition(Angle position) {
        armSim.setInputVoltage(positionController.calculate(armSim.getAngleRads()));
        targetPosition = position;
    }
    @Override
    public void logData() {
        Logger.recordOutput("Intake/Wheel speed", wheelsim.getAngularVelocityRPM());
        Logger.recordOutput("Intake/Position", armSim.getAngleRads());
        Logger.recordOutput("Intake/Target position", targetPosition);
        Logger.recordOutput("Intake/Target speed", targetSpeed);

    }
}
