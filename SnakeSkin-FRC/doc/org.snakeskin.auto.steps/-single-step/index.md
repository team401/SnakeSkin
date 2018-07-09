[doc](../../index.md) / [org.snakeskin.auto.steps](../index.md) / [SingleStep](./index.md)

# SingleStep

`abstract class SingleStep : `[`AutoStep`](../-auto-step/index.md)

**Author**
Cameron Earle

**Version**
5/11/18

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SingleStep()` |

### Inherited Properties

| Name | Summary |
|---|---|
| [done](../-auto-step/done.md) | `var done: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [stepState](../-auto-step/step-state.md) | `var stepState: `[`StepState`](../-auto-step/-step-state/index.md) |

### Functions

| Name | Summary |
|---|---|
| [action](action.md) | `open fun action(currentTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lastTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [exit](exit.md) | `open fun exit(currentTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [create](../-auto-step/create.md) | `fun create(): `[`AutoStep`](../-auto-step/index.md)<br>Creates a copy of this auto step.  Since step instances should not be shared, we use this to ensure that a new copy is created whenever it is needed. |
| [doContinue](../-auto-step/do-continue.md) | `fun doContinue(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [entry](../-auto-step/entry.md) | `abstract fun entry(currentTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [reset](../-auto-step/reset.md) | `fun reset(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [tick](../-auto-step/tick.md) | `fun tick(currentTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lastTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [LambdaStep](../-lambda-step/index.md) | `class LambdaStep : `[`SingleStep`](./index.md) |
