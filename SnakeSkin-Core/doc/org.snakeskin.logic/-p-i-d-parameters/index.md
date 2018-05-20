[doc](../../index.md) / [org.snakeskin.logic](../index.md) / [PIDParameters](./index.md)

# PIDParameters

`class PIDParameters`

**Author**
Cameron Earle

**Version**
12/26/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PIDParameters(p: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 0.0, i: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 0.0, d: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 0.0, f: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 0.0, allowedError: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 0.0, iMagnitude: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = Double.MAX_VALUE, iZone: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = Double.MAX_VALUE, outMagnitude: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 1.0)` |

### Properties

| Name | Summary |
|---|---|
| [allowedError](allowed-error.md) | `val allowedError: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [d](d.md) | `val d: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [f](f.md) | `val f: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [i](i.md) | `val i: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [iMagnitude](i-magnitude.md) | `val iMagnitude: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [iZone](i-zone.md) | `val iZone: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [outMagnitude](out-magnitude.md) | `val outMagnitude: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [p](p.md) | `val p: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |

### Functions

| Name | Summary |
|---|---|
| [createController](create-controller.md) | `fun createController(): `[`PIDController`](../-p-i-d-controller/index.md) |
