package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
    private final VictorSP elevatorMotor = new VictorSP(0);

    public void setMotorVoltage(double power) {
        elevatorMotor.set(power);
    }
}
