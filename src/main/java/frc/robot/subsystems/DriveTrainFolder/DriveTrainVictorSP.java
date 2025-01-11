package frc.robot.subsystems.DriveTrainFolder;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainVictorSP extends SubsystemBase {
    VictorSP frmotor = new VictorSP(5);
    VictorSP brmotor = new VictorSP(4);
    VictorSP flmotor1 = new VictorSP(6);
    VictorSP blmotor2 = new VictorSP(7);

    public DriveTrainVictorSP() {
        frmotor.addFollower(brmotor);
        blmotor2.setInverted(true);
        flmotor1.addFollower(blmotor2);
    }

    public void setSpeedRight(double power) {
        frmotor.set(-1 * power);
    }

    public void setSpeedLeft(double power) {
        flmotor1.set(power);
    }

    public void drive(double voltageRight, double voltageLeft) {
        setSpeedRight(voltageRight);
        setSpeedLeft(voltageLeft);
    }

    public Command driveCommand(DoubleSupplier left, DoubleSupplier right) {
        return Commands.run(() -> drive(left.getAsDouble(), right.getAsDouble()), this);
    }
}
