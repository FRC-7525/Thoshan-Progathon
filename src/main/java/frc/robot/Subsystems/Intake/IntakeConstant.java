package frc.robot.Subsystems.Intake;

import static edu.wpi.first.units.Units.Degree;
import static edu.wpi.first.units.Units.RotationsPerSecond;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

import static frc.robot.GlobalConstants.*;

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

}
