package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator;

/**
 * Elevator up.
 */

public class ElevatorUp extends Command {
    private Elevator elevator;

    public ElevatorUp(Elevator elevator) {
        this.elevator = elevator;
        addRequirements(elevator);
    }

    @Override
    public void execute() {
        this.elevator.setMotorVoltage(1.0);
    }

    @Override
    public void end(boolean interrupt) {
        this.elevator.setMotorVoltage(0.0);
    }
}

