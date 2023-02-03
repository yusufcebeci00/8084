package frc.robot.subsystems;

import frc.robot.Constants.MotorDriver;

public class ArmSubsystem {
    


    

    public ArmSubsystem() {
   
    }


    public void runArm(double arm_speed){
        MotorDriver.arm_motor.set(arm_speed);
      }


    
    }




