package org.snakeskin.component

import org.snakeskin.component.provider.IFollowProvider
import org.snakeskin.component.provider.IFollowableProvider
import org.snakeskin.component.provider.IInputVoltageProvider
import org.snakeskin.component.provider.IPercentOutputMotorControlProvider

/**
 * Marker interface for a networked motor controller who has some smart features, but not others
 *
 * In the context of FRC, this describes a Victor SPX or other "slave" motor controller
 */
interface IMotorControllerEnhancedComponent :
        IFollowProvider,
        IFollowableProvider,
        IInputVoltageProvider,
        IPercentOutputMotorControlProvider