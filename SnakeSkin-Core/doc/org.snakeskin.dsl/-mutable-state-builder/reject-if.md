[doc](../../index.md) / [org.snakeskin.dsl](../index.md) / [MutableStateBuilder](index.md) / [rejectIf](./reject-if.md)

# rejectIf

`fun rejectIf(condition: () -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Adds rejection conditions for this state.

### Parameters

`condition` - The function to run to check the conditions.  Should return true if the state change should be rejected