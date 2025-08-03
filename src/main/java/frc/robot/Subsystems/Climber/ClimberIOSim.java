package frc.robot.Subsystems.Climber;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;

import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.Subsystems.Climber.ClimberConstants.*;



import org.littletonrobotics.junction.Logger;

public class ClimberIOSim implements ClimberIO{
    DCMotorSim motorSim;
    PIDController motorController;
    AngularVelocity targetspeed;
    
    public ClimberIOSim() {
        motorSim = new DCMotorSim(LinearSystemId.createDCMotorSystem(DCMotor.getNEO(1), 1,1), DCMotor.getNEO(1), 
        null);
        motorController = MOTOR_CONTROLLER.get();

    }
    
    
    
    @Override
    public void setMotorSpeed(AngularVelocity motorSpeed) {
        motorSim.setInputVoltage(motorController.calculate(motorSim.getAngularVelocityRPM() / 60, motorSpeed.in(RotationsPerSecond)));
        targetspeed = motorSpeed;
    }
    @Override
    public void logData() {
        Logger.recordOutput("Climber/Target speed", targetspeed);
        Logger.recordOutput("Climber/Motor speed", motorSim.getAngularVelocityRPM());
    }
}
