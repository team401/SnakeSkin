[doc](../index.md) / [org.snakeskin.dsl](index.md) / [commandMachine](./command-machine.md)

# commandMachine

`fun <T> `[`Subsystem`](../org.snakeskin.subsystem/-subsystem/index.md)`.commandMachine(states: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, `[`T`](command-machine.md#T)`>, mapping: `[`StateValuePair`](-state-value-pair/index.md)`<`[`T`](command-machine.md#T)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, setup: `[`StateMachineBuilder`](-state-machine-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`StateMachine`](../org.snakeskin.state/-state-machine/index.md)

Adds a command machine to the subsystem
A command machine extends the behaviour of a state machine, but provides a shorter syntax for many "command" actions
that only need an entry.  Provides the standard state machine builder for hybrid functionality

