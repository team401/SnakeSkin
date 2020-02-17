package org.snakeskin.component

import org.snakeskin.component.provider.IAngularPositionProvider
import org.snakeskin.component.provider.IAngularVelocityProvider
import org.snakeskin.component.provider.IInvertableInputProvider

/**
 * Marker interface for a position and velocity sensor combo
 */
interface IAngularPositionVelocitySensorComponent : IAngularPositionProvider, IAngularVelocityProvider, IInvertableInputProvider