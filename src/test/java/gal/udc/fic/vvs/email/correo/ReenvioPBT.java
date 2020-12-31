package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.util.MensajeGenerator;

/**
 * Clase para probar usando PBT los métodos de la clase {@link Reenvio}.
 * 
 * @author Sergio Cortizo De Dios
 */
@RunWith(JUnitQuickcheck.class)
public class ReenvioPBT {

	/**
	 * Test para comprobar el método obtenerTamaño() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el tamaño de la clase sea el tamaño del mensaje en conjunto
	 *  	con el tamaño del mensaje reenviado.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MensajeGenerator} para generar
	 *      contenido tanto para el mensaje principal como para el mensaje generado
	 *      aleatoriamente, asegurando que se cumple la propiedad independientemente
	 *      del tamaño de ambos mensajes.
	 *
	 * @param mensaje mensaje generado aleatoriamente
	 * @param mensajeReenviado mensaje con el rol de mensaje reenviado generado aleatoriamente
	 */
	@Property
	public void reenvioObtenerTamañoTest(@From(MensajeGenerator.class) Mensaje mensaje,
			@From(MensajeGenerator.class) Mensaje mensajeReenviado) {
		Reenvio reenvio = new Reenvio(mensaje, mensajeReenviado);

		assertEquals(mensaje.obtenerTamaño() + mensajeReenviado.obtenerTamaño(), reenvio.obtenerTamaño());
	}

}
