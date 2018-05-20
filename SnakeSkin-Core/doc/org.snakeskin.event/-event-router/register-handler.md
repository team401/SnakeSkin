[doc](../../index.md) / [org.snakeskin.event](../index.md) / [EventRouter](index.md) / [registerHandler](./register-handler.md)

# registerHandler

`@Synchronized @JvmStatic fun registerHandler(event: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, handler: (`[`Parameters`](../../org.snakeskin.logic/-parameters/index.md)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Registers an event handler on the event router

### Parameters

`event` - The event to listen for

`handler` - The function to call when the event is received.  This lambda receives a Parameters object.  @see Parameters