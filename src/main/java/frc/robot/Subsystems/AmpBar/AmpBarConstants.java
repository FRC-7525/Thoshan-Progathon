package frc.robot.Subsystems.AmpBar;

import static edu.wpi.first.units.Units.Degree;
import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.GlobalConstants.ROBOT_MODE;

<<<<<<< HEAD
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import java.util.function.Supplier;

public class AmpBarConstants {

	public static final Angle SCORRING_POSITION = Degree.of(90);
	public static final Angle IDLE_POSITION = Degree.of(0);
	public static final Angle LOADING_POSITION = Degree.of(90);

	public static final AngularVelocity SCORRINGT_VELOCITY = RotationsPerSecond.of(60);
	public static final AngularVelocity IDLE_VELOCITY = RotationsPerSecond.of(0);
	public static final AngularVelocity LOADING_VELOCITY = RotationsPerSecond.of(55);

	public static final int WHEEL_MOTOR_DEVICE_ID = 1;
	public static final int PIVOT_MOTOR_DEVICE_ID = 2;

	public static final Supplier<PIDController> WHEEL_CONTROLLER = () ->
		switch (ROBOT_MODE) {
			case REAL -> new PIDController(0.1, 0, 0);
			case SIM -> new PIDController(0.1, 0, 0);
			case TESTING -> new PIDController(0.1, 0, 0);
		};
	public static final Supplier<PIDController> PIVOT_CONTROLLER = () ->
		switch (ROBOT_MODE) {
			case REAL -> new PIDController(0.1, 0, 0);
			case SIM -> new PIDController(0.1, 0, 0);
			case TESTING -> new PIDController(0.1, 0, 0);
		};
=======
import java.util.function.Supplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

public class AmpBarConstants {
    public final static Angle SCORRING_POSITION = Degree.of(90);
    public final static Angle IDLE_POSITION = Degree.of(0);
    public final static Angle LOADING_POSITION = Degree.of(90);

    public final static AngularVelocity SCORRINGT_VELOCITY = RotationsPerSecond.of(60);
    public final static AngularVelocity IDLE_VELOCITY = RotationsPerSecond.of(0);
    public final static AngularVelocity LOADING_VELOCITY = RotationsPerSecond.of(55);

    public final static int WHEEL_MOTOR_DEVICE_ID = 1;
    public final static int PIVOT_MOTOR_DEVICE_ID = 2;

    public static final Supplier<PIDController> WHEEL_CONTROLLER = () -> 
        switch (ROBOT_MODE) {
            case REAL -> new PIDController(0.1, 0, 0);
            case SIM -> new PIDController(0.1, 0, 0);
            case TESTING -> new PIDController(0.1, 0, 0);        
    };
    public static final Supplier<PIDController> PIVOT_CONTROLLER = () -> 
        switch (ROBOT_MODE) {
            case REAL -> new PIDController(0.1, 0, 0);
            case SIM -> new PIDController(0.1, 0, 0);
            case TESTING -> new PIDController(0.1, 0, 0);        
    };
>>>>>>> c0b9b56 (Co-authored-by: PotmanNob <PotmanNob@users.noreply.github.com>)
}
