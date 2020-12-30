package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

/**
 * Clase para probar manualmente los métodos protegidos de la clase {@link Carpeta}.
 * 
 * @author Sergio Cortizo De Dios
 */
public class CarpetaProtectedTest {
	
	private final String nombreCarpeta = "CarpetaPrueba";
	
	/**
	 * Test para comprobar que los métodos protegidos obtenerPadre()
	 * y establecerPadre() funcionan adecuadamente.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que la carpeta padre se ha establecido adecuadamente usando
	 *   	los dos métodos que se están probando.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		que se devuelve lo mencionado anteriormente.
	 */
	@Test
	public void obtenerPadreYEstablecerPadre() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Carpeta carpetaPadre = new Carpeta(nombreCarpeta);
				
		carpeta.establecerPadre(carpetaPadre);
		
		assertEquals(carpetaPadre, carpeta.obtenerPadre());
	}
	
	/**
	 * Test para exponer un error en el cual a través de obtenerPadre()
	 * se puede asignar un objeto de la clase {@link Mensaje} como padre de la clase
	 * que se está probando.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra negativa,
	 *  	la prueba está pensada para demostrar lo dicho anteriormente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba manual, sólo se prueba
	 * 		lo mencionado anteriormente.
	 */
	//TODO: ¿Tiene sentido establecer un mensaje como padre de una carpeta?
	@Test
	public void establecerMensajeComoPadre() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Mensaje mensajePadre = new Mensaje(new Texto("MensajePadre", "Es el mensaje padre"));
				
		carpeta.establecerPadre(mensajePadre);
		
		assertEquals(mensajePadre, carpeta.obtenerPadre());
	}
}
