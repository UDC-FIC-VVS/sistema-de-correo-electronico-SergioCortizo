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
	
	/**
	 * Test para comprobar que el método obtenerDelegado() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver null si no se ha asignado ningún delegado
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve null al no asignarse ningún delegado.
	 */
	@Test
	public void archivadorSimpleTest_obtenerDelegado_Null() {
		ArchivadorSimple archivadorSimplePrueba = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		
		assertEquals(null, archivadorSimplePrueba.obtenerDelegado());
	}
	
	/**
	 * Test para comprobar que el método almacenarCorreo() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra negativa,
	 *  	ya que a pesar de que el test pasa correctamente el espacio asignado no debería ser 0.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que no se guarda el correo al no haber espacio.
	 */
	//TODO: Bug encontrado. El valor 0 no debería ser un valor válido para el espacio del archivador al crear un objeto de esa clase.
	@Test 
	public void almacenarCorreoTest_EspacioVacio() {
		ArchivadorSimple archivadorSimplePrueba = new ArchivadorSimple(nombreArchivador, 0);
			
		Mensaje correo = new Mensaje(new Texto("TextoPrueba", "Texto de prueba"));
				
		assertFalse(archivadorSimplePrueba.almacenarCorreo(correo));
	}
}
