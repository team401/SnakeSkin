package org.snakeskin.component

import org.snakeskin.component.provider.*

/**
 * Marker interface for a networked motor controller who has some smart features, but not others
 *
 * In the context of FRC, this describes a Victor SPX or other "slave" motor controller
 */
interface IMotorControllerEnhancedComponent :
        IFollowProvider,
        IFollowableProvider,
        IInputVoltageProvider,
        IPercentOutputMotorControlProvider,
        IInvertableOutputProvider