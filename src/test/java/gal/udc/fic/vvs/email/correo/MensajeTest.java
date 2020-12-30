package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Collection;
import java.util.Vector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gal.udc.fic.vvs.email.archivo.Texto;

/**
 * Clase para probar manualmente los métodos de la clase {@link Mensaje}.
 * 
 * @author Sergio Cortizo De Dios
 */
public class MensajeTest {
	private final String nombreTexto = "TextoPrueba";
	private final String contenidoTexto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas metus. ";
    private final String previsualizacion = contenidoTexto.substring(0, Math.min(contenidoTexto.length(), 32)) + "...";
	private final String keywords = "Lorem adipiscing amet dolor consectetur";
	private final String partialContent = "Lorem ipsum dolor sit amet,";
    
	private Texto texto = new Texto(nombreTexto, contenidoTexto);
	
	@Rule
	public ExpectedException thrown= ExpectedException.none();
	
	/**
	 * Test para comprobar que el método obtenerNoLeidos() funciona como se espera
	 * cuando inicialmente el mensaje es nuevo.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que lo mencionado anteriormente funcione correctamente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void mensajeObtenerNoLeidosTest_InitialState () {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		assertEquals(1, mensajeATestear.obtenerNoLeidos());
	}
	
	/**
	 * Test para comprobar que el método obtenerTamaño() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el tamaño del mensaje coincida con el tamaño del texto.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void mensajeObtenerTamañoTest () {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		assertEquals(texto.obtenerTamaño(), mensajeATestear.obtenerTamaño());
	}
	
	/**
	 * Test para comprobar que el método obtenerIcono() funciona como se espera
	 * cuando inicialmente el mensaje es nuevo.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se devuelva el icono de nuevo menaje cuando éste aún
	 *  	no se ha leído.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void mensajeObtenerIconoTest_NuevoMensaje () {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		assertEquals(Correo.ICONO_NUEVO_MENSAJE, mensajeATestear.obtenerIcono());
	}
	
	/**
	 * Test para comprobar que el método obtenerPreVisualizacion() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se devuelva la previsualización del mensaje con la sintaxis adecuada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void mensajeObtenerPrevisualizacionTest () {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		assertEquals(previsualizacion, mensajeATestear.obtenerPreVisualizacion());
	}
	
	/**
	 * Test para comprobar que el método obtenerVisualizacion() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se devuelva la visualización del mensaje con la sintaxis adecuada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void mensajeObtenerVisualizacionTest () {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		assertEquals(texto.obtenerContenido(), mensajeATestear.obtenerVisualizacion());
	}
	
	/**
	 * Test para comprobar que el método establecerLeido() funciona como se espera
	 * cuando se marca el mensaje como leído.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el mensaje se haya marcado como leído.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void establecerComoLeidoTest () {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		mensajeATestear.establecerLeido(true);
		
		assertEquals(0, mensajeATestear.obtenerNoLeidos());
	}
	
	/**
	 * Test para comprobar que el método establecerLeido() funciona como se espera
	 * cuando se marca el mensaje como no leído.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el mensaje se haya marcado no como leído.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void establecerComoNoLeidoTest () {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		mensajeATestear.establecerLeido(false);
		
		assertEquals(1, mensajeATestear.obtenerNoLeidos());
	}
	
	/**
	 * Test para comprobar que el método buscar() funciona como se espera
	 * cuando se pasa el contenido completo del mensaje como parámetro.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se devuelva una colección con el mensaje usando la
	 *  	búsqueda indicada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void findExpectedMensajeTest() {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		Collection expectedCollection = new Vector();
		
		expectedCollection.add(mensajeATestear);
		
		assertEquals(expectedCollection, mensajeATestear.buscar(contenidoTexto));
		
	}
	
	/**
	 * Test para comprobar que el método buscar() funciona como se espera
	 * cuando se pasa contenido parcial del mensaje como parámetro.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se devuelva una colección con el mensaje usando la
	 *  	búsqueda indicada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void findExpectedMensajeTestWithPartialContent() {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		Collection expectedCollection = new Vector();
		
		expectedCollection.add(mensajeATestear);
		
		assertEquals(expectedCollection, mensajeATestear.buscar(partialContent));
		
	}
	
	/**
	 * Test para exponer un error en el método buscar() cuando se pasan palabras clave aleatorias
	 * presentes en el contenido del mensaje.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra negativa,
	 *  	la prueba está pensada para demostrar el error mencionado anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void findExpectedMensajeTestWithRandomKeywords() {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		Collection expectedCollection = new Vector();
		
		expectedCollection.add(mensajeATestear);
				
		/*TODO: Test falla cuando se ponen palabras en orden aleatorio que están dentro del contenido*/
		assertNotEquals(expectedCollection, mensajeATestear.buscar(keywords));
	}
	
	/**
	 * Test para comprobar que el método buscar() funciona como se espera
	 * cuando se pasa una cadena vacía como parámetro.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se devuelva una colección con el mensaje usando la
	 *  	búsqueda indicada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void findExpectedMensajeTestWithNoKeywords() {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		Collection expectedCollection = new Vector();
		expectedCollection.add(mensajeATestear);
						
		assertEquals(expectedCollection, mensajeATestear.buscar(""));
	}
	
	/**
	 * Test para comprobar que el método buscar() lanza la excepción
	 * {@link NullPointerException} cuando se pasa un nulo como parámetro.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se lance la excepción indicada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	//TODO: ¿Sería correcto devolver igualmente el correo aunque el parámetro sea null?
	@Test
	public void findMensajeTestExpectedNullPointerExceptionPassingNullAsParameter() {
		Mensaje mensajeATestear = new Mensaje(texto);
		thrown.expect(NullPointerException.class);
		mensajeATestear.buscar(null);
	}
	
	/**
	 * Test para comprobar que el método obtenerRuta() funciona como se espera
	 * cuando no se define un padre para el mensaje.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se devuelva la ruta con la sintaxis esperada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void obtenerRutaWithoutPadreTest() {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		assertEquals(mensajeATestear.obtenerRuta(), mensajeATestear.obtenerPreVisualizacion());
	}
	
	/**
	 * Test para comprobar que el método obtenerRuta() funciona como se espera
	 * cuando se define un padre para el mensaje.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se devuelva la ruta con la sintaxis esperada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void obtenerRutaWithPadreTest() throws OperacionInvalida {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		Carpeta carpetaPadre = new Carpeta("CarpetaPadre");
		
		carpetaPadre.añadir(mensajeATestear);
		
		assertEquals(carpetaPadre.obtenerPreVisualizacion() + " > " + mensajeATestear.obtenerPreVisualizacion(),
				mensajeATestear.obtenerRuta());
	}
	
	/**
	 * Test para comprobar que el método obtenerPadre() devuelve un valor nulo
	 * cuando no se define un padre para el mensaje.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se devuelva lo dicho anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void obtenerPadreNullTest() {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		assertEquals(null, mensajeATestear.obtenerPadre());
	}
	
	/**
	 * Test para comprobar que el método obtenerPadre() devuelve la carpeta padre
	 * cuando se define un padre para el mensaje.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se devuelva lo dicho anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void obtenerPadreTest() throws OperacionInvalida {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		Carpeta carpetaPadre = new Carpeta("CarpetaPadre");
		
		carpetaPadre.añadir(mensajeATestear);
		
		assertEquals(carpetaPadre, mensajeATestear.obtenerPadre());
	}
	
	/**
	 * Test para comprobar que el método explorar() lanza la excepción
	 * {@link OperacionInvalida}.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se lance la excepción mencionada anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void explorarExpectedOperacionInvalidaTestExceptionTest() throws OperacionInvalida {
		Mensaje mensajeATestear = new Mensaje(texto);
		thrown.expect(OperacionInvalida.class);
		mensajeATestear.explorar();
	}
	
	/**
	 * Test para comprobar que el método añadir() lanza la excepción
	 * {@link OperacionInvalida}.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se lance la excepción mencionada anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void añadirExpectedOperacionInvalidaTestExceptionTest() throws OperacionInvalida {
		Mensaje mensajeATestear = new Mensaje(texto);
		thrown.expect(OperacionInvalida.class);
		mensajeATestear.añadir(null);
	}

	/**
	 * Test para comprobar que el método eliminar() lanza la excepción
	 * {@link OperacionInvalida}.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se lance la excepción mencionada anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void eliminarExpectedOperacionInvalidaTestExceptionTest() throws OperacionInvalida {
		Mensaje mensajeATestear = new Mensaje(texto);
		thrown.expect(OperacionInvalida.class);
		mensajeATestear.eliminar(null);
	}
	
	/**
	 * Test para comprobar que el método obtenerHijo() lanza la excepción
	 * {@link OperacionInvalida}.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se lance la excepción mencionada anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void obtenerHijoExpectedOperacionInvalidaTestExceptionTest() throws OperacionInvalida {
		Mensaje mensajeATestear = new Mensaje(texto);
		thrown.expect(OperacionInvalida.class);
		mensajeATestear.obtenerHijo(0);
	}
	
}
