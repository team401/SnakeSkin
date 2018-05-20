[doc](../../index.md) / [org.snakeskin.state](../index.md) / [StateMachine](./index.md)

# StateMachine

`class StateMachine`

**Author**
Cameron Earle

**Version**
8/3/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `StateMachine()` |

### Properties

| Name | Summary |
|---|---|
| [elseCondition](else-condition.md) | `var elseCondition: `[`State`](../-state/index.md)<br>The state to go to when a state change is requested for a state that doesn't exist |

### Functions

| Name | Summary |
|---|---|
| [addState](add-state.md) | `fun addState(state: `[`State`](../-state/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Adds a state to this state machine |
| [back](back.md) | `fun back(): `[`AWaitable`](../../org.snakeskin.ability/-a-waitable/index.md)<br>Returns the state machine to the state it was in previously |
| [getLastState](get-last-state.md) | `fun getLastState(): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)<br>Gets the state that the machine was in last Note that this value is not updated during a state change until the "exit" method of the previous state finishes |
| [getState](get-state.md) | `fun getState(): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)<br>Gets the state that the machine is currently in Note that this value is not updated during a state change until the "exit" method of the previous state finishes |
| [isInState](is-in-state.md) | `fun isInState(state: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Checks if a machine is in the given state |
| [setState](set-state.md) | `fun setState(state: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`AWaitable`](../../org.snakeskin.ability/-a-waitable/index.md)<br>Sets the state of this machine to the given state. If the machine is already in the given state, no action is taken. |
| [toggle](toggle.md) | `fun toggle(state1: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, state2: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`AWaitable`](../../org.snakeskin.ability/-a-waitable/index.md)<br>Toggles between two states. The logic is as follows: If the machine is in state1, switch to state2.  Otherwise, switch to state1 This means that if the machine is in any other state than state1, it will switch to state1. |
| [wasInState](was-in-state.md) | `fun wasInState(state: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Checks if a machine was in the given state |

### Companion Object Properties

| Name | Summary |
|---|---|
| [EMPTY_LAMBDA](-e-m-p-t-y_-l-a-m-b-d-a.md) | `val EMPTY_LAMBDA: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>An shared reference to an empty lambda, which can be used as a default value to avoid running empty tasks on the executor.  Checks should be made using the "===" in Kotlin to check reference equality |
