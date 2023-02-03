package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.MotorVeriablesContants;
import frc.robot.subsystems.ArmSubsystem;

public class ArmCmd extends CommandBase{
    private final ArmSubsystem armSubsystem;
    private final double speed;
    
    public ArmCmd(ArmSubsystem armSubsystem, double speed) {
        this.armSubsystem = armSubsystem;
        this.speed = speed;
        addRequirements(armSubsystem);
    }


private void addRequirements(ArmSubsystem elevatorSubsystem) {
    }


@Override
public void initialize(){

}


@Override
public void execute() {
   armSubsystem.runArm(MotorVeriablesContants.cw_arm_motor_speed);
}
@Override
public void end(boolean interrupted) {
    armSubsystem.runArm(MotorVeriablesContants.motor_off);

}


}
