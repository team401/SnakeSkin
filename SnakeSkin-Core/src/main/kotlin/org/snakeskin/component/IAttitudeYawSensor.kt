package org.snakeskin.component

import org.snakeskin.component.provider.IPitchProvider
import org.snakeskin.component.provider.IRollProvider
import org.snakeskin.component.provider.IYawProvider

/**
 * Represents a sensor that can provide heading and attitude information.
 */
interface IAttitudeYawSensor : IYawProvider, IRollProvider, IPitchProvider