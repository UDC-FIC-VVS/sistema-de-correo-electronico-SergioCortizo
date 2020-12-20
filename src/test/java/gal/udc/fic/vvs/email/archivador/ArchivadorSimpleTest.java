package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

/**
 * Clase para probar manualmente los métodos de la clase {@link ArchivadorSimple}.
 * 
 * @author Sergio Cortizo De Dios
 */
public class ArchivadorSimpleTest {

	private String nombreArchivador = "archivadorPrueba";
	private int espacioArchivador = 1000;
	
	@Test
	public void archivadorSimpleTest_obtenerDelegado() {
		ArchivadorSimple archivadorSimplePrueba = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		
		assertEquals(null, archivadorSimplePrueba.obtenerDelegado());
	}
	
	//TODO: Bug encontrado. El valor 0 no debería ser un valor válido para el espacio del archivador al crear un objeto de esa clase.
	@Test 
	public void almacenarCorreoTest_EspacioVacio() {
		ArchivadorSimple archivadorSimplePrueba = new ArchivadorSimple(nombreArchivador, 0);
			
		Mensaje correo = new Mensaje(new Texto("TextoPrueba", "Texto de prueba"));
				
		assertFalse(archivadorSimplePrueba.almacenarCorreo(correo));
	}
}
