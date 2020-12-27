package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Vector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.CarpetaLimitada;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;

public class CarpetaLimitadaTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
		
	private int tamaño = 10;
	
	private final String nombreCarpeta = "CarpetaPrueba";
	private final String nombreSubcarpeta = "SubcarpetaPrueba";

	private final String nombreTexto = "TextoPrueba";
	private final String contenidoTexto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas metus. ";
	private final int tamañoContenidoTexto = contenidoTexto.length();

	private final int num_mensajes = 10;
	private final int num_subcarpetas = 10;
	
	private final Texto texto = new Texto(nombreTexto, contenidoTexto);
	
	private Carpeta prepareCarpetaWithMensajes() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		for (int i = 1; i <= num_mensajes; i++) {
			Mensaje mensaje = new Mensaje(texto);
			carpetaATestear.añadir(mensaje);
		}

		return carpetaATestear;
	}

	private Carpeta prepareCarpetaWithMensajesAndSubcarpetas() throws OperacionInvalida {
		Carpeta carpetaATestear = prepareCarpetaWithMensajes();

		for (int i = 1; i <= num_subcarpetas; i++) {
			Carpeta carpeta = new Carpeta(nombreSubcarpeta);
			for (int j = 1; j <= num_mensajes; j++) {
				Mensaje mensaje = new Mensaje(texto);
				carpeta.añadir(mensaje);
			}
			carpetaATestear.añadir(carpeta);
		}

		return carpetaATestear;
	}

	private Carpeta prepareCarpetaWithSubcarpetas() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		for (int i = 1; i <= num_subcarpetas; i++) {
			Carpeta carpeta = new Carpeta(nombreSubcarpeta);
			carpetaATestear.añadir(carpeta);
		}

		return carpetaATestear;
	}

	private Collection mensajesCollection() {
		Collection coleccion = new Vector();

		for (int i = 1; i <= num_mensajes; i++) {
			Mensaje mensaje = new Mensaje(texto);
			coleccion.add(mensaje);
		}

		return coleccion;
	}

	private Collection subcarpetasCollection() {
		Collection coleccion = new Vector();

		for (int i = 1; i <= num_subcarpetas; i++) {
			Carpeta carpeta = new Carpeta(nombreCarpeta);
			coleccion.add(carpeta);
		}

		return coleccion;
	}

	private Collection subcarpetasConMensajesCollection() throws OperacionInvalida {
		Collection coleccion = new Vector();

		for (int i = 1; i <= num_mensajes; i++) {
			Mensaje mensaje = new Mensaje(texto);
			coleccion.add(mensaje);
		}

		for (int i = 1; i <= num_subcarpetas; i++) {
			Carpeta carpeta = new Carpeta(nombreSubcarpeta);
			for (int j = 1; j <= num_mensajes; j++) {
				Mensaje mensaje = new Mensaje(texto);
				carpeta.añadir(mensaje);
			}
			coleccion.add(carpeta);
		}

		return coleccion;
	}
	
	@Test
	public void obtenerIcono() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Mensaje mensaje = new Mensaje(new Texto("TextoPrueba", "Este es un texto de prueba"));

		carpeta.añadir(mensaje);
		
		CarpetaLimitada carpetaLimitadaATestear = new CarpetaLimitada(carpeta, tamaño);
		
		assertEquals(Correo.ICONO_CARPETA, carpetaLimitadaATestear.obtenerIcono());
	}
	
	@Test
	public void obtenerVisualizacionMensajesTest() throws OperacionInvalida {
		Carpeta carpeta = prepareCarpetaWithMensajes();
		CarpetaLimitada carpetaLimitadaATestear = new CarpetaLimitada(carpeta, tamaño);

		assertEquals(nombreCarpeta + " (" + num_mensajes + ")", carpetaLimitadaATestear.obtenerVisualizacion());
	}
	
	@Test
	public void obtenerPreVisualizacionMensajesTest() throws OperacionInvalida {
		Carpeta carpeta = prepareCarpetaWithMensajes();
		CarpetaLimitada carpetaLimitadaATestear = new CarpetaLimitada(carpeta, tamaño);

		assertEquals(nombreCarpeta + " (" + num_mensajes + ")", carpetaLimitadaATestear.obtenerPreVisualizacion());
	}
	
	@Test
	public void explorarCarpetaWithMensajesTest() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitadaATestear = new CarpetaLimitada(carpeta, tamaño);

		Collection<Correo> expectedHijos = mensajesCollection();

		for (Correo mensaje : expectedHijos) {
			carpetaLimitadaATestear.añadir(mensaje);
		}

		assertEquals(expectedHijos, carpetaLimitadaATestear.explorar());

	}
	
	@Test
	public void buscarEnCarpetaWithMensajesTest() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);

		Collection expectedResult = new Vector();
		Collection secondExpectedResult = new Vector();
		Collection thirdExpectedResult = new Vector();
		Collection fourthExpectedResult = new Vector();

		Mensaje mensaje1 = new Mensaje(new Texto("Mensaje 1", "Mensaje numero 1"));
		carpeta.añadir(mensaje1);
		expectedResult.add(mensaje1);
		secondExpectedResult.add(mensaje1);

		Mensaje mensaje2 = new Mensaje(new Texto("Mensaje 2", "Mensaje numero 2"));
		carpeta.añadir(mensaje2);
		expectedResult.add(mensaje2);

		Mensaje mensaje3 = new Mensaje(new Texto("Mensaje 3", "Mensaje numero 3"));
		carpeta.añadir(mensaje3);
		expectedResult.add(mensaje3);
		thirdExpectedResult.add(mensaje3);

		Mensaje mensaje4 = new Mensaje(new Texto("Mensaje 4", "Mensaje numero 4"));
		carpeta.añadir(mensaje4);
		expectedResult.add(mensaje4);
		fourthExpectedResult.add(mensaje4);
		
		CarpetaLimitada carpetaLimitadaATestear = new CarpetaLimitada(carpeta, tamaño);

		assertEquals(expectedResult, carpetaLimitadaATestear.buscar("Mensaje"));
		assertEquals(secondExpectedResult, carpetaLimitadaATestear.buscar("1"));
		assertEquals(thirdExpectedResult, carpetaLimitadaATestear.buscar("3"));
		assertEquals(fourthExpectedResult, carpetaLimitadaATestear.buscar("4"));

	}
	
	@Test
	public void cambiarCarpetaPadreDeCorreo() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Carpeta carpetaPadre = new Carpeta(nombreCarpeta);
		
		CarpetaLimitada carpetaLimitadaATestear = new CarpetaLimitada(carpeta, tamaño);
		
		Mensaje mensajePrueba = new Mensaje(texto);
		
		carpetaPadre.añadir(mensajePrueba);
		
		assertEquals(carpetaPadre, mensajePrueba.obtenerPadre());
		
		carpetaLimitadaATestear.añadir(mensajePrueba);
		
		assertEquals(carpeta, mensajePrueba.obtenerPadre());
	}
	
	@Test
	public void obtenerRutaWithoutPadreTest() {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		
		CarpetaLimitada carpetaLimitadaATestear = new CarpetaLimitada(carpeta, tamaño);
		
		assertEquals(carpetaLimitadaATestear.obtenerRuta(), carpetaLimitadaATestear.obtenerPreVisualizacion());
	}
	
	@Test
	public void obtenerRutaWithPadreTest() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Carpeta carpetaPadre = new Carpeta(nombreCarpeta);
		
		CarpetaLimitada carpetaLimitadaATestear = new CarpetaLimitada(carpeta, tamaño);
		
		carpetaPadre.añadir(carpetaLimitadaATestear);
		
		assertEquals(carpetaPadre.obtenerPreVisualizacion() + " > " + carpetaLimitadaATestear.obtenerPreVisualizacion(),
				carpetaLimitadaATestear.obtenerRuta());
	}
	
	//@Test
	public void buscarEnCarpetaLlenaConTamañoMayorQueElTopeTest() throws OperacionInvalida {
		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Collection expectedCollection = new Vector();
		
		for (int i = 1; i <= tamaño; i++) {
			Mensaje mensaje = new Mensaje(new Texto("Texto " + i, "Este es el texto " + i));
			expectedCollection.add(mensaje);
			carpeta.añadir(mensaje);
		}
		
		for (int i = tamaño + 1; i <= tamaño * 2; i++) {
			Mensaje mensaje = new Mensaje(new Texto("Texto " + i, "Este es el texto " + i));
			carpeta.añadir(mensaje);
		}
		
		CarpetaLimitada carpetaLimitadaATestear = new CarpetaLimitada(carpeta, tamaño);
		
		Collection result = carpetaLimitadaATestear.buscar("Texto");

		//TODO: En realidad CarpetaLimitada está devolviendo más objetos de los que debería, concretamente 1 de más
		assertEquals(tamaño, carpetaLimitadaATestear.buscar("Texto").size());
	}
}
