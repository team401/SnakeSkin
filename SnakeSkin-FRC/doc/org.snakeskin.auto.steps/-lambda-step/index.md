[doc](../../index.md) / [org.snakeskin.auto.steps](../index.md) / [LambdaStep](./index.md)

# LambdaStep

`class LambdaStep : `[`SingleStep`](../-single-step/index.md)

**Author**
Cameron Earle

**Version**
5/11/18

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `LambdaStep(lambda: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [lambda](lambda.md) | `val lambda: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Functions

| Name | Summary |
|---|---|
| [entry](entry.md) | `fun entry(currentTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [action](../-single-step/action.md) | `open fun action(currentTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lastTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [exit](../-single-step/exit.md) | `open fun exit(currentTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
