package frc.robot.Subsystems.Intake;

import static edu.wpi.first.units.Units.Degree;
import static edu.wpi.first.units.Units.RotationsPerSecond;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

public class IntakeConstant {
    public static final AngularVelocity IDLE_SPEED = RotationsPerSecond.of(0);
    public static final AngularVelocity INTAKING_SPEED = RotationsPerSecond.of(-55);
    public static final AngularVelocity PASSING_SPEED = RotationsPerSecond.of(55);

    public static final Angle IDLE_ANGLE = Degree.of(0);
    public static final Angle INTAKING_ANGLE = Degree.of(180);
    public static final Angle PASSING_ANGLE = Degree.of(0);

}
