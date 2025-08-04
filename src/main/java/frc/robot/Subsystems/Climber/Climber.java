package frc.robot.Subsystems.Climber;

import org.team7525.subsystem.Subsystem;


import static frc.robot.GlobalConstants.*;

public class Climber extends Subsystem<ClimberStates>{
    ClimberIO io;
    private static Climber instance;
    private Climber() {
        super("Climber", ClimberStates.IDLE);
                this.io = switch(ROBOT_MODE){
            case REAL -> new ClimberIONeo();
            case SIM -> new ClimberIOSim();
            case TESTING -> new ClimberIONeo();
        };
    }
    public static Climber getInstance() {
		if (instance == null) {
			instance = new Climber();
		}
		return instance;
	}


    @Override
    protected void runState() {
        io.setMotorSpeed(getState().getMotorSpeed());
        io.logData();
    }
    
}
