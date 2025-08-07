<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 3d33c3b (Done with intake subsystem)
package frc.robot.Subsystems.Intake;

import static edu.wpi.first.units.Units.Degree;
import static edu.wpi.first.units.Units.RotationsPerSecond;
<<<<<<< HEAD
import static frc.robot.GlobalConstants.*;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import java.util.function.Supplier;

public class IntakeConstant {

	public static final AngularVelocity IDLE_SPEED = RotationsPerSecond.of(0);
	public static final AngularVelocity INTAKING_SPEED = RotationsPerSecond.of(-55);
	public static final AngularVelocity PASSING_SPEED = RotationsPerSecond.of(55);

	public static final Angle IDLE_ANGLE = Degree.of(0);
	public static final Angle INTAKING_ANGLE = Degree.of(180);
	public static final Angle PASSING_ANGLE = Degree.of(0);

	public static final int WHEEL_MOTOR_DEVICE_ID = 15;
	public static final int PIVOT_MOTOR_DEVICEID = 16;

	public static final Supplier<PIDController> PIVOT_CONTROLLER = () ->
		switch (ROBOT_MODE) {
			case REAL -> new PIDController(0.1, 0, 0);
			case SIM -> new PIDController(0.1, 0, 0);
			case TESTING -> new PIDController(0.1, 0, 0);
		};
	public static final Supplier<PIDController> WHEEL_CONTROLLER = () ->
		switch (ROBOT_MODE) {
			case REAL -> new PIDController(0.1, 0, 0);
			case SIM -> new PIDController(0.1, 0, 0);
			case TESTING -> new PIDController(0.1, 0, 0);
		};
=======
public class IntakeConstant {
    
>>>>>>> 9872d74 (ghjg)
=======

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

import static frc.robot.GlobalConstants.*;

import java.util.function.Supplier;

public class IntakeConstant {
    public static final AngularVelocity IDLE_SPEED = RotationsPerSecond.of(0);
    public static final AngularVelocity INTAKING_SPEED = RotationsPerSecond.of(-55);
    public static final AngularVelocity PASSING_SPEED = RotationsPerSecond.of(55);

    public static final Angle IDLE_ANGLE = Degree.of(0);
    public static final Angle INTAKING_ANGLE = Degree.of(-233);
    public static final Angle PASSING_ANGLE = Degree.of(0);

<<<<<<< HEAD
>>>>>>> 3d33c3b (Done with intake subsystem)
=======
    public static final int WHEEL_MOTOR_DEVICE_ID = 15;
    public static final int PIVOT_MOTOR_DEVICEID = 16;

    public static final Supplier<PIDController> PIVOT_CONTROLLER = () -> 
    switch (ROBOT_MODE) {
        case REAL -> new PIDController(0.1, 0, 0);
        case SIM -> new PIDController(0.1, 0, 0);
        case TESTING -> new PIDController(0.1, 0, 0);        
    };
    public static final Supplier<PIDController> WHEEL_CONTROLLER = () -> 
    switch (ROBOT_MODE) {
        case REAL -> new PIDController(0.1, 0, 0);
        case SIM -> new PIDController(0.1, 0, 0);
        case TESTING -> new PIDController(0.1, 0, 0);        
    };

<<<<<<< HEAD
>>>>>>> c0b9b56 (Co-authored-by: PotmanNob <PotmanNob@users.noreply.github.com>)
=======
	public static final Translation3d ZEROED_PIVOT_TRANSLATION = new Translation3d(
		0.31,
		0,
		0.24
	);
>>>>>>> 6fca02c (changed code to work w akit mech sim)
}
