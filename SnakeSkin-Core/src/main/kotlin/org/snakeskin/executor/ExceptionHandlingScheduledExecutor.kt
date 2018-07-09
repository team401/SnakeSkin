package org.snakeskin.executor

import java.util.concurrent.*

/**
 * @author Cameron Earle
 * @version 5/16/18
 */
class ExceptionHandlingScheduledExecutor(corePoolSize: Int, threadFactory: ThreadFactory): ScheduledThreadPoolExecutor(corePoolSize, threadFactory) {
    override fun <T : Any?> invokeAll(tasks: MutableCollection<out Callable<T>>?): MutableList<Future<T>> {
        val wrapped = tasks?.map {
            ExceptionHandlingCallable(it)
        }
        return super.invokeAll(wrapped)
    }

    override fun <T : Any?> invokeAll(tasks: MutableCollection<out Callable<T>>?, timeout: Long, unit: TimeUnit?): MutableList<Future<T>> {
        val wrapped = tasks?.map {
            ExceptionHandlingCallable(it)
        }
        return super.invokeAll(wrapped, timeout, unit)
    }

    override fun <T : Any?> invokeAny(tasks: MutableCollection<out Callable<T>>?): T {
        val wrapped = tasks?.map {
            ExceptionHandlingCallable(it)
        }
        return super.invokeAny(wrapped)
    }

    override fun <T : Any?> invokeAny(tasks: MutableCollection<out Callable<T>>?, timeout: Long, unit: TimeUnit?): T {
        val wrapped = tasks?.map {
            ExceptionHandlingCallable(it)
        }
        return super.invokeAny(wrapped, timeout, unit)
    }

    override fun <T : Any?> submit(task: Callable<T>?): Future<T> {
        val wrapped = ExceptionHandlingCallable(task)
        return super.submit(wrapped)
    }

    override fun submit(task: Runnable?): Future<*> {
        val wrapped = ExceptionHandlingRunnable(task)
        return super.submit(wrapped)
    }

    override fun <T : Any?> submit(task: Runnable?, result: T): Future<T> {
        val wrapped = ExceptionHandlingRunnable(task)
        return super.submit(wrapped, result)
    }

    override fun execute(command: Runnable?) {
        val wrapped = ExceptionHandlingRunnable(command)
        super.execute(wrapped)
    }

    override fun <V : Any?> schedule(callable: Callable<V>?, delay: Long, unit: TimeUnit?): ScheduledFuture<V> {
        val wrapped = ExceptionHandlingCallable(callable)
        return super.schedule(wrapped, delay, unit)
    }

    override fun schedule(command: Runnable?, delay: Long, unit: TimeUnit?): ScheduledFuture<*> {
        val wrapped = ExceptionHandlingRunnable(command)
        return super.schedule(wrapped, delay, unit)
    }

    override fun scheduleAtFixedRate(command: Runnable?, initialDelay: Long, period: Long, unit: TimeUnit?): ScheduledFuture<*> {
        val wrapped = ExceptionHandlingRunnable(command)
        return super.scheduleAtFixedRate(wrapped, initialDelay, period, unit)
    }

    override fun scheduleWithFixedDelay(command: Runnable?, initialDelay: Long, delay: Long, unit: TimeUnit?): ScheduledFuture<*> {
        val wrapped = ExceptionHandlingRunnable(command)
        return super.scheduleWithFixedDelay(wrapped, initialDelay, delay, unit)
    }
}