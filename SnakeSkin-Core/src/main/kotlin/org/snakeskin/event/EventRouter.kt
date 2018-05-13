package org.snakeskin.event

import org.snakeskin.factory.ExecutorFactory
import org.snakeskin.logic.MutableParameters
import org.snakeskin.logic.Parameters

/*
 * SnakeSkin - Created on 7/4/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/4/17
 */
object EventRouter {
    private val handlers = hashMapOf<String, ArrayList<(Parameters) -> Unit>>()
    private val executor = ExecutorFactory.getExecutor("Event Router")

    fun registerHandler(event: String, handler: (Parameters) -> Unit) {
        handlers.putIfAbsent(event, arrayListOf())
        handlers[event]!!.add(handler)
    }


    @Synchronized @JvmStatic @JvmOverloads fun fireEvent(event: String, parameters: MutableParameters = MutableParameters()) {
        handlers[event]?.forEach {
            executor.submit { it(parameters.toParameters()) }
        }
    }
}