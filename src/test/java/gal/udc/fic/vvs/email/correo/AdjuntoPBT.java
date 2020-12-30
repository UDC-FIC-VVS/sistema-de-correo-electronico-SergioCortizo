package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.email.archivo.Imagen;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.util.AudioGenerator;
import gal.udc.fic.vvs.util.ImagenGenerator;
import gal.udc.fic.vvs.util.MensajeGenerator;
import gal.udc.fic.vvs.util.TextoGenerator;

/**
 * Clase para probar usando PBT los métodos de la clase {@link Adjunto}.
 * 
 * @author Sergio Cortizo De Dios
 */
@RunWith(JUnitQuickcheck.class)
public class AdjuntoPBT {

	/**
	 * Test para comprobar el método obtenerTamaño() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de integración, ya que dentro del método el tipo de
	 * 		integración se basa en procedimientos, en el cual se usan los objetos pasados en el
	 * 		constructor para que el método devuelva el tamaño en total ocupado por el mensaje y
	 * 		el archivo adjunto.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera obtener el tamaño correcto del adjunto.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usan las clases {@link MensajeGenerator} para generar
	 *      mensajes aleatorios y {@link TextoGenerator} para generar textos adjuntos aleatorios,
	 *      esperando que se devuelva el resultado esperado dependiendo del contenido tanto del
	 *      mensaje como del texto adjunto a éste.
	 *
	 * @param mensaje mensaje generado aleatoriamente
	 * @param texto texto generado aleatoriamente
	 */
	@Property
	public void textoAdjuntoObtenerTamañoTest(@From(MensajeGenerator.class) Mensaje mensaje,
			@From(TextoGenerator.class) Texto texto) {
		Adjunto adjunto = new Adjunto(mensaje, texto);

		assertEquals(mensaje.obtenerTamaño() + texto.obtenerTamaño(), adjunto.obtenerTamaño());

	}

	/**
	 * Test para comprobar el método obtenerTamaño() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de integración, ya que dentro del método el tipo de
	 * 		integración se basa en procedimientos, en el cual se usan los objetos pasados en el
	 * 		constructor para que el método devuelva el tamaño en total ocupado por el mensaje y
	 * 		el archivo adjunto.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera obtener el tamaño correcto del adjunto.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usan las clases {@link MensajeGenerator} para generar
	 *      mensajes aleatorios y {@link AudioGenerator} para generar audios adjuntos aleatorios,
	 *      esperando que se devuelva el resultado esperado dependiendo del contenido tanto del
	 *      mensaje como del texto adjunto a éste.
	 *
	 * @param mensaje mensaje generado aleatoriamente
	 * @param audio audio generado aleatoriamente
	 */
	@Property
	public void audioAdjuntoObtenerTamañoTest(@From(MensajeGenerator.class) Mensaje mensaje,
			@From(AudioGenerator.class) Audio audio) {
		Adjunto adjunto = new Adjunto(mensaje, audio);

		assertEquals(mensaje.obtenerTamaño() + audio.obtenerTamaño(), adjunto.obtenerTamaño());
		
	}

	/**
	 * Test para comprobar el método obtenerTamaño() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de integración, ya que dentro del método el tipo de
	 * 		integración se basa en procedimientos, en el cual se usan los objetos pasados en el
	 * 		constructor para que el método devuelva el tamaño en total ocupado por el mensaje y
	 * 		el archivo adjunto.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera obtener el tamaño correcto del adjunto.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usan las clases {@link MensajeGenerator} para generar
	 *      mensajes aleatorios y {@link ImagenGenerator} para generar imagenes adjuntas aleatorios,
	 *      esperando que se devuelva el resultado esperado dependiendo del contenido tanto del
	 *      mensaje como del texto adjunto a éste.
	 *
	 * @param mensaje mensaje generado aleatoriamente
	 * @param imagen imagen generada aleatoriamente
	 */
	@Property
	public void imagenAdjuntoObtenerTamañoTest(@From(MensajeGenerator.class) Mensaje mensaje,
			@From(ImagenGenerator.class) Imagen imagen) {
		Adjunto adjunto = new Adjunto(mensaje, imagen);
		
		assertEquals(mensaje.obtenerTamaño() + imagen.obtenerTamaño(), adjunto.obtenerTamaño());
		
	}
	
}
