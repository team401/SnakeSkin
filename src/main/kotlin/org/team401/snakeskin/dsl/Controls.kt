package org.team401.snakeskin.dsl

import org.team401.snakeskin.controls2.Controller
import org.team401.snakeskin.controls2.mappings.Extreme3D
import javax.naming.ldap.Control

/*
 * snakeskin - Created on 7/17/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/17/17
 */

object HumanControls {
    private fun <T: Controller> controller(controllerObj: T, setup: T.() -> Unit): T {

        controllerObj.setup()
        return controllerObj
    }

    fun extreme3d(id: Int, setup: Extreme3D.() -> Unit) = controller(Extreme3D(id), setup)
}

