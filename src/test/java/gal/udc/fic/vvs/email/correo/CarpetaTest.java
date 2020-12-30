package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Vector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gal.udc.fic.vvs.email.archivo.Texto;

/**
 * Clase para probar manualmente los métodos de la clase {@link Carpeta}.
 * 
 * @author Sergio Cortizo De Dios
 */
public class CarpetaTest {
	private final String nombreCarpeta = "CarpetaPrueba";
	private final String nombreSubcarpeta = "SubcarpetaPrueba";

	private final String nombreTexto = "TextoPrueba";
	private final String contenidoTexto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas metus. ";
	private final int tamañoContenidoTexto = contenidoTexto.length();

	private final int num_mensajes = 10;
	private final int num_subcarpetas = 10;

	private final Texto texto = new Texto(nombreTexto, contenidoTexto);

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private Carpeta prepareCarpetaWithMensajes() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		for (int i = 1; i <= num_mensajes; i++) {
			Mensaje mensaje = new Mensaje(texto);
			carpetaATestear.añadir(mensaje);
		}

		return carpetaATestear;
	}

	private Collection mensajesCollection() {
		Collection coleccion = new Vector();

		for (int i = 1; i <= num_mensajes; i++) {
			Mensaje mensaje = new Mensaje(texto);
			coleccion.add(mensaje);
		}

		return coleccion;
	}
	
	/**
	 * Test para comprobar que el método obtenerNoLeidos() funciona como se espera
	 * cuando inicialmente no hay mensajes almacenados.
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
	public void carpetaObtenerNoLeidosTest_InitialState() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		assertEquals(0, carpetaATestear.obtenerNoLeidos());

	}
	
	/**
	 * Test para comprobar que el método obtenerTamaño() funciona como se espera
	 * cuando inicialmente no hay mensajes almacenados.
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
	public void carpetaObtenerTamañoTest_InitialState() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);
		
		assertEquals(0, carpetaATestear.obtenerTamaño());

	}
	
	/**
	 * Test para comprobar que el método obtenerIcono() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el método devuelva el icono de la carpeta.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void carpetaObtenerIconoTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		assertEquals(Correo.ICONO_CARPETA, carpetaATestear.obtenerIcono());

	}
	
	/**
	 * Test para comprobar que el método obtenerVisualizacion() funciona como se espera
	 * cuando inicialmente no hay mensajes almacenados.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se devuelva la visualización esperada cuando no hay mensajes nuevos
	 *  	con la sintaxis adecuada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void carpetaObtenerVisualizacionTest_InitialState() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		assertEquals(nombreCarpeta, carpetaATestear.obtenerVisualizacion());

	}
	
	/**
	 * Test para comprobar que el método obtenerPreVisualizacion() funciona como se espera
	 * cuando inicialmente no hay mensajes almacenados.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se devuelva la previsualización esperada cuando no hay mensajes nuevos
	 *  	con la sintaxis adecuada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void carpetaObtenerPreVisualizacionTest_InitialState() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		assertEquals(nombreCarpeta, carpetaATestear.obtenerPreVisualizacion());

	}
	
	/**
	 * Test para comprobar que el método explorar() funciona como se espera
	 * cuando inicialmente no hay mensajes almacenados.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se devuelva una colección vacía cuando al principio 
	 *  	no hay mensajes almacenados.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void carpetaExplorarTest_InitialState() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		assertEquals(new Vector(), carpetaATestear.explorar());
	}
	
	/**
	 * Test para comprobar que el método buscar() funciona como se espera
	 * cuando inicialmente no hay mensajes almacenados.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se devuelva una colección vacía cuando al principio 
	 *  	no hay mensajes almacenados.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void carpetaBuscarTest_InitialState() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		assertEquals(new Vector(), carpetaATestear.buscar(""));

	}
	
	/**
	 * Test para comprobar que el método obtenerHijo() devuelva la excepción
	 * {@link ArrayIndexOutOfBoundsException} cuando no hay mensajes almacenados.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se devuelva la excepción mencionada anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void carpetaObtenerHijosTest_InitialState() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		thrown.expect(ArrayIndexOutOfBoundsException.class);
		carpetaATestear.obtenerHijo(0);

	}

	/**
	 * Test para comprobar que el método obtenerVisualizacion() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver la visualización de la carpeta con el nº de mensajes
	 *  	nuevos con la sintaxis esperada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void obtenerVisualizacionMensajesTest() throws OperacionInvalida {
		Carpeta carpetaATestear = prepareCarpetaWithMensajes();

		assertEquals(nombreCarpeta + " (" + num_mensajes + ")", carpetaATestear.obtenerVisualizacion());
	}

	/**
	 * Test para comprobar que el método obtenerPreVisualizacion() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver la previsualización de la carpeta con el nº de mensajes
	 *  	nuevos con la sintaxis esperada.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void obtenerPreVisualizacionMensajesTest() throws OperacionInvalida {
		Carpeta carpetaATestear = prepareCarpetaWithMensajes();

		assertEquals(nombreCarpeta + " (" + num_mensajes + ")", carpetaATestear.obtenerPreVisualizacion());
	}

	/**
	 * Test para comprobar que el método explorar() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver el contenido existente dentro de la carpeta.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void explorarCarpetaWithMensajesTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		Collection<Correo> expectedHijos = mensajesCollection();

		for (Correo mensaje : expectedHijos) {
			carpetaATestear.añadir(mensaje);
		}

		assertEquals(expectedHijos, carpetaATestear.explorar());

	}

	/**
	 * Test para comprobar que el método buscar() funciona como se espera
	 * en distintas situaciones de búsqueda.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver los resultados indicados dependiendo de la búsqueda
	 *  	que se esté haciendo.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void buscarEnCarpetaWithMensajesTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		Collection expectedResult = new Vector();
		Collection secondExpectedResult = new Vector();
		Collection thirdExpectedResult = new Vector();
		Collection fourthExpectedResult = new Vector();

		Mensaje mensaje1 = new Mensaje(new Texto("Mensaje 1", "Mensaje numero 1"));
		carpetaATestear.añadir(mensaje1);
		expectedResult.add(mensaje1);
		secondExpectedResult.add(mensaje1);

		Mensaje mensaje2 = new Mensaje(new Texto("Mensaje 2", "Mensaje numero 2"));
		carpetaATestear.añadir(mensaje2);
		expectedResult.add(mensaje2);

		Mensaje mensaje3 = new Mensaje(new Texto("Mensaje 3", "Mensaje numero 3"));
		carpetaATestear.añadir(mensaje3);
		expectedResult.add(mensaje3);
		thirdExpectedResult.add(mensaje3);

		Mensaje mensaje4 = new Mensaje(new Texto("Mensaje 4", "Mensaje numero 4"));
		carpetaATestear.añadir(mensaje4);
		expectedResult.add(mensaje4);
		fourthExpectedResult.add(mensaje4);

		assertEquals(expectedResult, carpetaATestear.buscar("Mensaje"));
		assertEquals(secondExpectedResult, carpetaATestear.buscar("1"));
		assertEquals(thirdExpectedResult, carpetaATestear.buscar("3"));
		assertEquals(fourthExpectedResult, carpetaATestear.buscar("4"));

	}

	/**
	 * Test para comprobar que el método añadir() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el mensaje se haya añadido correctamente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void añadirMensajeACarpetaTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		Mensaje mensaje = new Mensaje(texto);

		carpetaATestear.añadir(mensaje);

		assertEquals(mensaje, carpetaATestear.obtenerHijo(0));
	}

	/**
	 * Test para comprobar que el método añadir() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que la subcarpeta vacía se haya añadido correctamente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void añadirSubcarpetaVaciaACarpetaTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		Carpeta subcarpeta = new Carpeta("subcarpeta");

		carpetaATestear.añadir(subcarpeta);

		assertEquals(subcarpeta, carpetaATestear.obtenerHijo(0));
	}

	/**
	 * Test para comprobar que el método añadir() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que la subcarpeta con mensaje se haya añadido correctamente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void añadirSubcarpetaConMensajeACarpetaTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		Carpeta subcarpeta = new Carpeta("subcarpeta");

		Mensaje mensaje = new Mensaje(texto);

		subcarpeta.añadir(mensaje);

		carpetaATestear.añadir(subcarpeta);

		assertEquals(subcarpeta, carpetaATestear.obtenerHijo(0));
	}
	
	/**
	 * Test para comprobar que la carpeta padre del mensaje se cambia correctamente.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que la carpeta padre del mensaje se cambie correctamente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void cambiarCarpetaPadreDeCorreo() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);
		Carpeta carpetaPadre = new Carpeta(nombreCarpeta);
		
		Mensaje mensajePrueba = new Mensaje(texto);
		
		carpetaPadre.añadir(mensajePrueba);
		
		assertEquals(carpetaPadre, mensajePrueba.obtenerPadre());
		
		carpetaATestear.añadir(mensajePrueba);
		
		assertEquals(carpetaATestear, mensajePrueba.obtenerPadre());
	}
}
