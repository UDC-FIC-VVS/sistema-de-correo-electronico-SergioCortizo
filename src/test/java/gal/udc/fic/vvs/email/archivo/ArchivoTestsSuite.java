/**
 * 
 */
package gal.udc.fic.vvs.email.archivo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.renderer.SimpleTextRenderer;

/**
 * Test suite para los tests del paquete de tests para {@see gal.udc.fic.vvs.email.archivo}
 * 
 * @author Sergio Cortizo De Dios
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ImagenTest.class, TextoTest.class, AudioTest.class,
	AudioPBT.class, ImagenPBT.class, TextoPBT.class})
public class ArchivoTestsSuite {

	private static EtmMonitor monitor;
	
	@BeforeClass
	public final static void prepareMonitor() {
		BasicEtmConfigurator.configure();
	    monitor = EtmManager.getEtmMonitor();
	    monitor.start();
	}
	
	@AfterClass
	public final static void stopMonitor() {
		monitor.render(new SimpleTextRenderer());
		monitor.stop();
	}
	
}
