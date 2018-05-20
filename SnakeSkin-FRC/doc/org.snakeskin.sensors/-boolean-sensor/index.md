[doc](../../index.md) / [org.snakeskin.sensors](../index.md) / [BooleanSensor](./index.md)

# BooleanSensor

`open class BooleanSensor : `[`Sensor`](../-sensor/index.md)`<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>, AInvertable`

**Author**
Cameron Earle

**Version**
9/10/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BooleanSensor(inverted: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, getter: () -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [inverted](inverted.md) | `open var inverted: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [triggeredListener](triggered-listener.md) | `var triggeredListener: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [untriggeredListener](untriggered-listener.md) | `var untriggeredListener: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Properties

| Name | Summary |
|---|---|
| [changedListener](../-sensor/changed-listener.md) | `var changedListener: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [pollRate](../-sensor/poll-rate.md) | `var pollRate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [receivingChangeListener](../-sensor/receiving-change-listener.md) | `var receivingChangeListener: (`[`T`](../-sensor/index.md#T)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Functions

| Name | Summary |
|---|---|
| [isTriggered](is-triggered.md) | `open fun isTriggered(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [read](read.md) | `open fun read(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [callListeners](../-sensor/call-listeners.md) | `fun callListeners(value: `[`T`](../-sensor/index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [registerUpdatable](../-sensor/register-updatable.md) | `fun registerUpdatable(updatable: AUpdatable<`[`T`](../-sensor/index.md#T)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [DigitalSensor](../-digital-sensor/index.md) | `open class DigitalSensor : `[`BooleanSensor`](./index.md) |
