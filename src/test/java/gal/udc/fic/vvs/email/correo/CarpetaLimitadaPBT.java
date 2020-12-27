package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;

import java.util.Collection;
import java.util.Vector;

import org.hamcrest.Matchers;
import org.junit.Test;
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
	
	@Property
	public void buscarEnCarpetaLlenaConTamañoTopeTest(
			@From(CarpetaLimitadaGenerator.class) CarpetaLimitada carpeta) throws OperacionInvalida {
		Collection expectedCollection = new Vector();
		
		for (int i = 1; i <= CarpetaLimitadaGenerator.TAMAÑO; i++) {
			Mensaje mensaje = new Mensaje(new Texto("Texto " + i, "Este es el texto " + i));
			expectedCollection.add(mensaje);
			carpeta.añadir(mensaje);
		}
		
		assertEquals(expectedCollection, carpeta.buscar("Texto"));
		assertEquals(expectedCollection.size(), carpeta.buscar("Texto").size());
		
	}
	
	@Property
	public void buscarEnCarpetaLlenaConTamañoMenorQueElTopeTest(
			@From(CarpetaLimitadaGenerator.class) CarpetaLimitada carpeta) throws OperacionInvalida {
		Collection expectedCollection = new Vector();
		
		for (int i = 1; i < CarpetaLimitadaGenerator.TAMAÑO; i++) {
			Mensaje mensaje = new Mensaje(new Texto("Texto " + i, "Este es el texto " + i));
			expectedCollection.add(mensaje);
			carpeta.añadir(mensaje);
		}
		
		assertEquals(expectedCollection, carpeta.buscar("Texto"));
		assertEquals(expectedCollection.size(), carpeta.buscar("Texto").size());
	}
	
	//Otro test que refleja el problema al buscar en CarpetaLimitada
	@Property
	public void buscarTest_conCarpetaSuperandoTamaño(@From(CarpetaLimitadaGenerator.class) CarpetaLimitada carpeta)
			throws OperacionInvalida {
		assertEquals(carpeta.obtenerNoLeidos(), CarpetaLimitadaGenerator.TAMAÑO);

		carpeta.añadir(new Mensaje(new Texto("Mensaje", "Mensaje de prueba")));
		carpeta.añadir(new Mensaje(new Texto("Mensaje", "Mensaje de prueba")));
		carpeta.añadir(new Mensaje(new Texto("Mensaje", "Mensaje de prueba")));

		Collection result = carpeta.buscar("Mensaje");

		assertTrue(result.size() > CarpetaLimitadaGenerator.TAMAÑO);
	}
	
	@Property
	public void establecerComoLeidoTest(
			@From(CarpetaLimitadaGenerator.class) CarpetaLimitada carpeta) throws OperacionInvalida {
		carpeta.establecerLeido(true);

		assertEquals(0, carpeta.obtenerNoLeidos());
	}
	
	@Property
	public void establecerComoNoLeidoTest(
			@From(CarpetaLimitadaGenerator.class) CarpetaLimitada carpeta) throws OperacionInvalida {

		carpeta.establecerLeido(false);

		assertEquals(CarpetaLimitadaGenerator.TAMAÑO, carpeta.obtenerNoLeidos());
	}
	
	@Property
	public void obtenerTamañoMensajesTest(
			@From(CarpetaLimitadaGenerator.class) CarpetaLimitada carpeta) throws OperacionInvalida {

		assertTrue(carpeta.obtenerTamaño() > 0);
	}
	
	/*@Property
	public void eliminarMensajeDeCarpetaTest(
			@From(CarpetaLimitadaGenerator.class) CarpetaLimitada carpeta) throws OperacionInvalida {

		carpeta.eliminar(mensaje);

		thrown.expect(ArrayIndexOutOfBoundsException.class);

		carpetaLimitadaATestear.obtenerHijo(0);
	}*/

}
