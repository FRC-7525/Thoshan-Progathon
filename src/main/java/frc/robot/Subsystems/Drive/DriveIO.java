package frc.robot.Subsystems.Drive;

public interface DriveIO {
    
    public void setTransistionalMultiplier(double transationalMultiplier);
    public void setRotationMultiplier(double rotationMultiplier);
    public void drivecommands(double xtranslation, double ytranslation, double rotation, boolean feldRealative);
    
    public void logdata();
}

