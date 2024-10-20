package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainFalconFX extends SubsystemBase {
    TalonFX otherMotor = new TalonFX(51);

    public void setOtherPower(double power) {
        otherMotor.set(power);
    }

    public void driveFX() {
        setOtherPower(0.7);
    }

    public void otherMoterStop() {
        setOtherPower(0);
    }

    public void getIncoder() {

    }

    public Command otherMotorCommand() {
        return Commands.runEnd(this::driveFX, () -> otherMoterStop(), this);
    }
}
