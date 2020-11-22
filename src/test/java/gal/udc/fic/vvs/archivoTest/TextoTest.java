package gal.udc.fic.vvs.archivoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class TextoTest {
	private final String nombreTexto = "TextoPrueba";
	private final String contenidoTexto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas metus. ";
	private final String previsualizacionTexto = nombreTexto + "(" + contenidoTexto.length() + " bytes, text/plain)";
	
	@Test
	public void textoObjectIsWellGenerated() {
		Texto textoATestear = new Texto(nombreTexto, contenidoTexto);
		
		assertEquals(nombreTexto, textoATestear.obtenerNombre());
		assertEquals(contenidoTexto, textoATestear.obtenerContenido());
		assertEquals(contenidoTexto.length(), textoATestear.obtenerTamaño());
		assertEquals(previsualizacionTexto, textoATestear.obtenerPreVisualizacion());
	}
}
