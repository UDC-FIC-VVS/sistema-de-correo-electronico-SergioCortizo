package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.util.MyCharacterGenerator;

/**
 * Clase para probar usando PBT los métodos de la clase {@link Audio}.
 * 
 * @author Sergio Cortizo De Dios
 */
@RunWith(JUnitQuickcheck.class)
public class AudioPBT {
	private static EtmMonitor monitor = EtmManager.getEtmMonitor();

	/**
	 * Test para comprobar el método obtenerNombre() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el nombre del audio.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MyCharacterGenerator} para generar
	 *      cadenas aleatoriamente, asegurando que cualquier cadena no vacía se pueda
	 *      usar como nombre de audio.
	 *
	 * @param nombreAudio nombre que recibe el audio
	 * @param contenidoAudio contenido del audio
	 */
	@Property
	public void obtenerNombrePBT(@From(MyCharacterGenerator.class) String nombreAudio,
			@From(MyCharacterGenerator.class) String contenidoAudio) {
		EtmPoint point = monitor.createPoint("Audio:obtenerNombrePBT");
		
		Audio audioATestear = new Audio(nombreAudio, contenidoAudio);
		
		assertEquals(nombreAudio, audioATestear.obtenerNombre());
		
		point.collect();
	}
	
	/**
	 * Test para comprobar que el método obtenerContenido() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el contenido del audio.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MyCharacterGenerator} para generar
	 *      cadenas aleatoriamente, asegurando que cualquier cadena no vacía se pueda
	 *      usar como contenido de audio.
	 *
	 * @param nombreAudio nombre que recibe el audio
	 * @param contenidoAudio contenido del audio
	 */
	@Property
	public void obtenerContenidoPBT(@From(MyCharacterGenerator.class) String nombreAudio,
			@From(MyCharacterGenerator.class) String contenidoAudio) {
		EtmPoint point = monitor.createPoint("Audio:obtenerContenidoPBT");
		
		Audio textoATestear = new Audio(nombreAudio, contenidoAudio);
		
		assertEquals(contenidoAudio, textoATestear.obtenerContenido());
		
		point.collect();
	}
	
	/**
	 * Test para comprobar que el método obtenerTamaño() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el tamaño que ocupa el audio.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MyCharacterGenerator} para generar
	 *      cadenas aleatoriamente, asegurando que cualquier cadena no vacía que
	 *      se meta como contenido haga que en consecuencia el método a testear
	 *      devuelva un valor mayor que 0.
	 *
	 * @param nombreAudio nombre que recibe el audio
	 * @param contenidoAudio contenido del audio
	 */
	@Property
	public void obtenerTamañoPBT(@From(MyCharacterGenerator.class) String nombreAudio,
			@From(MyCharacterGenerator.class) String contenidoAudio) {
		EtmPoint point = monitor.createPoint("Audio:obtenerTamañoPBT");
		
		Audio audioATestear = new Audio(nombreAudio, contenidoAudio);
		
		assertEquals(contenidoAudio.length(), audioATestear.obtenerTamaño());
		
		point.collect();
	}
	
	/**
	 * Test para comprobar que el método obtenerPreVisualizacion() 
	 * funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el nombre del audio junto con su tamaño 
	 *  	en el siguiente formato:
	 *  		{Nombre del audio}({nº de bytes} bytes, audio/ogg)
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MyCharacterGenerator} para generar
	 *      cadenas aleatoriamente, asegurando que cualquier cadena no vacía que se
	 *      pase por parámetro como nombre o contenido permita que el método a testear
	 *      devuelva una previsualización adecuada del archivo.
	 *
	 * @param nombreAudio nombre que recibe el audio
	 * @param contenidoAudio contenido del audio
	 */
	@Property
	public void obtenerPreVisualizacionPBT(@From(MyCharacterGenerator.class) String nombreAudio,
			@From(MyCharacterGenerator.class) String contenidoAudio) {
		EtmPoint point = monitor.createPoint("Audio:obtenerPreVisualizacionPBT");
		
		Audio textoATestear = new Audio(nombreAudio, contenidoAudio);
		
		final String previsualizacionAudio =
				nombreAudio + "(" + contenidoAudio.length() + " bytes, audio/ogg)";
		
		assertEquals(previsualizacionAudio, textoATestear.obtenerPreVisualizacion());
		
		point.collect();
	}
	
	
}
