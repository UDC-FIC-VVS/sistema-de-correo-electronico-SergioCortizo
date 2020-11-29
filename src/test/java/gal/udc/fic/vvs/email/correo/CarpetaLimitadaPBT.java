package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;

import java.util.Collection;

import org.hamcrest.Matchers;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.util.CollectionGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.util.CarpetaLimitadaGenerator;

@RunWith(JUnitQuickcheck.class)
public class CarpetaLimitadaPBT {

	@Property
	public void buscarTest(@From(CarpetaLimitadaGenerator.class) CarpetaLimitada carpeta) {
		assertEquals(carpeta.obtenerNoLeidos(), CarpetaLimitadaGenerator.TAMAÑO);

		Collection result = carpeta.buscar("Mensaje");

		assertEquals(result.size(), carpeta.obtenerNoLeidos());
	}
	
	//Otro test que refleja el problema al buscar en CarpetaLimitada
	//@Property
	public void buscarTest_conCarpetaSuperandoTamaño(@From(CarpetaLimitadaGenerator.class) CarpetaLimitada carpeta)
			throws OperacionInvalida {
		assertEquals(carpeta.obtenerNoLeidos(), CarpetaLimitadaGenerator.TAMAÑO);

		carpeta.añadir(new Mensaje(new Texto("Mensaje", "Mensaje de prueba")));
		carpeta.añadir(new Mensaje(new Texto("Mensaje", "Mensaje de prueba")));
		carpeta.añadir(new Mensaje(new Texto("Mensaje", "Mensaje de prueba")));

		Collection result = carpeta.buscar("Mensaje");

		assertEquals(result.size(), CarpetaLimitadaGenerator.TAMAÑO);
	}
}
