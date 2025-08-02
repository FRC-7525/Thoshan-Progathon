package frc.robot.Subsystems.Intake;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

public interface IntakeIO {
    
    public void setWheelSpeed(AngularVelocity wheelSpeed);
    public void setPosition(Angle position);

    void logData();
    
} 
