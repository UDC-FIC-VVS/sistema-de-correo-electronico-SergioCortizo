package gal.udc.fic.vvs.email;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.renderer.SimpleTextRenderer;
import gal.udc.fic.vvs.email.archivador.ArchivadorSimplePBT;
import gal.udc.fic.vvs.email.archivador.ArchivadorSimpleTest;
import gal.udc.fic.vvs.email.archivador.DelegadoPBT;
import gal.udc.fic.vvs.email.archivador.DelegadoTest;
import gal.udc.fic.vvs.email.archivador.LogPBT;
import gal.udc.fic.vvs.email.archivador.LogTest;
import gal.udc.fic.vvs.email.archivo.AudioPBT;
import gal.udc.fic.vvs.email.archivo.AudioTest;
import gal.udc.fic.vvs.email.archivo.ImagenPBT;
import gal.udc.fic.vvs.email.archivo.ImagenTest;
import gal.udc.fic.vvs.email.archivo.TextoPBT;
import gal.udc.fic.vvs.email.archivo.TextoTest;

/**
 * Test suite para llas clases de tests, activando utilidades como pruebas con JETM
 * 
 * @author Sergio Cortizo De Dios
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ImagenTest.class, TextoTest.class, AudioTest.class,
	AudioPBT.class, ImagenPBT.class, TextoPBT.class, ArchivadorSimpleTest.class,
	ArchivadorSimplePBT.class, DelegadoPBT.class, DelegadoTest.class,
	LogPBT.class, LogTest.class})
public class TestsSuite {

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
