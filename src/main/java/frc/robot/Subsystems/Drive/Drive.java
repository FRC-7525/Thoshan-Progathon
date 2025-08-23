package frc.robot.Subsystems.Drive;

import static frc.robot.GlobalConstants.ROBOT_MODE;

import edu.wpi.first.math.Matrix;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.numbers.N1;
import edu.wpi.first.math.numbers.N3;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.GlobalConstants.RobotMode;

import org.team7525.subsystem.Subsystem;

import com.ctre.phoenix6.Utils;

public class Drive extends Subsystem<DriveStates> {

	XboxController XboxController = new XboxController(0);
	static DriveIO io;
		private static Drive instance;
	
	private Drive() {
		super("Drive", DriveStates.DRIVE_NORMAL);
		this.io = switch (ROBOT_MODE) {
			case REAL -> new DriveIOReal();
			case SIM -> new DriveIOSim();
			case TESTING -> new DriveIOReal();
			};
		}
	
	public static Drive getInstance() {
			if (instance == null) {
				instance = new Drive();
			}
			return instance;
		}
		public void addVisionMeasurement(Pose2d visionPose, double timestamp, Matrix<N3, N1> visionMeasurementStdDevs) {
			if (ROBOT_MODE == RobotMode.REAL) {
				DriveIO.addVisionMeasurement(visionPose, Utils.fpgaToCurrentTime(timestamp), visionMeasurementStdDevs);
			} else {
				DriveIO.addVisionMeasurement(visionPose, timestamp, visionMeasurementStdDevs);
			}
		}
	public ChassisSpeeds getRobotRelativeSpeeds() {
		return io.getRelativSpeeds();
		}
	public Pose2d getPose() {
		return io.getPose();
	}
	public void driveRobot() {
		io.drivecommands(
			XboxController.getLeftX(),
			XboxController.getLeftY(),
			XboxController.getRightX(),
			true
			);
	}
	public void driverobotAutoAlign(double x, double y, double rotation) {
		io.driveAutoAlign( x, y, rotation);
	}

	@Override
	protected void runState() {
		io.setTransistionalMultiplier(getState().transationalMultiplier);
		io.setRotationMultiplier(getState().rotationMultiplier);
		if (AutoAlignStates.OFF == AutoAlign.getInstance().getState()) {
		io.drivecommands(
			XboxController.getLeftX(),
			XboxController.getLeftY(),
			XboxController.getRightX(),
			false
		);
		}
		io.logdata();
	}


}
