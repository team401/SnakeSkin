[doc](../../index.md) / [org.snakeskin.dsl](../index.md) / [MutableStateBuilder](./index.md)

# MutableStateBuilder

`class MutableStateBuilder : `[`StateBuilder`](../-state-builder/index.md)

Adds functionality to the StateBuilder, with certain special functions that can't be used in default or disabled states

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MutableStateBuilder(name: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`)`<br>Adds functionality to the StateBuilder, with certain special functions that can't be used in default or disabled states |

### Inherited Properties

| Name | Summary |
|---|---|
| [builder](../-state-builder/builder.md) | `val builder: `[`State`](../../org.snakeskin.state/-state/index.md) |

### Functions

| Name | Summary |
|---|---|
| [rejectIf](reject-if.md) | `fun rejectIf(condition: () -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds rejection conditions for this state. |
| [timeout](timeout.md) | `fun timeout(timeout: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, timeoutTo: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets up the timeout for this state |

### Inherited Functions

| Name | Summary |
|---|---|
| [action](../-state-builder/action.md) | `fun action(rate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 20L, action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds the action method to the state |
| [build](../-state-builder/build.md) | `open fun build(): `[`State`](../../org.snakeskin.state/-state/index.md) |
| [entry](../-state-builder/entry.md) | `fun entry(action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds the entry method to the state |
| [exit](../-state-builder/exit.md) | `fun exit(action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds the exit method to the state |
