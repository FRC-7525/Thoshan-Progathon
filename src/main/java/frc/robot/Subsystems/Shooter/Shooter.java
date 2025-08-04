package frc.robot.Subsystems.Shooter;

import org.team7525.subsystem.Subsystem;
import static frc.robot.GlobalConstants.ROBOT_MODE;

public class Shooter extends Subsystem<ShooterStates> {

    ShooterIO io;
    private static Shooter instance;
    private Shooter() {
        super("Shooter", ShooterStates.IDLE);
        this.io = switch(ROBOT_MODE){
            case REAL -> new ShooterIONeo();
            case SIM -> new ShooterIOSim();
            case TESTING -> new ShooterIONeo();
        };
            
    }
    public static Shooter getInstance() {
		if (instance == null) {
			instance = new Shooter();
		}
		return instance;
	}

    @Override
    protected void runState() {
        io.setWheelSpeed(getState().getWheelSpeed());
        io.logData();
    }
    
}
