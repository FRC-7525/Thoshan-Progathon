package frc.robot.Subsystems.AmpBar;

import static frc.robot.GlobalConstants.*;

import org.team7525.subsystem.Subsystem;

<<<<<<< HEAD
public class AmpBar extends Subsystem<AmpbarStates> {

	AmpBarIO io;
	private static AmpBar instance;

	private AmpBar() {
		super("AmpBar", AmpbarStates.IDLE);
		this.io = switch (ROBOT_MODE) {
			case REAL -> new AmpBarIONeo();
			case SIM -> new AmpBarIOSim();
			case TESTING -> new AmpBarIONeo();
		};
	}

	public static AmpBar getInstance() {
		if (instance == null) {
			instance = new AmpBar();
		}
		return instance;
	}

	@Override
	protected void runState() {
		io.setPosition(getState().getPosition());
		io.setWheelSpeed(getState().getwheelSpeed());
		io.logData();
	}
=======
public class AmpBar extends Subsystem<AmpbarStates>{
    AmpBarIO io;
    public AmpBar() {
        super("AmpBar", AmpbarStates.IDLE);
        this.io = switch(ROBOT_MODE) {
            case REAL -> new AmpBarIONeo();
            case SIM -> new AmpBarIOSim();
            case TESTING -> new AmpBarIONeo();
        };
    }
    @Override
    protected void runState() {
        io.setPosition(getState().getPosition());
        io.setWheelSpeed(getState().getwheelSpeed());
        io.logData();
    }
>>>>>>> c0b9b56 (Co-authored-by: PotmanNob <PotmanNob@users.noreply.github.com>)
}
