package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.MotorVeriablesContants;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.BalanceSubsystem;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
public class BalanceCmd extends CommandBase{
    private final BalanceSubsystem a_balance;
   
    private final AHRS gyro = new AHRS(SPI.Port.kMXP); 

    public BalanceCmd(BalanceSubsystem balanceSubsystem) {
        this.a_balance = balanceSubsystem;
       

        addRequirements(balanceSubsystem);
    }





private void addRequirements(BalanceSubsystem balanceSubsystem) {
    }


@Override
public void initialize(){
System.out.println("Balance Command Started!");
}


@Override
public void execute() {
    double kP = 0.07;
      double error = 0 + gyro.getPitch();
   a_balance.runBalance(kP * error,  -kP * error);
}
@Override
public void end(boolean interrupted) {
    a_balance.runBalance(0,0);

}


}
