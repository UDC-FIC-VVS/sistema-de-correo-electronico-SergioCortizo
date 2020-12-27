package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.util.MensajeGenerator;

@RunWith(JUnitQuickcheck.class)
public class CabeceraPBT {
	
	@Property
	public void cabeceraObtenerTamañoTest(@From(MensajeGenerator.class) Mensaje mensaje,
			@From(StringGenerator.class) String nombre,
			@From(StringGenerator.class) String valor) {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		assertEquals(mensaje.obtenerTamaño() + nombre.length() + valor.length(), cabeceraDePrueba.obtenerTamaño());
		
	}
}
