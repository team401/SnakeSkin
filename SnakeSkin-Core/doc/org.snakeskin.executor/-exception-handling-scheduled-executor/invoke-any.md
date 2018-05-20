[doc](../../index.md) / [org.snakeskin.executor](../index.md) / [ExceptionHandlingScheduledExecutor](index.md) / [invokeAny](./invoke-any.md)

# invokeAny

`fun <T> invokeAny(tasks: `[`MutableCollection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-collection/index.html)`<out `[`Callable`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/Callable.html)`<`[`T`](invoke-any.md#T)`>>?): `[`T`](invoke-any.md#T)
`fun <T> invokeAny(tasks: `[`MutableCollection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-collection/index.html)`<out `[`Callable`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/Callable.html)`<`[`T`](invoke-any.md#T)`>>?, timeout: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, unit: `[`TimeUnit`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/TimeUnit.html)`?): `[`T`](invoke-any.md#T)