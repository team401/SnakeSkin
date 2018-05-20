[doc](../../../index.md) / [org.snakeskin.dsl](../../index.md) / [Sensors](../index.md) / [BooleanSensorBuilder](./index.md)

# BooleanSensorBuilder

`class BooleanSensorBuilder : `[`SensorBuilder`](../-sensor-builder/index.md)`<`[`BooleanSensor`](../../../org.snakeskin.sensors/-boolean-sensor/index.md)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BooleanSensorBuilder(sensor: `[`BooleanSensor`](../../../org.snakeskin.sensors/-boolean-sensor/index.md)`)` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `open fun build(): `[`BooleanSensor`](../../../org.snakeskin.sensors/-boolean-sensor/index.md) |
| [invert](invert.md) | `fun invert(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [whenTriggered](when-triggered.md) | `fun whenTriggered(action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [whenUntriggered](when-untriggered.md) | `fun whenUntriggered(action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [noPoll](../-sensor-builder/no-poll.md) | `fun noPoll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [pollAt](../-sensor-builder/poll-at.md) | `fun pollAt(rate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [whenChanged](../-sensor-builder/when-changed.md) | `fun whenChanged(action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [DigitalSensorBuilder](../-digital-sensor-builder/index.md) | `class DigitalSensorBuilder : `[`BooleanSensorBuilder`](./index.md) |
