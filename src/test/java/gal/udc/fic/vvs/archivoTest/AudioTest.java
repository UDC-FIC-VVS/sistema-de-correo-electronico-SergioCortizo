package gal.udc.fic.vvs.archivoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Audio;

public class AudioTest {
	private final String nombreAudio = "AudioPrueba";
	private final String contenidoAudio = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas metus. ";
	private final String previsualizacionAudio = nombreAudio + "(" + contenidoAudio.length() + " bytes, audio/ogg)";
	
	@Test
	public void audioObjectIsWellGenerated() {
		Audio textoATestear = new Audio(nombreAudio, contenidoAudio);
		
		assertEquals(nombreAudio, textoATestear.obtenerNombre());
		assertEquals(contenidoAudio, textoATestear.obtenerContenido());
		assertEquals(contenidoAudio.length(), textoATestear.obtenerTamaño());
		assertEquals(previsualizacionAudio, textoATestear.obtenerPreVisualizacion());
	}
}
