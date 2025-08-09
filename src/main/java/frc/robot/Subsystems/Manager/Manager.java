package frc.robot.Subsystems.Manager;

import static frc.robot.GlobalConstants.*;

import frc.robot.Subsystems.AmpBar.AmpBar;
import frc.robot.Subsystems.Climber.Climber;
import frc.robot.Subsystems.Intake.Intake;
import frc.robot.Subsystems.Shooter.Shooter;
import frc.robot.Subsystems.Drive.Drive;
import org.littletonrobotics.junction.Logger;
import org.team7525.subsystem.Subsystem;

public class Manager extends Subsystem<ManagerStates> {

	private static Manager instance;

	private Manager() {
		super("Manager", ManagerStates.IDLE);
		// Amp Scorring
		addTrigger(ManagerStates.IDLE, ManagerStates.PASSINGAMP, () ->
			xboxController.getYButtonPressed()
		);
		addTrigger(ManagerStates.PASSINGAMP, ManagerStates.AMPSCORING, () ->
			xboxController.getYButtonPressed()
		);
		addTrigger(ManagerStates.AMPSCORING, ManagerStates.IDLE, () ->
			xboxController.getYButtonPressed()
		);

		// Climbing
		addTrigger(
			ManagerStates.IDLE,
			ManagerStates.CLIMBERSOUT,
			() -> xboxController.getPOV() == 0
		);
		addTrigger(
			ManagerStates.CLIMBERSOUT,
			ManagerStates.CLIMBING,
			() -> xboxController.getPOV() == 180
		);

		// Intaking
		addTrigger(ManagerStates.IDLE, ManagerStates.INTAKING, () ->
			xboxController.getAButtonPressed()
		);
		addTrigger(ManagerStates.INTAKING, ManagerStates.IDLE, () ->
			xboxController.getAButtonPressed()
		);

		// Shooting
		addTrigger(ManagerStates.IDLE, ManagerStates.LOADINGSHOOTER, () ->
			xboxController.getXButtonPressed()
		);
		addTrigger(ManagerStates.LOADINGSHOOTER, ManagerStates.SHOOTING, () ->
			xboxController.getXButtonPressed()
		);
		addTrigger(ManagerStates.SHOOTING, ManagerStates.IDLE, () ->
			xboxController.getXButtonPressed()
		);
	}

	public static Manager getInstance() {
		if (instance == null) {
			instance = new Manager();
		}
		return instance;
	}

	@Override
	protected void runState() {
		Intake.getInstance().setState(getState().getIntakeState());
		Shooter.getInstance().setState(getState().getShooterState());
		Climber.getInstance().setState(getState().getClimberState());
		AmpBar.getInstance().setState(getState().getAmpBarState());

		Logger.recordOutput("Manger/ State tine", getStateTime());
		Logger.recordOutput("Manager/ State String", getState().getStateString());

		Intake.getInstance().periodic();
		Shooter.getInstance().periodic();
		Climber.getInstance().periodic();
		AmpBar.getInstance().periodic();
		Drive.getInstance().periodic();
	}
}
