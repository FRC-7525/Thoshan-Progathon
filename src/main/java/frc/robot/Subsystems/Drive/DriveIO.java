package frc.robot.Subsystems.Drive;

import edu.wpi.first.math.Matrix;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.numbers.N1;
import edu.wpi.first.math.numbers.N3;
import static frc.robot.Subsystems.Drive.TunerConstants.*;

public interface DriveIO {
<<<<<<< HEAD
	public void setTransistionalMultiplier(double transationalMultiplier);

	public void setRotationMultiplier(double rotationMultiplier);

	public void drivecommands(
		double xtranslation,
		double ytranslation,
		double rotation,
		boolean feldRealative
	);

	public void logdata();
}
=======
    
    public void setTransistionalMultiplier(double transationalMultiplier);
    public void setRotationMultiplier(double rotationMultiplier);
    public void drivecommands(double xtranslation, double ytranslation, double rotation, boolean feldRealative);
    public static void addVisionMeasurement(Pose2d pose, double timestamp, Matrix<N3, N1> standardDeviaton) {}
    public static TunerSwerveDrivetrain getDrive() {
		return null;
    }
    
    public void logdata();
}

>>>>>>> c0b9b56 (Co-authored-by: PotmanNob <PotmanNob@users.noreply.github.com>)
