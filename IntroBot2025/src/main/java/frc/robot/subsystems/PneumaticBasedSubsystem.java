// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PneumaticsConstants;

public class PneumaticBasedSubsystem extends SubsystemBase {
  DoubleSolenoid solenoid1 = new DoubleSolenoid(PneumaticsModuleType.REVPH, PneumaticsConstants.SOLENOID_FORWARD_CHANNEL, PneumaticsConstants.SOLENOID_REVERSE_CHANNEL);
  
  public void set(Value value) {
    solenoid1.set(value);
  }
}
