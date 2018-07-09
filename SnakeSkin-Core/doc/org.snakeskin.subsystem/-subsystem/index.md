[doc](../../index.md) / [org.snakeskin.subsystem](../index.md) / [Subsystem](./index.md)

# Subsystem

`open class Subsystem`

**Author**
Cameron Earle

**Version**
7/4/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Subsystem(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, loopRate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 20L)` |

### Properties

| Name | Summary |
|---|---|
| [name](name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [action](action.md) | `open fun action(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Looping actions for this subsystem |
| [addStateMachine](add-state-machine.md) | `fun addStateMachine(machine: `[`StateMachine`](../../org.snakeskin.state/-state-machine/index.md)` = StateMachine()): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Adds a state machine to this subsystem |
| [clearFault](clear-fault.md) | `fun clearFault(fault: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Removes a fault from this subsystem |
| [fault](fault.md) | `fun fault(fault: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Registers the specified fault to this subsystem |
| [isFaulted](is-faulted.md) | `fun isFaulted(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this subsystem has any faults`fun isFaulted(vararg faults: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this subsystem has any of the provided faults |
| [setup](setup.md) | `open fun setup(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Setup tasks for this subsystem |

### Extension Functions

| Name | Summary |
|---|---|
| [booleanCommandMachine](../../org.snakeskin.dsl/boolean-command-machine.md) | `fun `[`Subsystem`](./index.md)`.booleanCommandMachine(mapping: `[`StateValuePair`](../../org.snakeskin.dsl/-state-value-pair/index.md)`<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, setup: `[`StateMachineBuilder`](../../org.snakeskin.dsl/-state-machine-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`StateMachine`](../../org.snakeskin.state/-state-machine/index.md) |
| [commandMachine](../../org.snakeskin.dsl/command-machine.md) | `fun <T> `[`Subsystem`](./index.md)`.commandMachine(states: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, `[`T`](../../org.snakeskin.dsl/command-machine.md#T)`>, mapping: `[`StateValuePair`](../../org.snakeskin.dsl/-state-value-pair/index.md)`<`[`T`](../../org.snakeskin.dsl/command-machine.md#T)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, setup: `[`StateMachineBuilder`](../../org.snakeskin.dsl/-state-machine-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`StateMachine`](../../org.snakeskin.state/-state-machine/index.md)<br>Adds a command machine to the subsystem A command machine extends the behaviour of a state machine, but provides a shorter syntax for many "command" actions that only need an entry.  Provides the standard state machine builder for hybrid functionality |
| [stateMachine](../../org.snakeskin.dsl/state-machine.md) | `fun `[`Subsystem`](./index.md)`.stateMachine(setup: `[`StateMachineBuilder`](../../org.snakeskin.dsl/-state-machine-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`StateMachine`](../../org.snakeskin.state/-state-machine/index.md)<br>Adds a state machine to the subsystem Should be used within the subsystem itself |
