package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.email.archivo.Imagen;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.util.AudioGenerator;
import gal.udc.fic.vvs.util.ImagenGenerator;
import gal.udc.fic.vvs.util.MensajeGenerator;
import gal.udc.fic.vvs.util.TextoGenerator;

@RunWith(JUnitQuickcheck.class)
public class AdjuntoPBT {

	
	@Property
	public void textoAdjuntoObtenerTamañoTest(@From(MensajeGenerator.class) Mensaje mensaje,
			@From(TextoGenerator.class) Texto texto) {
		Adjunto adjunto = new Adjunto(mensaje, texto);

		assertEquals(mensaje.obtenerTamaño() + texto.obtenerTamaño(), adjunto.obtenerTamaño());

	}

	@Property
	public void audioAdjuntoObtenerTamañoTest(@From(MensajeGenerator.class) Mensaje mensaje,
			@From(AudioGenerator.class) Audio audio) {
		Adjunto adjunto = new Adjunto(mensaje, audio);

		assertEquals(mensaje.obtenerTamaño() + audio.obtenerTamaño(), adjunto.obtenerTamaño());
		
	}

	@Property
	public void imagenAdjuntoObtenerTamañoTest(@From(MensajeGenerator.class) Mensaje mensaje,
			@From(ImagenGenerator.class) Imagen imagen) {
		Adjunto adjunto = new Adjunto(mensaje, imagen);
		
		assertEquals(mensaje.obtenerTamaño() + imagen.obtenerTamaño(), adjunto.obtenerTamaño());
		
	}
	
}
