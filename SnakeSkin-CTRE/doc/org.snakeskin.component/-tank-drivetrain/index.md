[doc](../../index.md) / [org.snakeskin.component](../index.md) / [TankDrivetrain](./index.md)

# TankDrivetrain

`class TankDrivetrain : `[`Drivetrain`](../-drivetrain/index.md)

**Author**
Cameron Earle

**Version**
12/25/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TankDrivetrain(wheelRadius: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, wheelbase: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [imu](imu.md) | `lateinit var imu: PigeonIMU` |
| [invertLeft](invert-left.md) | `var invertLeft: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [invertRight](invert-right.md) | `var invertRight: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [invertShifter](invert-shifter.md) | `var invertShifter: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [left](left.md) | `lateinit var left: `[`Gearbox`](../-gearbox/index.md) |
| [right](right.md) | `lateinit var right: `[`Gearbox`](../-gearbox/index.md) |
| [shifter](shifter.md) | `lateinit var shifter: Solenoid` |
| [shifterState](shifter-state.md) | `var shifterState: `[`ShifterState`](../../org.snakeskin/-shifter-state/index.md) |
| [wheelRadius](wheel-radius.md) | `val wheelRadius: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [wheelbase](wheelbase.md) | `val wheelbase: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |

### Functions

| Name | Summary |
|---|---|
| [arcade](arcade.md) | `fun arcade(mode: ControlMode, translation: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, rotation: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [enableVoltageCompensation](enable-voltage-compensation.md) | `fun enableVoltageCompensation(enable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getDistance](get-distance.md) | `fun getDistance(pidIdx: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [getVelocity](get-velocity.md) | `fun getVelocity(pidIdx: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [getYaw](get-yaw.md) | `fun getYaw(): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [high](high.md) | `fun high(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [init](init.md) | `fun init(left: `[`Gearbox`](../-gearbox/index.md)`, right: `[`Gearbox`](../-gearbox/index.md)`, imu: PigeonIMU, shifter: Solenoid, invertLeft: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, invertRight: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, invertShifter: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [isHigh](is-high.md) | `fun isHigh(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isLow](is-low.md) | `fun isLow(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [low](low.md) | `fun low(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setCurrentLimit](set-current-limit.md) | `fun setCurrentLimit(continuousCurrent: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, peakCurrent: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, peakDuration: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, timeout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setNeutralMode](set-neutral-mode.md) | `fun setNeutralMode(mode: NeutralMode): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setOutputLimits](set-output-limits.md) | `fun setOutputLimits(peakForward: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, peakReverse: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, nominalForward: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, nominalReverse: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, timeout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setPosition](set-position.md) | `fun setPosition(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setRampRate](set-ramp-rate.md) | `fun setRampRate(closedLoop: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, openLoop: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, timeout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setYaw](set-yaw.md) | `fun setYaw(yaw: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, timeout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [shift](shift.md) | `fun shift(state: `[`ShifterState`](../../org.snakeskin/-shifter-state/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stop](stop.md) | `fun stop(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [tank](tank.md) | `fun tank(mode: ControlMode, left: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, right: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [zero](zero.md) | `fun zero(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [cheesy](../../org.snakeskin.dsl/cheesy.md) | `fun `[`TankDrivetrain`](./index.md)`.cheesy(mode: ControlMode, p: `[`CheesyDriveParameters`](../../org.snakeskin.dsl/-cheesy-drive-parameters/index.md)`, throttleIn: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, wheelIn: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, quickTurn: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
