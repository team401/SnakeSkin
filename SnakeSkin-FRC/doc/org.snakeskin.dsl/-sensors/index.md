[doc](../../index.md) / [org.snakeskin.dsl](../index.md) / [Sensors](./index.md)

# Sensors

`object Sensors`

**Author**
Cameron Earle

**Version**
9/10/17

### Types

| Name | Summary |
|---|---|
| [AnalogSensorBuilder](-analog-sensor-builder/index.md) | `class AnalogSensorBuilder : `[`NumericSensorBuilder`](-numeric-sensor-builder/index.md) |
| [BooleanSensorBuilder](-boolean-sensor-builder/index.md) | `class BooleanSensorBuilder : `[`SensorBuilder`](-sensor-builder/index.md)`<`[`BooleanSensor`](../../org.snakeskin.sensors/-boolean-sensor/index.md)`>` |
| [DigitalSensorBuilder](-digital-sensor-builder/index.md) | `class DigitalSensorBuilder : `[`BooleanSensorBuilder`](-boolean-sensor-builder/index.md) |
| [NumericSensorBuilder](-numeric-sensor-builder/index.md) | `class NumericSensorBuilder : `[`SensorBuilder`](-sensor-builder/index.md)`<`[`NumericSensor`](../../org.snakeskin.sensors/-numeric-sensor/index.md)`>` |
| [SensorBuilder](-sensor-builder/index.md) | `class SensorBuilder<out T : `[`Sensor`](../../org.snakeskin.sensors/-sensor/index.md)`<*>> : Builder<`[`T`](-sensor-builder/index.md#T)`>` |

### Functions

| Name | Summary |
|---|---|
| [analogSensor](analog-sensor.md) | `fun analogSensor(port: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, setup: `[`AnalogSensorBuilder`](-analog-sensor-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`AnalogSensor`](../../org.snakeskin.sensors/-analog-sensor/index.md) |
| [booleanSensor](boolean-sensor.md) | `fun booleanSensor(getter: () -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, setup: `[`BooleanSensorBuilder`](-boolean-sensor-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`BooleanSensor`](../../org.snakeskin.sensors/-boolean-sensor/index.md) |
| [digitalSensor](digital-sensor.md) | `fun digitalSensor(port: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, setup: `[`BooleanSensorBuilder`](-boolean-sensor-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`DigitalSensor`](../../org.snakeskin.sensors/-digital-sensor/index.md) |
| [numericSensor](numeric-sensor.md) | `fun numericSensor(getter: () -> `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, setup: `[`NumericSensorBuilder`](-numeric-sensor-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`NumericSensor`](../../org.snakeskin.sensors/-numeric-sensor/index.md) |
