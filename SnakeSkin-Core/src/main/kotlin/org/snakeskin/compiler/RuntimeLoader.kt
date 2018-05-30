package org.snakeskin.compiler

import java.util.*

object RuntimeLoader {
    private lateinit var loader: ServiceLoader<AnnotatedRunnable>

    /**
     * Loads all of the AnnotatedRunnable objects registered in the service registry
     */
    fun load() {
        loader = ServiceLoader.load(AnnotatedRunnable::class.java)
    }

    /**
     * Gets all runnables with the given annotation
     */
    fun getAnnotated(annotation: Class<*>): List<AnnotatedRunnable> {
        val list = arrayListOf<AnnotatedRunnable>()
        loader.forEach {
            if (it.getName() == annotation.name) {
                list.add(it)
            }
        }
        return list
    }
}