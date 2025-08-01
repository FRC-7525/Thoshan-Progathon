package frc.robot.Subsystems.Shooter;

import static edu.wpi.first.units.Units.RotationsPerSecond;

import edu.wpi.first.units.measure.AngularVelocity;

public class ShooterConstant {
    public static final AngularVelocity IDLE_SPEED = RotationsPerSecond.of(0);
    public static final AngularVelocity PASSING_SPEED = RotationsPerSecond.of(10);
    public static final AngularVelocity SHOOTING_SPEED = RotationsPerSecond.of(55);
    public static final AngularVelocity BEING_FED_SPEED = RotationsPerSecond.of(10);
}
