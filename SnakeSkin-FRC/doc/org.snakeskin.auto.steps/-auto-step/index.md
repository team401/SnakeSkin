[doc](../../index.md) / [org.snakeskin.auto.steps](../index.md) / [AutoStep](./index.md)

# AutoStep

`abstract class AutoStep`

**Author**
Cameron Earle

**Version**
5/11/18

### Types

| Name | Summary |
|---|---|
| [State](-state/index.md) | `enum class State` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AutoStep(done: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false)` |

### Properties

| Name | Summary |
|---|---|
| [done](done.md) | `var done: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [state](state.md) | `var state: `[`State`](-state/index.md) |

### Functions

| Name | Summary |
|---|---|
| [action](action.md) | `abstract fun action(currentTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lastTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [doContinue](do-continue.md) | `fun doContinue(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [entry](entry.md) | `abstract fun entry(currentTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [exit](exit.md) | `abstract fun exit(currentTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [reset](reset.md) | `fun reset(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [tick](tick.md) | `fun tick(currentTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lastTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [DelayStep](../-delay-step/index.md) | `class DelayStep : `[`AutoStep`](./index.md) |
| [ParallelSteps](../-parallel-steps/index.md) | `class ParallelSteps : `[`AutoStep`](./index.md) |
| [SequentialSteps](../-sequential-steps/index.md) | `class SequentialSteps : `[`AutoStep`](./index.md) |
| [SingleStep](../-single-step/index.md) | `abstract class SingleStep : `[`AutoStep`](./index.md) |
| [WaitStep](../-wait-step/index.md) | `class WaitStep : `[`AutoStep`](./index.md) |
