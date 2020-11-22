package gal.udc.fic.vvs.correoTest;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.junit.rules.ExpectedException;

import java.util.Collection;
import java.util.Vector;

import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;
import gal.udc.fic.vvs.email.correo.Reenvio;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Cabecera;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.CarpetaLimitada;

public class ReenvioTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	Mensaje mensaje = new Mensaje(new Texto("Texto de prueba", "Este es un texto de prueba"));

	Mensaje mensajeReenviado = new Mensaje(
			new Texto("Texto de prueba reenviado", "Este es un texto de prueba reenviado"));

	@Test
	public void reenvioIsWellFormedTest() {
		Reenvio reenvio = new Reenvio(mensaje, mensajeReenviado);

		assertEquals(mensaje.obtenerTamaño() + mensajeReenviado.obtenerTamaño(), reenvio.obtenerTamaño());
		assertEquals(
				mensaje.obtenerVisualizacion() + "\n\n---- Correo reenviado ----\n\n"
						+ mensajeReenviado.obtenerVisualizacion() + "\n---- Fin correo reenviado ----",
				reenvio.obtenerVisualizacion());
	}
	
	@Test
	public void nullPointerExceptionExceptedWhenMensajeIsNull() {
		Reenvio reenvio = new Reenvio(null, mensajeReenviado);
		
		thrown.expect(NullPointerException.class);
		
		reenvio.obtenerTamaño();
	}
	
	@Test
	public void nullPointerExceptionExceptedWhenCorreoIsNull() {
		Reenvio reenvio = new Reenvio(mensaje, null);
		
		thrown.expect(NullPointerException.class);
		
		reenvio.obtenerTamaño();
	}
}
