package org.snakeskin.component

import org.snakeskin.component.provider.IInvertableProvider
import org.snakeskin.component.provider.IPercentOutputMotorControlProvider

/**
 * Represents a basic "direct" motor controller, meaning it is connected directly to a signal output
 * on the primary controller.
 *
 * In the context of FRC, this is a PWM motor controller.
 */
interface IMotorControllerDirectComponent : IPercentOutputMotorControlProvider, IInvertableProvider