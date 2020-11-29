package gal.udc.fic.vvs.correoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Cabecera;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class CabeceraTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private String nombre = "Prueba";
	private String valor = "Valor de prueba";
	private Mensaje mensaje = new Mensaje(new Texto("Mensaje de prueba", "Esto es un mensaje de prueba"));
	
	@Test
	public void cabeceraIsWellFormedTest() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);
		
		assertEquals(mensaje.obtenerTamaño() + nombre.length() + valor.length(),
					cabeceraDePrueba.obtenerTamaño());
		assertEquals(nombre + ": " + valor + "\n" + mensaje.obtenerVisualizacion(),
					cabeceraDePrueba.obtenerVisualizacion());
		
	}
	
	//@Test
	public void cabeceraNoAñadidaSiNombreYValorSonVaciosTest() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, "", "");
		
		//TODO: No tiene sentido añadir cabeceras vacías
		assertEquals(mensaje.obtenerTamaño(),
				cabeceraDePrueba.obtenerTamaño());
		assertEquals(mensaje.obtenerVisualizacion(),
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
}
