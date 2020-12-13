package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;

public class ArchivadorSimpleTest {

	private String nombreArchivador = "archivadorPrueba";
	private int espacioArchivador = 1000;
	
	@Test
	public void archivadorSimpleTest_obtenerNombre() {
		ArchivadorSimple archivadorSimplePrueba = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		
		assertEquals(nombreArchivador, archivadorSimplePrueba.obtenerNombre());
	}
	
	@Test
	public void archivadorSimpleTest_obtenerEspacioTotal() {
		ArchivadorSimple archivadorSimplePrueba = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		
		assertEquals(espacioArchivador, archivadorSimplePrueba.obtenerEspacioTotal());
	}
	
	@Test
	public void archivadorSimpleTest_obtenerEspacioDisponibleCuandoSeCrea() {
		ArchivadorSimple archivadorSimplePrueba = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		
		assertEquals(espacioArchivador, archivadorSimplePrueba.obtenerEspacioDisponible());
	}
	
	@Test
	public void archivadorSimpleTest_obtenerDelegado() {
		ArchivadorSimple archivadorSimplePrueba = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		
		assertEquals(null, archivadorSimplePrueba.obtenerDelegado());
	}
}
