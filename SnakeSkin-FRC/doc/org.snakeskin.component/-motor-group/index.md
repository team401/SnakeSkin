[doc](../../index.md) / [org.snakeskin.component](../index.md) / [MotorGroup](./index.md)

# MotorGroup

`class MotorGroup<T : SpeedController> : SpeedController`

**Author**
Cameron Earle

**Version**
7/21/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MotorGroup(vararg motors: `[`T`](index.md#T)`)` |

### Functions

| Name | Summary |
|---|---|
| [disable](disable.md) | `fun disable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [get](get.md) | `fun get(): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [getInverted](get-inverted.md) | `fun getInverted(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [pidWrite](pid-write.md) | `fun pidWrite(output: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [set](set.md) | `fun set(speed: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setInverted](set-inverted.md) | `fun setInverted(isInverted: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stopMotor](stop-motor.md) | `fun stopMotor(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
