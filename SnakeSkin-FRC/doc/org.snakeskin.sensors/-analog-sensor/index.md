[doc](../../index.md) / [org.snakeskin.sensors](../index.md) / [AnalogSensor](./index.md)

# AnalogSensor

`open class AnalogSensor : `[`NumericSensor`](../-numeric-sensor/index.md)

**Author**
Cameron Earle

**Version**
9/11/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AnalogSensor(analogInput: AnalogInput, deadband: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 0.0, zero: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 0.0, rawZero: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0)` |

### Properties

| Name | Summary |
|---|---|
| [analogInput](analog-input.md) | `val analogInput: AnalogInput` |
| [analogReceivingChangeListener](analog-receiving-change-listener.md) | `var analogReceivingChangeListener: (`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [deadband](deadband.md) | `open var deadband: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [rawZero](raw-zero.md) | `var rawZero: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [zero](zero.md) | `open var zero: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |

### Inherited Properties

| Name | Summary |
|---|---|
| [history](../-numeric-sensor/history.md) | `val history: ComparableDoubleHistory` |

### Functions

| Name | Summary |
|---|---|
| [getAveragedValue](get-averaged-value.md) | `fun getAveragedValue(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getAveragedVoltage](get-averaged-voltage.md) | `fun getAveragedVoltage(): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [getRawValue](get-raw-value.md) | `fun getRawValue(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getVoltage](get-voltage.md) | `fun getVoltage(): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [zero](zero.md) | `open fun zero(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [getValue](../-numeric-sensor/get-value.md) | `open fun getValue(): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [read](../-numeric-sensor/read.md) | `open fun read(): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [registerWhenAboveListener](../-numeric-sensor/register-when-above-listener.md) | `fun registerWhenAboveListener(whenAbove: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, listener: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [registerWhenBelowListener](../-numeric-sensor/register-when-below-listener.md) | `fun registerWhenBelowListener(whenBelow: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, listener: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
