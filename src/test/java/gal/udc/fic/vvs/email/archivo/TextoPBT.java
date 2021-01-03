package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import gal.udc.fic.vvs.util.MyCharacterGenerator;

/**
 * Clase para probar usando PBT los métodos de la clase {@link Texto}.
 * 
 * @author Sergio Cortizo De Dios
 */
@RunWith(JUnitQuickcheck.class)
public class TextoPBT {
	
	private static EtmMonitor monitor = EtmManager.getEtmMonitor();
	
	/**
	 * Test para comprobar el método obtenerNombre() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el nombre del texto.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MyCharacterGenerator} para generar
	 *      cadenas aleatoriamente, asegurando que cualquier cadena no vacía se pueda
	 *      usar como nombre de texto.
	 *
	 * @param nombreTexto nombre del texto
	 * @param contenidoTexto contenido del texto
	 */
	@Property
	public void obtenerNombrePBT(@From(MyCharacterGenerator.class) String nombreTexto,
			@From(MyCharacterGenerator.class) String contenidoTexto) {
		EtmPoint point = monitor.createPoint("Texto:obtenerNombrePBT");
		
		Texto textoATestear = new Texto(nombreTexto, contenidoTexto);
		
		assertEquals(nombreTexto, textoATestear.obtenerNombre());
		
		point.collect();

	}
	
	/**
	 * Test para comprobar que el método obtenerContenido() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el contenido del texto.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MyCharacterGenerator} para generar
	 *      cadenas aleatoriamente, asegurando que cualquier cadena no vacía se pueda
	 *      usar como contenido para el texto.
	 *
	 * @param nombreTexto nombre del texto
	 * @param contenidoTexto contenido del texto
	 */
	@Property
	public void obtenerContenidoPBT(@From(MyCharacterGenerator.class) String nombreTexto,
			@From(MyCharacterGenerator.class) String contenidoTexto) {
		EtmPoint point = monitor.createPoint("Texto:obtenerContenidoPBT");
		
		Texto textoATestear = new Texto(nombreTexto, contenidoTexto);
		
		assertEquals(contenidoTexto, textoATestear.obtenerContenido());
		
		point.collect();

	}
	
	/**
	 * Test para comprobar que el método obtenerTamaño() funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el número de bytes que ocupa el contenido del texto.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MyCharacterGenerator} para generar
	 *      cadenas aleatoriamente, asegurando que cualquier cadena no vacía que
	 *      se meta como contenido haga que en consecuencia el método a testear
	 *      devuelva un valor mayor que 0.
	 *
	 * @param nombreTexto nombre del texto
	 * @param contenidoTexto contenido del texto
	 */
	@Property
	public void obtenerTamañoPBT(@From(MyCharacterGenerator.class) String nombreTexto,
			@From(MyCharacterGenerator.class) String contenidoTexto) {
		EtmPoint point = monitor.createPoint("Texto:obtenerTamañoPBT");
		
		Texto textoATestear = new Texto(nombreTexto, contenidoTexto);
		
		assertEquals(contenidoTexto.length(), textoATestear.obtenerTamaño());

		point.collect();
	}
	
	/**
	 * Test para comprobar que el método obtenerPreVisualizacion() 
	 * funciona como se espera.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que devuelva el nombre del texto junto con su tamaño 
	 *  	en el siguiente formato:
	 *  		{Nombre del texto}({nº de bytes} bytes, text/plain)
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MyCharacterGenerator} para generar
	 *      cadenas aleatoriamente, asegurando que cualquier cadena no vacía que se
	 *      pase por parámetro como nombre o contenido permita que el método a testear
	 *      devuelva una previsualización adecuada del archivo.
	 *
	 * @param nombreTexto nombre del texto
	 * @param contenidoTexto contenido del texto
	 */
	@Property
	public void obtenerPreVisualizacionPBT(@From(MyCharacterGenerator.class) String nombreTexto,
			@From(MyCharacterGenerator.class) String contenidoTexto) {
		EtmPoint point = monitor.createPoint("Texto:obtenerPreVisualizacionPBT");
		
		Texto textoATestear = new Texto(nombreTexto, contenidoTexto);
		
		final String previsualizacionTexto =
				nombreTexto + "(" + contenidoTexto.length() + " bytes, text/plain)";
		
		assertEquals(previsualizacionTexto, textoATestear.obtenerPreVisualizacion());
	
		point.collect();
	}
}
