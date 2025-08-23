package frc.robot.Subsystems.Drive;

import org.littletonrobotics.junction.Logger;
import org.team7525.subsystem.Subsystem;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import static frc.robot.Subsystems.Drive.AutoAlignConstants.*;


public class AutoAlign extends Subsystem<AutoAlignStates>{
    private static AutoAlign instance;

    

    private final ProfiledPIDController rotationalController;
    private final ProfiledPIDController xtranslationalController;
    private final ProfiledPIDController ytranslationalController;

    private PosePair targetPose;
    private Pose2d goalPose;




   
    
    private AutoAlign() {
        super("AutoAlign", AutoAlignStates.OFF); 
        this.rotationalController = ROTATIONAL_CONTROLLER.get();
        this.xtranslationalController = XTRANSITIONAL_CONTROLLER.get();
        this.ytranslationalController = YTRANSITIONAL_CONTROLLER.get();


        targetPose = new PosePair(null, null);
        goalPose = new Pose2d(null, null);
        SmartDashboard.putData("Rotaitonal Cotroller", rotationalController);
		SmartDashboard.putData("Y Transisitional Controller", ytranslationalController);
        SmartDashboard.putData("X Transisitional Controller", xtranslationalController);
        
    
    }
    public static AutoAlign getInstance() {
        if (instance == null) {
            instance = new AutoAlign();
        }
        return instance;
    }
    
    @Override
    protected void runState() {
        targetPose = getState().getLocation();
        if (!DriverStation.getAlliance().isEmpty() && DriverStation.getAlliance().get() == Alliance.Red) {
            goalPose = targetPose.getRedPose();
        } else {
            goalPose = targetPose.getBluePose();
        }
        Pose2d currentPose = Drive.getInstance().getPose();
        if (!(AutoAlignStates.OFF == getState())) {
        Drive.getInstance().driverobotAutoAlign( 
            xtranslationalController.calculate(currentPose.getX(), goalPose.getX()),
            ytranslationalController.calculate(currentPose.getY(), goalPose.getY()),
            rotationalController.calculate(currentPose.getRotation().getDegrees(), goalPose.getRotation().getDegrees()));
        }

        Logger.recordOutput("Target Pose", goalPose);
    }

}
