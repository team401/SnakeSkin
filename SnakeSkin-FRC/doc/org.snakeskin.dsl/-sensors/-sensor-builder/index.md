[doc](../../../index.md) / [org.snakeskin.dsl](../../index.md) / [Sensors](../index.md) / [SensorBuilder](./index.md)

# SensorBuilder

`class SensorBuilder<out T : `[`Sensor`](../../../org.snakeskin.sensors/-sensor/index.md)`<*>> : Builder<`[`T`](index.md#T)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SensorBuilder(sensor: `[`T`](index.md#T)`)` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `open fun build(): `[`T`](index.md#T) |
| [noPoll](no-poll.md) | `fun noPoll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [pollAt](poll-at.md) | `fun pollAt(rate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [whenChanged](when-changed.md) | `fun whenChanged(action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [BooleanSensorBuilder](../-boolean-sensor-builder/index.md) | `class BooleanSensorBuilder : `[`SensorBuilder`](./index.md)`<`[`BooleanSensor`](../../../org.snakeskin.sensors/-boolean-sensor/index.md)`>` |
| [NumericSensorBuilder](../-numeric-sensor-builder/index.md) | `class NumericSensorBuilder : `[`SensorBuilder`](./index.md)`<`[`NumericSensor`](../../../org.snakeskin.sensors/-numeric-sensor/index.md)`>` |
