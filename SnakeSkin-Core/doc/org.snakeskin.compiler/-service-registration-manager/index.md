[doc](../../index.md) / [org.snakeskin.compiler](../index.md) / [ServiceRegistrationManager](./index.md)

# ServiceRegistrationManager

`class ServiceRegistrationManager`

**Author**
Cameron Earle

**Version**
6/26/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ServiceRegistrationManager(env: `[`ProcessingEnvironment`](http://docs.oracle.com/javase/6/docs/api/javax/annotation/processing/ProcessingEnvironment.html)`, className: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [className](class-name.md) | `val className: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [env](env.md) | `val env: `[`ProcessingEnvironment`](http://docs.oracle.com/javase/6/docs/api/javax/annotation/processing/ProcessingEnvironment.html) |

### Functions

| Name | Summary |
|---|---|
| [addClass](add-class.md) | `fun addClass(className: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [read](read.md) | `fun read(location: `[`Location`](http://docs.oracle.com/javase/6/docs/api/javax/tools/JavaFileManager/Location.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [write](write.md) | `fun write(writer: `[`Writer`](http://docs.oracle.com/javase/6/docs/api/java/io/Writer.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun write(location: `[`Location`](http://docs.oracle.com/javase/6/docs/api/javax/tools/JavaFileManager/Location.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
