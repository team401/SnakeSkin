[doc](../../index.md) / [org.snakeskin.logic](../index.md) / [ShifterState](./index.md)

# ShifterState

`class ShifterState : `[`PistonState`](../-piston-state/index.md)

Manages the states of a typical shifter piston

### Parameters

`solenoidOnForExtended` - Does the piston extend when the solenoid is on

`extendedForLowGear` - Is the shifter in low gear when the piston is extended

**Author**
Cameron Earle

**Version**
5/30/18

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ShifterState(solenoidOnForExtended: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, extendedForLowGear: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`)`<br>Manages the states of a typical shifter piston |

### Properties

| Name | Summary |
|---|---|
| [HIGH](-h-i-g-h.md) | `val HIGH: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [LOW](-l-o-w.md) | `val LOW: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Inherited Properties

| Name | Summary |
|---|---|
| [EXTENDED](../-piston-state/-e-x-t-e-n-d-e-d.md) | `val EXTENDED: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [RETRACTED](../-piston-state/-r-e-t-r-a-c-t-e-d.md) | `val RETRACTED: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
