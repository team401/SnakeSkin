[doc](../../index.md) / [org.snakeskin.ability](../index.md) / [AUpdatable](./index.md)

# AUpdatable

`interface AUpdatable<in T>`

**Author**
Cameron Earle

**Version**
8/15/17

### Functions

| Name | Summary |
|---|---|
| [update](update.md) | `abstract fun update(newValue: `[`T`](index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [History](../../org.snakeskin.logic/-history/index.md) | `open class History<T> : `[`AUpdatable`](./index.md)`<`[`T`](../../org.snakeskin.logic/-history/index.md#T)`>`<br>A simple class that tracks history of an object |
| [PIDController](../../org.snakeskin.logic/-p-i-d-controller/index.md) | `class PIDController : `[`AUpdatable`](./index.md)`<`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`>`<br>This is an adapted version of CTRE's PID controller.  The implementation is subject to change, however the API will remain the same.  This class is fully thread safe |
