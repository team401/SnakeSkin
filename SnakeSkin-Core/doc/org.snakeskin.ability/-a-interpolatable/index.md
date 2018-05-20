[doc](../../index.md) / [org.snakeskin.ability](../index.md) / [AInterpolatable](./index.md)

# AInterpolatable

`interface AInterpolatable<T>`

**Author**
Zachary Kozar

**Version**

5/22/17



AInterpolatable is an interface used by an Interpolating Tree as the Value type.
Given two end points and an interpolation parameter on [0,1](#), it calculates
a new AInterpolatable representing the interpolated value.

**Parameters**
The Type of AInterpolatable

### Functions

| Name | Summary |
|---|---|
| [interpolate](interpolate.md) | `abstract fun interpolate(other: `[`T`](index.md#T)`, x: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`T`](index.md#T)<br>Interpolates between this value and an other value according to a given parameter. If x is 0, the method should return this value. If x is 1, the method should return the other value. If 0 &lt; x &lt; 1, the return value should be interpolated proportionally between the two. |

### Inheritors

| Name | Summary |
|---|---|
| [Rotation2d](../../org.snakeskin.logic/-rotation2d/index.md) | `class Rotation2d : `[`AInterpolatable`](./index.md)`<`[`Rotation2d`](../../org.snakeskin.logic/-rotation2d/index.md)`>` |
