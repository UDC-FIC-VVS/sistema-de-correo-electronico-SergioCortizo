package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;

/**
 * Clase para probar usando pruebas manuales los métodos de la clase {@link Log}.
 * 
 * @author Sergio Cortizo De Dios
 */
public class LogTest {
	
	private static EtmMonitor monitor = EtmManager.getEtmMonitor();
	
	/**
	 * Test para comprobar que el método obtenerDelegado() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver el archivador que se ha asignado como delegado.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve el archivador asignado como delegado.
	 */
	@Test
	public void LogTest_obtenerDelegado () {
		EtmPoint point = monitor.createPoint("Log:LogTest_obtenerDelegado");
		
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorSimple", 1);
		
		ArchivadorSimple archivadorDelegado = new ArchivadorSimple("archivadorDelegado", 1);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivadorDelegado);
		
		Log log = new Log(delegado);
		
		assertEquals(archivadorDelegado, log.obtenerDelegado());
		
		point.collect();
	}
	
	/**
	 * Test para comprobar que el método obtenerDelegado() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	si el archivador del log es un {@link ArchivadorSimple}, nno se debería
	 *  	establecer un delegado debido a la implementación de esta.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve el archivador asignado como delegado.
	 */
	@Test
	public void LogTest_obtenerDelegadoConArchivadorSimple () {
		EtmPoint point = monitor.createPoint("Log:LogTest_obtenerDelegadoConArchivadorSimple");
		
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", 1);
		
		ArchivadorSimple archivadorDelegado = new ArchivadorSimple("archivadorDelegado", 1);
		
		Log log = new Log(archivador);
		
		log.establecerDelegado(archivadorDelegado);
		
		assertEquals(null, log.obtenerDelegado());
		
		point.collect();
	}
	
	/**
	 * Test para comprobar que al almacenar correo se imprime el mensaje de log.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se imprima el mensaje de log.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se imprime el mensaje de log al almacenar el correo.
	 */
	@Test
	public void LogTest_almacenarCorreo_verifyPrintlnIsCalled () throws OperacionInvalida {
		EtmPoint point = monitor.createPoint("Log:LogTest_almacenarCorreo_verifyPrintlnIsCalled");
		
		final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		
		System.setOut(new PrintStream(outputStreamCaptor));
		
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", 1);
		
		ArchivadorSimple archivadorDelegado = new ArchivadorSimple("archivadorDelegado", 1);
		
		Log log = new Log(archivador);
		
		log.establecerDelegado(archivadorDelegado);
		
		log.almacenarCorreo(new Carpeta("carpeta"));
		
		assertEquals("Mensaxe de log", outputStreamCaptor.toString()
			      .trim());
		
		point.collect();
	}
}
