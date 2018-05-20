[doc](../../index.md) / [org.snakeskin.executor](../index.md) / [ExceptionHandlingScheduledExecutor](./index.md)

# ExceptionHandlingScheduledExecutor

`class ExceptionHandlingScheduledExecutor : `[`ScheduledThreadPoolExecutor`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/ScheduledThreadPoolExecutor.html)

**Author**
Cameron Earle

**Version**
5/16/18

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ExceptionHandlingScheduledExecutor(corePoolSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, threadFactory: `[`ThreadFactory`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/ThreadFactory.html)`)` |

### Functions

| Name | Summary |
|---|---|
| [execute](execute.md) | `fun execute(command: `[`Runnable`](http://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [invokeAll](invoke-all.md) | `fun <T> invokeAll(tasks: `[`MutableCollection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-collection/index.html)`<out `[`Callable`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/Callable.html)`<`[`T`](invoke-all.md#T)`>>?): `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Future`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/Future.html)`<`[`T`](invoke-all.md#T)`>>`<br>`fun <T> invokeAll(tasks: `[`MutableCollection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-collection/index.html)`<out `[`Callable`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/Callable.html)`<`[`T`](invoke-all.md#T)`>>?, timeout: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, unit: `[`TimeUnit`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/TimeUnit.html)`?): `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Future`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/Future.html)`<`[`T`](invoke-all.md#T)`>>` |
| [invokeAny](invoke-any.md) | `fun <T> invokeAny(tasks: `[`MutableCollection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-collection/index.html)`<out `[`Callable`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/Callable.html)`<`[`T`](invoke-any.md#T)`>>?): `[`T`](invoke-any.md#T)<br>`fun <T> invokeAny(tasks: `[`MutableCollection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-collection/index.html)`<out `[`Callable`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/Callable.html)`<`[`T`](invoke-any.md#T)`>>?, timeout: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, unit: `[`TimeUnit`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/TimeUnit.html)`?): `[`T`](invoke-any.md#T) |
| [schedule](schedule.md) | `fun <V> schedule(callable: `[`Callable`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/Callable.html)`<`[`V`](schedule.md#V)`>?, delay: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, unit: `[`TimeUnit`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/TimeUnit.html)`?): `[`ScheduledFuture`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/ScheduledFuture.html)`<`[`V`](schedule.md#V)`>`<br>`fun schedule(command: `[`Runnable`](http://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)`?, delay: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, unit: `[`TimeUnit`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/TimeUnit.html)`?): `[`ScheduledFuture`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/ScheduledFuture.html)`<*>` |
| [scheduleAtFixedRate](schedule-at-fixed-rate.md) | `fun scheduleAtFixedRate(command: `[`Runnable`](http://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)`?, initialDelay: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, period: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, unit: `[`TimeUnit`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/TimeUnit.html)`?): `[`ScheduledFuture`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/ScheduledFuture.html)`<*>` |
| [scheduleWithFixedDelay](schedule-with-fixed-delay.md) | `fun scheduleWithFixedDelay(command: `[`Runnable`](http://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)`?, initialDelay: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, delay: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, unit: `[`TimeUnit`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/TimeUnit.html)`?): `[`ScheduledFuture`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/ScheduledFuture.html)`<*>` |
| [submit](submit.md) | `fun <T> submit(task: `[`Callable`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/Callable.html)`<`[`T`](submit.md#T)`>?): `[`Future`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/Future.html)`<`[`T`](submit.md#T)`>`<br>`fun submit(task: `[`Runnable`](http://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)`?): `[`Future`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/Future.html)`<*>`<br>`fun <T> submit(task: `[`Runnable`](http://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)`?, result: `[`T`](submit.md#T)`): `[`Future`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/Future.html)`<`[`T`](submit.md#T)`>` |
