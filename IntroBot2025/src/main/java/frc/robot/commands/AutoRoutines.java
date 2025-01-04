package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.MotorBasedSubsystem;
import frc.robot.subsystems.PneumaticBasedSubsystem;

public class AutoRoutines {
  Drivetrain d;
  MotorBasedSubsystem m;
  PneumaticBasedSubsystem p;

  public AutoRoutines(Drivetrain drivetrain, MotorBasedSubsystem motorSubsystem, PneumaticBasedSubsystem pneumaticSubsystem) {
    d = drivetrain;
    m = motorSubsystem;
    p = pneumaticSubsystem;
  }

  public Command pneumaticDriveAndMotor() {
    return Commands.sequence(
      Commands.parallel(
        d.driveCommand(() -> 0.6, () -> 0.6).withTimeout(1),
        Commands.runOnce(() -> p.set(Value.kForward), p)
      ),
      Commands.run(() -> m.spin(0.5), m).withTimeout(2)
    );
  }

  public Command exit() {
    return d.driveCommand(() -> 0.5, () -> 0.5).withTimeout(3);
  }

  public Command pneumaticSequenceAndExit() {
    return Commands.sequence(
      pneumaticDriveAndMotor(),
      exit()
    );
  }
}
