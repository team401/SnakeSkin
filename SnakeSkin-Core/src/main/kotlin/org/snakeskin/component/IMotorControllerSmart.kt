package org.snakeskin.component

import org.snakeskin.component.provider.*

/**
 * Marker interface for a smart motor controller
 */
interface IMotorControllerSmart :
        IPercentOutputMotorControlProvider,
        IAngularPositionVelocitySensor,
        IAngularPositionMotorControlProvider,
        IAngularVelocityMotorControlProvider