package frc.robot.Subsystems.Drive;



import org.team7525.subsystem.SubsystemStates;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;


public enum AutoAlignStates implements SubsystemStates{
    OFF(new PosePair(new Pose2d( 1, 1, new Rotation2d()), new Pose2d(1, 1, new Rotation2d()))),
    toSource(new PosePair(new Pose2d( 15.636,4.39, new Rotation2d(Math.toRadians(-122.5))), new Pose2d(0.864,4.39, new Rotation2d(Math.toRadians(-62.5))))),
    toSpeaker(new PosePair(new Pose2d(15.1,5.50, new Rotation2d(Math.toRadians(180))), new Pose2d(1.45,5.50, new Rotation2d(Math.toRadians(0))))),
    toAmp(new PosePair(new Pose2d(14.7,7.72, new Rotation2d(Math.toRadians(-90))), new Pose2d(1.85,7.72, new Rotation2d(Math.toRadians(-90))))),
    toAmpBar(new PosePair(new Pose2d(15.59,6.644, new Rotation2d(Math.toRadians(120.5))), new Pose2d(0.909,6.644, new Rotation2d(Math.toRadians(55.5)))));

    private PosePair location;
               
    private AutoAlignStates(PosePair location) {
        this.location = location;
   
    }
       
        public PosePair getLocation() {
            return location;
    }
}
