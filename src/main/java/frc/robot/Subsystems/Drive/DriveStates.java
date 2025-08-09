package frc.robot.Subsystems.Drive;

import static frc.robot.Subsystems.Drive.DriveConstants.*;

import org.team7525.subsystem.SubsystemStates;

public enum DriveStates implements SubsystemStates {
<<<<<<< HEAD
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
=======
    DRIVE_SLOW( DRIVE_SLOW_ROTATION_MULTIPLER, DRIVE_SLOW_TRANSITIONAL_MULTIPLER),
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
>>>>>>> c0b9b56 (Co-authored-by: PotmanNob <PotmanNob@users.noreply.github.com>)
}
