
package frc.robot.Subsystems.Vision;

import static edu.wpi.first.units.Units.DegreesPerSecond;

import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.math.Matrix;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.numbers.N1;
import edu.wpi.first.math.numbers.N3;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.units.measure.AngularVelocity;
import frc.robot.Subsystems.Drive.Drive;
import java.util.Set;

public class VisionConstants {

	public enum CameraResolution {
		HIGH_RESOLUTION,
		NORMAL,
	}

	// INSANE skill issue from First
	// This is comp dependent
	public static final boolean USE_WELDED_FIELD = true;

	public static final AprilTagFieldLayout APRIL_TAG_FIELD_LAYOUT = AprilTagFieldLayout.loadField(USE_WELDED_FIELD ? AprilTagFields.k2025ReefscapeWelded : AprilTagFields.k2025ReefscapeAndyMark);

	public record VisionMeasurment(Pose2d pose, double timestamp, Matrix<N3, N1> standardDev) {}

	// Front Left
	public static final String FRONT_LEFT_CAM_NAME = "Front Left Camera";
	public static final Translation3d ROBOT_TO_FRONT_LEFT_CAMERA_TRANSLATION = new Translation3d(Units.inchesToMeters(11.809459), Units.inchesToMeters(11.164206), Units.inchesToMeters(8.887162));
	public static final Rotation3d ROBOT_TO_FRONT_LEFT_CAMERA_ROTATION = new Rotation3d(0, Math.toRadians(-10), Math.toRadians(-30.4));
	public static final Transform3d ROBOT_TO_FRONT_LEFT_CAMERA = new Transform3d(ROBOT_TO_FRONT_LEFT_CAMERA_TRANSLATION, ROBOT_TO_FRONT_LEFT_CAMERA_ROTATION);

	// Front Right
	public static final String FRONT_RIGHT_CAM_NAME = "Front Right Camera";
	public static final Translation3d ROBOT_TO_FRONT_RIGHT_CAMERA_TRANSLATION = new Translation3d(Units.inchesToMeters(11.809459), Units.inchesToMeters(-11.164206), Units.inchesToMeters(8.887162));
	public static final Rotation3d ROBOT_TO_FRONT_RIGHT_CAMERA_ROTATION = new Rotation3d(0, Math.toRadians(-10), Math.toRadians(27.8));
	public static final Transform3d ROBOT_TO_FRONT_RIGHT_CAMERA = new Transform3d(ROBOT_TO_FRONT_RIGHT_CAMERA_TRANSLATION, ROBOT_TO_FRONT_RIGHT_CAMERA_ROTATION);

	//Back Left
	public static final String BACK_LEFT_CAM_NAME = "Back Left Camera";
	public static final Translation3d ROBOT_TO_BACK_LEFT_CAMERA_TRALSLATION = new Translation3d(Units.inchesToMeters(-11.697), Units.inchesToMeters(11.81), Units.inchesToMeters(8.859));
	public static final Rotation3d ROBOT_TO_BACK_LEFT_CAMERA_ROTATION = new Rotation3d(0, Math.toRadians(-10), Math.toRadians(180));
	public static final Transform3d ROBOT_TO_BACK_LEFT_CAMERA = new Transform3d(ROBOT_TO_BACK_LEFT_CAMERA_TRALSLATION, ROBOT_TO_BACK_LEFT_CAMERA_ROTATION);

	//Back Right
	public static final String BACK_RIGHT_CAM_NAME = "Back Right Camera";
	public static final Translation3d ROBOT_TO_BACK_RIGHT_CAMERA_TRALSLATION = new Translation3d(Units.inchesToMeters(-11.697), Units.inchesToMeters(-11.81), Units.inchesToMeters(8.859));
	public static final Rotation3d ROBOT_TO_BACK_RIGHT_CAMERA_ROTATION = new Rotation3d(0, Math.toRadians(-10), Math.toRadians(180));
	public static final Transform3d ROBOT_TO_BACK_RIGHT_CAMERA = new Transform3d(ROBOT_TO_BACK_RIGHT_CAMERA_TRALSLATION, ROBOT_TO_BACK_RIGHT_CAMERA_ROTATION);

	public static final VisionIO[] FRONT_SIM_IOS = new VisionIO[] { new VisionIOPhotonVisionSim(FRONT_LEFT_CAM_NAME, ROBOT_TO_FRONT_LEFT_CAMERA, Drive.getInstance()::getPose), new VisionIOPhotonVisionSim(FRONT_RIGHT_CAM_NAME, ROBOT_TO_FRONT_RIGHT_CAMERA, Drive.getInstance()::getPose) };

	public static final VisionIO[] BACK_SIM_IOS = new VisionIO[] { new VisionIOPhotonVisionSim(BACK_LEFT_CAM_NAME, ROBOT_TO_BACK_LEFT_CAMERA, Drive.getInstance()::getPose), new VisionIOPhotonVisionSim(BACK_RIGHT_CAM_NAME, ROBOT_TO_BACK_RIGHT_CAMERA, Drive.getInstance()::getPose) };

	public static final VisionIO[] FRONT_REAL_IOS = new VisionIO[] { new VisionIOPhotonVision(FRONT_LEFT_CAM_NAME, ROBOT_TO_FRONT_LEFT_CAMERA), new VisionIOPhotonVision(FRONT_RIGHT_CAM_NAME, ROBOT_TO_FRONT_RIGHT_CAMERA) };

	public static final VisionIO[] BACK_REAL_IOS = new VisionIO[] { new VisionIOPhotonVision(BACK_LEFT_CAM_NAME, ROBOT_TO_BACK_LEFT_CAMERA), new VisionIOPhotonVision(BACK_RIGHT_CAM_NAME, ROBOT_TO_BACK_RIGHT_CAMERA) };

	public static final double CAMERA_DEBOUNCE_TIME = 0.5;

	// TODO: What camera resolutions actually are these? Assuming they're high bc
	// 1080p is high
	// we never even use these why are they here
	public static final CameraResolution BACK_RESOLUTION = CameraResolution.HIGH_RESOLUTION;
	public static final CameraResolution FRONT_RESOLUTION = CameraResolution.HIGH_RESOLUTION;

	public static final int CAMERA_WIDTH = 1200;
	public static final int CAMERA_HEIGHT = 800;
	public static final Rotation2d CAMERA_FOV = Rotation2d.fromDegrees(84.47);
	public static final double CALIB_ERROR_AVG = 2;
	public static final double CALIB_ERROR_STD_DEV = 0.08;
	public static final int CAMERA_FPS = 40;
	public static final int AVG_LATENCY_MS = 40;
	public static final int LATENCY_STD_DEV_MS = 10;

	//April Tag Lists
	public static final Set<Short> SOURCE_TAGS = Set.of((short) 12, (short) 13, (short) 1, (short) 2);
	public static final Set<Short> RED_REEF_TAGS = Set.of((short) 6, (short) 7, (short) 8, (short) 9, (short) 10, (short) 11);
	public static final Set<Short> BLUE_REEF_TAGS = Set.of((short) 17, (short) 18, (short) 19, (short) 20, (short) 21, (short) 22);
	public static final Set<Short> APRIL_TAG_IGNORE = Set.of((short) 14, (short) 15, (short) 4, (short) 5);

	// AKIT TEMPLATE STUFF

	// Basic filtering thresholds
	public static final double maxAmbiguity = 0.3;
	public static final double maxZError = 0.75;
	public static final AngularVelocity MAX_ANGULAR_VELOCITY = DegreesPerSecond.of(200);

	// Standard deviation baselines, for 1 meter distance and 1 tag
	// (Adjusted automatically based on distance and # of tags)
	public static final double linearStdDevBaseline = 0.02; // Meters
	public static final double angularStdDevBaseline = 0.06; // Radians

	// Standard deviation multipliers for each camera
	// (Adjust to trust some cameras more than others)
	public static final double[] cameraStdDevFactors = new double[] {
		1.0, // Camera 0
		1.0, // Camera 1
	};

	// Multipliers to apply for MegaTag 2 observations
	public static final double linearStdDevMegatag2Factor = 0.5; // More stable than full 3D solve
	public static final double angularStdDevMegatag2Factor = Double.POSITIVE_INFINITY; // No rotation data available
}
