package gal.udc.fic.vvs.archUnit.correo;

import org.junit.runner.RunWith;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "gal.udc.fic.vvs.email.correo")
public class MethodsTest {
	
	@ArchTest
    public static ArchRule all_nombre__contenido_previsualizacion_methods_in_archivo_should_return_string = 
    	methods().that().haveNameMatching(".*Nombre")
    		.and().haveNameMatching(".*Contenido")
    		.and().haveNameMatching(".*PreVisualizacion")
    		.should().haveRawReturnType(String.class);
	
	@ArchTest
    public static ArchRule all_tamaño_methods_in_archivo_should_return_int = 
    	methods().that().haveNameMatching(".*Tamaño")
    		.should().haveRawReturnType("int");
}
