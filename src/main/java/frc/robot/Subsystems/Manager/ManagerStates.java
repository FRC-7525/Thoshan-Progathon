package frc.robot.Subsystems.Manager;

<<<<<<< HEAD
import frc.robot.Subsystems.AmpBar.AmpbarStates;
import frc.robot.Subsystems.Climber.ClimberStates;
import frc.robot.Subsystems.Intake.IntakeStates;
import frc.robot.Subsystems.Shooter.ShooterStates;
import org.team7525.subsystem.SubsystemStates;

public enum ManagerStates implements SubsystemStates {
	AMPSCORING(
		"Amp Scoring",
		IntakeStates.IDLE,
		AmpbarStates.SCORING,
		ShooterStates.IDLE,
		ClimberStates.IDLE
	),
	CLIMBERSOUT(
		"Climbers out",
		IntakeStates.IDLE,
		AmpbarStates.IDLE,
		ShooterStates.IDLE,
		ClimberStates.SHOOTSOUT
	),
	CLIMBING(
		"Climbing",
		IntakeStates.IDLE,
		AmpbarStates.IDLE,
		ShooterStates.IDLE,
		ClimberStates.CLIMBING
	),
	PASSINGAMP(
		"Passing amp",
		IntakeStates.IDLE,
		AmpbarStates.LOADING,
		ShooterStates.PASSING,
		ClimberStates.IDLE
	),
	IDLE("Idle", IntakeStates.IDLE, AmpbarStates.IDLE, ShooterStates.IDLE, ClimberStates.IDLE),
	LOADINGSHOOTER(
		"Loading shooter",
		IntakeStates.PASSING,
		AmpbarStates.IDLE,
		ShooterStates.BEING_FED,
		ClimberStates.IDLE
	),
	SHOOTING(
		"Shooting",
		IntakeStates.IDLE,
		AmpbarStates.IDLE,
		ShooterStates.SHOOTING,
		ClimberStates.IDLE
	),
	INTAKING(
		"Intaking",
		IntakeStates.INTAKING,
		AmpbarStates.IDLE,
		ShooterStates.IDLE,
		ClimberStates.IDLE
	);

	private String stateString;
	private IntakeStates intakestate;
	private AmpbarStates ampbarState;
	private ShooterStates shooterstate;
	private ClimberStates climberState;

	private ManagerStates(
		String stateString,
		IntakeStates intakestate,
		AmpbarStates ampbarState,
		ShooterStates shooterstate,
		ClimberStates climberState
	) {
		this.stateString = stateString;
		this.intakestate = intakestate;
		this.ampbarState = ampbarState;
		this.shooterstate = shooterstate;
		this.climberState = climberState;
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
=======
import org.team7525.subsystem.SubsystemStates;
import frc.robot.Subsystems.Intake.IntakeStates;
import frc.robot.Subsystems.Shooter.ShooterStates;
import frc.robot.Subsystems.Climber.ClimberStates;
import frc.robot.Subsystems.AmpBar.AmpbarStates;

public enum ManagerStates implements SubsystemStates{
    AMPSCORING("Amp Scoring",IntakeStates.IDLE, AmpbarStates.SCORING, ShooterStates.IDLE, ClimberStates.IDLE),
    CLIMBERSOUT("Climbers out",IntakeStates.IDLE, AmpbarStates.IDLE, ShooterStates.IDLE, ClimberStates.SHOOTSOUT),
    CLIMBING("Climbing",IntakeStates.IDLE, AmpbarStates.IDLE, ShooterStates.IDLE, ClimberStates.CLIMBING),
    PASSINGAMP("Passing amp",IntakeStates.IDLE, AmpbarStates.LOADING, ShooterStates.PASSING, ClimberStates.IDLE),
    IDLE("Idle",IntakeStates.IDLE, AmpbarStates.IDLE, ShooterStates.IDLE, ClimberStates.IDLE),
    LOADINGSHOOTER("Loading shooter",IntakeStates.PASSING, AmpbarStates.IDLE, ShooterStates.BEING_FED, ClimberStates.IDLE),
    SHOOTING("Shooting",IntakeStates.IDLE, AmpbarStates.IDLE, ShooterStates.SHOOTING, ClimberStates.IDLE),
    INTAKING("Intaking",IntakeStates.INTAKING, AmpbarStates.IDLE, ShooterStates.IDLE, ClimberStates.IDLE),
	

    private String stateString;
    private IntakeStates intakestate;
    private AmpbarStates ampbarState;
    private ShooterStates shooterstate;
    private ClimberStates climberState;


    private ManagerStates(String stateString, IntakeStates intakestate,AmpbarStates ampbarState, ShooterStates shooterstate,ClimberStates climberState) {
        this.stateString = stateString;
        this.intakestate = intakestate;
        this.ampbarState = ampbarState;
        this.shooterstate = shooterstate;
        this.climberState = climberState;
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


>>>>>>> 0b09382 (das)
}
