[doc](../index.md) / [org.snakeskin.dsl](./index.md)

## Package org.snakeskin.dsl

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T>` |
| [MutableStateBuilder](-mutable-state-builder/index.md) | `class MutableStateBuilder : `[`StateBuilder`](-state-builder/index.md)<br>Adds functionality to the StateBuilder, with certain special functions that can't be used in default or disabled states |
| [StateBuilder](-state-builder/index.md) | `open class StateBuilder : `[`Builder`](-builder/index.md)`<`[`State`](../org.snakeskin.state/-state/index.md)`>`<br>Builds a State object |
| [StateMachineBuilder](-state-machine-builder/index.md) | `class StateMachineBuilder : `[`Builder`](-builder/index.md)`<`[`StateMachine`](../org.snakeskin.state/-state-machine/index.md)`>` |

### Type Aliases

| Name | Summary |
|---|---|
| [Events](-events.md) | `typealias Events = `[`Events`](../org.snakeskin.event/-events/index.md) |
| [Setup](-setup.md) | `typealias Setup = `[`Setup`](../org.snakeskin.annotation/-setup/index.md) |
| [Subsystem](-subsystem.md) | `typealias Subsystem = `[`Subsystem`](../org.snakeskin.subsystem/-subsystem/index.md)<br>Aliases to allow access to certain classes by importing 'org.snakeskin.dsl.*' |
| [Subsystems](-subsystems.md) | `typealias Subsystems = `[`Subsystems`](../org.snakeskin.registry/-subsystems/index.md) |

### Functions

| Name | Summary |
|---|---|
| [on](on.md) | `fun on(name: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, action: `[`Parameters`](../org.snakeskin.logic/-parameters/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Registers an event handler |
| [send](send.md) | `fun send(name: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, setup: `[`MutableParameters`](../org.snakeskin.logic/-mutable-parameters/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sends an event on the event router |
| [stateMachine](state-machine.md) | `fun `[`Subsystem`](../org.snakeskin.subsystem/-subsystem/index.md)`.stateMachine(setup: `[`StateMachineBuilder`](-state-machine-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`StateMachine`](../org.snakeskin.state/-state-machine/index.md)<br>Adds a state machine to the subsystem Should be used within the subsystem itself |
