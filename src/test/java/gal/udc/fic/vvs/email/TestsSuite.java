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
import gal.udc.fic.vvs.email.archivo.AudioPBT;
import gal.udc.fic.vvs.email.archivo.AudioTest;
import gal.udc.fic.vvs.email.archivo.ImagenPBT;
import gal.udc.fic.vvs.email.archivo.ImagenTest;
import gal.udc.fic.vvs.email.archivo.TextoPBT;
import gal.udc.fic.vvs.email.archivo.TextoTest;
import gal.udc.fic.vvs.email.correo.AdjuntoPBT;
import gal.udc.fic.vvs.email.correo.AdjuntoTest;
import gal.udc.fic.vvs.email.correo.CabeceraPBT;
import gal.udc.fic.vvs.email.correo.CabeceraTest;
import gal.udc.fic.vvs.email.correo.CarpetaLimitadaPBT;
import gal.udc.fic.vvs.email.correo.CarpetaLimitadaProtectedTest;
import gal.udc.fic.vvs.email.correo.CarpetaLimitadaTest;
import gal.udc.fic.vvs.email.correo.CarpetaPBT;
import gal.udc.fic.vvs.email.correo.CarpetaProtectedTest;
import gal.udc.fic.vvs.email.correo.CarpetaTest;
import gal.udc.fic.vvs.email.correo.MensajePBT;
import gal.udc.fic.vvs.email.correo.MensajeTest;
import gal.udc.fic.vvs.email.correo.ReenvioPBT;
import gal.udc.fic.vvs.email.correo.ReenvioTest;

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
	AdjuntoPBT.class, AdjuntoTest.class, CabeceraPBT.class, CabeceraTest.class,
	CarpetaLimitadaPBT.class, CarpetaLimitadaProtectedTest.class, CarpetaLimitadaTest.class,
	CarpetaPBT.class, CarpetaProtectedTest.class, CarpetaTest.class,
	MensajePBT.class, MensajeTest.class, ReenvioPBT.class, ReenvioTest.class
	})
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
