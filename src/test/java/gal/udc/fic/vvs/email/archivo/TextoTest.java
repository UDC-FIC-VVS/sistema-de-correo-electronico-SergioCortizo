package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class TextoTest {
	private final String nombreTexto = "TextoPrueba";
	private final String contenidoTexto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas metus. ";
	private final String previsualizacionTexto = nombreTexto + "(" + contenidoTexto.length() + " bytes, text/plain)";
	
	@Test
	public void obtenerNombreTest() {
		Texto textoATestear = new Texto(nombreTexto, contenidoTexto);
		
		assertEquals(nombreTexto, textoATestear.obtenerNombre());
	}
	
	@Test
	public void obtenerContenidoTest() {
		Texto textoATestear = new Texto(nombreTexto, contenidoTexto);
		
		assertEquals(contenidoTexto, textoATestear.obtenerContenido());
	}
	
	@Test
	public void obtenerTamañoTest() {
		Texto textoATestear = new Texto(nombreTexto, contenidoTexto);
		
		assertEquals(contenidoTexto.length(), textoATestear.obtenerTamaño());
	}
	
	@Test
	public void obtenerPreVisualizacionTest() {
		Texto textoATestear = new Texto(nombreTexto, contenidoTexto);
		
		assertEquals(previsualizacionTexto, textoATestear.obtenerPreVisualizacion());
	}
}
