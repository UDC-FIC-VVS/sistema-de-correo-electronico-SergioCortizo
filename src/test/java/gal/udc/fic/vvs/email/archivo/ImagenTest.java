package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Imagen;

/**
 * Clase para probar manualmente los métodos de la clase {@link Imagen}.
 * 
 * @author Sergio Cortizo De Dios
 */
public class ImagenTest {
	private final String nombreImagen = "ImagenPrueba";
	private final String contenidoImagen = "3k6aJuuumy4/UyFQTuC+HQ==";
	private final String previsualizacionImagen = nombreImagen + "(" + contenidoImagen.length() + " bytes, image/png)";
	
	/**
	 * Test para comprobar que el método obtenerNombre() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el nombre de la imagen.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		con una cadena de texto concreta que representa el nombre de la imagen.
	 * 		(se pasa por parámetro en el constructor).
	 */
	@Test
	public void obtenerNombreTest() {
		Imagen imagenATestear = new Imagen(nombreImagen, contenidoImagen);
		
		assertEquals(nombreImagen, imagenATestear.obtenerNombre());
	}
	
	/**
	 * Test para comprobar que el método obtenerContenido() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el contenido de la imagen
	 *  	(se da por hecho que es un string en base64).
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		con una cadena concreta que representa el contenido de la imagen
	 * 		(se pasa por parámetro en el constructor).
	 */
	@Test
	public void obtenerContenidoTest() {
		Imagen imagenATestear = new Imagen(nombreImagen, contenidoImagen);
		
		assertEquals(contenidoImagen, imagenATestear.obtenerContenido());
	}
	
	/**
	 * Test para comprobar que el método obtenerTamaño() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el tamaño que ocupa la imagen.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		con una cadena concreta que representa el contenido de la imagen
	 * 		(se pasa por parámetro en el constructor).
	 */
	@Test
	public void obtenerTamañoTest() {
		Imagen imagenATestear = new Imagen(nombreImagen, contenidoImagen);
		
		assertEquals(contenidoImagen.length(), imagenATestear.obtenerTamaño());
	}
	
	/**
	 * Test para comprobar que el método obtenerPreVisualizacion() 
	 * funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el nombre de la imagen junto con su tamaño 
	 *  	en el siguiente formato:
	 *  		{Nombre de la imagen}({nº de bytes} bytes, image/png)
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		con una cadena de texto concreta que representa el nombre de la imagen
	 * 		y otra cadena representando su contenido
	 * 		(se pasa por parámetro en el constructor).
	 */
	@Test
	public void obtenerPreVisualizacion() {
		Imagen imagenATestear = new Imagen(nombreImagen, contenidoImagen);
		
		assertEquals(previsualizacionImagen, imagenATestear.obtenerPreVisualizacion());
	}
}
