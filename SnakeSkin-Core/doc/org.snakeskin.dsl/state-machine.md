[doc](../index.md) / [org.snakeskin.dsl](index.md) / [stateMachine](./state-machine.md)

# stateMachine

`fun `[`Subsystem`](../org.snakeskin.subsystem/-subsystem/index.md)`.stateMachine(setup: `[`StateMachineBuilder`](-state-machine-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`StateMachine`](../org.snakeskin.state/-state-machine/index.md)

Adds a state machine to the subsystem
Should be used within the subsystem itself

### Parameters

`setup` - The function to set up the state machine.  Receives a StateMachineBuilder.  @see StateMachineBuilder

**Return**
The StateMachine object

