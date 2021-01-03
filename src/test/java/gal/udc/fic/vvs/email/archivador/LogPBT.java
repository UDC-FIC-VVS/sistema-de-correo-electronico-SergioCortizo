package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;
import gal.udc.fic.vvs.util.MensajeGenerator;
import gal.udc.fic.vvs.util.MyCharacterGenerator;

/**
 * Clase para probar usando PBT los métodos de la clase {@link Log}.
 * 
 * @author Sergio Cortizo De Dios
 */
@RunWith(JUnitQuickcheck.class)
public class LogPBT {
	

	/**
	 * Test para comprobar el método almacenarCorreo() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el correo se guarde correctamente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MensajeGenerator} para generar
	 *      mensajes aleatorios, asegurando que la propiedad se cumple
	 *      sin influir el mensaje que se está pasando.
	 *
	 * @param espacioArchivador espacio asignado al archivador.
	 *  Por lo menos debería ser de 1 (valor frontera para valores de espacio asignado válidos).
	 * @param mensaje mensaje aleatorio
	 */
	//TODO: Bug encontrado. El mensaje de log debería contener más información.
	@Property
	public void logPBT_almacenarCorreo(@InRange(min = "1") int espacioArchivador,
										@From(MensajeGenerator.class) Mensaje mensaje) {
		
		Log logTest = new Log(new ArchivadorSimple("archivadorPrueba", espacioArchivador));
		
		assertTrue(logTest.almacenarCorreo(mensaje));
		
	}
	
	/**
	 * Test para comprobar el método obtenerEspacioDisponible() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el espacio se reduzca al almacenar un correo.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MensajeGenerator} para generar
	 *      mensajes aleatorios, asegurando que la propiedad se cumple
	 *      sin influir el mensaje que se está pasando.
	 *
	 * @param espacioArchivador espacio asignado al archivador.
	 *  Por lo menos debería ser de 1 (valor frontera para valores de espacio asignado válidos).
	 * @param mensaje mensaje aleatorio
	 */
	@Property
	public void logPBT_almacenarCorreo_espacioReducido(@InRange(min = "1") int espacioArchivador,
										@From(MensajeGenerator.class) Mensaje mensaje) {
		
		Log logTest = new Log(new ArchivadorSimple("archivadorPrueba", espacioArchivador));
		
		logTest.almacenarCorreo(mensaje);
		assertEquals(espacioArchivador - mensaje.obtenerTamaño(), logTest.obtenerEspacioDisponible());
		
	}
	
	/**
	 * Test para comprobar el método obtenerEspacioTotal() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra tanto positiva como negativa,
	 *  	se espera que el espacio total sea el mismo que el asignado al crear el log,
	 *  	pero el espacio no debería ser negativo.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se generan números enteros aleatorios para comprobar que pasando cualquier
	 *      entero podemos asignarle espacio al archivador delegado (se tiene en cuenta enteros positivos
	 *      y negativos para demostrar el bug sobre el espacio negativo mencionado anteriormente).
	 *
	 * @param espacio espacio a asignar
	 */
	@Property
	public void logPBT_obtenerEspacioTotal(int espacioArchivador) {
		
		Log logTest = new Log(new ArchivadorSimple("archivadorPrueba", espacioArchivador));
		
		assertEquals(espacioArchivador, logTest.obtenerEspacioTotal());
		
	}
	
	/**
	 * Test para comprobar el método obtenerEspacioDisponible() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra tanto positiva como negativa,
	 *  	se espera que el espacio disponible sea el mismo que el asignado al crear el log,
	 *  	pero el espacio no debería ser negativo.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se generan números enteros aleatorios para comprobar que pasando cualquier
	 *      entero podemos asignarle espacio al archivador (se tiene en cuenta enteros positivos
	 *      o negativos para demostrar el bug sobre el espacio negativo mencionado anteriormente).
	 *
	 * @param espacio espacio a asignar
	 */
	@Property
	public void logPBT_obtenerEspacioDisponible(@InRange(min = "1") int espacioArchivador) {
		
		Log logTest = new Log(new ArchivadorSimple("archivadorPrueba", espacioArchivador));
		
		assertEquals(espacioArchivador, logTest.obtenerEspacioDisponible());
		
	}
	
	/**
	 * Test para comprobar el método obtenerNombre() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se devuelva el nombre asignado al log.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MyCharacterGenerator} para generar
	 *      cadenas aleatorias, asegurando que se pueda poner cualquier nombre al
	 *      archivador siempre y cuando no sea una cadena vacía.
	 *
	 * @param nombre nombre del archivador
	 */
	@Property
	public void LogPBT_obtenerNombre (@From(MyCharacterGenerator.class) String nombre) {
		
		ArchivadorSimple archivador = new ArchivadorSimple(nombre, 1);
		
		Log log = new Log(archivador);
		
		log.establecerDelegado(archivador);
		
		assertEquals(nombre, log.obtenerNombre());
		
	}
	
	/**
	 * Test para comprobar que el método almacenarCorreo() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el correo se guarde correctamente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MensajeGenerator} para generar
	 *      mensajes, asegurando que la propiedad se cumple
	 *      sin influir el tamaño del mensaje que se está pasando siempre y cuando haya espacio.
	 *
	 * @param espacioArchivador espacio del archivador (el espacio debe valer por lo menos 1)
	 * @param mensaje mensaje que se va a almacenar
	 */
	@Property
	public void LogPBT_almacenarCorreo (@InRange(min = "1") int espacioArchivador,
			@From(MensajeGenerator.class) Mensaje mensaje) {
		
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", espacioArchivador);
		
		ArchivadorSimple archivadorDelegado = new ArchivadorSimple("archivadorDelegado", espacioArchivador);
		
		Log log = new Log(archivador);
		
		log.establecerDelegado(archivadorDelegado);
		
		boolean result = log.almacenarCorreo(mensaje);
		
		assertTrue(result);
		
	}
	
	/**
	 * Test para comprobar que el método almacenarCorreo() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que no se guarde el correo por falta de espacio.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MyCharacterGenerator} para generar
	 *      cadenas aleatorias de contenido, asegurando que la propiedad se cumple
	 *      sin influir el contenido que se está pasando.
	 *
	 * @param contenido contenido del correo
	 * @throws OperacionInvalida
	 */
	@Property
	public void LogPBT_almacenarCorreo_false (
			@From(MyCharacterGenerator.class) String contenido) throws OperacionInvalida {
		
		int max = contenido.length() - 1; 
        int min = 1; 
        int range = max - min + 1; 
		
		int espacio = (int) (Math.random() * range) + min;
		
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", espacio);
		
		ArchivadorSimple archivadorDelegado = new ArchivadorSimple("archivadorDelegado", espacio);
		
		Log log = new Log(archivador);
		
		log.establecerDelegado(archivadorDelegado);
		
		boolean result = log.almacenarCorreo(new Mensaje(new Texto("mensaje", contenido)));
		
		assertFalse(result);
		
	}
}
