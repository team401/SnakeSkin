package org.snakeskin.component

import org.snakeskin.component.provider.ICurrentProvider
import org.snakeskin.component.provider.IOutputVoltageProvider

/**
 * Marker interface for a current and voltage sensor combo
 */
interface ICurrentVoltageSensorComponent : ICurrentProvider, IOutputVoltageProvider