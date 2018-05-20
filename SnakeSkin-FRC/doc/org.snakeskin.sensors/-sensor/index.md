[doc](../../index.md) / [org.snakeskin.sensors](../index.md) / [Sensor](./index.md)

# Sensor

`abstract class Sensor<T> : AReadable<`[`T`](index.md#T)`>`

**Author**
Cameron Earle

**Version**
9/10/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Sensor()` |

### Properties

| Name | Summary |
|---|---|
| [changedListener](changed-listener.md) | `var changedListener: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [pollRate](poll-rate.md) | `var pollRate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [receivingChangeListener](receiving-change-listener.md) | `var receivingChangeListener: (`[`T`](index.md#T)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Functions

| Name | Summary |
|---|---|
| [callListeners](call-listeners.md) | `fun callListeners(value: `[`T`](index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [registerUpdatable](register-updatable.md) | `fun registerUpdatable(updatable: AUpdatable<`[`T`](index.md#T)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [BooleanSensor](../-boolean-sensor/index.md) | `open class BooleanSensor : `[`Sensor`](./index.md)`<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>, AInvertable` |
| [NumericSensor](../-numeric-sensor/index.md) | `open class NumericSensor : `[`Sensor`](./index.md)`<`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`>` |
