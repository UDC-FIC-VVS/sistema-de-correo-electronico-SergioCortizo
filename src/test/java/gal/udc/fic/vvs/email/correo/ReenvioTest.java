package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gal.udc.fic.vvs.email.archivo.Texto;

/**
 * Clase para probar manualmente los métodos de la clase {@link Reenvio}.
 * 
 * @author Sergio Cortizo De Dios
 */
public class ReenvioTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	Mensaje mensaje = new Mensaje(new Texto("Texto de prueba", "Este es un texto de prueba"));

	Mensaje mensajeReenviado = new Mensaje(
			new Texto("Texto de prueba reenviado", "Este es un texto de prueba reenviado"));
	
	/**
	 * Test para comprobar que el método obtenerVisualizacion() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se obtenga la visualización del reenvío con la sintaxis esperada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void reenvioObtenerVisualizacionTest() {
		Reenvio reenvio = new Reenvio(mensaje, mensajeReenviado);

		assertEquals(
				mensaje.obtenerVisualizacion() + "\n\n---- Correo reenviado ----\n\n"
						+ mensajeReenviado.obtenerVisualizacion() + "\n---- Fin correo reenviado ----",
				reenvio.obtenerVisualizacion());
	}
	
	/**
	 * Test para comprobar que si el mensaje es nulo, cualquier método de la clase lanza
	 * la excepción {@link NullPointerException}.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se obtenga la excepción mencionada anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void nullPointerExceptionExceptedWhenMensajeIsNull() {
		Reenvio reenvio = new Reenvio(null, mensajeReenviado);
		
		thrown.expect(NullPointerException.class);
		
		reenvio.obtenerTamaño();
	}
	
	/**
	 * Test para comprobar que si el mensaje reenviado es nulo, cualquier método de la clase lanza
	 * la excepción {@link NullPointerException}.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se obtenga la excepción mencionada anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void nullPointerExceptionExceptedWhenCorreoIsNull() {
		Reenvio reenvio = new Reenvio(mensaje, null);
		
		thrown.expect(NullPointerException.class);
		
		reenvio.obtenerTamaño();
	}
}
