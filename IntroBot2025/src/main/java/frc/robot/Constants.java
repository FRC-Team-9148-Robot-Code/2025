// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int DRIVER_CONTROLLER_PORT = 0;
    public static final int OPERATOR_CONTROLLER_PORT = 1;
  }
  public static class DrivetrainConstants {
    public static final int FRONT_LEFT_SPARK_ID = 1;
    public static final int BACK_LEFT_SPARK_ID = 2;
    public static final int FRONT_RIGHT_SPARK_ID = 3;
    public static final int BACK_RIGHT_SPARK_ID = 4;
  }
  public static class PneumaticsConstants {
    public static final int SOLENOID_FORWARD_CHANNEL = 0;
    public static final int SOLENOID_REVERSE_CHANNEL = 1;
  }
  public static class MotorBasedConstants {
    public static final int MOTOR_BASED_SPARK_ID = 5;
    public static final double DEFAULT_MOTOR_SPEED = 0.25;
  }
}