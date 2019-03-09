/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.nerdherd.lib.logging.LoggableLambda;
import com.nerdherd.lib.logging.NerdyBadlog;
import com.nerdherd.lib.pneumatics.Piston;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  public static Piston piston;
  public static AnalogInput pressureSensor1;
  public static OI oi;
  public int kPistonPort1 = 3;
  public int kPistonPort2 = 4;

  double voltageToPressure = 0;

  public void reportToSmartDashboard() {
    double voltage = Robot.pressureSensor1.getVoltage();
    //double voltageToPressure = 250 * (voltage/4.460) - 25.0;
    voltageToPressure = 3.51336 * (voltage * voltage)+ 30.3481 * (voltage) + 2.62798;
    SmartDashboard.putNumber("Pressure Voltage", voltage);
    SmartDashboard.putNumber("Pressure", voltageToPressure);
  }
  public double voltageToPressure() {
    return voltageToPressure;
  }
  @Override
  public void robotInit() {
    piston = new Piston(kPistonPort1, kPistonPort2);
    pressureSensor1 = new AnalogInput(3);
    oi = new OI();

    LoggableLambda pressureSensor = new LoggableLambda("Pressure Sensor", () -> voltageToPressure());

    reportToSmartDashboard();
    NerdyBadlog.initAndLog("/media/sda1/", "Pressure_Logs", 0.02, pressureSensor);
  }

  @Override
  public void autonomousInit() {
    reportToSmartDashboard();
  }

  @Override
  public void autonomousPeriodic() {
    reportToSmartDashboard();
  }

  @Override
  public void teleopInit() {
    reportToSmartDashboard();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

    reportToSmartDashboard();
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
