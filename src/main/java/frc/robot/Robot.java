// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.littletonrobotics.junction.LoggedRobot;
import org.littletonrobotics.junction.Logger;
import org.littletonrobotics.junction.networktables.NT4Publisher;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.Subsystems.Manager.Manager;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
<<<<<<< HEAD
public class Robot extends TimedRobot {
<<<<<<< HEAD

	/**
	 * This function is run when the robot is first started up and should be used for any
	 * initialization code.
	 */
	public Robot() {
		manager = Manager.getInstance();
	}
=======
=======
public class Robot extends LoggedRobot {
>>>>>>> 6fca02c (changed code to work w akit mech sim)
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  public Robot() {
    manager = Manager.getInstance();
  }
  Manager manager;

  @Override
  public void robotInit() {
    Logger.addDataReceiver(new NT4Publisher());
    Logger.start();
  }

  @Override
  public void robotPeriodic() {
    manager.periodic();
  }
>>>>>>> 0b09382 (das)

	Manager manager;

	@Override
	public void robotPeriodic() {
		manager.periodic();
	}

	@Override
	public void autonomousInit() {}

	@Override
	public void autonomousPeriodic() {}

	@Override
	public void teleopInit() {}

	@Override
	public void teleopPeriodic() {}

	@Override
	public void disabledInit() {}

	@Override
	public void disabledPeriodic() {}

	@Override
	public void testInit() {}

	@Override
	public void testPeriodic() {}

	@Override
	public void simulationInit() {}

	@Override
	public void simulationPeriodic() {}
}
