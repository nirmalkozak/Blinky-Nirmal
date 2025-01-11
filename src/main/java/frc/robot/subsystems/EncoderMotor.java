package frc.robot.subsystems;

import org.littletonrobotics.junction.Logger;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class EncoderMotor extends SubsystemBase {
    private EncoderMotorIO io;
    private SmallEncoderMotorIOAutoLogged inputs = new SmallEncoderMotorIOAutoLogged();

    public EncoderMotor(EncoderMotorIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        Logger.processInputs("encoder", inputs);
        io.updateInputs(inputs);
    }

    public void SetMotorPower(double power) {
        Logger.recordOutput("encoder", power);
        io.setMotorPower(power);
    }

    public Command EncoderMotorOn(double power) {
        return startEnd(() -> {
            SetMotorPower(power);
        }, () -> {
            SetMotorPower(0);
        }).until(() -> inputs.limitSwitch);
    }
}
