package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class IntakeVictorSP implements intakeIO {

    VictorSP intakeMotor1 = new VictorSP(1);
    VictorSP intakeMotor2 = new VictorSP(2);

    public void update() {

    }

    public void intakeReal() {
        intakeMotor2.setInverted(true);
        intakeMotor1.addFollower(intakeMotor2);
        // otherMotor.setInverted(true);

    }

    public void setPower(double power) {
        intakeMotor1.set(power);
    }
}
