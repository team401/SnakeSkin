[doc](../index.md) / [org.snakeskin.dsl](index.md) / [send](./send.md)

# send

`fun send(name: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, setup: `[`MutableParameters`](../org.snakeskin.logic/-mutable-parameters/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Sends an event on the event router

### Parameters

`name` - The event to send

`setup` - The function to set up the event.  Can be used to add parameters to the event.  @see MutableParameters