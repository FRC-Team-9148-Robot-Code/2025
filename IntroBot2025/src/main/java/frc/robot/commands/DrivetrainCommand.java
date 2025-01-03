// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DrivetrainCommand extends Command {
  Drivetrain d;
  DoubleSupplier l;
  DoubleSupplier r;
  /** Creates a new DrivetrainCommand. */
  public DrivetrainCommand(Drivetrain drivetrain, DoubleSupplier leftSpeed, DoubleSupplier rightSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    d = drivetrain;
    l = leftSpeed;
    r = rightSpeed;
    addRequirements(d);
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    d.drive(l.getAsDouble(), r.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    d.drive(0, 0);
  }
}
