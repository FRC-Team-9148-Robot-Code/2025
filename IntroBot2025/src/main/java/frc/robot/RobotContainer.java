// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.MotorBasedConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.AutoRoutines;
import frc.robot.commands.MotorBasedCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.MotorBasedSubsystem;
import frc.robot.subsystems.PneumaticBasedSubsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  Drivetrain drivetrain = new Drivetrain();
  CommandXboxController driverController = new CommandXboxController(OperatorConstants.DRIVER_CONTROLLER_PORT);
  CommandXboxController operatorController = new CommandXboxController(OperatorConstants.OPERATOR_CONTROLLER_PORT);
  MotorBasedSubsystem motorBasedSubsystem = new MotorBasedSubsystem();
  PneumaticBasedSubsystem pneumaticBasedSubsystem = new PneumaticBasedSubsystem();

  Command driveStraightAuto = drivetrain.driveCommand(() -> 0.4, () -> 0.4).withTimeout(3);
  SendableChooser<Command> autoChooser = new SendableChooser<>();
  AutoRoutines autoRoutines = new AutoRoutines(drivetrain, motorBasedSubsystem, pneumaticBasedSubsystem);
  
  public RobotContainer() {
    drivetrain.setDefaultCommand(drivetrain.driveCommand(
      driverController::getLeftY, 
      driverController::getRightY
    ));

    autoChooser.setDefaultOption("Drive Straight", driveStraightAuto);
    autoChooser.addOption("Pneumatic & Exit", autoRoutines.pneumaticSequenceAndExit());
    Shuffleboard.getTab("Auto Routine Selector").add(autoChooser);

    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    operatorController.a().whileTrue(new MotorBasedCommand(motorBasedSubsystem, MotorBasedConstants.DEFAULT_MOTOR_SPEED));
    
    operatorController.x().onTrue(Commands.runOnce(() -> pneumaticBasedSubsystem.set(Value.kForward), pneumaticBasedSubsystem));
    operatorController.y().onTrue(Commands.runOnce(() -> pneumaticBasedSubsystem.set(Value.kReverse), pneumaticBasedSubsystem));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }
}
