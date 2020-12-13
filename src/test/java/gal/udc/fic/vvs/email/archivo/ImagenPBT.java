package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.util.MyCharacterGenerator;

/**
 * Clase para probar usando PBT los métodos de la clase {@link Imagen}.
 * 
 * @author Sergio Cortizo De Dios
 */
@RunWith(JUnitQuickcheck.class)
public class ImagenPBT {
	
	/**
	 * Test para comprobar que el método obtenerNombre() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el nombre de la imagen.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MyCharacterGenerator} para generar
	 *      cadenas aleatoriamente, asegurando que cualquier cadena no vacía se pueda
	 *      usar como nombre de imagen.
	 *
	 * @param nombreImagen nombre de la imagen
	 * @param contenidoImagen contenido de la imagen
	 */
	@Property
	public void obtenerNombrePBT(@From(MyCharacterGenerator.class) String nombreImagen,
			@From(MyCharacterGenerator.class) String contenidoImagen) {
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
	 * - Mecanismo de selección de datos:es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MyCharacterGenerator} para generar
	 *      cadenas aleatoriamente, asegurando que cualquier cadena no vacía se pueda
	 *      usar como contenido de imagen.
	 *
	 * @param nombreImagen nombre de la imagen
	 * @param contenidoImagen contenido de la imagen
	 */
	@Property
	public void obtenerContenidoTest(@From(MyCharacterGenerator.class) String nombreImagen,
			@From(MyCharacterGenerator.class) String contenidoImagen) {
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
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MyCharacterGenerator} para generar
	 *      cadenas aleatoriamente, asegurando que cualquier cadena no vacía que
	 *      se meta como contenido haga que en consecuencia el método a testear
	 *      devuelva un valor mayor que 0.
	 *
	 * @param nombreImagen nombre de la imagen
	 * @param contenidoImagen contenido de la imagen
	 */
	@Property
	public void obtenerTamañoPBT(@From(MyCharacterGenerator.class) String nombreImagen,
			@From(MyCharacterGenerator.class) String contenidoImagen) {
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
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MyCharacterGenerator} para generar
	 *      cadenas aleatoriamente, asegurando que cualquier cadena no vacía que se
	 *      pase por parámetro como nombre o contenido permita que el método a testear
	 *      devuelva una previsualización adecuada del archivo.
	 *
	 * @param nombreImagen nombre de la imagen
	 * @param contenidoImagen contenido de la imagen
	 */
	@Property
	public void obtenerPreVisualizacion(@From(MyCharacterGenerator.class) String nombreImagen,
			@From(MyCharacterGenerator.class) String contenidoImagen) {
		Imagen imagenATestear = new Imagen(nombreImagen, contenidoImagen);

		final String previsualizacionImagen =
				nombreImagen + "(" + contenidoImagen.length() + " bytes, image/png)";
		
		assertEquals(previsualizacionImagen, imagenATestear.obtenerPreVisualizacion());
	}
}
