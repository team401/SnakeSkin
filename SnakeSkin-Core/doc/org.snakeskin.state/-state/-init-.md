[doc](../../index.md) / [org.snakeskin.state](../index.md) / [State](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`State(name: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, entry: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, exit: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, rate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 20, rejectionConditions: () -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = {false}, timeout: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = -1L, timeoutTo: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)` = "")`

### Parameters

`name` - The name of the state

`entry` - The entry actions of the state

`action` - The looping actions of the state

`exit` - The exit actions of the state

`rate` - The rate, in ms, to run the action loop at

`rejectionConditions` - The rejection conditions for this state, which will prevent it being switched to

`timeout` - The timeout length, in ms, to active the timeout

`timeoutTo` - The state to timeout to

**Author**
Cameron Earle

**Version**
8/3/17

