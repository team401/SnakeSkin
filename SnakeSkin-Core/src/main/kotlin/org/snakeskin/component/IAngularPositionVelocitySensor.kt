package org.snakeskin.component

import org.snakeskin.component.provider.IAngularPositionProvider
import org.snakeskin.component.provider.IAngularVelocityProvider

/**
 * Marker interface for a position and velocity sensor combo
 */
interface IAngularPositionVelocitySensor : IAngularPositionProvider, IAngularVelocityProvider