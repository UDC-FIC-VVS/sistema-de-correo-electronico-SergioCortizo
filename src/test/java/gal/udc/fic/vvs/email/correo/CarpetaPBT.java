package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Vector;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.util.CarpetaGenerator;

@RunWith(JUnitQuickcheck.class)
public class CarpetaPBT {
	
	@Property
	public void buscarTest(@From(CarpetaGenerator.class) Carpeta carpeta) {
		assertEquals(carpeta.obtenerNoLeidos(), CarpetaGenerator.TAMAÑO);

		Collection result = carpeta.buscar("Mensaje");

		assertEquals(result.size(), carpeta.obtenerNoLeidos());
	}
	
	@Property
	public void buscarEnCarpetaLlenaConTamañoTopeTest(
			@From(CarpetaGenerator.class) Carpeta carpeta) throws OperacionInvalida {
		Collection expectedCollection = new Vector();
		
		for (int i = 1; i <= CarpetaGenerator.TAMAÑO; i++) {
			Mensaje mensaje = new Mensaje(new Texto("Texto " + i, "Este es el texto " + i));
			expectedCollection.add(mensaje);
			carpeta.añadir(mensaje);
		}
		
		assertEquals(expectedCollection, carpeta.buscar("Texto"));
		assertEquals(expectedCollection.size(), carpeta.buscar("Texto").size());
		
	}
	
	@Property
	public void buscarEnCarpetaLlenaConTamañoMenorQueElTopeTest(
			@From(CarpetaGenerator.class) Carpeta carpeta) throws OperacionInvalida {
		Collection expectedCollection = new Vector();
		
		for (int i = 1; i < CarpetaGenerator.TAMAÑO; i++) {
			Mensaje mensaje = new Mensaje(new Texto("Texto " + i, "Este es el texto " + i));
			expectedCollection.add(mensaje);
			carpeta.añadir(mensaje);
		}
		
		assertEquals(expectedCollection, carpeta.buscar("Texto"));
		assertEquals(expectedCollection.size(), carpeta.buscar("Texto").size());
	}
	
	//Otro test que refleja el problema al buscar en CarpetaLimitada
	@Property
	public void buscarTest_conCarpetaSuperandoTamaño(
			@From(CarpetaGenerator.class) Carpeta carpeta)
			throws OperacionInvalida {
		assertEquals(carpeta.obtenerNoLeidos(), CarpetaGenerator.TAMAÑO);

		carpeta.añadir(new Mensaje(new Texto("Mensaje", "Mensaje de prueba")));
		carpeta.añadir(new Mensaje(new Texto("Mensaje", "Mensaje de prueba")));
		carpeta.añadir(new Mensaje(new Texto("Mensaje", "Mensaje de prueba")));

		Collection result = carpeta.buscar("Mensaje");

		assertTrue(result.size() > CarpetaGenerator.TAMAÑO);
	}
	
	@Property
	public void establecerComoLeidoTest(
			@From(CarpetaGenerator.class) Carpeta carpeta) throws OperacionInvalida {
		carpeta.establecerLeido(true);

		assertEquals(0, carpeta.obtenerNoLeidos());
	}
	
	@Property
	public void establecerComoNoLeidoTest(
			@From(CarpetaGenerator.class) Carpeta carpeta) throws OperacionInvalida {

		carpeta.establecerLeido(false);

		assertEquals(CarpetaGenerator.TAMAÑO, carpeta.obtenerNoLeidos());
	}
	
	@Property
	public void obtenerTamañoMensajesTest(
			@From(CarpetaGenerator.class) Carpeta carpeta) throws OperacionInvalida {

		assertTrue(carpeta.obtenerTamaño() > 0);
	}
	
	@Property
	public void eliminarMensajeDeCarpetaTest(
			@From(CarpetaGenerator.class) Carpeta carpeta) throws OperacionInvalida {

		int numAleatorio = (int) (Math.random() * CarpetaGenerator.TAMAÑO);
		
		Correo correoHijo = carpeta.obtenerHijo(numAleatorio);
		
		carpeta.eliminar(correoHijo);
		
		assertFalse(carpeta.explorar().contains(correoHijo));
	}

	@Property
	public void obtenerHijoEnCarpetaWithMensajesTest(
			@From(CarpetaGenerator.class) Carpeta carpeta) throws OperacionInvalida {
		int hijoAleatorio =
				(int) (Math.random() * CarpetaGenerator.TAMAÑO);
		
		Mensaje mensajeEsperado = new Mensaje(
				new Texto(CarpetaGenerator.nombreMensajes,
						CarpetaGenerator.contenidoMensajes + hijoAleatorio));
		
		assertEquals(mensajeEsperado.obtenerVisualizacion(), 
				carpeta.obtenerHijo(hijoAleatorio).obtenerVisualizacion());
		
	}
}
