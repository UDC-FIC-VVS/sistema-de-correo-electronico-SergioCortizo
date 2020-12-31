package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Vector;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.util.CarpetaLimitadaGenerator;
import gal.udc.fic.vvs.util.MensajeGenerator;

/**
 * Clase para probar usando PBT los métodos de la clase {@link CarpetaLimitada}.
 * 
 * @author Sergio Cortizo De Dios
 */
@RunWith(JUnitQuickcheck.class)
public class CarpetaLimitadaPBT {
	
	/**
	 * Test para comprobar el método buscar() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de integración, donde el tipo de integración
	 * 		se basa en procedimientos ya que se comunica con el objeto de la clase 
	 * 		{@link Carpeta} para obtener el contenido almacenado y posteriormente
	 * 		reducir el tamaño del resultado al tamaño indicado si éste se supera.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el tamaño de la búsqueda sea el adecuado.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link CarpetaLimitadaGenerator} para generar
	 *      carpetas limitadas aleatoriamente, esperando que la propiedad se cumpla 
	 *      independientemente del tamaño de la carpeta.
	 *
	 * @param carpeta carpeta generada aleatoriamente
	 */
	@Property
	public void buscarTest(@From(CarpetaLimitadaGenerator.class) CarpetaLimitada carpeta) {
		assertEquals(carpeta.obtenerNoLeidos(), CarpetaLimitadaGenerator.TAMAÑO);

		Collection result = carpeta.buscar("Mensaje");

		assertEquals(result.size(), carpeta.obtenerNoLeidos());
	}
	
	/**
	 * Test para comprobar el método buscar() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de integración, donde el tipo de integración
	 * 		se basa en procedimientos ya que se comunica con el objeto de la clase 
	 * 		{@link Carpeta} para obtener el contenido almacenado y posteriormente
	 * 		reducir el tamaño del resultado al tamaño indicado si éste se supera.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el tamaño de la búsqueda sea el adecuado cuando el tamaño de
	 *  	la carpeta es el mismo que el tamaño tope.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link CarpetaLimitadaGenerator} para generar
	 *      carpetas limitadas aleatoriamente, esperando que la propiedad se cumpla 
	 *      independientemente del tamaño de la carpeta.
	 *
	 * @param carpeta carpeta generada aleatoriamente
	 */
	@Property
	public void buscarEnCarpetaLlenaConTamañoTopeTest(
			@From(CarpetaLimitadaGenerator.class) CarpetaLimitada carpeta) throws OperacionInvalida {
		Collection expectedCollection = new Vector();
		
		for (int i = 1; i <= CarpetaLimitadaGenerator.TAMAÑO; i++) {
			Mensaje mensaje = new Mensaje(new Texto("Texto " + i, "Este es el texto " + i));
			expectedCollection.add(mensaje);
			carpeta.añadir(mensaje);
		}
		
		assertEquals(expectedCollection, carpeta.buscar("Texto"));
		assertEquals(expectedCollection.size(), carpeta.buscar("Texto").size());
		
	}
	
	/**
	 * Test para comprobar el método buscar() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de integración, donde el tipo de integración
	 * 		se basa en procedimientos ya que se comunica con el objeto de la clase 
	 * 		{@link Carpeta} para obtener el contenido almacenado y posteriormente
	 * 		reducir el tamaño del resultado al tamaño indicado si éste se supera.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el tamaño de la búsqueda sea el adecuado cuando el tamaño de
	 *  	la carpeta es el mismo que el tamaño tope.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link CarpetaLimitadaGenerator} para generar
	 *      carpetas limitadas aleatoriamente, esperando que la propiedad se cumpla 
	 *      independientemente del tamaño de la carpeta.
	 *
	 * @param carpeta carpeta generada aleatoriamente
	 */
	@Property
	public void buscarEnCarpetaLlenaConTamañoMenorQueElTopeTest(
			@From(CarpetaLimitadaGenerator.class) CarpetaLimitada carpeta) throws OperacionInvalida {
		Collection expectedCollection = new Vector();
		
		for (int i = 1; i < CarpetaLimitadaGenerator.TAMAÑO; i++) {
			Mensaje mensaje = new Mensaje(new Texto("Texto " + i, "Este es el texto " + i));
			expectedCollection.add(mensaje);
			carpeta.añadir(mensaje);
		}
		
		assertEquals(expectedCollection, carpeta.buscar("Texto"));
		assertEquals(expectedCollection.size(), carpeta.buscar("Texto").size());
	}
	
	/**
	 * Test para exponer un error en el método buscar() usando pruebas basadas en propiedades
	 * el cual está relacionado con el tamaño de la búsqueda resultante cuando se supera el tamaño límite.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de integración, donde el tipo de integración
	 * 		se basa en procedimientos ya que se comunica con el objeto de la clase 
	 * 		{@link Carpeta} para obtener el contenido almacenado y posteriormente
	 * 		reducir el tamaño del resultado al tamaño indicado si éste se supera.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra negativa,
	 * 	 	la prueba está pensada para demostrar el fallo mencionado anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link CarpetaLimitadaGenerator} para generar
	 *      carpetas limitadas aleatoriamente, esperando que la propiedad se cumpla 
	 *      independientemente del tamaño de la carpeta.
	 *
	 * @param carpeta carpeta generada aleatoriamente
	 */
	//Otro test que refleja el problema al buscar en CarpetaLimitada
	@Property
	public void buscarTest_conCarpetaSuperandoTamaño(@From(CarpetaLimitadaGenerator.class) CarpetaLimitada carpeta)
			throws OperacionInvalida {
		assertEquals(carpeta.obtenerNoLeidos(), CarpetaLimitadaGenerator.TAMAÑO);

		carpeta.añadir(new Mensaje(new Texto("Mensaje", "Mensaje de prueba")));
		carpeta.añadir(new Mensaje(new Texto("Mensaje", "Mensaje de prueba")));
		carpeta.añadir(new Mensaje(new Texto("Mensaje", "Mensaje de prueba")));

		Collection result = carpeta.buscar("Mensaje");

		assertTrue(result.size() > CarpetaLimitadaGenerator.TAMAÑO);
	}
	
	/**
	 * Test para comprobar el método establecerLeido() usando pruebas basadas en propiedades
	 * cuando se marca todo el contenido de la carpeta como leído.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de integración, donde el tipo de integración
	 * 		se basa en procedimientos ya que se comunica con el objeto de la clase 
	 * 		{@link Carpeta} para indicarle a la propia carpeta que marque todos los contenidos
	 *  	como leídos.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que todo el contenido se haya leído.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link CarpetaLimitadaGenerator} para generar
	 *      carpetas limitadas aleatoriamente, esperando que la propiedad se cumpla 
	 *      independientemente del tamaño de la carpeta.
	 *
	 * @param carpeta carpeta generada aleatoriamente
	 */
	@Property
	public void establecerComoLeidoTest(
			@From(CarpetaLimitadaGenerator.class) CarpetaLimitada carpeta) throws OperacionInvalida {
		carpeta.establecerLeido(true);

		assertEquals(0, carpeta.obtenerNoLeidos());
	}
	
	/**
	 * Test para comprobar el método establecerLeido() usando pruebas basadas en propiedades
	 * cuando se marca todo el contenido de la carpeta como no leído.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de integración, donde el tipo de integración
	 * 		se basa en procedimientos ya que se comunica con el objeto de la clase 
	 * 		{@link Carpeta} para indicarle a la propia carpeta que marque todos los contenidos
	 *  	como no leídos.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que todo el contenido se haya leído.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link CarpetaLimitadaGenerator} para generar
	 *      carpetas limitadas aleatoriamente, esperando que la propiedad se cumpla 
	 *      independientemente del tamaño de la carpeta.
	 *
	 * @param carpeta carpeta generada aleatoriamente
	 */
	@Property
	public void establecerComoNoLeidoTest(
			@From(CarpetaLimitadaGenerator.class) CarpetaLimitada carpeta) throws OperacionInvalida {

		carpeta.establecerLeido(false);

		assertEquals(CarpetaLimitadaGenerator.TAMAÑO, carpeta.obtenerNoLeidos());
	}
	
	/**
	 * Test para comprobar el método obtenerTamaño() usando pruebas basadas en propiedades
	 * para comprobar que el tamaño de la carpeta es mayor que 0 cuando hay contenidos dentro.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de integración, donde el tipo de integración
	 * 		se basa en procedimientos ya que se comunica con el objeto de la clase 
	 * 		{@link Carpeta} para indicarle a la propia carpeta que indique el tamaño total
	 * 		que ocupa el propio contenido de la carpeta.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el tamaño sea mayor que 0.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link CarpetaLimitadaGenerator} para generar
	 *      carpetas limitadas aleatoriamente, esperando que la propiedad se cumpla 
	 *      independientemente del tamaño de la carpeta.
	 *
	 * @param carpeta carpeta generada aleatoriamente
	 */
	@Property
	public void obtenerTamañoMensajesTest(
			@From(CarpetaLimitadaGenerator.class) CarpetaLimitada carpeta) throws OperacionInvalida {

		assertTrue(carpeta.obtenerTamaño() > 0);
	}
	
	/**
	 * Test para comprobar el método eliminar() usando pruebas basadas en propiedades
	 * para comprobar que el mensaje dentro de la carpeta se elimina correctamente.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de integración, donde el tipo de integración
	 * 		se basa en procedimientos ya que se comunica con el objeto de la clase 
	 * 		{@link Carpeta} para indicarle a la propia carpeta el contenido que tiene
	 * 		que eliminar.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el correo no esté presente una vez ha sido eliminado.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link CarpetaLimitadaGenerator} para generar
	 *      carpetas limitadas aleatoriamente, esperando que la propiedad se cumpla 
	 *      independientemente del tamaño de la carpeta.
	 *
	 * @param carpeta carpeta generada aleatoriamente
	 */
	@Property
	public void eliminarMensajeDeCarpetaTest(
			@From(CarpetaLimitadaGenerator.class) CarpetaLimitada carpeta) throws OperacionInvalida {

		int numAleatorio = (int) (Math.random() * CarpetaLimitadaGenerator.TAMAÑO);
		
		Correo correoHijo = carpeta.obtenerHijo(numAleatorio);
		
		carpeta.eliminar(correoHijo);
		
		assertFalse(carpeta.explorar().contains(correoHijo));
	}

	/**
	 * Test para comprobar el método obtenerHijo() usando pruebas basadas en propiedades
	 * para comprobar que se devuelve cualquier contenido de la carpeta correctamente.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de integración, donde el tipo de integración
	 * 		se basa en procedimientos ya que se comunica con el objeto de la clase 
	 * 		{@link Carpeta} para indicarle a la propia carpeta el hijo que tiene que recuperar.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se devuelva el correo esperado.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link CarpetaLimitadaGenerator} para generar
	 *      carpetas limitadas aleatoriamente, esperando que la propiedad se cumpla 
	 *      independientemente del tamaño de la carpeta.
	 *
	 * @param carpeta carpeta generada aleatoriamente
	 */
	@Property
	public void obtenerHijoEnCarpetaWithMensajesTest(
			@From(CarpetaLimitadaGenerator.class) CarpetaLimitada carpeta) throws OperacionInvalida {
		int hijoAleatorio =
				(int) (Math.random() * CarpetaLimitadaGenerator.TAMAÑO);
		
		Mensaje mensajeEsperado = new Mensaje(
				new Texto(CarpetaLimitadaGenerator.nombreMensajes,
						CarpetaLimitadaGenerator.contenidoMensajes + hijoAleatorio));
		
		assertEquals(mensajeEsperado.obtenerVisualizacion(), 
				carpeta.obtenerHijo(hijoAleatorio).obtenerVisualizacion());
		
	}
}
