package gal.udc.fic.vvs.archivadorTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivador.Delegado;
import gal.udc.fic.vvs.email.archivador.Log;

public class LogTest {
	
	@Test
	public void LogTest_obtenerNombre () {
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", 1);
		
		Log log = new Log(archivador);
		
		log.establecerDelegado(archivador);
		
		assertEquals("archivadorPrueba", log.obtenerNombre());
	}
	
	@Test
	public void LogTest_obtenerDelegado () {
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorSimple", 1);
		
		ArchivadorSimple archivadorDelegado = new ArchivadorSimple("archivadorDelegado", 1);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivadorDelegado);
		
		Log log = new Log(delegado);
		
		assertEquals(archivadorDelegado, log.obtenerDelegado());
	}
	
	@Test
	public void LogTest_obtenerDelegadoConArchivadorSimple () {
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", 1);
		
		ArchivadorSimple archivadorDelegado = new ArchivadorSimple("archivadorDelegado", 1);
		
		Log log = new Log(archivador);
		
		log.establecerDelegado(archivadorDelegado);
		
		assertEquals(null, log.obtenerDelegado());
	}
	
	
}
