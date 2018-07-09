[doc](../../index.md) / [org.snakeskin.rt](../index.md) / [RealTimeExecutor](index.md) / [getDt](./get-dt.md)

# getDt

`fun getDt(): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)

Gets the most recent dt (seconds between last run and this one) value from the executor
Useful for analysing how accurately the executor is maintaining the desired rate.  It should be
very close to the rate property.  If not, something in your real time code is taking too long and should be removed.

