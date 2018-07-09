[doc](../../index.md) / [org.snakeskin.auto.steps](../index.md) / [SequentialSteps](./index.md)

# SequentialSteps

`class SequentialSteps : `[`AutoStep`](../-auto-step/index.md)

**Author**
Cameron Earle

**Version**
5/11/18

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SequentialSteps(vararg steps: `[`AutoStep`](../-auto-step/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [steps](steps.md) | `val steps: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`AutoStep`](../-auto-step/index.md)`>` |

### Inherited Properties

| Name | Summary |
|---|---|
| [done](../-auto-step/done.md) | `var done: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [stepState](../-auto-step/step-state.md) | `var stepState: `[`StepState`](../-auto-step/-step-state/index.md) |

### Functions

| Name | Summary |
|---|---|
| [action](action.md) | `fun action(currentTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lastTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [entry](entry.md) | `fun entry(currentTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [exit](exit.md) | `fun exit(currentTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [create](../-auto-step/create.md) | `fun create(): `[`AutoStep`](../-auto-step/index.md)<br>Creates a copy of this auto step.  Since step instances should not be shared, we use this to ensure that a new copy is created whenever it is needed. |
| [doContinue](../-auto-step/do-continue.md) | `fun doContinue(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [reset](../-auto-step/reset.md) | `fun reset(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [tick](../-auto-step/tick.md) | `fun tick(currentTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lastTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
