[doc](../index.md) / [org.snakeskin.dsl](index.md) / [on](./on.md)

# on

`fun on(name: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, action: `[`Parameters`](../org.snakeskin.logic/-parameters/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Registers an event handler

### Parameters

`name` - The event to listen for

`action` - The function to run when the event is received.  This function receives a Parameters object.  @see Parameters