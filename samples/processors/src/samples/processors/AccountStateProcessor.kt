package samples.processors
import java.io.PrintWriter
import javax.annotation.processing.*
import javax.lang.model.element.TypeElement

@SupportedAnnotationTypes("samples.annotations.AccountState")
@SupportedSourceVersion(javax.lang.model.SourceVersion.RELEASE_21)
public class AccountStateProcessor : AbstractProcessor(){
    override fun process(
        annotations: Set<TypeElement?>?,
        roundEnv: RoundEnvironment?
    ): Boolean {
        annotations?.forEach { annotation ->
            if (annotation?.qualifiedName.toString() == "samples.annotations.AccountState") {
                roundEnv?.getElementsAnnotatedWith(annotation)?.forEach { element ->
                    when (element) {
                        is TypeElement -> {
                            // Process the TypeElement annotation
                            val className = element.qualifiedName.toString()
                            processingEnv.messager.printNote("AccountStateProcessor processing: ${element.qualifiedName}")
                            val lastDot = className.lastIndexOf('.')
                            val packageName = if (lastDot > 0) className.take(lastDot) else null
                            val packagePath = packageName?.replace('.', '/').let {
                                if (it == null) it else "$it/"
                            } ?: ""
                            val simpleClassName = className.substring(lastDot + 1)
                            val generatedClassName = "${simpleClassName}Generated"
                            val qualifiedGeneratedClassName =
                                if(packageName != null) "$packagePath.$generatedClassName" else generatedClassName
                            val generatedFilePath = "$packagePath$generatedClassName"
                            val writer = processingEnv.filer.createSourceFile(generatedClassName).openWriter()
                            val out = PrintWriter(writer)
                            processingEnv.messager.printNote("AccountStateProcessor generating: \n$generatedClassName\n\n")
                            try {
                                out.use { o ->
                                    packageName?.let { o.println("package $it;") }
                                    o.println("public class $generatedClassName {")
                                    o.println("    public void process() {")
                                    o.println("        // Processing logic for $simpleClassName")
                                    o.println("        System.out.println(\"Processing $simpleClassName\");")
                                    o.println("    }")
                                    out.println("}")
                                }
                            } finally {
                                out.close()
                            }
                        }

                        else -> {
                            // Handle other cases if necessary
                        }
                    }
                }
            }
        }
        return true
    }
}