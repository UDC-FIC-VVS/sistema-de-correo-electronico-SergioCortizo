package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CarpetaProtectedTest {
	
	private final String nombreCarpeta = "CarpetaPrueba";
	
	@Test
	public void obtenerPadreYEstablecerPadre() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Carpeta carpetaPadre = new Carpeta(nombreCarpeta);
				
		carpeta.establecerPadre(carpetaPadre);
		
		assertEquals(carpetaPadre, carpeta.obtenerPadre());
	}
	
	//TODO: ¿Tiene sentido establecer un mensaje como padre de una carpeta?
	@Test
	public void establecerMensajeComoPadre() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Mensaje mensajePadre = new Mensaje(new Texto("MensajePadre", "Es el mensaje padre"));
				
		carpeta.establecerPadre(mensajePadre);
		
		assertEquals(mensajePadre, carpeta.obtenerPadre());
	}
}
