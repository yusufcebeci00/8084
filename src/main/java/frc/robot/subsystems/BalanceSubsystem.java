package frc.robot.subsystems;

import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.MotorDriver;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
public class BalanceSubsystem {
  
  private final AHRS gyro = new AHRS(SPI.Port.kMXP); 
  public PIDController balancePID;
  

    

    public BalanceSubsystem() {
   
    }


    public void runBalance(double sol, double sag){
      double kP = 0.05;
      double error = 0 + gyro.getPitch();
      balancePID = new PIDController(0.15, 0.0, 0.0175);
      balancePID.setIntegratorRange(-0.01, 0.01);
      balancePID.setTolerance(2.5);
      balancePID.disableContinuousInput();
      double axis = 0;
      

      double balance = MathUtil.clamp(balancePID.calculate(gyro.getPitch() , axis), -0.8, 0.8);
    
      
      
        DriveConstants.drive.tankDrive(sol,  sag);
        //DriveConstants.drive.tankDrive(r_speed, f_speed);
      
      }


    
    }



