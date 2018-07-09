[doc](../../index.md) / [org.snakeskin.compiler](../index.md) / [AnnotatedRunnableGenerator](./index.md)

# AnnotatedRunnableGenerator

`class AnnotatedRunnableGenerator`

**Author**
Cameron Earle

**Version**
6/26/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AnnotatedRunnableGenerator(env: `[`ProcessingEnvironment`](http://docs.oracle.com/javase/6/docs/api/javax/annotation/processing/ProcessingEnvironment.html)`, annotationName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [annotationName](annotation-name.md) | `val annotationName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [env](env.md) | `val env: `[`ProcessingEnvironment`](http://docs.oracle.com/javase/6/docs/api/javax/annotation/processing/ProcessingEnvironment.html) |

### Functions

| Name | Summary |
|---|---|
| [generate](generate.md) | `fun generate(method: `[`ExecutableElement`](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/element/ExecutableElement.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [GET_NAME_METHOD](-g-e-t_-n-a-m-e_-m-e-t-h-o-d.md) | `const val GET_NAME_METHOD: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [RUN_METHOD](-r-u-n_-m-e-t-h-o-d.md) | `const val RUN_METHOD: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [getMethodQualifiedName](get-method-qualified-name.md) | `fun getMethodQualifiedName(method: `[`ExecutableElement`](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/element/ExecutableElement.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
