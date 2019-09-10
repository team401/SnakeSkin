package org.snakeskin.component.impl

import org.snakeskin.component.INetworkMotorControllerSmartComponent
import org.snakeskin.component.ITalonSrxDevice

class SoftwareTalonSrxDevice : ITalonSrxDevice,
        INetworkMotorControllerSmartComponent by SoftwareNetworkMotorControllerSmartComponent()