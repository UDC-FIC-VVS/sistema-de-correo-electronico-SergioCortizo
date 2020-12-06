package gal.udc.fic.vvs.archivoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Audio;

public class AudioTest {
	private final String nombreAudio = "AudioPrueba";
	private final String contenidoAudio = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas metus. ";
	private final String previsualizacionAudio = nombreAudio + "(" + contenidoAudio.length() + " bytes, audio/ogg)";
	
	@Test
	public void obtenerNombreTest() {
		Audio textoATestear = new Audio(nombreAudio, contenidoAudio);
		
		assertEquals(nombreAudio, textoATestear.obtenerNombre());
	}
	
	@Test
	public void obtenerContenidoTest() {
		Audio textoATestear = new Audio(nombreAudio, contenidoAudio);
		
		assertEquals(contenidoAudio, textoATestear.obtenerContenido());
	}
	
	@Test
	public void obtenerTamañoTest() {
		Audio textoATestear = new Audio(nombreAudio, contenidoAudio);
		
		assertEquals(contenidoAudio.length(), textoATestear.obtenerTamaño());
	}
	
	@Test
	public void obtenerPreVisualizacionTest() {
		Audio textoATestear = new Audio(nombreAudio, contenidoAudio);
		
		assertEquals(previsualizacionAudio, textoATestear.obtenerPreVisualizacion());
	}
	
	
}
