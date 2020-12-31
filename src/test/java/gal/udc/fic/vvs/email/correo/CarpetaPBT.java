package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.util.CarpetaGenerator;
import gal.udc.fic.vvs.util.CarpetaLimitadaGenerator;

/**
 * Clase para probar usando PBT los métodos de la clase {@link Carpeta}.
 * 
 * @author Sergio Cortizo De Dios
 */
@RunWith(JUnitQuickcheck.class)
public class CarpetaPBT {
	
	/**
	 * Test para comprobar el método buscar() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de integración, donde el tipo de integración
	 * 		se basa en procedimientos ya que la carpeta se comunica de forma recursiva con objetos
	 * 		que implementen la interfaz {@link Correo}, como por ejemplo objetos de las
	 * 		clases {@link Mensaje} o {@link Carpeta}, los cuales son hijos de dicha carpeta.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que la búsqueda se haya realizado con éxito.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link CarpetaGenerator} para generar
	 *      carpetas con contenido aleatoriamente, esperando que la propiedad se cumpla 
	 *      independientemente del tamaño de la carpeta.
	 *
	 * @param carpeta carpeta generada aleatoriamente
	 */
	@Property
	public void buscarTest(@From(CarpetaGenerator.class) Carpeta carpeta) {

		Collection result = carpeta.buscar("Mensaje");

		assertEquals(CarpetaGenerator.TAMAÑO, carpeta.obtenerNoLeidos());
	}
	
	/**
	 * Test para comprobar el método establecerLeido() usando pruebas basadas en propiedades
	 * cuando se marca todo el contenido de la carpeta como leído.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de integración, donde el tipo de integración
	 * 		se basa en procedimientos ya que  la carpeta se comunica de forma recursiva con objetos
	 * 		que implementen la interfaz {@link Correo}, como por ejemplo objetos de las
	 * 		clases {@link Mensaje} o {@link Carpeta}, los cuales son hijos de dicha carpeta.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que todo el contenido se haya leído.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link CarpetaGenerator} para generar
	 *      carpetas con contenido aleatoriamente, esperando que la propiedad se cumpla 
	 *      independientemente del tamaño de la carpeta.
	 *
	 * @param carpeta carpeta generada aleatoriamente
	 */
	@Property
	public void establecerComoLeidoTest(
			@From(CarpetaGenerator.class) Carpeta carpeta) throws OperacionInvalida {
		carpeta.establecerLeido(true);

		assertEquals(0, carpeta.obtenerNoLeidos());
	}
	
	/**
	 * Test para comprobar el método establecerLeido() usando pruebas basadas en propiedades
	 * cuando se marca todo el contenido de la carpeta como no leído.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de integración, donde el tipo de integración
	 * 		se basa en procedimientos ya que  la carpeta se comunica de forma recursiva con objetos
	 * 		que implementen la interfaz {@link Correo}, como por ejemplo objetos de las
	 * 		clases {@link Mensaje} o {@link Carpeta}, los cuales son hijos de dicha carpeta.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que todo el contenido se haya marcado como no leído.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link CarpetaGenerator} para generar
	 *      carpetas con contenido aleatoriamente, esperando que la propiedad se cumpla 
	 *      independientemente del tamaño de la carpeta.
	 *
	 * @param carpeta carpeta generada aleatoriamente
	 */
	@Property
	public void establecerComoNoLeidoTest(
			@From(CarpetaGenerator.class) Carpeta carpeta) throws OperacionInvalida {

		carpeta.establecerLeido(false);

		assertEquals(CarpetaGenerator.TAMAÑO, carpeta.obtenerNoLeidos());
	}
	
	/**
	 * Test para comprobar el método obtenerTamaño() usando pruebas basadas en propiedades
	 * para comprobar que el tamaño de la carpeta es mayor que 0 cuando hay contenidos dentro.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de integración, donde el tipo de integración
	 * 		se basa en procedimientos ya que se comunica de forma recursiva con objetos
	 * 		que implementen la interfaz {@link Correo}, como por ejemplo objetos de las
	 * 		clases {@link Mensaje} o {@link Carpeta}, los cuales son hijos de dicha carpeta.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el tamaño sea mayor que 0.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link CarpetaGenerator} para generar
	 *      carpetas con contenido aleatoriamente, esperando que la propiedad se cumpla 
	 *      independientemente del tamaño de la carpeta.
	 *
	 * @param carpeta carpeta generada aleatoriamente
	 */
	@Property
	public void obtenerTamañoMensajesTest(
			@From(CarpetaGenerator.class) Carpeta carpeta) throws OperacionInvalida {

		assertTrue(carpeta.obtenerTamaño() > 0);
	}
	
	/**
	 * Test para comprobar el método eliminar() usando pruebas basadas en propiedades
	 * para comprobar que el correo dentro de la carpeta se elimina correctamente.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de integración, donde el tipo de integración
	 * 		se basa en procedimientos ya que se comunica con el correo que se quiere eliminar
	 * 		de la carpeta estableciendo el elemento padre de dicho correo como nulo una vez se
	 *  	ha encontrado dentro de la colección de hijos de la carpeta.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el correo no esté presente una vez ha sido eliminado.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link CarpetaGenerator} para generar
	 *      carpetas con contenido aleatoriamente, esperando que la propiedad se cumpla 
	 *      independientemente del tamaño de la carpeta.
	 *
	 * @param carpeta carpeta generada aleatoriamente
	 */
	@Property
	public void eliminarMensajeDeCarpetaTest(
			@From(CarpetaGenerator.class) Carpeta carpeta) throws OperacionInvalida {

		int numAleatorio = (int) (Math.random() * CarpetaGenerator.TAMAÑO);
		
		Correo correoHijo = carpeta.obtenerHijo(numAleatorio);
		
		carpeta.eliminar(correoHijo);
		
		assertFalse(carpeta.explorar().contains(correoHijo));
	}

	/**
	 * Test para comprobar el método obtenerHijo() usando pruebas basadas en propiedades
	 * para comprobar que se devuelve cualquier contenido de la carpeta correctamente.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se devuelva el correo esperado.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link CarpetaGenerator} para generar
	 *      carpetas con contenido aleatoriamente, esperando que la propiedad se cumpla 
	 *      independientemente del tamaño de la carpeta.
	 *
	 * @param carpeta carpeta generada aleatoriamente
	 */
	@Property
	public void obtenerHijoEnCarpetaWithMensajesTest(
			@From(CarpetaGenerator.class) Carpeta carpeta) throws OperacionInvalida {
		int hijoAleatorio =
				(int) (Math.random() * CarpetaGenerator.TAMAÑO);
		
		Mensaje mensajeEsperado = new Mensaje(
				new Texto(CarpetaGenerator.nombreMensajes,
						CarpetaGenerator.contenidoMensajes + hijoAleatorio));
		
		assertEquals(mensajeEsperado.obtenerVisualizacion(), 
				carpeta.obtenerHijo(hijoAleatorio).obtenerVisualizacion());
		
	}
}
