package frc.robot.subsystems;

// import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainFalconFX extends SubsystemBase {
    TalonFX otherMotor = new TalonFX(51);
    // CANCoder coder = new CANCoder(1);
    int _loopCount = 0;

    public void setOtherPower(double power) {
        otherMotor.set(power);
    }

    public void driveFX() {
        setOtherPower(0.7);
        // double degrees = coder.getPosition();
        // System.out.println("CANCoder position is: " + degrees);
    }

    public void otherMoterStop() {
        setOtherPower(0);
    }

    public Command otherMotorCommand() {
        return Commands.runEnd(this::driveFX, () -> otherMoterStop(), this);
    }
}
