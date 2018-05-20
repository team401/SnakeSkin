[doc](../../index.md) / [org.snakeskin.dsl](../index.md) / [StateBuilder](./index.md)

# StateBuilder

`open class StateBuilder : `[`Builder`](../-builder/index.md)`<`[`State`](../../org.snakeskin.state/-state/index.md)`>`

Builds a State object

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `StateBuilder(name: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`)`<br>Builds a State object |

### Properties

| Name | Summary |
|---|---|
| [builder](builder.md) | `val builder: `[`State`](../../org.snakeskin.state/-state/index.md) |

### Functions

| Name | Summary |
|---|---|
| [action](action.md) | `fun action(rate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 20L, action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds the action method to the state |
| [build](build.md) | `open fun build(): `[`State`](../../org.snakeskin.state/-state/index.md) |
| [entry](entry.md) | `fun entry(action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds the entry method to the state |
| [exit](exit.md) | `fun exit(action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds the exit method to the state |

### Inheritors

| Name | Summary |
|---|---|
| [MutableStateBuilder](../-mutable-state-builder/index.md) | `class MutableStateBuilder : `[`StateBuilder`](./index.md)<br>Adds functionality to the StateBuilder, with certain special functions that can't be used in default or disabled states |
