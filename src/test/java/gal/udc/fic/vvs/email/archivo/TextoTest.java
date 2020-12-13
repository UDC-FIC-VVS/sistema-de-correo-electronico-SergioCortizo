package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

/**
 * Clase para probar de forma manual los métodos de la clase {@link Texto}.
 * 
 * @author Sergio Cortizo De Dios
 */
public class TextoTest {
	private final String nombreTexto = "TextoPrueba";
	private final String contenidoTexto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas metus. ";
	private final String previsualizacionTexto = nombreTexto + "(" + contenidoTexto.length() + " bytes, text/plain)";
	
	/**
	 * Test para comprobar que el método obtenerNombre() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el nombre del texto.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		con una cadena de texto concreta que representa el nombre del texto
	 * 		(se pasa por parámetro en el constructor).
	 */
	@Test
	public void obtenerNombreTest() {
		Texto textoATestear = new Texto(nombreTexto, contenidoTexto);
		
		assertEquals(nombreTexto, textoATestear.obtenerNombre());
	}
	
	/**
	 * Test para comprobar que el método obtenerContenido() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el contenido del texto.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		con una cadena de texto concreta que representa el contenido del texto
	 * 		(se pasa por parámetro en el constructor).
	 */
	@Test
	public void obtenerContenidoTest() {
		Texto textoATestear = new Texto(nombreTexto, contenidoTexto);
		
		assertEquals(contenidoTexto, textoATestear.obtenerContenido());
	}
	
	/**
	 * Test para comprobar que el método obtenerTamaño() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el número de bytes que ocupa el contenido del texto.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		a partir de una cadena de texto concreta que representa el contenido del texto
	 * 		(se pasa por parámetro en el constructor).
	 */
	@Test
	public void obtenerTamañoTest() {
		Texto textoATestear = new Texto(nombreTexto, contenidoTexto);
		
		assertEquals(contenidoTexto.length(), textoATestear.obtenerTamaño());
	}
	
	/**
	 * Test para comprobar que el método obtenerPreVisualizacion() 
	 * funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el nombre del texto junto con su tamaño 
	 *  	en el siguiente formato:
	 *  		{Nombre del texto}({nº de bytes} bytes, text/plain)
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		con una cadena de texto concreta que representa el nombre del texto
	 * 		y otra cadena que representa su contenido
	 * 		(se pasan por parámetros en el constructor).
	 */
	@Test
	public void obtenerPreVisualizacionTest() {
		Texto textoATestear = new Texto(nombreTexto, contenidoTexto);
		
		assertEquals(previsualizacionTexto, textoATestear.obtenerPreVisualizacion());
	}
}
