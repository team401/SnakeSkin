package org.snakeskin.auto

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser
import org.snakeskin.Constants
import org.snakeskin.factory.ExecutorFactory
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

/*
 * snakeskin - Created on 11/7/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 11/7/17
 */

object AutoManager {
    private val executor = ExecutorFactory.getExecutor("auto")
    private var activeFuture: ScheduledFuture<*>? = null
    private val availableAutos = arrayListOf<Auto>()
    val chooser = SendableChooser<Auto>()

    fun registerAutos(autos: ArrayList<Auto>) {
        availableAutos.addAll(autos)
    }


    fun publish() {
        availableAutos.forEach {
            chooser.addObject(it.name, it)
        }
    }

    @JvmStatic fun start() {
        val selectedAuto = chooser.selected

        if (selectedAuto != null) {
            selectedAuto.reset()
            activeFuture = executor.scheduleAtFixedRate(selectedAuto::tick, 0L, Constants.AUTO_RATE, TimeUnit.MILLISECONDS)
        }
    }

    @JvmStatic fun stop() {
        activeFuture?.cancel(true)
    }

}