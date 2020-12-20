package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.renderer.SimpleTextRenderer;
import gal.udc.fic.vvs.email.archivo.Texto;

/**
 * Clase para probar de forma manual los métodos de la clase {@link Texto}.
 * 
 * @author Sergio Cortizo De Dios
 */
public class TextoTest {
	
	private static EtmMonitor monitor;
	
	@BeforeClass
	public final static void prepareMonitor() {
		BasicEtmConfigurator.configure(true);
	    monitor = EtmManager.getEtmMonitor();
	    monitor.start();
	}
	
	@AfterClass
	public final static void stopMonitor() {
		monitor.render(new SimpleTextRenderer());
		monitor.stop();
	}
	
	/**
	 * Test para comprobar que el método obtenerNombre() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra negativa,
	 *  	el nombre del texto no debería estar vacío.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		con una cadena de texto vacía (se pasa por parámetro en el constructor).
	 */
	@Test
	public void obtenerNombreTest() {
		Texto textoATestear = new Texto("", "");
		
		assertEquals("", textoATestear.obtenerNombre());
	}
	
	/**
	 * Test para comprobar que el método obtenerContenido() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra negativa,
	 *  	el contenido de un texto no debería estar vacío.
	 * <p>
	 * - Mecanismo de selección de datos: ees una prueba manual, sólo se prueba
	 * 		con una cadena de texto vacía (se pasa por parámetro en el constructor).
	 */
	@Test
	public void obtenerContenidoTest() {
		Texto textoATestear = new Texto("", "");
		
		assertEquals("", textoATestear.obtenerContenido());
	}
}
