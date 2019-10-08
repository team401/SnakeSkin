package org.snakeskin.component.impl

import org.snakeskin.component.IMotorControllerEnhancedComponent
import org.snakeskin.component.IVictorSpxDevice

class SoftwareVictorSpxDevice : IVictorSpxDevice,
        IMotorControllerEnhancedComponent by SoftwareMotorControllerEnhancedComponent()