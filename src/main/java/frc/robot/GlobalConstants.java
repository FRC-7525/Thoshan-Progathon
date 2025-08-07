package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class GlobalConstants {
<<<<<<< HEAD

	public static final XboxController xboxController = new XboxController(0);

	public enum RobotMode {
=======
	public static final XboxController xboxController = new XboxController(0);
    public static final double UPDATE_PERIOD = 0.02;
 	public enum RobotMode {
>>>>>>> 0b09382 (das)
		REAL,
		TESTING,
		SIM,
	}

	public static final RobotMode ROBOT_MODE = "Crash".equals(System.getenv("CI_NAME")) ||
		!Robot.isReal()
		? RobotMode.SIM
		: RobotMode.REAL;
}
