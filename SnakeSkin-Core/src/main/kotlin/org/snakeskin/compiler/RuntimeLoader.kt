package org.snakeskin.compiler

import java.util.*

/**
 * @author Cameron Earle
 * @version 6/26/17
 */
object RuntimeLoader {
    private lateinit var loader: ServiceLoader<AnnotatedRunnable>
    private val injectedClasses = arrayListOf<AnnotatedRunnable>()

    /**
     * Injects an implementation for a given annotation, which can be used for testing
     */
    fun inject(implementation: AnnotatedRunnable) {
        injectedClasses.add(implementation)
    }

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
        injectedClasses.forEach {
            if (it.getName() == annotation.name) {
                list.add(it)
            }
        }
        loader.forEach {
            if (it.getName() == annotation.name) {
                list.add(it)
            }
        }
        return list
    }
}