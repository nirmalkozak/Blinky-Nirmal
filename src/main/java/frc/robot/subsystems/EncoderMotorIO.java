package frc.robot.subsystems;

import org.littletonrobotics.junction.AutoLog;

public interface EncoderMotorIO {
    @AutoLog
    public static class SmallEncoderMotorIO {
        public double CSMMotorVelocity;
        public double CSMMotorVoltage;
        public double CSMMotorPosition;
        public double TFXMotorPosition;
        public double TFXMotorVelocity;
        public double TFXMotorVoltage;
        public boolean limitSwitch;
    }

    public default double encoder() {
        return 0;
    }

    public default void setMotorPower(double power) {}

    public default void setMotorPercentage(double percent) {}

    public default void updateInputs(SmallEncoderMotorIO inputs) {}
}
