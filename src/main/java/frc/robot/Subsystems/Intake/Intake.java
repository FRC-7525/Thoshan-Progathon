package frc.robot.Subsystems.Intake;

import static frc.robot.GlobalConstants.ROBOT_MODE;


import org.team7525.subsystem.Subsystem;

public class Intake extends Subsystem<IntakeStates> {
    IntakeIO io;
    public Intake() {
        super("Intake", IntakeStates.IDLE);
        this.io = switch(ROBOT_MODE){
            case REAL -> new IntakeIONeo();
            case SIM -> new IntakeIOSim();
            case TESTING -> new IntakeIONeo();
        };
    }
    @Override
    protected void runState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'runState'");
    }
}
