[doc](../../index.md) / [org.snakeskin.state](../index.md) / [StateMachine](index.md) / [setState](./set-state.md)

# setState

`fun setState(state: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`AWaitable`](../../org.snakeskin.ability/-a-waitable/index.md)

Sets the state of this machine to the given state.
If the machine is already in the given state, no action is taken.

### Parameters

`state` - The state to switch to

**Return**
A waitable object that unblocks when the state's "entry" finishes

