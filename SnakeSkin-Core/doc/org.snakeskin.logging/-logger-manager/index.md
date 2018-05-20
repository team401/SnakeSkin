[doc](../../index.md) / [org.snakeskin.logging](../index.md) / [LoggerManager](./index.md)

# LoggerManager

`object LoggerManager`

**Author**
Cameron Earle

**Version**
8/26/17

### Functions

| Name | Summary |
|---|---|
| [getExceptionHandler](get-exception-handler.md) | `fun getExceptionHandler(): `[`UncaughtExceptionHandler`](http://docs.oracle.com/javase/6/docs/api/java/lang/Thread/UncaughtExceptionHandler.html) |
| [getMainThreadExceptionHandler](get-main-thread-exception-handler.md) | `fun getMainThreadExceptionHandler(): `[`UncaughtExceptionHandler`](http://docs.oracle.com/javase/6/docs/api/java/lang/Thread/UncaughtExceptionHandler.html) |
| [logCrash](log-crash.md) | `fun logCrash(e: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`, t: `[`Thread`](http://docs.oracle.com/javase/6/docs/api/java/lang/Thread.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [logCurrentThread](log-current-thread.md) | `fun logCurrentThread(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [logMainThread](log-main-thread.md) | `fun logMainThread(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [logMessage](log-message.md) | `fun logMessage(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, level: `[`LogLevel`](../-log-level/index.md)` = LogLevel.INFO): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [logThrowable](log-throwable.md) | `fun logThrowable(e: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`, t: `[`Thread`](http://docs.oracle.com/javase/6/docs/api/java/lang/Thread.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
