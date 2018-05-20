[doc](../../index.md) / [org.snakeskin.state](../index.md) / [StateMachine](index.md) / [getLastState](./get-last-state.md)

# getLastState

`fun getLastState(): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)

Gets the state that the machine was in last
Note that this value is not updated during a state change until the "exit" method of the previous state finishes

**Return**
The state that the machine was last in

