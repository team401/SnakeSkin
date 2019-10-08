package org.snakeskin.component.impl

import org.snakeskin.component.IMotorControllerSmartComponent
import org.snakeskin.component.ITalonSrxDevice

class SoftwareTalonSrxDevice : ITalonSrxDevice,
        IMotorControllerSmartComponent by SoftwareMotorControllerSmartComponent()