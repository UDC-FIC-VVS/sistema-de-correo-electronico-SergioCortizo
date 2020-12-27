package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Vector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CabeceraTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private String nombre = "Prueba";
	private String valor = "Valor de prueba";
	private Mensaje mensaje = new Mensaje(new Texto("Mensaje de prueba", "Esto es un mensaje de prueba"));
	private Carpeta carpeta = new Carpeta(nombre);
	
	@Test
	public void cabeceraObtenerVisualizacionTest() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		assertEquals(nombre + ": " + valor + "\n" + mensaje.obtenerVisualizacion(),
				cabeceraDePrueba.obtenerVisualizacion());

	}

	@Test
	public void cabeceraNoAñadidaSiNombreYValorSonVaciosTest() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, "", "");

		// TODO: No tiene sentido añadir cabeceras vacías
		assertEquals(mensaje.obtenerTamaño(), cabeceraDePrueba.obtenerTamaño());
		assertEquals("" + ": " + "" + "\n" + mensaje.obtenerVisualizacion(),
				cabeceraDePrueba.obtenerVisualizacion());
	}

	@Test
	public void cabeceraNoAñadidaSiValorEsNullTest() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, null);
		thrown.expect(NullPointerException.class);
		cabeceraDePrueba.obtenerTamaño();
	}

	@Test
	public void cabeceraNoAñadidaSiNombreEsNullTest() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, null, valor);
		thrown.expect(NullPointerException.class);
		cabeceraDePrueba.obtenerTamaño();
	}

	@Test
	public void cabeceraNoAñadidaSiMensajeEsNullTest() {
		Cabecera cabeceraDePrueba = new Cabecera(null, nombre, valor);
		thrown.expect(NullPointerException.class);
		cabeceraDePrueba.obtenerTamaño();
	}

	@Test
	public void obtenerNoLeidosConMensaje() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		assertEquals(cabeceraDePrueba.obtenerNoLeidos(), 1);
	}

	@Test
	public void establecerLeidoConMensaje() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		cabeceraDePrueba.establecerLeido(true);

		assertEquals(cabeceraDePrueba.obtenerNoLeidos(), 0);
	}

	@Test
	public void obtenerIconoConMensajeNoLeido() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		assertEquals(cabeceraDePrueba.obtenerIcono(), Correo.ICONO_NUEVO_MENSAJE);
	}

	@Test
	public void obtenerIconoConMensajeLeido() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		cabeceraDePrueba.establecerLeido(true);

		assertEquals(cabeceraDePrueba.obtenerIcono(), Correo.ICONO_MENSAJE);
	}

	@Test
	public void obtenerPreVisualizacion() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		assertEquals(cabeceraDePrueba.obtenerPreVisualizacion(), mensaje.obtenerPreVisualizacion());
	}

	@Test
	public void obtenerRutaSinCarpetaPadre() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		assertEquals(cabeceraDePrueba.obtenerRuta(), mensaje.obtenerRuta());
	}

	@Test
	public void obtenerRutaConCarpetaPadre() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);
		Carpeta carpeta = new Carpeta("Carpeta de prueba");

		cabeceraDePrueba.establecerPadre(carpeta);

		assertEquals(cabeceraDePrueba.obtenerRuta(), mensaje.obtenerRuta());
	}
	
	@Test
	public void explorarTestOperacionInvalidaExceptionExpected() throws OperacionInvalida {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		thrown.expect(OperacionInvalida.class);
		
		cabeceraDePrueba.explorar();
	}
	
	@Test
	public void añadirTestOperacionInvalidaExceptionExpected() throws OperacionInvalida {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		thrown.expect(OperacionInvalida.class);
		
		cabeceraDePrueba.añadir(mensaje);
	}
	
	@Test
	public void eliminarTestOperacionInvalidaExceptionExpected() throws OperacionInvalida {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		thrown.expect(OperacionInvalida.class);
		
		cabeceraDePrueba.eliminar(mensaje);
	}
	
	@Test
	public void obtenerHijoTestOperacionInvalidaExceptionExpected() throws OperacionInvalida {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		thrown.expect(OperacionInvalida.class);
		
		cabeceraDePrueba.obtenerHijo(0);
	}
	
	@Test
	public void obtenerPadreSinCarpetaPadre() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		assertEquals(null, cabeceraDePrueba.obtenerPadre());
	}
	
	@Test
	public void obtenerPadreConCarpetaPadre() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		cabeceraDePrueba.establecerPadre(carpeta);
		
		assertEquals(carpeta, cabeceraDePrueba.obtenerPadre());
	}
	
	@Test
	public void buscarConExito() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		Collection collectionExpected = new Vector();
		collectionExpected.add(cabeceraDePrueba);
		
		Collection collectionObtained = cabeceraDePrueba.buscar("prueba");
		
		assertEquals(collectionObtained, collectionExpected);
	}
}
