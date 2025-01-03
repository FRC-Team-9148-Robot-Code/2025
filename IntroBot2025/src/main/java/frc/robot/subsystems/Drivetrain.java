// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends SubsystemBase {
  SparkMax leftSpark1 = new SparkMax(DrivetrainConstants.FRONT_LEFT_SPARK_ID, MotorType.kBrushless);
  SparkMax leftSpark2 = new SparkMax(DrivetrainConstants.FRONT_RIGHT_SPARK_ID, MotorType.kBrushless);
  SparkMax rightSpark1 = new SparkMax(DrivetrainConstants.FRONT_RIGHT_SPARK_ID, MotorType.kBrushless);
  SparkMax rightSpark2 = new SparkMax(DrivetrainConstants.BACK_RIGHT_SPARK_ID, MotorType.kBrushless);

  public void drive(double leftSpeed, double rightSpeed) {
    leftSpark1.set(-leftSpeed);
    leftSpark2.set(-leftSpeed);
    rightSpark1.set(rightSpeed);
    rightSpark2.set(rightSpeed);
  }

  public Command driveCommand(DoubleSupplier left, DoubleSupplier right) {
    return runEnd(
      () -> drive(left.getAsDouble(), right.getAsDouble()),
      () -> drive(0,0)
    );
  }
}
