// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PneumaticBasedSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class PneumaticBasedCommand extends Command {
  PneumaticBasedSubsystem p;
  Value v;
  /** Creates a new PneumaticBasedCommand. */
  public PneumaticBasedCommand(PneumaticBasedSubsystem subsystem, Value value) {
    // Use addRequirements() here to declare subsystem dependencies.
    p = subsystem;
    v = value;
    addRequirements(p);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    p.set(v);
  }
}
