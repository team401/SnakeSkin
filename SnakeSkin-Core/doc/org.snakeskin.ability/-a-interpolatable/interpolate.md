[doc](../../index.md) / [org.snakeskin.ability](../index.md) / [AInterpolatable](index.md) / [interpolate](./interpolate.md)

# interpolate

`abstract fun interpolate(other: `[`T`](index.md#T)`, x: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`T`](index.md#T)

Interpolates between this value and an other value according to a given
parameter. If x is 0, the method should return this value. If x is 1, the
method should return the other value. If 0 &lt; x &lt; 1, the return value
should be interpolated proportionally between the two.

### Parameters

`other` -
*

```
           The value of the upper bound
```

*

`x` -
*

```
           The requested value. Should be between 0 and 1.
```

*

**Return**
AInterpolatable The estimated average between the surrounding

