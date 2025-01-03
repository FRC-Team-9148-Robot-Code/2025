// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorBasedConstants;

public class MotorBasedSubsystem extends SubsystemBase {
  SparkMax spark1 = new SparkMax(MotorBasedConstants.MOTOR_BASED_SPARK_ID, MotorType.kBrushless);

  public void spin(double speed) {
    spark1.set(speed);
  }
}
