[doc](../../index.md) / [org.snakeskin.logging](../index.md) / [LoggableThrowable](./index.md)

# LoggableThrowable

`class LoggableThrowable : `[`ALoggable`](../../org.snakeskin.ability/-a-loggable/index.md)

**Author**
Cameron Earle

**Version**
8/26/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `LoggableThrowable(e: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`, t: `[`Thread`](http://docs.oracle.com/javase/6/docs/api/java/lang/Thread.html)`?)` |

### Properties

| Name | Summary |
|---|---|
| [message](message.md) | `val message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [name](name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [stackTrace](stack-trace.md) | `val stackTrace: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`StackTraceElement`](http://docs.oracle.com/javase/6/docs/api/java/lang/StackTraceElement.html)`>` |
| [thread](thread.md) | `val thread: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [type](type.md) | `val type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [serialize](../../org.snakeskin.ability/-a-loggable/serialize.md) | `open fun serialize(gson: Gson): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
