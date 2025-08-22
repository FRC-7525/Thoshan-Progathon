package frc.robot.Subsystems.Drive;




import java.util.function.Supplier;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import frc.robot.GlobalConstants;


public class AutoAlignConstants {
    public static final Supplier<ProfiledPIDController> ROTATIONAL_CONTROLLER = () ->
        switch (GlobalConstants.ROBOT_MODE) {
            case REAL -> new ProfiledPIDController(20, 0, 1, new TrapezoidProfile.Constraints(Math.PI * 2, Math.PI * 2), 0.02);
			case SIM -> new ProfiledPIDController(20, 0, 0, new TrapezoidProfile.Constraints(Math.PI * 2, Math.PI * 2), 0.02);
			default -> new ProfiledPIDController(3, 0, 0, new TrapezoidProfile.Constraints(Math.PI * 2, Math.PI * 2), 0.02);
        };
    public static final Supplier<ProfiledPIDController> TRANSITIONAL_CONTROLLER = () -> 
        switch (GlobalConstants.ROBOT_MODE) {
            case REAL -> new ProfiledPIDController(25, 0, 0, new TrapezoidProfile.Constraints(Units.feetToMeters(9), 7), 0.02);
			case SIM -> new ProfiledPIDController(20, 1, 0, new TrapezoidProfile.Constraints(Units.feetToMeters(9), 7), 0.02);
			default -> new ProfiledPIDController(20, 1, 0, new TrapezoidProfile.Constraints(Units.feetToMeters(9), 7), 0.02);
        };
            



}