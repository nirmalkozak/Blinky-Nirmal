package frc.robot.subsystems;

import org.littletonrobotics.junction.Logger;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    private intakeIO io;
    private IntakeInputAutoLogged inputs = new IntakeInputAutoLogged();

    public Intake(intakeIO io) {
        this.io = io;
    }

    @Override

    public void periodic() {
        Logger.processInputs("intake", inputs);
        io.updateInput(inputs);
    }

    public void setPower(double power) {
        Logger.recordOutput("Intake", power);
        io.setPower(power);
    }

    public Command intakeCMD(double power) {
        return startEnd(() -> {
            setPower(power);
        }, () -> {
            setPower(0);
        });
    }
    // DigitalInput beambrake = new DigitalInput(9);

}
