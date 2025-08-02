package frc.robot.Subsystems.AmpBar;

import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.Subsystems.AmpBar.AmpBarConstants.*;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;

public class AmpBarIOSim implements AmpBarIO{
    SingleJointedArmSim armsim;
    FlywheelSim wheelsim;
    PIDController pivotController;
    PIDController wheelController;
    AngularVelocity targetspeed;
    Angle targetposition;
    public AmpBarIOSim() {
        armsim = new SingleJointedArmSim(LinearSystemId.createSingleJointedArmSystem(DCMotor.getNEO(1), 1, 1), DCMotor.getNEO(1), 1, 1, 1, 1, true, 1, null);
        wheelsim = new FlywheelSim(LinearSystemId.createFlywheelSystem(DCMotor.getNEO(1), 1,1), DCMotor.getNEO(1), 
        null);

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
        wheelsim.setInputVoltage(wheelController.calculate(wheelsim.getAngularVelocityRPM() / 60, wheelspeed.in(RotationsPerSecond)));
        targetspeed = wheelspeed;
    }
    @Override
    public void logData() {
        Logger.recordOutput("AmpBar/wheelspeed", armsim.getAngleRads());
        Logger.recordOutput("AmpBar/position", wheelsim.getAngularVelocityRPM());
        Logger.recordOutput("AmpBar/target speed", targetspeed);
        Logger.recordOutput("AmpBar/target position", targetposition);
    }

}
