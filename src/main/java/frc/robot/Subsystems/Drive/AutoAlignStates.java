package frc.robot.Subsystems.Drive;

import org.team7525.subsystem.SubsystemStates;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.measure.Angle;

public enum AutoAlignStates implements SubsystemStates{
    toSource( , ),
    toStage(, ),
    toAmpBar( , );

    private Pose2d location;
    private Rotation2d rotation;
        
    private AutoAlignStates(Pose2d location, Rotation2d rotation) {
        this.location = location;
        this.rotation = rotation;
    }

    public Pose2d getLocation() {
        return location;
    }
    public Rotation2d getRotation() {
        return rotation;
    }

}
