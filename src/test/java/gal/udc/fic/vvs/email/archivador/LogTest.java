package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivador.Delegado;
import gal.udc.fic.vvs.email.archivador.Log;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;

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

	@Test
	public void LogTest_almacenarCorreo () {
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", 1);
		
		ArchivadorSimple archivadorDelegado = new ArchivadorSimple("archivadorDelegado", 1);
		
		Log log = new Log(archivador);
		
		log.establecerDelegado(archivadorDelegado);
		
		boolean result = log.almacenarCorreo(new Carpeta("carpeta"));
		
		assertTrue(result);
	}
	
	@Test
	public void LogTest_almacenarCorreo_false () throws OperacionInvalida {
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", 1);
		
		ArchivadorSimple archivadorDelegado = new ArchivadorSimple("archivadorDelegado", 1);
		
		Log log = new Log(archivador);
		
		log.establecerDelegado(archivadorDelegado);
		
		Carpeta carpeta = new Carpeta("carpeta");
		
		carpeta.añadir(new Mensaje(new Texto("mensaje", "mensaje")));
		
		boolean result = log.almacenarCorreo(carpeta);
		
		assertFalse(result);
	}
}
