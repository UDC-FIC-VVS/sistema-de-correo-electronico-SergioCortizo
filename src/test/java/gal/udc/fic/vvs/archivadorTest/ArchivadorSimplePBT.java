package gal.udc.fic.vvs.archivadorTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.Ctor;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

@RunWith(JUnitQuickcheck.class)
public class ArchivadorSimplePBT {
	
	private String nombreArchivador = "archivadorPrueba";

	@Property 
	public void almacenarCorreoTest(@From(Ctor.class) Texto texto, 
									@InRange(min = "1") int espacioArchivador) {
		ArchivadorSimple archivadorSimplePrueba = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		
		Mensaje correo = new Mensaje(texto);
		
		assertTrue(archivadorSimplePrueba.almacenarCorreo(correo));
	}
	
	//TODO: Bug encontrado. El valor 0 no debería ser un valor válido para el espacio del archivador.
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
}
