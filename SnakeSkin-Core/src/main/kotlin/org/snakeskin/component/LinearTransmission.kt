package org.snakeskin.component

import org.snakeskin.component.provider.ILinearPositionProvider
import org.snakeskin.component.provider.ILinearVelocityProvider
import org.snakeskin.measure.distance.linear.LinearDistanceMeasureInches
import org.snakeskin.measure.velocity.linear.LinearVelocityMeasureInchesPerSecond

/**
 * Represents a linear transmission, which wraps a gearbox
 */
class LinearTransmission(val gearbox: Gearbox, val linearRadius: LinearDistanceMeasureInches): ILinearPositionProvider, ILinearVelocityProvider {
    override fun getLinearPosition(): LinearDistanceMeasureInches {
        return gearbox.getAngularPosition().toLinearDistance(linearRadius)
    }

    override fun setLinearPosition(position: LinearDistanceMeasureInches) {
        gearbox.setAngularPosition(position.toAngularDistance(linearRadius))
    }

    override fun getLinearVelocity(): LinearVelocityMeasureInchesPerSecond {
        return gearbox.getAngularVelocity().toLinearVelocity(linearRadius)
    }
}