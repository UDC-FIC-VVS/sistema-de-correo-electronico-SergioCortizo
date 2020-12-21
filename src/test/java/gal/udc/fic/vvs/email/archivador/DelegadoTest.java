package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivador.Delegado;

/**
 * Clase para probar usando pruebas manuales los métodos de la clase {@link Delegado}.
 * 
 * @author Sergio Cortizo De Dios
 */
public class DelegadoTest {
	
	/**
	 * Test para comprobar que el método establecerDelegado() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera devolver el archivador delegado que se haya asignado.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		con un archivador de muestra.
	 */
	@Test
	public void DelegadoTest_establecerDelegado () {
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", 1);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivador);
		
		assertEquals(archivador, delegado.obtenerDelegado());
	}
	
}
