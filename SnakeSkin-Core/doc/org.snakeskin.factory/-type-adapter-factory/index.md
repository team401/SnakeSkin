[doc](../../index.md) / [org.snakeskin.factory](../index.md) / [TypeAdapterFactory](./index.md)

# TypeAdapterFactory

`class TypeAdapterFactory<T>`

**Author**
Cameron Earle

**Version**
12/25/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TypeAdapterFactory()` |

### Functions

| Name | Summary |
|---|---|
| [adapt](adapt.md) | `fun adapt(item: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`T`](index.md#T)`?` |
| [registerAdapter](register-adapter.md) | `fun registerAdapter(clazz: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>, handler: (`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`) -> `[`T`](index.md#T)`): (`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`) -> `[`T`](index.md#T) |
