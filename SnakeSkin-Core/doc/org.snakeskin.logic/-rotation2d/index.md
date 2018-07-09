[doc](../../index.md) / [org.snakeskin.logic](../index.md) / [Rotation2d](./index.md)

# Rotation2d

`class Rotation2d : `[`AInterpolatable`](../../org.snakeskin.ability/-a-interpolatable/index.md)`<`[`Rotation2d`](./index.md)`>`

**Author**
Zachary Kozar

**Version**

5/22/17




A rotation in a 2d coordinate frame represented a point on the unit circle
(cosine and sine).
Inspired by Sophus (https://github.com/strasdat/Sophus/tree/master/sophus)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Rotation2d(x: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 1.0, y: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 0.0, normalize: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false)`<br>`Rotation2d(other: `[`Rotation2d`](./index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [degrees](degrees.md) | `val degrees: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [radians](radians.md) | `val radians: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |

### Functions

| Name | Summary |
|---|---|
| [cos](cos.md) | `fun cos(): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [interpolate](interpolate.md) | `fun interpolate(other: `[`Rotation2d`](./index.md)`, x: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Rotation2d`](./index.md)<br>Interpolates between this value and an other value according to a given parameter. If x is 0, the method should return this value. If x is 1, the method should return the other value. If 0 &lt; x &lt; 1, the return value should be interpolated proportionally between the two. |
| [inverse](inverse.md) | `fun inverse(): `[`Rotation2d`](./index.md)<br>The inverse of a Rotation2d "undoes" the effect of this rotation. |
| [normalize](normalize.md) | `fun normalize(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>From trig, we know that sin^2 + cos^2 == 1, but as we do math on this object we might accumulate rounding errors. Normalizing forces us to re-scale the sin and cos to reset rounding errors. |
| [rotateBy](rotate-by.md) | `fun rotateBy(other: `[`Rotation2d`](./index.md)`): `[`Rotation2d`](./index.md)<br>We can rotate this Rotation2d by adding together the effects of it and another rotation. |
| [sin](sin.md) | `fun sin(): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [tan](tan.md) | `fun tan(): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [fromDegrees](from-degrees.md) | `fun fromDegrees(degrees: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Rotation2d`](./index.md) |
| [fromRadians](from-radians.md) | `fun fromRadians(radians: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Rotation2d`](./index.md) |
