package frc.robot.Subsystems.Drive;

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
    private final ProfiledPIDController translationalController;

    private PosePair targetPose;
    private Pose2d goalPose;




   
    
    private AutoAlign() {
        super("AutoAlign", AutoAlignStates.OFF); 
        this.rotationalController = ROTATIONAL_CONTROLLER.get();
        this.translationalController = TRANSITIONAL_CONTROLLER.get();


        targetPose = new PosePair(null, null);
        goalPose = new Pose2d(null, null);
        SmartDashboard.putData("Rotaitonal Cotroller", rotationalController);
		SmartDashboard.putData("Transisitional Controller", translationalController);
    
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
        if (DriverStation.getAlliance().get() == Alliance.Red) {
            goalPose = targetPose.getRedPose();
        } else {
            goalPose = targetPose.getBluePose();
        }
        Pose2d currentPose = Drive.getInstance().getPose();
        if (!(AutoAlignStates.OFF == getState())) {
        Drive.getInstance().driverobotAutoAlign( 
            translationalController.calculate(currentPose.getX(), goalPose.getX()),
            translationalController.calculate(currentPose.getY(), goalPose.getY()),
            rotationalController.calculate(currentPose.getRotation().getDegrees(), goalPose.getRotation().getDegrees()));
        }
    }

}
