// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorBasedSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class MotorBasedCommand extends Command {
  MotorBasedSubsystem m;
  double s;
  /** Creates a new MotorBasedCommand. */
  public MotorBasedCommand(MotorBasedSubsystem motorBasedSubsystem, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    m = motorBasedSubsystem;
    s = speed;
    addRequirements(m);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m.spin(s);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m.spin(0);
  }
}
