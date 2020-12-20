package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.util.MyCharacterGenerator;

/**
 * Clase para probar usando PBT los métodos de la clase {@link Delegado}.
 * 
 * @author Sergio Cortizo De Dios
 */
@RunWith(JUnitQuickcheck.class)
public class DelegadoPBT {
	
	/**
	 * Test para comprobar el método obtenerNombre() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que se devuelva el nombre asignado al archivador.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MyCharacterGenerator} para generar
	 *      cadenas aleatorias, asegurando que se pueda poner cualquier nombre al
	 *      archivador siempre y cuando no sea una cadena vacía.
	 *
	 * @param nombre nombre del archivador
	 */
	@Property
	public void DelegadoTest_obtenerNombre (@From(MyCharacterGenerator.class) String nombre) {
		ArchivadorSimple archivador = new ArchivadorSimple(nombre, 1);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivador);
		
		assertEquals(nombre, delegado.obtenerNombre());
	}
	
	/**
	 * Test para comprobar el método obtenerEspacioTotal() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra tanto positiva como negativa,
	 *  	se espera que el espacio total sea el mismo que el asignado al crear el delegado,
	 *  	pero el espacio no debería ser negativo.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se generan números enteros aleatorios para comprobar que pasando cualquier
	 *      entero podemos asignarle espacio al archivador delegado (no se tiene en cuenta enteros positivos
	 *      y negativos para demostrar el bug sobre el espacio negativo mencionado anteriormente).
	 *
	 * @param espacio espacio a asignar
	 */
	@Property
	public void DelegadoPBT_ObtenerEspacioTotal(int espacio) {
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", espacio);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivador);
		
		assertEquals(espacio, delegado.obtenerEspacioTotal());
	}
	
	/**
	 * Test para comprobar el método obtenerEspacioDisponible() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra tanto positiva como negativa,
	 *  	se espera que el espacio total sea el mismo que el asignado al crear el archivador,
	 *  	pero el espacio no debería ser negativo.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se generan números enteros aleatorios para comprobar que pasando cualquier
	 *      entero podemos asignarle espacio al archivador (no se tiene en cuenta enteros positivos
	 *      o negativos para demostrar el bug sobre el espacio negativo mencionado anteriormente).
	 *
	 * @param espacio espacio a asignar
	 */
	@Property
	public void DelegadoPBT_ObtenerEspacioDisponibleSinAlmacenarCorreo(int espacio) {
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", espacio);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivador);
		
		assertEquals(espacio, delegado.obtenerEspacioDisponible());
	}
	
	/**
	 * Test para comprobar el método almacenarCorreo() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el correo se guarde correctamente.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MyCharacterGenerator} para generar
	 *      cadenas aleatorias de contenido, asegurando que la propiedad se cumple
	 *      sin influir el contenido que se está pasando.
     * 
	 * @param contenido contenido del correo
	 * @param espacioArchivador espacio asignado al archivador.
	 *  Por lo menos debería ser de 1 (valor frontera para valores de espacio asignado válidos).
	 */
	@Property
	public void DelegadoPBT_AlmacenarCorreo(@InRange(min = "1") int espacio,
			@From(MyCharacterGenerator.class) String contenido) {
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", espacio);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivador);
		
		Mensaje mensaje = new Mensaje(new Texto("TextoPrueba", contenido));
		
		assertTrue(delegado.almacenarCorreo(mensaje));
	}
	
	/**
	 * Test para comprobar el método obtenerEspacioDisponible() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que el espacio disponible del archivador se haya disminuido.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MyCharacterGenerator} para generar
	 *      cadenas aleatorias de contenido, asegurando que la propiedad se cumple
	 *      sin influir el contenido que se está pasando.
     * 
	 * @param contenido contenido del correo
	 * @param espacioArchivador espacio asignado al archivador.
	 *  Por lo menos debería ser de 1 (valor frontera para valores de espacio asignado válidos).
	 */
	@Property
	public void DelegadoPBT_AlmacenarCorreo_reducidoEspacioDisponible(@InRange(min = "1") int espacio,
			@From(MyCharacterGenerator.class) String contenido) {
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", espacio);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivador);
		
		Mensaje mensaje = new Mensaje(new Texto("TextoPrueba", contenido));
		
		delegado.almacenarCorreo(mensaje);
		assertEquals(espacio - mensaje.obtenerTamaño(), delegado.obtenerEspacioDisponible());
	}
	
	/**
	 * Test para comprobar el método almacenarCorreo() usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra positiva,
	 *  	se espera que no se guarde el correo si no hay espacio disponible.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MyCharacterGenerator} para generar
	 *      cadenas aleatorias de contenido, asegurando que la propiedad se cumple
	 *      sin influir el contenido que se está pasando.
     * 
	 * @param contenido contenido del correo
	 */
	@Property
	public void DelegadoPBT_AlmacenarCorreoEnArchivadorSinEspacio(
			@From(MyCharacterGenerator.class) String contenido) {
		
		int max = contenido.length() - 1; 
        int min = 1; 
        int range = max - min + 1; 
		
		int espacio = (int) (Math.random() * range) + min;
		
		ArchivadorSimple archivador = new ArchivadorSimple("archivadorPrueba", espacio);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivador);
		
		Mensaje mensaje = new Mensaje(new Texto("TextoPrueba", contenido));
		
		assertFalse(delegado.almacenarCorreo(mensaje));
	}
}
