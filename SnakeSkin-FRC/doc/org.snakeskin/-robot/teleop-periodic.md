[doc](../../index.md) / [org.snakeskin](../index.md) / [Robot](index.md) / [teleopPeriodic](./teleop-periodic.md)

# teleopPeriodic

`fun teleopPeriodic(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

This method is fired when the robot receives a packet from the Driver Station, containing controller states.
Therefore, it makes sense to react to these controller state changes in this method rather than their own thread

