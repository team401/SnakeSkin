[doc](../../index.md) / [org.snakeskin.sensors](../index.md) / [NumericSensor](./index.md)

# NumericSensor

`open class NumericSensor : `[`Sensor`](../-sensor/index.md)`<`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`>`

**Author**
Cameron Earle

**Version**
9/11/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NumericSensor(getter: () -> `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, deadband: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 0.0, zero: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 0.0)` |

### Properties

| Name | Summary |
|---|---|
| [deadband](deadband.md) | `open var deadband: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [history](history.md) | `val history: ComparableDoubleHistory` |
| [zero](zero.md) | `open var zero: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |

### Inherited Properties

| Name | Summary |
|---|---|
| [changedListener](../-sensor/changed-listener.md) | `var changedListener: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [pollRate](../-sensor/poll-rate.md) | `var pollRate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [receivingChangeListener](../-sensor/receiving-change-listener.md) | `var receivingChangeListener: (`[`T`](../-sensor/index.md#T)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Functions

| Name | Summary |
|---|---|
| [getValue](get-value.md) | `open fun getValue(): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [read](read.md) | `open fun read(): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [registerWhenAboveListener](register-when-above-listener.md) | `fun registerWhenAboveListener(whenAbove: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, listener: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [registerWhenBelowListener](register-when-below-listener.md) | `fun registerWhenBelowListener(whenBelow: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, listener: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [zero](zero.md) | `open fun zero(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [callListeners](../-sensor/call-listeners.md) | `fun callListeners(value: `[`T`](../-sensor/index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [registerUpdatable](../-sensor/register-updatable.md) | `fun registerUpdatable(updatable: AUpdatable<`[`T`](../-sensor/index.md#T)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [AnalogSensor](../-analog-sensor/index.md) | `open class AnalogSensor : `[`NumericSensor`](./index.md) |
