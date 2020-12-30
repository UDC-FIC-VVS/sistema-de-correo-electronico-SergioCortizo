package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Vector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gal.udc.fic.vvs.email.archivo.Texto;

/**
 * Clase para probar manualmente los métodos de la clase {@link Cabecera}.
 * 
 * @author Sergio Cortizo De Dios
 */
public class CabeceraTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private String nombre = "Prueba";
	private String valor = "Valor de prueba";
	private Mensaje mensaje = new Mensaje(new Texto("Mensaje de prueba", "Esto es un mensaje de prueba"));
	private Carpeta carpeta = new Carpeta(nombre);
	
	/**
	 * Test para comprobar que el método obtenerVisualizacion() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver la visualización tanto del mensaje como de la cabecera
	 *  	con la sintaxis esperada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void cabeceraObtenerVisualizacionTest() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		assertEquals(nombre + ": " + valor + "\n" + mensaje.obtenerVisualizacion(),
				cabeceraDePrueba.obtenerVisualizacion());

	}

	/**
	 * Test para exponer un error de implementación del método 
	 * obtenerVisualizacion() en el cual tanto el nombre como el valor de la cabecera
	 * se admiten como cadenas vacías.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra negativa,
	 *  	se espera demostrar el error mencionado anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void cabeceraNoAñadidaSiNombreYValorSonVaciosTest() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, "", "");

		// TODO: No tiene sentido añadir cabeceras vacías
		assertEquals(mensaje.obtenerTamaño(), cabeceraDePrueba.obtenerTamaño());
		assertEquals("" + ": " + "" + "\n" + mensaje.obtenerVisualizacion(),
				cabeceraDePrueba.obtenerVisualizacion());
	}

	/**
	 * Test para comprobar que la clase lanza una excepción con cualquier método si el
	 * valor de la cabecera es nulo.
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
	public void cabeceraNoAñadidaSiValorEsNullTest() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, null);
		thrown.expect(NullPointerException.class);
		cabeceraDePrueba.obtenerTamaño();
	}

	/**
	 * Test para comprobar que la clase lanza una excepción con cualquier método si el
	 * nombre de la cabecera es nulo.
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
	public void cabeceraNoAñadidaSiNombreEsNullTest() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, null, valor);
		thrown.expect(NullPointerException.class);
		cabeceraDePrueba.obtenerTamaño();
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
	public void cabeceraNoAñadidaSiMensajeEsNullTest() {
		Cabecera cabeceraDePrueba = new Cabecera(null, nombre, valor);
		thrown.expect(NullPointerException.class);
		cabeceraDePrueba.obtenerTamaño();
	}

	
	/**
	 * Test para comprobar que el método obtenerNoLeidos() funciona como se espera
	 * cuando el mensaje aún no se ha leído.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera el resultado mencionado anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void obtenerNoLeidosConMensaje() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		assertEquals(cabeceraDePrueba.obtenerNoLeidos(), 1);
	}

	/**
	 * Test para comprobar que el método establecerLeido() funciona como se espera
	 * cuando se quiere marcar el mensaje como leído.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el mensaje quede marcado como leído.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void establecerLeidoConMensaje() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		cabeceraDePrueba.establecerLeido(true);

		assertEquals(cabeceraDePrueba.obtenerNoLeidos(), 0);
	}

	/**
	 * Test para comprobar que el método obtenerIcono() funciona como se espera
	 * cuando se trata de un nuevo mensaje.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver el icono de nuevo mensaje cuando éste aún no se ha leido.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void obtenerIconoConMensajeNoLeido() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		assertEquals(cabeceraDePrueba.obtenerIcono(), Correo.ICONO_NUEVO_MENSAJE);
	}

	/**
	 * Test para comprobar que el método obtenerIcono() funciona como se espera
	 * cuando se trata de un mensaje ya leido.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver el icono de mensaje cuando éste ya se ha leido.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void obtenerIconoConMensajeLeido() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		cabeceraDePrueba.establecerLeido(true);

		assertEquals(cabeceraDePrueba.obtenerIcono(), Correo.ICONO_MENSAJE);
	}

	/**
	 * Test para comprobar que el método obtenerPreVisualizacion() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver la previsualización de la clase con la sintaxis esperada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void obtenerPreVisualizacion() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		assertEquals(cabeceraDePrueba.obtenerPreVisualizacion(), mensaje.obtenerPreVisualizacion());
	}

	/**
	 * Test para comprobar que el método obtenerRuta() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver la ruta de la clase sin la carpeta padre
	 *  	con la sintaxis esperada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void obtenerRutaSinCarpetaPadre() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		assertEquals(cabeceraDePrueba.obtenerRuta(), mensaje.obtenerRuta());
	}

	/**
	 * Test para comprobar que el método obtenerRuta() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver la ruta de la clase con la carpeta padre
	 *  	con la sintaxis esperada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void obtenerRutaConCarpetaPadre() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);
		Carpeta carpeta = new Carpeta("Carpeta de prueba");

		cabeceraDePrueba.establecerPadre(carpeta);

		assertEquals(cabeceraDePrueba.obtenerRuta(), mensaje.obtenerRuta());
	}
	
	/**
	 * Test para comprobar que el método explorar() devuelve la excepción {@link OperacionInvalida}.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver la excepción mencionada anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void explorarTestOperacionInvalidaExceptionExpected() throws OperacionInvalida {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		thrown.expect(OperacionInvalida.class);
		
		cabeceraDePrueba.explorar();
	}
	
	/**
	 * Test para comprobar que el método añadir() devuelve la excepción {@link OperacionInvalida}.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver la excepción mencionada anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void añadirTestOperacionInvalidaExceptionExpected() throws OperacionInvalida {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		thrown.expect(OperacionInvalida.class);
		
		cabeceraDePrueba.añadir(mensaje);
	}
	
	/**
	 * Test para comprobar que el método eliminar() devuelve la excepción {@link OperacionInvalida}.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver la excepción mencionada anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void eliminarTestOperacionInvalidaExceptionExpected() throws OperacionInvalida {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		thrown.expect(OperacionInvalida.class);
		
		cabeceraDePrueba.eliminar(mensaje);
	}
	
	/**
	 * Test para comprobar que el método obtenerHijo() 
	 * devuelve la excepción {@link OperacionInvalida}.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver la excepción mencionada anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void obtenerHijoTestOperacionInvalidaExceptionExpected() throws OperacionInvalida {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		thrown.expect(OperacionInvalida.class);
		
		cabeceraDePrueba.obtenerHijo(0);
	}
	
	/**
	 * Test para comprobar que el método obtenerPadre() devuelve null 
	 * cuando no se establece ninguno.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver lo dicho anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void obtenerPadreSinCarpetaPadre() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		assertEquals(null, cabeceraDePrueba.obtenerPadre());
	}
	
	/**
	 * Test para comprobar que el método obtenerPadre() devuelve la carpeta padre 
	 * cuando se establece una.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver lo dicho anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void obtenerPadreConCarpetaPadre() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		cabeceraDePrueba.establecerPadre(carpeta);
		
		assertEquals(carpeta, cabeceraDePrueba.obtenerPadre());
	}
	
	/**
	 * Test para comprobar que el método buscar() devuelve el emnsaje de prueba 
	 * cuando coincide la búsqueda.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver lo dicho anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void buscarConExito() {
		Cabecera cabeceraDePrueba = new Cabecera(mensaje, nombre, valor);

		Collection collectionExpected = new Vector();
		collectionExpected.add(cabeceraDePrueba);
		
		Collection collectionObtained = cabeceraDePrueba.buscar("prueba");
		
		assertEquals(collectionObtained, collectionExpected);
	}
}
