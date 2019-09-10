package org.snakeskin.component.impl

import org.snakeskin.component.IAngularPositionVelocitySensorComponent
import org.snakeskin.measure.distance.angular.AngularDistanceMeasureRevolutions
import org.snakeskin.measure.velocity.angular.AngularVelocityMeasureRevolutionsPerSecond

class SoftwareAngularPositionVelocitySensorComponent :  IAngularPositionVelocitySensorComponent {
    override fun getRotationalPosition(): AngularDistanceMeasureRevolutions {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setRotationalPosition(angle: AngularDistanceMeasureRevolutions) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRotationalVelocity(): AngularVelocityMeasureRevolutionsPerSecond {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}