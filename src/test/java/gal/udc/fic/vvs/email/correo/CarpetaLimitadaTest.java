package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Vector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gal.udc.fic.vvs.email.archivo.Texto;

/**
 * Clase para probar manualmente los métodos de la clase {@link CarpetaLimitada}.
 * 
 * @author Sergio Cortizo De Dios
 */
public class CarpetaLimitadaTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
		
	private int tamaño = 10;
	
	private final String nombreCarpeta = "CarpetaPrueba";
	private final String nombreSubcarpeta = "SubcarpetaPrueba";

	private final String nombreTexto = "TextoPrueba";
	private final String contenidoTexto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas metus. ";
	private final int tamañoContenidoTexto = contenidoTexto.length();

	private final int num_mensajes = 10;
	private final int num_subcarpetas = 10;
	
	private final Texto texto = new Texto(nombreTexto, contenidoTexto);
	
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
	 * Test para comprobar que el método obtenerIcono() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver el icono de carpeta.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void obtenerIcono() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Mensaje mensaje = new Mensaje(new Texto("TextoPrueba", "Este es un texto de prueba"));

		carpeta.añadir(mensaje);
		
		CarpetaLimitada carpetaLimitadaATestear = new CarpetaLimitada(carpeta, tamaño);
		
		assertEquals(Correo.ICONO_CARPETA, carpetaLimitadaATestear.obtenerIcono());
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
		Carpeta carpeta = prepareCarpetaWithMensajes();
		CarpetaLimitada carpetaLimitadaATestear = new CarpetaLimitada(carpeta, tamaño);

		assertEquals(nombreCarpeta + " (" + num_mensajes + ")", carpetaLimitadaATestear.obtenerVisualizacion());
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
		Carpeta carpeta = prepareCarpetaWithMensajes();
		CarpetaLimitada carpetaLimitadaATestear = new CarpetaLimitada(carpeta, tamaño);

		assertEquals(nombreCarpeta + " (" + num_mensajes + ")", carpetaLimitadaATestear.obtenerPreVisualizacion());
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
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitadaATestear = new CarpetaLimitada(carpeta, tamaño);

		Collection<Correo> expectedHijos = mensajesCollection();

		for (Correo mensaje : expectedHijos) {
			carpetaLimitadaATestear.añadir(mensaje);
		}

		assertEquals(expectedHijos, carpetaLimitadaATestear.explorar());

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
		Carpeta carpeta = new Carpeta(nombreCarpeta);

		Collection expectedResult = new Vector();
		Collection secondExpectedResult = new Vector();
		Collection thirdExpectedResult = new Vector();
		Collection fourthExpectedResult = new Vector();

		Mensaje mensaje1 = new Mensaje(new Texto("Mensaje 1", "Mensaje numero 1"));
		carpeta.añadir(mensaje1);
		expectedResult.add(mensaje1);
		secondExpectedResult.add(mensaje1);

		Mensaje mensaje2 = new Mensaje(new Texto("Mensaje 2", "Mensaje numero 2"));
		carpeta.añadir(mensaje2);
		expectedResult.add(mensaje2);

		Mensaje mensaje3 = new Mensaje(new Texto("Mensaje 3", "Mensaje numero 3"));
		carpeta.añadir(mensaje3);
		expectedResult.add(mensaje3);
		thirdExpectedResult.add(mensaje3);

		Mensaje mensaje4 = new Mensaje(new Texto("Mensaje 4", "Mensaje numero 4"));
		carpeta.añadir(mensaje4);
		expectedResult.add(mensaje4);
		fourthExpectedResult.add(mensaje4);
		
		CarpetaLimitada carpetaLimitadaATestear = new CarpetaLimitada(carpeta, tamaño);

		assertEquals(expectedResult, carpetaLimitadaATestear.buscar("Mensaje"));
		assertEquals(secondExpectedResult, carpetaLimitadaATestear.buscar("1"));
		assertEquals(thirdExpectedResult, carpetaLimitadaATestear.buscar("3"));
		assertEquals(fourthExpectedResult, carpetaLimitadaATestear.buscar("4"));

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
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Carpeta carpetaPadre = new Carpeta(nombreCarpeta);
		
		CarpetaLimitada carpetaLimitadaATestear = new CarpetaLimitada(carpeta, tamaño);
		
		Mensaje mensajePrueba = new Mensaje(texto);
		
		carpetaPadre.añadir(mensajePrueba);
		
		assertEquals(carpetaPadre, mensajePrueba.obtenerPadre());
		
		carpetaLimitadaATestear.añadir(mensajePrueba);
		
		assertEquals(carpeta, mensajePrueba.obtenerPadre());
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
	public void obtenerRutaWithoutPadreTest() {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		
		CarpetaLimitada carpetaLimitadaATestear = new CarpetaLimitada(carpeta, tamaño);
		
		assertEquals(carpetaLimitadaATestear.obtenerRuta(), carpetaLimitadaATestear.obtenerPreVisualizacion());
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
	public void obtenerRutaWithPadreTest() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Carpeta carpetaPadre = new Carpeta(nombreCarpeta);
		
		CarpetaLimitada carpetaLimitadaATestear = new CarpetaLimitada(carpeta, tamaño);
		
		carpetaPadre.añadir(carpetaLimitadaATestear);
		
		assertEquals(carpetaPadre.obtenerPreVisualizacion() + " > " + carpetaLimitadaATestear.obtenerPreVisualizacion(),
				carpetaLimitadaATestear.obtenerRuta());
	}
	
	/**
	 * Test para exponer un error encontrado en el método buscar()
	 * donde al realizar la búsqueda el tamaño de la colección sobrepasa al tamaño límite.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra negativa,
	 *  	se espera demostrar el fallo mencionado anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void buscarEnCarpetaLlenaConTamañoMayorQueElTopeTest() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Collection expectedCollection = new Vector();
		
		for (int i = 1; i <= tamaño; i++) {
			Mensaje mensaje = new Mensaje(new Texto("Texto " + i, "Este es el texto " + i));
			expectedCollection.add(mensaje);
			carpeta.añadir(mensaje);
		}
		
		for (int i = tamaño + 1; i <= tamaño * 2; i++) {
			Mensaje mensaje = new Mensaje(new Texto("Texto " + i, "Este es el texto " + i));
			carpeta.añadir(mensaje);
		}
		
		CarpetaLimitada carpetaLimitadaATestear = new CarpetaLimitada(carpeta, tamaño);
		
		Collection result = carpetaLimitadaATestear.buscar("Texto");

		//TODO: En realidad CarpetaLimitada está devolviendo más objetos de los que debería, concretamente 1 de más
		assertTrue(tamaño < carpetaLimitadaATestear.buscar("Texto").size());
	}
}
