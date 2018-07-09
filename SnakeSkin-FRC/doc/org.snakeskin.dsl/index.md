[doc](../index.md) / [org.snakeskin.dsl](./index.md)

## Package org.snakeskin.dsl

### Types

| Name | Summary |
|---|---|
| [Components](-components/index.md) | `object Components` |
| [HumanControls](-human-controls/index.md) | `object HumanControls` |
| [Sensors](-sensors/index.md) | `object Sensors` |

### Type Aliases

| Name | Summary |
|---|---|
| [PistonState](-piston-state.md) | `typealias PistonState = `[`PistonState`](../org.snakeskin.logic/-piston-state/index.md) |
| [Publisher](-publisher.md) | `typealias Publisher<T> = `[`Publisher`](../org.snakeskin.publish/-publisher/index.md)`<`[`T`](-publisher.md#T)`>` |
| [Receiver](-receiver.md) | `typealias Receiver<T> = `[`Receiver`](../org.snakeskin.publish/-receiver/index.md)`<`[`T`](-receiver.md#T)`>` |
| [ShifterState](-shifter-state.md) | `typealias ShifterState = `[`ShifterState`](../org.snakeskin.logic/-shifter-state/index.md) |

### Extensions for External Classes

| Name | Summary |
|---|---|
| [edu.wpi.first.wpilibj.DigitalInput](edu.wpi.first.wpilibj.-digital-input/index.md) |  |
| [edu.wpi.first.wpilibj.DigitalOutput](edu.wpi.first.wpilibj.-digital-output/index.md) |  |
| [edu.wpi.first.wpilibj.Solenoid](edu.wpi.first.wpilibj.-solenoid/index.md) |  |
| [edu.wpi.first.wpilibj.interfaces.Gyro](edu.wpi.first.wpilibj.interfaces.-gyro/index.md) |  |
| [org.snakeskin.subsystem.Subsystem](org.snakeskin.subsystem.-subsystem/index.md) |  |

### Functions

| Name | Summary |
|---|---|
| [and](and.md) | `fun Switch.and(other: Switch): Switch` |
| [compareTo](compare-to.md) | `operator fun Rotation2d.compareTo(other: Rotation2d): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [dec](dec.md) | `operator fun Rotation2d.dec(): Rotation2d` |
| [div](div.md) | `operator fun Rotation2d.div(other: Rotation2d): Rotation2d`<br>`operator fun Rotation2d.div(degrees: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): Rotation2d` |
| [inc](inc.md) | `operator fun Rotation2d.inc(): Rotation2d` |
| [invert](invert.md) | `fun Switch.invert(): Switch` |
| [minus](minus.md) | `operator fun Rotation2d.minus(other: Rotation2d): Rotation2d`<br>`operator fun Rotation2d.minus(degrees: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): Rotation2d` |
| [or](or.md) | `fun Switch.or(other: Switch): Switch` |
| [plus](plus.md) | `operator fun Rotation2d.plus(other: Rotation2d): Rotation2d`<br>`operator fun Rotation2d.plus(degrees: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): Rotation2d` |
| [times](times.md) | `operator fun Rotation2d.times(other: Rotation2d): Rotation2d`<br>`operator fun Rotation2d.times(degrees: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): Rotation2d` |
| [unaryMinus](unary-minus.md) | `operator fun Rotation2d.unaryMinus(): Rotation2d` |
