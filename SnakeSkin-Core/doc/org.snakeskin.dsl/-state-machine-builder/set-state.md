[doc](../../index.md) / [org.snakeskin.dsl](../index.md) / [StateMachineBuilder](index.md) / [setState](./set-state.md)

# setState

`fun setState(state: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`AWaitable`](../../org.snakeskin.ability/-a-waitable/index.md)

Sets the state of this machine

### Parameters

`state` - The state to set

**Return**
A waitable object that unblocks when the state's "entry" method finishes

