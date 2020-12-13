package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Audio;

/**
 * Clase para probar manualmente los métodos de la clase {@link Audio}.
 * 
 * @author Sergio Cortizo De Dios
 */
public class AudioTest {
	private final String nombreAudio = "AudioPrueba";
	private final String contenidoAudio = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas metus. ";
	private final String previsualizacionAudio = nombreAudio + "(" + contenidoAudio.length() + " bytes, audio/ogg)";
	
	/**
	 * Test para comprobar que el método obtenerNombre() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el nombre del audio.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		con una cadena de texto concreta que representa el nombre del audio.
	 * 		(se pasa por parámetro en el constructor).
	 */
	@Test
	public void obtenerNombreTest() {
		Audio textoATestear = new Audio(nombreAudio, contenidoAudio);
		
		assertEquals(nombreAudio, textoATestear.obtenerNombre());
	}
	
	/**
	 * Test para comprobar que el método obtenerContenido() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el contenido del audio.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		con una cadena concreta que representa el contenido del audio
	 * 		(se pasa por parámetro en el constructor).
	 */
	@Test
	public void obtenerContenidoTest() {
		Audio textoATestear = new Audio(nombreAudio, contenidoAudio);
		
		assertEquals(contenidoAudio, textoATestear.obtenerContenido());
	}
	
	/**
	 * Test para comprobar que el método obtenerTamaño() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el tamaño que ocupa el audio.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		con una cadena concreta que representa el contenido del audio
	 * 		(se pasa por parámetro en el constructor).
	 */
	@Test
	public void obtenerTamañoTest() {
		Audio textoATestear = new Audio(nombreAudio, contenidoAudio);
		
		assertEquals(contenidoAudio.length(), textoATestear.obtenerTamaño());
	}
	
	/**
	 * Test para comprobar que el método obtenerPreVisualizacion() 
	 * funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el nombre del audio junto con su tamaño 
	 *  	en el siguiente formato:
	 *  		{Nombre del audio}({nº de bytes} bytes, audio/ogg)
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		con una cadena de texto concreta que representa el nombre del audio
	 * 		y otra cadena representando su contenido
	 * 		(se pasa por parámetro en el constructor).
	 */
	@Test
	public void obtenerPreVisualizacionTest() {
		Audio textoATestear = new Audio(nombreAudio, contenidoAudio);
		
		assertEquals(previsualizacionAudio, textoATestear.obtenerPreVisualizacion());
	}
	
	
}
