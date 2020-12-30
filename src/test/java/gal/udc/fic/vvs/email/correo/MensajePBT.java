package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.util.MensajeGenerator;
import gal.udc.fic.vvs.util.TextoGenerator;

@RunWith(JUnitQuickcheck.class)
public class MensajePBT {

	@Property
	public void obtenerPrevisualizacion(@From(MensajeGenerator.class) Mensaje mensaje) {
		assertTrue(mensaje.obtenerPreVisualizacion().length() <= 35);
	}
	
	@Property
	public void mensajeObtenerTamañoTest (@From(TextoGenerator.class) Texto texto) {
		Mensaje mensajeATestear = new Mensaje(texto);

		assertEquals(texto.obtenerTamaño(), mensajeATestear.obtenerTamaño());
	}
	
	
}
