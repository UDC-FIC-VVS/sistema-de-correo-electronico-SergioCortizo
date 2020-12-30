package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.util.MensajeGenerator;
import gal.udc.fic.vvs.util.TextoGenerator;

/**
 * Clase para probar usando PBT los métodos de la clase {@link Cabecera}.
 * 
 * @author Sergio Cortizo De Dios
 */
@RunWith(JUnitQuickcheck.class)
public class CabeceraPBT {
	
	/**
	 * Test para comprobar el método obtenerTamaño() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el tamaño se indique correctamente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usan las clases {@link MensajeGenerator} para generar
	 *      mensajes aleatorios y {@link StringGenerator} para generar nombres y valores de cabecera aleatorios,
	 *      esperando que se devuelva el resultado esperado dependiendo del contenido tanto del
	 *      mensaje como de la cabecera asociada.
	 *
	 * @param mensaje mensaje generado aleatoriamente
	 * @param nombre nombre de cabecera generado aleatoriamente
	 * @param valor valor de cabecera generado aleatoriamente
	 */
	@Property
	public void cabeceraObtenerTamañoTest(@From(MensajeGenerator.class) Mensaje mensaje,
			@From(StringGenerator.class) String nombre,
			@From(StringGenerator.class) String valor) {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		assertEquals(mensaje.obtenerTamaño() + nombre.length() + valor.length(), cabeceraDePrueba.obtenerTamaño());
		
	}
}
