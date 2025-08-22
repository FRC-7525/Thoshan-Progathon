package frc.robot.Subsystems.Manager;

import frc.robot.Subsystems.AmpBar.AmpbarStates;
import frc.robot.Subsystems.Climber.ClimberStates;
import frc.robot.Subsystems.Drive.AutoAlignStates;
import frc.robot.Subsystems.Intake.IntakeStates;
import frc.robot.Subsystems.Shooter.ShooterStates;
import org.team7525.subsystem.SubsystemStates;

public enum ManagerStates implements SubsystemStates {
	AMPSCORING(
		"Amp Scoring",
		IntakeStates.IDLE,
		AmpbarStates.SCORING,
		ShooterStates.IDLE,
		ClimberStates.IDLE,
		AutoAlignStates.OFF
	),
	CLIMBERSOUT(
		"Climbers out",
		IntakeStates.IDLE,
		AmpbarStates.IDLE,
		ShooterStates.IDLE,
		ClimberStates.SHOOTSOUT,
		AutoAlignStates.OFF
	),
	CLIMBING(
		"Climbing",
		IntakeStates.IDLE,
		AmpbarStates.IDLE,
		ShooterStates.IDLE,
		ClimberStates.CLIMBING,
		AutoAlignStates.OFF
	),
	PASSINGAMP(
		"Passing amp",
		IntakeStates.IDLE,
		AmpbarStates.LOADING,
		ShooterStates.PASSING,
		ClimberStates.IDLE,
		AutoAlignStates.OFF
	),
	IDLE("Idle", IntakeStates.IDLE, AmpbarStates.IDLE, ShooterStates.IDLE, ClimberStates.IDLE, AutoAlignStates.OFF
),
	LOADINGSHOOTER(
		"Loading shooter",
		IntakeStates.PASSING,
		AmpbarStates.IDLE,
		ShooterStates.BEING_FED,
		ClimberStates.IDLE,
		AutoAlignStates.OFF
	),
	SHOOTING(
		"Shooting",
		IntakeStates.IDLE,
		AmpbarStates.IDLE,
		ShooterStates.SHOOTING,
		ClimberStates.IDLE,
		AutoAlignStates.OFF
	),
	INTAKING(
		"Intaking",
		IntakeStates.INTAKING,
		AmpbarStates.IDLE,
		ShooterStates.IDLE,
		ClimberStates.IDLE,
		AutoAlignStates.OFF
	),
	ALIGNTOSOURCE(
		"Align to source",
		IntakeStates.IDLE,
		AmpbarStates.IDLE,
		ShooterStates.IDLE,
		ClimberStates.IDLE,
		AutoAlignStates.toSource
	),
	ALIGNTOSPEAKER(
		"Align to Speaker",
		IntakeStates.IDLE,
		AmpbarStates.IDLE,
		ShooterStates.IDLE,
		ClimberStates.IDLE,
		AutoAlignStates.toSpeaker
	),
	ALIGNTOAMP(
		"Align to AMP",
		IntakeStates.IDLE,
		AmpbarStates.IDLE,
		ShooterStates.IDLE,
		ClimberStates.IDLE,
		AutoAlignStates.toAmp
	
	),
	ALIGNTOAMPBAR(
		"Align to Amp Bar",
		IntakeStates.IDLE,
		AmpbarStates.IDLE,
		ShooterStates.IDLE,
		ClimberStates.IDLE,
		AutoAlignStates.toAmpBar
	);


	private String stateString;
	private IntakeStates intakestate;
	private AmpbarStates ampbarState;
	private ShooterStates shooterstate;
	private ClimberStates climberState;
	private AutoAlignStates autoAlignStates;

	private ManagerStates(
		String stateString,
		IntakeStates intakestate,
		AmpbarStates ampbarState,
		ShooterStates shooterstate,
		ClimberStates climberState,
		AutoAlignStates AutoAlignState
	) {
		this.stateString = stateString;
		this.intakestate = intakestate;
		this.ampbarState = ampbarState;
		this.shooterstate = shooterstate;
		this.climberState = climberState;
		this.autoAlignStates = autoAlignStates;
	}

	public String getStateString() {
		return stateString;
	}

	public IntakeStates getIntakeState() {
		return intakestate;
	}

	public AmpbarStates getAmpBarState() {
		return ampbarState;
	}

	public ShooterStates getShooterState() {
		return shooterstate;
	}

	public ClimberStates getClimberState() {
		return climberState;
	}
	public AutoAlignStates AutoAlignState() {
		return autoAlignStates;
	}
}
