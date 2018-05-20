[doc](../../index.md) / [org.snakeskin.state](../index.md) / [State](./index.md)

# State

`data class State`

### Parameters

`name` - The name of the state

`entry` - The entry actions of the state

`action` - The looping actions of the state

`exit` - The exit actions of the state

`rate` - The rate, in ms, to run the action loop at

`rejectionConditions` - The rejection conditions for this state, which will prevent it being switched to

`timeout` - The timeout length, in ms, to active the timeout

`timeoutTo` - The state to timeout to

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `State(name: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, entry: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, exit: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, rate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 20, rejectionConditions: () -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = {false}, timeout: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = -1L, timeoutTo: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)` = "")` |

### Properties

| Name | Summary |
|---|---|
| [action](action.md) | `var action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>The looping actions of the state |
| [entry](entry.md) | `var entry: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>The entry actions of the state |
| [exit](exit.md) | `var exit: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>The exit actions of the state |
| [name](name.md) | `val name: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)<br>The name of the state |
| [rate](rate.md) | `var rate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>The rate, in ms, to run the action loop at |
| [rejectionConditions](rejection-conditions.md) | `var rejectionConditions: () -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>The rejection conditions for this state, which will prevent it being switched to |
| [timeout](timeout.md) | `var timeout: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>The timeout length, in ms, to active the timeout |
| [timeoutTo](timeout-to.md) | `var timeoutTo: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)<br>The state to timeout to |
