package gal.udc.fic.vvs.correoTest;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Vector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;

public class CarpetaTest {
	private final String nombreCarpeta = "CarpetaPrueba";
	private final String nombreSubcarpeta = "SubcarpetaPrueba";

	private final String nombreTexto = "TextoPrueba";
	private final String contenidoTexto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas metus. ";
	private final int tamañoContenidoTexto = contenidoTexto.length();

	private final int num_mensajes = 10;
	private final int num_subcarpetas = 10;

	private final Texto texto = new Texto(nombreTexto, contenidoTexto);

	@Rule
	public ExpectedException thrown = ExpectedException.none();

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
	public void carpetaObjectWellCreated() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		assertEquals(0, carpetaATestear.obtenerNoLeidos());
		assertEquals(0, carpetaATestear.obtenerTamaño());
		assertEquals(Correo.ICONO_CARPETA, carpetaATestear.obtenerIcono());
		assertEquals(nombreCarpeta, carpetaATestear.obtenerVisualizacion());
		assertEquals(nombreCarpeta, carpetaATestear.obtenerPreVisualizacion());
		assertEquals(new Vector(), carpetaATestear.explorar());
		assertEquals(new Vector(), carpetaATestear.buscar(""));

		thrown.expect(ArrayIndexOutOfBoundsException.class);
		carpetaATestear.obtenerHijo(0);

	}

	@Test
	public void obtenerNoLeidosTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);
		Mensaje mensaje = new Mensaje(texto);

		carpetaATestear.añadir(mensaje);

		assertEquals(1, carpetaATestear.obtenerNoLeidos());
	}

	@Test
	public void obtenerMultiplesNoLeidosTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);
		Mensaje mensaje = new Mensaje(texto);

		carpetaATestear.añadir(mensaje);

		assertEquals(1, carpetaATestear.obtenerNoLeidos());
	}

	@Test
	public void establecerComoLeidoYNoLeidoTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);
		Mensaje mensaje = new Mensaje(texto);

		carpetaATestear.añadir(mensaje);

		carpetaATestear.establecerLeido(true);

		assertEquals(0, carpetaATestear.obtenerNoLeidos());

		carpetaATestear.establecerLeido(false);

		assertEquals(1, carpetaATestear.obtenerNoLeidos());
	}

	@Test
	public void establecerComoLeidosYNoLeidosMensajesDeCarpetaTest() throws OperacionInvalida {
		Carpeta carpetaATestear = prepareCarpetaWithMensajes();

		carpetaATestear.establecerLeido(true);

		assertEquals(0, carpetaATestear.obtenerNoLeidos());

		carpetaATestear.establecerLeido(false);

		assertEquals(num_mensajes, carpetaATestear.obtenerNoLeidos());
	}

	@Test
	public void establecerComoLeidosYNoLeidosMensajesYSubcarpetasTest() throws OperacionInvalida {
		Carpeta carpetaATestear = prepareCarpetaWithMensajesAndSubcarpetas();

		carpetaATestear.establecerLeido(true);

		assertEquals(0, carpetaATestear.obtenerNoLeidos());

		carpetaATestear.establecerLeido(false);

		assertEquals((num_mensajes * num_subcarpetas) + num_mensajes, carpetaATestear.obtenerNoLeidos());
	}

	@Test
	public void establecerComoLeidosYNoLeidosSubcarpetasTest() throws OperacionInvalida {
		Carpeta carpetaATestear = prepareCarpetaWithSubcarpetas();

		carpetaATestear.establecerLeido(true);

		assertEquals(0, carpetaATestear.obtenerNoLeidos());

		carpetaATestear.establecerLeido(false);

		assertEquals(0, carpetaATestear.obtenerNoLeidos());
	}

	@Test
	public void obtenerNoLeidosMensajesTest() throws OperacionInvalida {
		Carpeta carpetaATestear = prepareCarpetaWithMensajes();

		assertEquals(num_mensajes, carpetaATestear.obtenerNoLeidos());
	}

	@Test
	public void obtenerNoLeidosSubcarpetasTest() throws OperacionInvalida {
		Carpeta carpetaATestear = prepareCarpetaWithSubcarpetas();

		assertEquals(0, carpetaATestear.obtenerNoLeidos());
	}

	@Test
	public void obtenerNoLeidosMensajesAndSubcarpetasTest() throws OperacionInvalida {
		Carpeta carpetaATestear = prepareCarpetaWithMensajesAndSubcarpetas();

		assertEquals((num_mensajes * num_subcarpetas) + num_mensajes, carpetaATestear.obtenerNoLeidos());
	}

	@Test
	public void obtenerTamañoMensajesTest() throws OperacionInvalida {
		Carpeta carpetaATestear = prepareCarpetaWithMensajes();

		assertEquals(num_mensajes * tamañoContenidoTexto, carpetaATestear.obtenerTamaño());
	}

	@Test
	public void obtenerTamañoSubcarpetasTest() throws OperacionInvalida {
		Carpeta carpetaATestear = prepareCarpetaWithSubcarpetas();

		assertEquals(0, carpetaATestear.obtenerTamaño());
	}

	@Test
	public void obtenerTamañoMensajesAndSubcarpetasTest() throws OperacionInvalida {
		Carpeta carpetaATestear = prepareCarpetaWithMensajesAndSubcarpetas();

		assertEquals((num_mensajes * tamañoContenidoTexto * num_subcarpetas) + num_mensajes * tamañoContenidoTexto,
				carpetaATestear.obtenerTamaño());
	}

	@Test
	public void obtenerVisualizacionMensajesTest() throws OperacionInvalida {
		Carpeta carpetaATestear = prepareCarpetaWithMensajes();

		assertEquals(nombreCarpeta + " (" + num_mensajes + ")", carpetaATestear.obtenerVisualizacion());
	}

	@Test
	public void obtenerVisualizacionSubcarpetasTest() throws OperacionInvalida {
		Carpeta carpetaATestear = prepareCarpetaWithSubcarpetas();

		assertEquals(nombreCarpeta, carpetaATestear.obtenerVisualizacion());
	}

	@Test
	public void obtenerVisualizacionMensajesAndSubcarpetasTest() throws OperacionInvalida {
		Carpeta carpetaATestear = prepareCarpetaWithMensajesAndSubcarpetas();

		int num_noleidos = num_mensajes + (num_mensajes * num_subcarpetas);

		assertEquals(nombreCarpeta + " (" + num_noleidos + ")", carpetaATestear.obtenerVisualizacion());
	}

	@Test
	public void obtenerPreVisualizacionMensajesTest() throws OperacionInvalida {
		Carpeta carpetaATestear = prepareCarpetaWithMensajes();

		assertEquals(nombreCarpeta + " (" + num_mensajes + ")", carpetaATestear.obtenerPreVisualizacion());
	}

	@Test
	public void obtenerPreVisualizacionSubcarpetasTest() throws OperacionInvalida {
		Carpeta carpetaATestear = prepareCarpetaWithSubcarpetas();

		assertEquals(nombreCarpeta, carpetaATestear.obtenerPreVisualizacion());
	}

	@Test
	public void obtenerPreVisualizacionMensajesAndSubcarpetasTest() throws OperacionInvalida {
		Carpeta carpetaATestear = prepareCarpetaWithMensajesAndSubcarpetas();

		int num_noleidos = num_mensajes + (num_mensajes * num_subcarpetas);

		assertEquals(nombreCarpeta + " (" + num_noleidos + ")", carpetaATestear.obtenerPreVisualizacion());
	}

	@Test
	public void explorarCarpetaWithMensajesTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		Collection<Correo> expectedHijos = mensajesCollection();

		for (Correo mensaje : expectedHijos) {
			carpetaATestear.añadir(mensaje);
		}

		assertEquals(expectedHijos, carpetaATestear.explorar());

	}

	@Test
	public void explorarCarpetaWithSubcarpetasTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		Collection<Correo> expectedHijos = subcarpetasCollection();

		for (Correo carpeta : expectedHijos) {
			carpetaATestear.añadir(carpeta);
		}

		assertEquals(expectedHijos, carpetaATestear.explorar());

	}

	@Test
	public void explorarCarpetaWithSubcarpetasAndMensajesTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		Collection<Correo> expectedHijos = subcarpetasConMensajesCollection();

		for (Correo carpeta : expectedHijos) {
			carpetaATestear.añadir(carpeta);
		}

		assertEquals(expectedHijos, carpetaATestear.explorar());

	}

	@Test
	public void buscarEnCarpetaWithMensajesTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		Collection expectedResult = new Vector();
		Collection secondExpectedResult = new Vector();
		Collection thirdExpectedResult = new Vector();
		Collection fourthExpectedResult = new Vector();

		Mensaje mensaje1 = new Mensaje(new Texto("Mensaje 1", "Mensaje numero 1"));
		carpetaATestear.añadir(mensaje1);
		expectedResult.add(mensaje1);
		secondExpectedResult.add(mensaje1);

		Mensaje mensaje2 = new Mensaje(new Texto("Mensaje 2", "Mensaje numero 2"));
		carpetaATestear.añadir(mensaje2);
		expectedResult.add(mensaje2);

		Mensaje mensaje3 = new Mensaje(new Texto("Mensaje 3", "Mensaje numero 3"));
		carpetaATestear.añadir(mensaje3);
		expectedResult.add(mensaje3);
		thirdExpectedResult.add(mensaje3);

		Mensaje mensaje4 = new Mensaje(new Texto("Mensaje 4", "Mensaje numero 4"));
		carpetaATestear.añadir(mensaje4);
		expectedResult.add(mensaje4);
		fourthExpectedResult.add(mensaje4);

		assertEquals(expectedResult, carpetaATestear.buscar("Mensaje"));
		assertEquals(secondExpectedResult, carpetaATestear.buscar("1"));
		assertEquals(thirdExpectedResult, carpetaATestear.buscar("3"));
		assertEquals(fourthExpectedResult, carpetaATestear.buscar("4"));

	}

	@Test
	public void añadirMensajeACarpetaTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		Mensaje mensaje = new Mensaje(texto);

		carpetaATestear.añadir(mensaje);

		assertEquals(mensaje, carpetaATestear.obtenerHijo(0));
	}

	@Test
	public void añadirSubcarpetaVaciaACarpetaTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		Carpeta subcarpeta = new Carpeta("subcarpeta");

		carpetaATestear.añadir(subcarpeta);

		assertEquals(subcarpeta, carpetaATestear.obtenerHijo(0));
	}

	@Test
	public void añadirSubcarpetaConMensajeACarpetaTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		Carpeta subcarpeta = new Carpeta("subcarpeta");

		Mensaje mensaje = new Mensaje(texto);

		subcarpeta.añadir(mensaje);

		carpetaATestear.añadir(subcarpeta);

		assertEquals(subcarpeta, carpetaATestear.obtenerHijo(0));
	}

	@Test
	public void eliminarMensajeDeCarpetaTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		Mensaje mensaje = new Mensaje(texto);

		carpetaATestear.añadir(mensaje);

		assertEquals(mensaje, carpetaATestear.obtenerHijo(0));

		carpetaATestear.eliminar(mensaje);

		thrown.expect(ArrayIndexOutOfBoundsException.class);

		carpetaATestear.obtenerHijo(0);
	}

	@Test
	public void eliminarSubcarpetaVaciaDeCarpetaTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		Carpeta subcarpeta = new Carpeta("subcarpeta");

		carpetaATestear.añadir(subcarpeta);

		assertEquals(subcarpeta, carpetaATestear.obtenerHijo(0));

		carpetaATestear.eliminar(subcarpeta);

		thrown.expect(ArrayIndexOutOfBoundsException.class);

		carpetaATestear.obtenerHijo(0);
	}

	@Test
	public void eliminarSubcarpetaConMensajeDeCarpetaTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);

		Carpeta subcarpeta = new Carpeta("subcarpeta");

		Mensaje mensaje = new Mensaje(texto);

		subcarpeta.añadir(mensaje);

		carpetaATestear.añadir(subcarpeta);

		assertEquals(subcarpeta, carpetaATestear.obtenerHijo(0));

		carpetaATestear.eliminar(subcarpeta);

		thrown.expect(ArrayIndexOutOfBoundsException.class);

		carpetaATestear.obtenerHijo(0);
	}

	@Test
	public void buscarHijoEnCarpetaWithMensajesTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);
		
		Mensaje mensaje1 = new Mensaje(new Texto("Mensaje 1", "Mensaje numero 1"));
		carpetaATestear.añadir(mensaje1);
		
		Mensaje mensaje2 = new Mensaje(new Texto("Mensaje 2", "Mensaje numero 2"));
		carpetaATestear.añadir(mensaje2);
		
		Mensaje mensaje3 = new Mensaje(new Texto("Mensaje 3", "Mensaje numero 3"));
		carpetaATestear.añadir(mensaje3);
		
		Mensaje mensaje4 = new Mensaje(new Texto("Mensaje 4", "Mensaje numero 4"));
		carpetaATestear.añadir(mensaje4);
		
		assertEquals(mensaje1, carpetaATestear.obtenerHijo(0));
		assertEquals(mensaje2, carpetaATestear.obtenerHijo(1));
		assertEquals(mensaje3, carpetaATestear.obtenerHijo(2));
		assertEquals(mensaje4, carpetaATestear.obtenerHijo(3));
		
	}
	
	@Test
	public void buscarHijoEnCarpetaWithSubcarpetasVaciasTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);
		
		Carpeta subcarpeta1 = new Carpeta("Carpeta 1");
		carpetaATestear.añadir(subcarpeta1);
		
		Carpeta subcarpeta2 = new Carpeta("Carpeta 2");
		carpetaATestear.añadir(subcarpeta2);
		
		Carpeta subcarpeta3 = new Carpeta("Carpeta 3");
		carpetaATestear.añadir(subcarpeta3);
		
		Carpeta subcarpeta4 = new Carpeta("Carpeta 4");
		carpetaATestear.añadir(subcarpeta4);
		
		assertEquals(subcarpeta1, carpetaATestear.obtenerHijo(0));
		assertEquals(subcarpeta2, carpetaATestear.obtenerHijo(1));
		assertEquals(subcarpeta3, carpetaATestear.obtenerHijo(2));
		assertEquals(subcarpeta4, carpetaATestear.obtenerHijo(3));
	}
	
	@Test
	public void buscarHijoEnCarpetaWithSubcarpetasConMensajesTest() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);
		
		Carpeta subcarpeta1 = new Carpeta("Carpeta 1");
		Mensaje mensaje1 = new Mensaje(new Texto("Mensaje 1", "Es el mensaje 1"));
		subcarpeta1.añadir(mensaje1);
		carpetaATestear.añadir(subcarpeta1);
		
		Carpeta subcarpeta2 = new Carpeta("Carpeta 2");
		Mensaje mensaje2 = new Mensaje(new Texto("Mensaje 2", "Es el mensaje 2"));
		subcarpeta2.añadir(mensaje2);
		carpetaATestear.añadir(subcarpeta2);
		
		Carpeta subcarpeta3 = new Carpeta("Carpeta 3");
		Mensaje mensaje3 = new Mensaje(new Texto("Mensaje 3", "Es el mensaje 3"));
		subcarpeta3.añadir(mensaje3);
		carpetaATestear.añadir(subcarpeta3);
		
		Carpeta subcarpeta4 = new Carpeta("Carpeta 4");
		Mensaje mensaje4 = new Mensaje(new Texto("Mensaje 4", "Es el mensaje 4"));
		subcarpeta4.añadir(mensaje4);
		carpetaATestear.añadir(subcarpeta4);
		
		assertEquals(subcarpeta1, carpetaATestear.obtenerHijo(0));
		assertEquals(subcarpeta2, carpetaATestear.obtenerHijo(1));
		assertEquals(subcarpeta3, carpetaATestear.obtenerHijo(2));
		assertEquals(subcarpeta4, carpetaATestear.obtenerHijo(3));
	}
	
	@Test
	public void cambiarCarpetaPadreDeCorreo() throws OperacionInvalida {
		Carpeta carpetaATestear = new Carpeta(nombreCarpeta);
		Carpeta carpetaPadre = new Carpeta(nombreCarpeta);
		
		Mensaje mensajePrueba = new Mensaje(texto);
		
		carpetaPadre.añadir(mensajePrueba);
		
		assertEquals(carpetaPadre, mensajePrueba.obtenerPadre());
		
		carpetaATestear.añadir(mensajePrueba);
		
		assertEquals(carpetaATestear, mensajePrueba.obtenerPadre());
	}
}
