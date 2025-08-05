package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class GlobalConstants {

	public static final XboxController xboxController = new XboxController(0);

	public enum RobotMode {
		REAL,
		TESTING,
		SIM,
	}

	public static final RobotMode ROBOT_MODE = "Crash".equals(System.getenv("CI_NAME")) ||
		!Robot.isReal()
		? RobotMode.SIM
		: RobotMode.REAL;
}
