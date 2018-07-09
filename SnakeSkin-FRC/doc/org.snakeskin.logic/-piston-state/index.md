[doc](../../index.md) / [org.snakeskin.logic](../index.md) / [PistonState](./index.md)

# PistonState

`open class PistonState : BooleanState`

### Parameters

`solenoidOnForExtended` - Does the piston become extended when the solenoid is turned on

**Author**
Cameron Earle

**Version**

5/30/18




Manages the state of a piston.  Provides "enums" for extended and retracted

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PistonState(solenoidOnForExtended: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [EXTENDED](-e-x-t-e-n-d-e-d.md) | `val EXTENDED: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [RETRACTED](-r-e-t-r-a-c-t-e-d.md) | `val RETRACTED: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [ShifterState](../-shifter-state/index.md) | `class ShifterState : `[`PistonState`](./index.md)<br>Manages the states of a typical shifter piston |
