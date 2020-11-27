package gal.udc.fic.vvs.archivadorTest;

import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.Ctor;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivador.Log;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

@RunWith(JUnitQuickcheck.class)
public class LogPBT {

	//TODO: Bug encontrado. El mensaje de log debería contener más información.
	@Property
	public void logTest_almacenarCorreo(@InRange(min = "1") int espacioArchivador,
										@From(Ctor.class) Texto texto) {
		Log logTest = new Log(new ArchivadorSimple("archivadorPrueba", espacioArchivador));
		Mensaje mensaje = new Mensaje(texto);
		
		assertTrue(logTest.almacenarCorreo(mensaje));
	}
}
