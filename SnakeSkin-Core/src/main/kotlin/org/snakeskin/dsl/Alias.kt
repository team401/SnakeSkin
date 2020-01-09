package org.snakeskin.dsl

/**
 * @author Cameron Earle
 * @version 12/2/17
 *
 * Aliases to allow access to certain classes
 * by importing 'org.snakeskin.dsl.*'
 */

typealias Subsystems = org.snakeskin.registry.SubsystemsRegistry
typealias Controllers = org.snakeskin.registry.HIDControllersRegistry

typealias Subsystem = org.snakeskin.subsystem.Subsystem
typealias StateMachine<T> = org.snakeskin.state.StateMachine<T>
typealias Setup = org.snakeskin.annotation.Setup
typealias BooleanState = org.snakeskin.logic.BooleanState
typealias Hardware = org.snakeskin.component.Hardware