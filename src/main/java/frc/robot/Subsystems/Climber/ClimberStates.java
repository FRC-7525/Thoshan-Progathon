package frc.robot.Subsystems.Climber;

<<<<<<< HEAD
import static frc.robot.Subsystems.Climber.ClimberConstants.*;

import edu.wpi.first.units.measure.AngularVelocity;
import org.team7525.subsystem.SubsystemStates;

public enum ClimberStates implements SubsystemStates {
	CLIMBING(CLIMBING_MOTOR_SPEED),
	IDLE(IDLE_MOTOR_SPEED),
	SHOOTSOUT(SHOOT_OUT_MOTOR_SPEED);

	private AngularVelocity motorSpeed;

	private ClimberStates(AngularVelocity motorSpeed) {
		this.motorSpeed = motorSpeed;
	}

	public AngularVelocity getMotorSpeed() {
		return motorSpeed;
	}
=======
import edu.wpi.first.units.measure.AngularVelocity;
import static frc.robot.Subsystems.Climber.ClimberConstants.*;

import org.team7525.subsystem.SubsystemStates;

public enum ClimberStates implements SubsystemStates {
    CLIMBING(CLIMBING_MOTOR_SPEED),
    IDLE(IDLE_MOTOR_SPEED),
    SHOOTSOUT(SHOOT_OUT_MOTOR_SPEED);


    private AngularVelocity motorSpeed;
    private ClimberStates(AngularVelocity motorSpeed) {
        this.motorSpeed = motorSpeed;
    }

    public AngularVelocity getMotorSpeed() {
        return motorSpeed;
    }
>>>>>>> 03ccaa8 (ffdfsfd)
}
