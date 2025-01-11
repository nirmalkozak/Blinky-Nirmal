package frc.robot.subsystems;

import org.littletonrobotics.junction.AutoLog;

public interface intakeIO {
    @AutoLog
    public static class IntakeInput {

    }

    public default void setPower(double power) {

        
    }

    public default void updateInput(IntakeInput inputs) {}

}
