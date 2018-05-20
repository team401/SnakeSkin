[doc](../../../index.md) / [org.snakeskin.dsl](../../index.md) / [Sensors](../index.md) / [AnalogSensorBuilder](./index.md)

# AnalogSensorBuilder

`class AnalogSensorBuilder : `[`NumericSensorBuilder`](../-numeric-sensor-builder/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AnalogSensorBuilder(sensor: `[`AnalogSensor`](../../../org.snakeskin.sensors/-analog-sensor/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [analogInput](analog-input.md) | `val analogInput: AnalogInput` |

### Inherited Properties

| Name | Summary |
|---|---|
| [deadband](../-numeric-sensor-builder/deadband.md) | `var deadband: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [zero](../-numeric-sensor-builder/zero.md) | `var zero: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |

### Functions

| Name | Summary |
|---|---|
| [buildAnalog](build-analog.md) | `fun buildAnalog(): `[`AnalogSensor`](../../../org.snakeskin.sensors/-analog-sensor/index.md) |
| [whenChanged](when-changed.md) | `fun whenChanged(action: (voltage: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, value: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, averageVoltage: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, averageValue: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [whenAbove](../-numeric-sensor-builder/when-above.md) | `fun whenAbove(above: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [whenBelow](../-numeric-sensor-builder/when-below.md) | `fun whenBelow(below: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [whenChanged](../-numeric-sensor-builder/when-changed.md) | `fun whenChanged(action: (`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
