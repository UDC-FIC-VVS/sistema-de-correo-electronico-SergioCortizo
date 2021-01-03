package gal.udc.fic.vvs.archUnit.archivo;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClass;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.theClass;

import org.junit.runner.RunWith;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

import gal.udc.fic.vvs.email.archivador.Archivador;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "gal.udc.fic.vvs.email.archivo")
public class SingleClassTest {

	@ArchTest
	public static final ArchRule archivador_should_only_be_accessed_by_correos = theClass(Archivador.class).should()
			.onlyBeAccessed().byClassesThat()
			.resideInAnyPackage("gal.udc.fic.vvs.email.correo");

	@ArchTest
	public static final ArchRule archivador_should_not_access_archivo_packages = 
			noClass(Archivador.class).should()
			.accessClassesThat().resideInAnyPackage("gal.udc.fic.vvs.email.archivo");

}
