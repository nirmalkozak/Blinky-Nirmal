package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    VictorSP intakeMotor1 = new VictorSP(1);
    VictorSP intakeMotor2 = new VictorSP(2);
    TalonFX otherMotor = new TalonFX(1);

    DigitalInput beambrake = new DigitalInput(9);

    public Intake() {
        intakeMotor2.setInverted(true);
        intakeMotor1.addFollower(intakeMotor2);
        // otherMotor.setInverted(true);

    }

    public void setPower(double power) {
        intakeMotor1.set(power);
    }


    public void setOtherPower(double power) {
        otherMotor.set(power);
    }

    public void otherMoterSpin() {
        setOtherPower(0.7);
    }

    public void otherMoterStop() {
        setOtherPower(0);
    }


    public void intake() {
        setPower(0.7);
    }

    public void outtake() {
        setPower(-0.7);
    }

    public void stop() {
        setPower(0);
    }

    public Command intakeCommand() {
        return Commands.runEnd(this::intake, () -> stop(), this).until(() -> beambrake.get());
    }

    public Command outtakeCommand() {
        return Commands.runEnd(this::outtake, () -> stop(), this);
    }


    public Command otherMotorCommand() {
        return Commands.runEnd(this::otherMoterSpin, () -> otherMoterStop(), this);
    }

}
