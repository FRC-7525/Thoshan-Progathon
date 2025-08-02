package frc.robot.Subsystems.Drive;

import java.io.File;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Filesystem;
import swervelib.SwerveDrive;
import swervelib.parser.SwerveParser;

public class DriveIOReal implements DriveIO {

    SwerveDrive swerveDrive;
    double transationalMultiplier;
    double rotationMultiplier;
    
    public DriveIOReal() {
        try {
            File directory = new File(Filesystem.getDeployDirectory(), "swerve");
            double maxSpeed = Units.feetToMeters(12); // your top speed
            swerveDrive = new SwerveParser(directory)
                        .createSwerveDrive(maxSpeed);
        } catch (Exception e) {
            System.out.println("hello");
        }        
    }



    @Override
    public void setTransistionalMultiplier(double transationalMultiplier) {
        this.transationalMultiplier = transationalMultiplier;


    }


    @Override
    public void setRotationMultiplier(double rotationMultiplier) {
        this.rotationMultiplier = rotationMultiplier;
    }

    @Override
    public void drivecommands(double xtranslation, double ytranslation, double rotation, boolean feldRealative) {
        swerveDrive.drive(
            new Translation2d(transationalMultiplier * xtranslation,transationalMultiplier * ytranslation),
            rotationMultiplier * rotation,
            false,
            true
        ); 
    }

    @Override
    public void logdata() {
        Logger.recordOutput("Drive/ Transitional Multiplier", transationalMultiplier);
        Logger.recordOutput("Drive/ Rotation multiplier", rotationMultiplier);
        Logger.recordOutput("Drive/ Position", swerveDrive.getPose());
    }

}