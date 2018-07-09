[doc](../index.md) / [org.snakeskin.dsl](index.md) / [stateMap](./state-map.md)

# stateMap

`fun <T> stateMap(vararg pairs: `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, `[`T`](state-map.md#T)`>): `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, `[`T`](state-map.md#T)`>`

Creates a map that forces the output type T, which mapOf doesn't
Essentially makes type inference work in command machines

