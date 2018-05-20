[doc](../../index.md) / [org.snakeskin.state](../index.md) / [StateMachine](index.md) / [getState](./get-state.md)

# getState

`fun getState(): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)

Gets the state that the machine is currently in
Note that this value is not updated during a state change until the "exit" method of the previous state finishes

**Return**
The state that the machine is currently in

