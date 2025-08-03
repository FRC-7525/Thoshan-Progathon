package frc.robot.Subsystems.Climber;

import org.team7525.subsystem.Subsystem;


import static frc.robot.GlobalConstants.*;

public class Climber extends Subsystem<ClimberStates>{
    ClimberIO io;
    public Climber() {
        super("Climber", ClimberStates.IDLE);
                this.io = switch(ROBOT_MODE){
            case REAL -> new ClimberIONeo();
            case SIM -> new ClimberIOSim();
            case TESTING -> new ClimberIONeo();
        };
    }



    @Override
    protected void runState() {
        io.setMotorSpeed(getState().getMotorSpeed());
        io.logData();
    }
    
}
