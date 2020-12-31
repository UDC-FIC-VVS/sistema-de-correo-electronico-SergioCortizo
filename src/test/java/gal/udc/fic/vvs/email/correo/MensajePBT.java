package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.util.TextoGenerator;

/**
 * Clase para probar usando PBT los métodos de la clase {@link Mensaje}.
 * 
 * @author Sergio Cortizo De Dios
 */
@RunWith(JUnitQuickcheck.class)
public class MensajePBT {
	
	/**
	 * Test para comprobar el método obtenerTamaño() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el tamaño del mensaje sea el mismo que el del texto.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link TextoGenerator} para generar
	 *      contenido para el mensaje aleatoriamente, asegurando que se cumple la
	 *      propiedad independientemente del texto que guarde el mensaje.
	 *
	 * @param texto texto generado aleatoriamente
	 */
	@Property
	public void mensajeObtenerTamañoTest (@From(TextoGenerator.class) Texto texto) {
		Mensaje mensajeATestear = new Mensaje(texto);

		assertEquals(texto.obtenerTamaño(), mensajeATestear.obtenerTamaño());
	}
	
	
}
