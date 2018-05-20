[doc](../../index.md) / [org.snakeskin.ability](../index.md) / [ALoggable](./index.md)

# ALoggable

`interface ALoggable : `[`ASerializable`](../-a-serializable/index.md)

**Author**
Cameron Earle

**Version**
8/26/17

### Properties

| Name | Summary |
|---|---|
| [type](type.md) | `abstract val type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [serialize](serialize.md) | `open fun serialize(gson: Gson): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [LoggableMessage](../../org.snakeskin.logging/-loggable-message/index.md) | `class LoggableMessage : `[`ALoggable`](./index.md) |
| [LoggableThrowable](../../org.snakeskin.logging/-loggable-throwable/index.md) | `class LoggableThrowable : `[`ALoggable`](./index.md) |
| [LoggableValue](../../org.snakeskin.logging/-loggable-value/index.md) | `open class LoggableValue : `[`ALoggable`](./index.md) |
