/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.nerdherd.lib.pneumatics.commands.ExtendPiston;
import com.nerdherd.lib.pneumatics.commands.RetractPiston;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class OI {

    public OI() {
        SmartDashboard.putData("Extend Piston", new ExtendPiston(Robot.piston));
        SmartDashboard.putData("Retract Piston", new RetractPiston(Robot.piston));
    }
}
