[doc](../../index.md) / [org.snakeskin.dsl](../index.md) / [StateBuilder](index.md) / [action](./action.md)

# action

`fun action(rate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 20L, action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Adds the action method to the state

### Parameters

`rate` - The rate, in ms, to run the action loop at

`action` - The function to run on the state's loop