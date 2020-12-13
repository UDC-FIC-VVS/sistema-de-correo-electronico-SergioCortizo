package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivador.Delegado;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.util.MyCharacterGenerator;

@RunWith(JUnitQuickcheck.class)
public class DelegadoPBT {
	
	@Property
	public void DelegadoPBT_ObtenerEspacioTotal(@InRange(min = "1") int espacio) {
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", espacio);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivador);
		
		assertEquals(espacio, delegado.obtenerEspacioTotal());
	}
	
	@Property
	public void DelegadoPBT_ObtenerEspacioDisponibleSinAlmacenarCorreo(@InRange(min = "1") int espacio) {
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", espacio);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivador);
		
		assertEquals(espacio, delegado.obtenerEspacioDisponible());
	}
	
	@Property
	public void DelegadoPBT_AlmacenarCorreo(@InRange(min = "1") int espacio,
			@From(MyCharacterGenerator.class) String contenido) {
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", espacio);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivador);
		
		Mensaje mensaje = new Mensaje(new Texto("TextoPrueba", contenido));
		
		assertTrue(delegado.almacenarCorreo(mensaje));
		assertEquals(espacio - mensaje.obtenerTamaño(), delegado.obtenerEspacioDisponible());
	}
	
	@Property
	public void DelegadoPBT_AlmacenarCorreoEnArchivadorSinEspacio(
			@From(MyCharacterGenerator.class) String contenido) {
		
		int max = contenido.length() - 1; 
        int min = 1; 
        int range = max - min + 1; 
		
		int espacio = (int) (Math.random() * range) + min;
		
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", espacio);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivador);
		
		Mensaje mensaje = new Mensaje(new Texto("TextoPrueba", contenido));
		
		assertFalse(delegado.almacenarCorreo(mensaje));
	}
}
