package org.snakeskin.component.impl

import org.snakeskin.component.IAngularPositionVelocitySensorComponent
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRevolutions
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRevolutionsPerSecond

class SoftwareAngularPositionVelocitySensorComponent :  IAngularPositionVelocitySensorComponent {
    override fun getAngularPosition(): AngularDistanceMeasureRevolutions {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setAngularPosition(angle: AngularDistanceMeasureRevolutions) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAngularVelocity(): AngularVelocityMeasureRevolutionsPerSecond {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}