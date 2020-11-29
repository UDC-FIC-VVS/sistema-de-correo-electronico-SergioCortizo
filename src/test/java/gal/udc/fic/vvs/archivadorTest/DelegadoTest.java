package gal.udc.fic.vvs.archivadorTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivador.Delegado;

public class DelegadoTest {
	
	@Test
	public void DelegadoTest_establecerDelegado () {
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", 1);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivador);
		
		assertEquals(archivador, delegado.obtenerDelegado());
	}
	
	@Test
	public void DelegadoTest_obtenerNombre () {
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", 1);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivador);
		
		assertEquals("archivadorPrueba", delegado.obtenerNombre());
	}
}
