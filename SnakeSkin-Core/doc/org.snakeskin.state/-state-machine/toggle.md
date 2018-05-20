[doc](../../index.md) / [org.snakeskin.state](../index.md) / [StateMachine](index.md) / [toggle](./toggle.md)

# toggle

`fun toggle(state1: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, state2: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`AWaitable`](../../org.snakeskin.ability/-a-waitable/index.md)

Toggles between two states.
The logic is as follows:
If the machine is in state1, switch to state2.  Otherwise, switch to state1
This means that if the machine is in any other state than state1, it will switch to state1.

### Parameters

`state1` - State 1 to toggle

`state2` - State 2 to toggle

**Return**
The waitable of whatever state was switched to

