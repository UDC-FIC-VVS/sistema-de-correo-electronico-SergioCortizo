package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.util.MensajeGenerator;

@RunWith(JUnitQuickcheck.class)
public class ReenvioPBT {

	@Property
	public void reenvioObtenerTamañoTest(@From(MensajeGenerator.class) Mensaje mensaje,
			@From(MensajeGenerator.class) Mensaje mensajeReenviado) {
		Reenvio reenvio = new Reenvio(mensaje, mensajeReenviado);

		assertEquals(mensaje.obtenerTamaño() + mensajeReenviado.obtenerTamaño(), reenvio.obtenerTamaño());
	}

}
