package frc.robot.Subsystems.Drive;

import edu.wpi.first.math.Matrix;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.numbers.N1;
import edu.wpi.first.math.numbers.N3;


public interface DriveIO {
	public void setTransistionalMultiplier(double transationalMultiplier);

	public void setRotationMultiplier(double rotationMultiplier);

	public void drivecommands(
		double xtranslation,
		double ytranslation,
		double rotation,
		boolean feldRealative
	);
	

	public ChassisSpeeds getRelativSpeeds();
	
	public Pose2d getPose();

	public static void addVisionMeasurement(Pose2d pose, double timestamp, Matrix<N3, N1> standardDeviaton) {}



	public void logdata();
}
