package frc.robot;

public class GlobalConstants {
    
 public enum RobotMode {
		REAL,
		TESTING,
		SIM;
	}

	public static final RobotMode ROBOT_MODE = "Crash".equals(System.getenv("CI_NAME")) || !Robot.isReal() ? RobotMode.SIM : RobotMode.REAL;
}
