package frc.robot.Subsystems.Drive;

import static frc.robot.Subsystems.Drive.DriveConstants.*;

import org.team7525.subsystem.SubsystemStates;

public enum DriveStates implements SubsystemStates {
	DRIVE_SLOW(DRIVE_SLOW_ROTATION_MULTIPLER, DRIVE_SLOW_TRANSITIONAL_MULTIPLER),
	DRIVE_NORMAL(DRIVE_NORMAL_ROTATION_MULTIPLER, DRIVE_NORMAL_TRANSITIONAL_MULTIPLER);

	double rotationMultiplier;
	double transationalMultiplier;

	private DriveStates(double rotationMultiplier, double transationalMultiplier) {
		this.rotationMultiplier = rotationMultiplier;
		this.transationalMultiplier = transationalMultiplier;
	}

	public double getRotationMultiplier() {
		return rotationMultiplier;
	}

	public double gettransationalMultiplier() {
		return transationalMultiplier;
	}
}
