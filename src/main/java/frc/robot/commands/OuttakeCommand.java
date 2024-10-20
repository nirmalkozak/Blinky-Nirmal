package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class OuttakeCommand extends Command {
    Intake outtake;

    public OuttakeCommand(Intake outtake) {
        this.outtake = outtake;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        outtake.outtake();
    }

    @Override
    public void end(boolean interrupted) {
        outtake.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
