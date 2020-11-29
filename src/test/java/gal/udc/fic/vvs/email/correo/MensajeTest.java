package gal.udc.fic.vvs.email.correo;

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

public class MensajeTest {
	private final String nombreTexto = "TextoPrueba";
	private final String contenidoTexto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas metus. ";
    private final String previsualizacion = contenidoTexto.substring(0, Math.min(contenidoTexto.length(), 32)) + "...";
	private final String keywords = "Lorem adipiscing amet dolor consectetur";
	private final String partialContent = "Lorem ipsum dolor sit amet,";
    
	private Texto texto = new Texto(nombreTexto, contenidoTexto);
	
	@Rule
	public ExpectedException thrown= ExpectedException.none();
	
	@Test
	public void mensajeObjectWellCreated () {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		assertEquals(1, mensajeATestear.obtenerNoLeidos());
		assertEquals(texto.obtenerTamaño(), mensajeATestear.obtenerTamaño());
		assertEquals(Correo.ICONO_NUEVO_MENSAJE, mensajeATestear.obtenerIcono());
		assertEquals(previsualizacion, mensajeATestear.obtenerPreVisualizacion());
		assertEquals(contenidoTexto, mensajeATestear.obtenerVisualizacion());
	}
	
	@Test
	public void establecerComoLeidoTest () {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		mensajeATestear.establecerLeido(true);
		
		assertEquals(0, mensajeATestear.obtenerNoLeidos());
		assertEquals(Correo.ICONO_MENSAJE, mensajeATestear.obtenerIcono());
	}
	
	@Test
	public void establecerComoNoLeidoTest () {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		mensajeATestear.establecerLeido(false);
		
		assertEquals(1, mensajeATestear.obtenerNoLeidos());
		assertEquals(Correo.ICONO_NUEVO_MENSAJE, mensajeATestear.obtenerIcono());
	}
	
	@Test
	public void findExpectedMensajeTest() {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		Collection expectedCollection = new Vector();
		
		expectedCollection.add(mensajeATestear);
		
		assertEquals(expectedCollection, mensajeATestear.buscar(contenidoTexto));
		
	}
	
	@Test
	public void findExpectedMensajeTestWithPartialContent() {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		Collection expectedCollection = new Vector();
		
		expectedCollection.add(mensajeATestear);
		
		assertEquals(expectedCollection, mensajeATestear.buscar(partialContent));
		
	}
	
	//@Test
	public void findExpectedMensajeTestWithRandomKeywords() {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		Collection expectedCollection = new Vector();
		
		expectedCollection.add(mensajeATestear);
				
		/*TODO: Test falla cuando se ponen palabras en orden aleatorio que están dentro del contenido*/
		assertEquals(expectedCollection, mensajeATestear.buscar(keywords));
	}
	
	@Test
	public void findExpectedMensajeTestWithNoKeywords() {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		Collection expectedCollection = new Vector();
		expectedCollection.add(mensajeATestear);
						
		assertEquals(expectedCollection, mensajeATestear.buscar(""));
	}
	
	//TODO: ¿Sería correcto devolver igualmente el correo aunque el parámetro sea null?
	@Test
	public void findMensajeTestExpectedNullPointerExceptionPassingNullAsParameter() {
		Mensaje mensajeATestear = new Mensaje(texto);
		thrown.expect(NullPointerException.class);
		mensajeATestear.buscar(null);
	}
	
	@Test
	public void obtenerRutaWithoutPadreTest() {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		assertEquals(mensajeATestear.obtenerRuta(), mensajeATestear.obtenerPreVisualizacion());
	}
	
	@Test
	public void obtenerRutaWithPadreTest() throws OperacionInvalida {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		Carpeta carpetaPadre = new Carpeta("CarpetaPadre");
		
		carpetaPadre.añadir(mensajeATestear);
		
		assertEquals(carpetaPadre.obtenerPreVisualizacion() + " > " + mensajeATestear.obtenerPreVisualizacion(),
				mensajeATestear.obtenerRuta());
	}
	
	@Test
	public void obtenerPadreNullTest() {
		Mensaje mensajeATestear = new Mensaje(texto);
		
		assertEquals(null, mensajeATestear.obtenerPadre());
	}
	
	@Test
	public void explorarExpectedOperacionInvalidaTestExceptionTest() throws OperacionInvalida {
		Mensaje mensajeATestear = new Mensaje(texto);
		thrown.expect(OperacionInvalida.class);
		mensajeATestear.explorar();
	}
	
	@Test
	public void añadirExpectedOperacionInvalidaTestExceptionTest() throws OperacionInvalida {
		Mensaje mensajeATestear = new Mensaje(texto);
		thrown.expect(OperacionInvalida.class);
		mensajeATestear.añadir(null);
	}

	@Test
	public void eliminarExpectedOperacionInvalidaTestExceptionTest() throws OperacionInvalida {
		Mensaje mensajeATestear = new Mensaje(texto);
		thrown.expect(OperacionInvalida.class);
		mensajeATestear.eliminar(null);
	}
	
	@Test
	public void obtenerHijoExpectedOperacionInvalidaTestExceptionTest() throws OperacionInvalida {
		Mensaje mensajeATestear = new Mensaje(texto);
		thrown.expect(OperacionInvalida.class);
		mensajeATestear.obtenerHijo(0);
	}
	
}
