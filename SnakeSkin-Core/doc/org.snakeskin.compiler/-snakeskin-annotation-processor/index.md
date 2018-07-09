[doc](../../index.md) / [org.snakeskin.compiler](../index.md) / [SnakeskinAnnotationProcessor](./index.md)

# SnakeskinAnnotationProcessor

`@SupportedSourceVersion(SourceVersion.RELEASE_8) @SupportedOptions(["kapt.kotlin.generated"]) class SnakeskinAnnotationProcessor : `[`AbstractProcessor`](http://docs.oracle.com/javase/6/docs/api/javax/annotation/processing/AbstractProcessor.html)

**Author**
Cameron Earle

**Version**
6/26/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SnakeskinAnnotationProcessor()` |

### Functions

| Name | Summary |
|---|---|
| [getSupportedAnnotationTypes](get-supported-annotation-types.md) | `fun getSupportedAnnotationTypes(): `[`MutableSet`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [process](process.md) | `fun process(annotations: `[`MutableSet`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/index.html)`<out `[`TypeElement`](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/element/TypeElement.html)`>?, roundEnv: `[`RoundEnvironment`](http://docs.oracle.com/javase/6/docs/api/javax/annotation/processing/RoundEnvironment.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [ANNOTATED_RUNNABLE](-a-n-n-o-t-a-t-e-d_-r-u-n-n-a-b-l-e.md) | `const val ANNOTATED_RUNNABLE: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [KAPT_KOTLIN_GENERATED](-k-a-p-t_-k-o-t-l-i-n_-g-e-n-e-r-a-t-e-d.md) | `const val KAPT_KOTLIN_GENERATED: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [SUPPORTED_ANNOTATIONS](-s-u-p-p-o-r-t-e-d_-a-n-n-o-t-a-t-i-o-n-s.md) | `val SUPPORTED_ANNOTATIONS: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
