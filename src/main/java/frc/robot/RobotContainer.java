
package frc.robot;

import frc.robot.Constants.JoysticksConstants;
import frc.robot.commands.ArmCmd;
import frc.robot.commands.BalanceCmd;
import frc.robot.subsystems.BalanceSubsystem;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;

public class RobotContainer {

  
private static double balance;
private final ArmSubsystem elevatorSubsystem = new ArmSubsystem();
private BalanceSubsystem balanceSubsystem = new BalanceSubsystem();





  public static final Joystick drivercontroller = new Joystick(JoysticksConstants.DriverController);
  public static final Joystick operatorcontroller = new Joystick(JoysticksConstants.OperatorController);
  private final AHRS gyro = new AHRS(SPI.Port.kMXP); 
  public PIDController balancePID;
  public double kP = 0.5;
  public double error = 0 + gyro.getPitch();

  public RobotContainer() {
    
gyro.calibrate();
    
      balancePID = new PIDController(0.15, 0.0, 0.0175);
      balancePID.setIntegratorRange(-0.01, 0.01);
      balancePID.setTolerance(2.5);
      balancePID.disableContinuousInput();
      double axis = 0;
      

      balance = MathUtil.clamp(balancePID.calculate(gyro.getPitch() , axis), -0.8, 0.8);
    configureBindings();
  
   
  
  
  }

  
  
  
  
  
  






  private void configureBindings() {

    
    new JoystickButton(operatorcontroller, 1).whileTrue(new BalanceCmd(balanceSubsystem));

  }

  
  
  
  
 
}
