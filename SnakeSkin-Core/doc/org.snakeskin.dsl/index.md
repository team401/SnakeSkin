[doc](../index.md) / [org.snakeskin.dsl](./index.md)

## Package org.snakeskin.dsl

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T>` |
| [MutableStateBuilder](-mutable-state-builder/index.md) | `class MutableStateBuilder : `[`StateBuilder`](-state-builder/index.md)<br>Adds functionality to the StateBuilder, with certain special functions that can't be used in default or disabled states |
| [StateBuilder](-state-builder/index.md) | `open class StateBuilder : `[`Builder`](-builder/index.md)`<`[`State`](../org.snakeskin.state/-state/index.md)`>`<br>Builds a State object |
| [StateMachineBuilder](-state-machine-builder/index.md) | `class StateMachineBuilder : `[`Builder`](-builder/index.md)`<`[`StateMachine`](../org.snakeskin.state/-state-machine/index.md)`>` |
| [StateValuePair](-state-value-pair/index.md) | `class StateValuePair<T>` |

### Type Aliases

| Name | Summary |
|---|---|
| [BooleanState](-boolean-state.md) | `typealias BooleanState = `[`BooleanState`](../org.snakeskin.logic/-boolean-state/index.md) |
| [Events](-events.md) | `typealias Events = `[`Events`](../org.snakeskin.event/-events/index.md) |
| [Setup](-setup.md) | `typealias Setup = `[`Setup`](../org.snakeskin.annotation/-setup/index.md) |
| [Subsystem](-subsystem.md) | `typealias Subsystem = `[`Subsystem`](../org.snakeskin.subsystem/-subsystem/index.md) |
| [Subsystems](-subsystems.md) | `typealias Subsystems = `[`Subsystems`](../org.snakeskin.registry/-subsystems/index.md) |

### Functions

| Name | Summary |
|---|---|
| [booleanCommandMachine](boolean-command-machine.md) | `fun `[`Subsystem`](../org.snakeskin.subsystem/-subsystem/index.md)`.booleanCommandMachine(mapping: `[`StateValuePair`](-state-value-pair/index.md)`<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, setup: `[`StateMachineBuilder`](-state-machine-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`StateMachine`](../org.snakeskin.state/-state-machine/index.md) |
| [commandMachine](command-machine.md) | `fun <T> `[`Subsystem`](../org.snakeskin.subsystem/-subsystem/index.md)`.commandMachine(states: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, `[`T`](command-machine.md#T)`>, mapping: `[`StateValuePair`](-state-value-pair/index.md)`<`[`T`](command-machine.md#T)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, setup: `[`StateMachineBuilder`](-state-machine-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`StateMachine`](../org.snakeskin.state/-state-machine/index.md)<br>Adds a command machine to the subsystem A command machine extends the behaviour of a state machine, but provides a shorter syntax for many "command" actions that only need an entry.  Provides the standard state machine builder for hybrid functionality |
| [on](on.md) | `fun on(name: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, action: `[`Parameters`](../org.snakeskin.logic/-parameters/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Registers an event handler |
| [send](send.md) | `fun send(name: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, setup: `[`MutableParameters`](../org.snakeskin.logic/-mutable-parameters/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sends an event on the event router |
| [stateMachine](state-machine.md) | `fun `[`Subsystem`](../org.snakeskin.subsystem/-subsystem/index.md)`.stateMachine(setup: `[`StateMachineBuilder`](-state-machine-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`StateMachine`](../org.snakeskin.state/-state-machine/index.md)<br>Adds a state machine to the subsystem Should be used within the subsystem itself |
| [stateMap](state-map.md) | `fun <T> stateMap(vararg pairs: `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, `[`T`](state-map.md#T)`>): `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, `[`T`](state-map.md#T)`>`<br>Creates a map that forces the output type T, which mapOf doesn't Essentially makes type inference work in command machines |
