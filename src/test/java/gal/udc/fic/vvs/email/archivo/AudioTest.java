package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import gal.udc.fic.vvs.email.archivo.Audio;

/**
 * Clase para probar manualmente los métodos de la clase {@link Audio}.
 * 
 * @author Sergio Cortizo De Dios
 */
public class AudioTest {
	
	private static EtmMonitor monitor = EtmManager.getEtmMonitor();
	
	/**
	 * Test para comprobar que el método obtenerNombre() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra negativa,
	 *  	el nombre del audio no debería estar vacío.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		con una cadena de texto vacía (se pasa por parámetro en el constructor).
	 */
	@Test
	public void obtenerNombreTest() {
		EtmPoint point = monitor.createPoint("Audio:obtenerNombreTest");
		
		Audio textoATestear = new Audio("", "");
		
		assertEquals("", textoATestear.obtenerNombre());
		
		point.collect();
	}
	
	/**
	 * Test para comprobar que el método obtenerContenido() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra negativa,
	 *  	el contenido de un audio no debería estar vacío.
	 * <p>
	 * - Mecanismo de selección de datos: ees una prueba manual, sólo se prueba
	 * 		con una cadena de texto vacía (se pasa por parámetro en el constructor).
	 */
	@Test
	public void obtenerContenidoTest() {
		EtmPoint point = monitor.createPoint("Audio:obtenerContenidoTest");
		
		Audio textoATestear = new Audio("", "");
		
		assertEquals("", textoATestear.obtenerContenido());
		
		point.collect();
	}
	
}
