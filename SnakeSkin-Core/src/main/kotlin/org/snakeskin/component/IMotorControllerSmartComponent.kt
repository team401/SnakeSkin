package org.snakeskin.component

import org.snakeskin.component.provider.IAngularPositionMotorControlProvider
import org.snakeskin.component.provider.IAngularProfileMotorControlProvider
import org.snakeskin.component.provider.IAngularVelocityMotorControlProvider

/**
 * Marker interface for a component that provides "smart" motor control functions.
 *
 * In the context of FRC, this represents a Talon SRX, SPARK MAX, etc.
 */
interface IMotorControllerSmartComponent :
        IMotorControllerEnhancedComponent,
        IAngularPositionVelocitySensorComponent,
        ICurrentVoltageSensorComponent,
        IAngularPositionMotorControlProvider,
        IAngularVelocityMotorControlProvider,
        IAngularProfileMotorControlProvider