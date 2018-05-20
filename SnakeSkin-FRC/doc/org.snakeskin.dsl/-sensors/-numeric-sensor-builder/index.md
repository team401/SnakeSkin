[doc](../../../index.md) / [org.snakeskin.dsl](../../index.md) / [Sensors](../index.md) / [NumericSensorBuilder](./index.md)

# NumericSensorBuilder

`class NumericSensorBuilder : `[`SensorBuilder`](../-sensor-builder/index.md)`<`[`NumericSensor`](../../../org.snakeskin.sensors/-numeric-sensor/index.md)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NumericSensorBuilder(sensor: `[`NumericSensor`](../../../org.snakeskin.sensors/-numeric-sensor/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [deadband](deadband.md) | `var deadband: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [zero](zero.md) | `var zero: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |

### Functions

| Name | Summary |
|---|---|
| [whenAbove](when-above.md) | `fun whenAbove(above: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [whenBelow](when-below.md) | `fun whenBelow(below: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [whenChanged](when-changed.md) | `fun whenChanged(action: (`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [build](../-sensor-builder/build.md) | `open fun build(): `[`T`](../-sensor-builder/index.md#T) |
| [noPoll](../-sensor-builder/no-poll.md) | `fun noPoll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [pollAt](../-sensor-builder/poll-at.md) | `fun pollAt(rate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [whenChanged](../-sensor-builder/when-changed.md) | `fun whenChanged(action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [AnalogSensorBuilder](../-analog-sensor-builder/index.md) | `class AnalogSensorBuilder : `[`NumericSensorBuilder`](./index.md) |
