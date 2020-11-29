package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.email.archivo.Imagen;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Adjunto;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class AdjuntoTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	Mensaje mensaje = new Mensaje((new Texto("Texto de prueba", "Esto es un texto de prueba")));

	Texto texto = new Texto("Texto adjunto", "Este es un texto adjunto");
	Audio audio = new Audio("Audio adjunto", "Dorime iterino amadache dorime ameno ameno");
	Imagen imagen = new Imagen("Imagen adjunta", "==840872=%");

	@Test
	public void textoAdjuntoIsWellFormed() {
		Adjunto adjunto = new Adjunto(mensaje, texto);

		assertEquals(mensaje.obtenerTamaño() + texto.obtenerTamaño(), adjunto.obtenerTamaño());
		assertEquals(mensaje.obtenerVisualizacion() + "\n\nAdxunto: " + texto.obtenerPreVisualizacion(),
				adjunto.obtenerVisualizacion());

	}
	
	@Test
	public void textoAdjuntoObtenerTamañoTest () {
		Adjunto adjunto = new Adjunto(mensaje, texto);
		
		assertEquals(mensaje.obtenerVisualizacion() + "\n\nAdxunto: " + texto.obtenerPreVisualizacion(),
				adjunto.obtenerVisualizacion());
	}

	@Test
	public void audioAdjuntoIsWellFormed() {
		Adjunto adjunto = new Adjunto(mensaje, audio);

		assertEquals(mensaje.obtenerTamaño() + audio.obtenerTamaño(), adjunto.obtenerTamaño());
		assertEquals(mensaje.obtenerVisualizacion() + "\n\nAdxunto: " + audio.obtenerPreVisualizacion(),
				adjunto.obtenerVisualizacion());
	}

	@Test
	public void imagenAdjuntoIsWellFormed() {
		Adjunto adjunto = new Adjunto(mensaje, imagen);
		
		assertEquals(mensaje.obtenerTamaño() + imagen.obtenerTamaño(), adjunto.obtenerTamaño());
		assertEquals(mensaje.obtenerVisualizacion() + "\n\nAdxunto: " + imagen.obtenerPreVisualizacion(),
				adjunto.obtenerVisualizacion());
	}
	
	@Test
	public void expectedNullPointerExceptionWhenMensajeIsNull() {
		Adjunto adjunto = new Adjunto(null, imagen);
		thrown.expect(NullPointerException.class);
		adjunto.obtenerTamaño();
	}
	
	@Test
	public void expectedNullPointerExceptionWhenArchivoIsNull() {
		Adjunto adjunto = new Adjunto(mensaje, null);
		thrown.expect(NullPointerException.class);
		adjunto.obtenerTamaño();
	}
}
