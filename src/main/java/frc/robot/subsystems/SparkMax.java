package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SparkMax extends SubsystemBase {
    CANSparkMax spark = new CANSparkMax(57, MotorType.kBrushless);
    // CANEncoder encoder = CANEncoder(spark);
    RelativeEncoder sparkCoder = spark.getEncoder();

    public void setOtherPower(double power) {
        spark.set(power);
    }

    public void driveSpark() {
        setOtherPower(0.7);
        double motorPosition = sparkCoder.getPosition();
        System.out.println(motorPosition);
    }

    public void otherMoterStop() {
        setOtherPower(0);
    }

    public Command SparkMaxCommand() {
        return Commands.runEnd(this::driveSpark, () -> otherMoterStop(), this);
    }
}
