package org.snakeskin.dsl

import edu.wpi.first.wpilibj.Solenoid
import org.snakeskin.state.StateMachine

/**
 * @author Cameron Earle
 * @version 5/30/18
 */

fun Subsystem.pistonCommandMachine(solenoid: Solenoid, setup: StateMachineBuilder<Any>.() -> Unit = {}): StateMachine<Any> {
    return booleanCommandMachine({ solenoid.set(value) }, setup)
}