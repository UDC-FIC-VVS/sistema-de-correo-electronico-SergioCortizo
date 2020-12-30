package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.email.archivo.Imagen;
import gal.udc.fic.vvs.email.archivo.Texto;

/**
 * Clase para probar manualmente los métodos de la clase {@link Adjunto}.
 * 
 * @author Sergio Cortizo De Dios
 */
public class AdjuntoTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	Mensaje mensaje = new Mensaje((new Texto("Texto de prueba", "Esto es un texto de prueba")));

	Texto texto = new Texto("Texto adjunto", "Este es un texto adjunto");
	Audio audio = new Audio("Audio adjunto", "Dorime iterino amadache dorime ameno ameno");
	Imagen imagen = new Imagen("Imagen adjunta", "==840872=%");
	
	/**
	 * Test para comprobar que el método obtenerVisualizacion() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver la visualización tanto del mensaje como del texto adjunto
	 *  	con la sintaxis esperada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void textoAdjuntoObtenerVisualizacionTest() {
		Adjunto adjunto = new Adjunto(mensaje, texto);

		assertEquals(mensaje.obtenerVisualizacion() + "\n\nAdxunto: " + texto.obtenerPreVisualizacion(),
				adjunto.obtenerVisualizacion());

	}
	
	/**
	 * Test para comprobar que el método obtenerPreVisualizacion() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver la previsualización del mensaje con la sintaxis esperada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void mensajeObtenerPreVisualizacionTest () {
		Adjunto adjunto = new Adjunto(mensaje, texto);
		System.out.println(adjunto.obtenerPreVisualizacion());
		
		assertEquals(mensaje.obtenerVisualizacion() + "...",
				adjunto.obtenerPreVisualizacion());
	}
	
	/**
	 * Test para comprobar que el método obtenerVisualizacion() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver la visualización tanto del mensaje como del audio adjunto
	 *  	con la sintaxis esperada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void audioAdjuntoObtenerVisualizacionTest() {
		Adjunto adjunto = new Adjunto(mensaje, audio);

		assertEquals(mensaje.obtenerVisualizacion() + "\n\nAdxunto: " + audio.obtenerPreVisualizacion(),
				adjunto.obtenerVisualizacion());
	}
	
	/**
	 * Test para comprobar que el método obtenerVisualizacion() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver la visualización tanto del mensaje como de la imagen adjunta
	 *  	con la sintaxis esperada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void imagenAdjuntoObtenerVisualizacionTest() {
		Adjunto adjunto = new Adjunto(mensaje, imagen);
		
		assertEquals(mensaje.obtenerVisualizacion() + "\n\nAdxunto: " + imagen.obtenerPreVisualizacion(),
				adjunto.obtenerVisualizacion());
	}
	
	/**
	 * Test para comprobar que la clase lanza una excepción con cualquier método si el
	 * mensaje es nulo.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que la ejecución de cualquier método falle con las condiciones mencionadas
	 *  	anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void expectedNullPointerExceptionWhenMensajeIsNull() {
		Adjunto adjunto = new Adjunto(null, imagen);
		thrown.expect(NullPointerException.class);
		adjunto.obtenerTamaño();
	}
	
	/**
	 * Test para comprobar que la clase lanza una excepción con cualquier método si el
	 * archivo es nulo.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que la ejecución de cualquier método falle con las condiciones mencionadas
	 *  	anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void expectedNullPointerExceptionWhenArchivoIsNull() {
		Adjunto adjunto = new Adjunto(mensaje, null);
		thrown.expect(NullPointerException.class);
		adjunto.obtenerTamaño();
	}
}
