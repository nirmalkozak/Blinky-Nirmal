package frc.robot.subsystems;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj.DigitalInput;


public class EncoderMotorVSP implements EncoderMotorIO {
    SparkMax CSMMotor = new SparkMax(57, MotorType.kBrushless);
    TalonFX TFXMotor = new TalonFX(51);
    private final DigitalInput limitSwitch = new DigitalInput(8);
    private final RelativeEncoder CSMMotorEncoder = CSMMotor.getEncoder();
    private final StatusSignal<Angle> TFXMotorPosition;
    private final StatusSignal<AngularVelocity> TFXMotorVelocity;
    private final StatusSignal<Voltage> TFXMotorVoltage;

    public EncoderMotorVSP() {
        TFXMotorPosition = TFXMotor.getPosition();
        TFXMotorVelocity = TFXMotor.getVelocity();
        TFXMotorVoltage = TFXMotor.getSupplyVoltage();
    }

    public double encoder() {
        return CSMMotor.get();
    }

    public void setMotorPower(double power) {
        CSMMotor.set(power);
        TFXMotor.set(power);
    }

    public void updateInputs(SmallEncoderMotorIO inputs) {
        BaseStatusSignal.refreshAll(TFXMotorPosition, TFXMotorVelocity, TFXMotorVoltage);
        inputs.CSMMotorVoltage = CSMMotor.getBusVoltage();
        inputs.CSMMotorVelocity = CSMMotorEncoder.getVelocity();
        inputs.CSMMotorVelocity = CSMMotorEncoder.getPosition();
        inputs.limitSwitch = !limitSwitch.get();

    }
}
