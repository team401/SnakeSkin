package org.snakeskin.component.impl

import org.snakeskin.component.INetworkMotorControllerEnhancedComponent
import org.snakeskin.component.IVictorSpxDevice

class SoftwareVictorSpxDevice : IVictorSpxDevice,
        INetworkMotorControllerEnhancedComponent by SoftwareNetworkMotorControllerEnhancedComponent()