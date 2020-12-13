package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.util.MyCharacterGenerator;

@RunWith(JUnitQuickcheck.class)
public class ArchivadorSimplePBT {
	
	private String nombreArchivador = "archivadorPrueba";

	@Property 
	public void almacenarCorreoTest(@From(MyCharacterGenerator.class) String contenido, 
									@InRange(min = "1") int espacioArchivador) {
		ArchivadorSimple archivadorSimplePrueba = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		
		Mensaje correo = new Mensaje(new Texto("TextoPrueba", contenido));
		
		assertTrue(archivadorSimplePrueba.almacenarCorreo(correo));
		assertEquals(espacioArchivador - correo.obtenerTamaño(),
				archivadorSimplePrueba.obtenerEspacioDisponible());
	}
	
	//TODO: Bug encontrado. El valor 0 no debería ser un valor válido para el espacio del archivador al crear un objeto de esa clase.
	@Test 
	public void almacenarCorreoTest_EspacioVacio() {
		ArchivadorSimple archivadorSimplePrueba = new ArchivadorSimple(nombreArchivador, 0);
		
		Mensaje correo = new Mensaje(new Texto("TextoPrueba", "Texto de prueba"));
			
		assertFalse(archivadorSimplePrueba.almacenarCorreo(correo));
	}
	
	//TODO: Bug encontrado. No se debería poder indicar valores negativos para el espacio del archivador.
	@Property 
	public void almacenarCorreoTest_EspacioNegativo(@InRange(max = "-1") int espacioArchivador) {
		ArchivadorSimple archivadorSimplePrueba = new ArchivadorSimple(nombreArchivador, espacioArchivador);
			
		Mensaje correo = new Mensaje(new Texto("TextoPrueba", "Texto de prueba"));
				
		assertFalse(archivadorSimplePrueba.almacenarCorreo(correo));
	}
	
	//Este test demuestra los 2 bugs mencionados anteriormente
	//@Property
	public void obtenerEspacioTotal(int espacioArchivador) {
		ArchivadorSimple archivadorSimplePrueba = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		
		assumeThat(archivadorSimplePrueba.obtenerEspacioTotal(), Matchers.greaterThan(0));
	}
	
	//Este test demuestra los 2 bugs mencionados anteriormente
	//@Property
	public void obtenerEspacioDisponible_SinAñadirArchivos(int espacioArchivador) {
		ArchivadorSimple archivadorSimplePrueba = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		
		assumeThat(archivadorSimplePrueba.obtenerEspacioDisponible(), Matchers.greaterThan(0));
	}
}
