[doc](../../index.md) / [org.snakeskin.logic](../index.md) / [Rotation2d](index.md) / [normalize](./normalize.md)

# normalize

`fun normalize(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

From trig, we know that sin^2 + cos^2 == 1, but as we do math on this
object we might accumulate rounding errors. Normalizing forces us to
re-scale the sin and cos to reset rounding errors.

