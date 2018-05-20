[doc](../../index.md) / [org.snakeskin.dsl](../index.md) / [StateMachineBuilder](./index.md)

# StateMachineBuilder

`class StateMachineBuilder : `[`Builder`](../-builder/index.md)`<`[`StateMachine`](../../org.snakeskin.state/-state-machine/index.md)`>`

**Author**
Cameron Earle

**Version**
8/16/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `StateMachineBuilder()` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`StateMachine`](../../org.snakeskin.state/-state-machine/index.md) |
| [default](default.md) | `fun default(setup: `[`StateBuilder`](../-state-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds the "default" state to the machine |
| [disabled](disabled.md) | `fun disabled(setup: `[`StateBuilder`](../-state-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds the "disabled" state to the machine |
| [isInState](is-in-state.md) | `fun isInState(state: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Checks if the machine is in the state given |
| [setState](set-state.md) | `fun setState(state: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`AWaitable`](../../org.snakeskin.ability/-a-waitable/index.md)<br>Sets the state of this machine |
| [state](state.md) | `fun state(state: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, setup: `[`MutableStateBuilder`](../-mutable-state-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds a state to the state machine |
| [wasInState](was-in-state.md) | `fun wasInState(state: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Checks if the machine was in the state given |
