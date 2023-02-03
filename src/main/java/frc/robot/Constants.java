// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.networktables.DoubleArrayEntry;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Joystick;
import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import java.util.List;


public final class Constants {

  public static final class MotorsContants{
public static int gripper_motor = 7;
public static int arm_motor = 8;
public static int elongated_arm_motor = 9;


  }
public static final class MotorVeriablesContants{
  public static double cw_arm_motor_speed = 0.7;
  public static double ccw_arm_motor_speed = -0.5;
  public static double cw_elongated_arm_motor_speed = 1;
  public static double ccw_elongated_arm_motor_speed = -1;
  public static double motor_off = 0;

}
  public static class MotorDriver{
  
    public static VictorSP leftfrontmotor = new VictorSP(DriveConstants.LeftRearMotor);
    public static VictorSP leftrearmotor = new VictorSP(DriveConstants.LeftFrontMotor);
    public static VictorSP rightfrontmotor = new VictorSP(DriveConstants.RightRearMotor);
    public static VictorSP rightrearmotor = new VictorSP(DriveConstants.RightFrontMotor);
    public static MotorControllerGroup leftmotors = new MotorControllerGroup(leftfrontmotor,leftrearmotor);
    public static MotorControllerGroup rightmotors = new MotorControllerGroup(rightfrontmotor,rightrearmotor);
    public static DifferentialDrive differentialDrive = new DifferentialDrive(leftmotors, rightmotors);
    public static VictorSP clamp_motor = new VictorSP(MotorsContants.gripper_motor);
    public static  VictorSP arm_motor = new VictorSP(MotorsContants.arm_motor);
    public static VictorSP elongated_arm_motor = new VictorSP(MotorsContants.elongated_arm_motor);
   
    }


  public static final class DriveConstants {
    public static SlewRateLimiter m_speedLimiter = new SlewRateLimiter(1.5);
    public static SlewRateLimiter m_rotLimiter = new SlewRateLimiter(1.5);
    public static final int LeftRearMotor = 0;
    public static final int LeftFrontMotor = 1;
    public static final int RightRearMotor = 2;
    public static final int RightFrontMotor = 3;
    public static final boolean LeftRearMotorInverted = false;
    public static final boolean LeftFrontMotorInverted = false;
    public static final boolean RightRearMotorInverted = false;
    public static final boolean RightFrontMotorInverted = false;

    public static final double ksVolts = 0.22;
    public static final double kvVoltSecondsPerMeter = 1.98;
    public static final double kaVoltSecondsSquaredPerMeter = 0.2;
    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAccelerationMetersPerSecondSquared = 3;
    public static final double kRamseteB = 2;
    public static final double kPDriveVel = 8.5;
    public static final double kRamseteZeta = 0.7;
    public static final double kTrackwidthMeters = 0.69;
    public static final double kMaxAutoVoltage = 10;

    
    
    public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(kTrackwidthMeters);
    public  static  final  boolean kGyroReversed =  true ;

    public static final double kEncoderCPR = 4096;
    public static final double kWheelDiameterMeters = 0.1524;

    public static final double kTurnP = 0.94;
    public static final double kTurnI = 0.00;
    public static final double kTurnD = 0.04;
    public static final double kMinCommand = 0.07;

    public static final double kMaxTurnRateDegPerS = 120;
    public static final double kMaxTurnAccelerationDegPerSSquared = 300;
    public static final double kTurnToleranceDeg = 0.5;
    public static final double kTurnRateToleranceDegPerS = 8;


    public static final MotorControllerGroup left_drive = new MotorControllerGroup(MotorDriver.leftfrontmotor, MotorDriver.leftrearmotor);
    public static final MotorControllerGroup right_drive = new MotorControllerGroup(MotorDriver.rightfrontmotor, MotorDriver.rightrearmotor);
    public static final DifferentialDrive drive = new DifferentialDrive(left_drive, right_drive);
   }


  public static class JoysticksConstants {
    public static final int DriverController = 0;
    public static final int OperatorController = 1;
    public static final Joystick operatorcontroller = new Joystick(OperatorController);
    public static final Joystick drivercontroller = new Joystick(DriverController);
  }


  public static class PIDContants {

    public static class BalancePID {
    
     public static double kP = 1;
     public static double kI = 0;
     public static double kD = 0;
     
    
    
    }

  }
  

  
  
}
