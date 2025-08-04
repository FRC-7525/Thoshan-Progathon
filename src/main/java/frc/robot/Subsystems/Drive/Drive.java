package frc.robot.Subsystems.Drive;

import static frc.robot.GlobalConstants.ROBOT_MODE;

<<<<<<< HEAD
import edu.wpi.first.wpilibj.XboxController;
import org.team7525.subsystem.Subsystem;

public class Drive extends Subsystem<DriveStates> {

	XboxController XboxController = new XboxController(0);
	DriveIO io;
	private static Drive instance;

	private Drive() {
		super("Drive", DriveStates.DRIVE_NORMAL);
		this.io = switch (ROBOT_MODE) {
			case REAL -> new DriveIOReal();
			case SIM -> new DriveIOSim();
			case TESTING -> new DriveIOReal();
		};
	}

	public static Drive getInstance() {
		if (instance == null) {
			instance = new Drive();
		}
		return instance;
	}

	@Override
	protected void runState() {
		io.setTransistionalMultiplier(getState().transationalMultiplier);
		io.setRotationMultiplier(getState().rotationMultiplier);
		io.drivecommands(
			XboxController.getLeftX(),
			XboxController.getLeftY(),
			XboxController.getRightX(),
			false
		);
		io.logdata();
	}
=======

import org.team7525.subsystem.Subsystem;



import edu.wpi.first.wpilibj.XboxController;


public class Drive extends Subsystem<DriveStates> {
    XboxController XboxController = new XboxController(0); 
    DriveIO io;
    private static Drive instance;


    private Drive() {
        super("Drive", DriveStates.DRIVE_NORMAL);
        this.io = switch (ROBOT_MODE) {
            case REAL -> new DriveIOReal();
            case SIM -> new DriveIOSim();
            case TESTING -> new DriveIOReal();   
        };
    }
    public static Drive getInstance() {
		if (instance == null) {
			instance = new Drive();
		}
		return instance;
	}
    @Override
    protected void runState() {
        io.setTransistionalMultiplier(getState().transationalMultiplier);
        io.setRotationMultiplier(getState().rotationMultiplier);
        io.drivecommands(XboxController.getLeftX(), XboxController.getLeftY(), XboxController.getRightX(), false);
        io.logdata();
    }
>>>>>>> c0b9b56 (Co-authored-by: PotmanNob <PotmanNob@users.noreply.github.com>)
}
