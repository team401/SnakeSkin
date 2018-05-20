[doc](../../index.md) / [org.snakeskin.sensors](../index.md) / [DigitalSensor](./index.md)

# DigitalSensor

`open class DigitalSensor : `[`BooleanSensor`](../-boolean-sensor/index.md)

**Author**
Cameron Earle

**Version**
9/11/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DigitalSensor(inverted: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, dio: DigitalInput)` |

### Properties

| Name | Summary |
|---|---|
| [inverted](inverted.md) | `open var inverted: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Inherited Properties

| Name | Summary |
|---|---|
| [triggeredListener](../-boolean-sensor/triggered-listener.md) | `var triggeredListener: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [untriggeredListener](../-boolean-sensor/untriggered-listener.md) | `var untriggeredListener: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [isTriggered](../-boolean-sensor/is-triggered.md) | `open fun isTriggered(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [read](../-boolean-sensor/read.md) | `open fun read(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
