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
 * Clase para probar usando PBT los métodos de la clase {@link ArchivadorSimple}.
 * 
 * @author Sergio Cortizo De Dios
 */
@RunWith(JUnitQuickcheck.class)
public class ArchivadorSimplePBT {
		
	private String nombreArchivador = "archivadorPrueba";
	
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
	public void archivadorSimpleTest_obtenerNombre(@From(MyCharacterGenerator.class) String nombre) {
		ArchivadorSimple archivadorSimplePrueba = new ArchivadorSimple(nombre, 1);
		
		assertEquals(nombre, archivadorSimplePrueba.obtenerNombre());
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
	public void almacenarCorreoTest(@From(MyCharacterGenerator.class) String contenido, 
									@InRange(min = "1") int espacioArchivador) {
		ArchivadorSimple archivadorSimplePrueba = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		
		Mensaje correo = new Mensaje(new Texto("TextoPrueba", contenido));
		
		assertTrue(archivadorSimplePrueba.almacenarCorreo(correo));
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
	public void almacenarCorreoTest_obtenerEspacioDisponible(@From(MyCharacterGenerator.class) String contenido, 
									@InRange(min = "1") int espacioArchivador) {
		ArchivadorSimple archivadorSimplePrueba = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		
		Mensaje correo = new Mensaje(new Texto("TextoPrueba", contenido));
		
		archivadorSimplePrueba.almacenarCorreo(correo);

		assertEquals(espacioArchivador - correo.obtenerTamaño(),
				archivadorSimplePrueba.obtenerEspacioDisponible());
	}
	
	/**
	 * Test para comprobar lo que ocurre si se pasa un valor negativo 
	 * para el espacio usando pruebas basadas en propiedades.
	 * <p>
	 * - Nivel de prueba: prueba a nivel de unidad.
	 * <p>
	 * - Categoría de prueba: prueba funcional dinámica de caja negra negativa,
	 *  	el valor del espacio no debe ser negativo.
	 * <p>
	 * - Mecanismo de selección de datos: es una prueba basada en propiedades,
	 *      por lo que se usa la clase {@link MyCharacterGenerator} para generar
	 *      cadenas aleatorias de contenido, asegurando que la propiedad se cumple
	 *      sin influir el contenido que se está pasando (en este caso almacenarCorreo()
	 *      debe devolver "false" ya que debido a lo mencionado anteriormente no hay espacio).
     * 
	 * @param contenido contenido del correo
	 * @param espacioArchivador espacio asignado al archivador. En este caso se usa una partición
	 * de valores negativos para demostrar el bug dentro de la prueba (-1 es el valor frontera).
	 */
	//TODO: Bug encontrado. No se debería poder indicar valores negativos para el espacio del archivador.
	@Property 
	public void almacenarCorreoTest_EspacioNegativo(@InRange(max = "-1") int espacioArchivador) {
		ArchivadorSimple archivadorSimplePrueba = new ArchivadorSimple(nombreArchivador, espacioArchivador);
			
		Mensaje correo = new Mensaje(new Texto("TextoPrueba", "Texto de prueba"));
				
		assertFalse(archivadorSimplePrueba.almacenarCorreo(correo));
	}

	/**
	 * Test para comprobar el método obtenerEspacioTotal() usando pruebas basadas en propiedades.
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
	 * @param espacioArchivador espacio a asignar al archivador
	 */
	@Property
	public void obtenerEspacioTotal(int espacioArchivador) {
		ArchivadorSimple archivadorSimplePrueba = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		
		assertEquals(archivadorSimplePrueba.obtenerEspacioTotal(), espacioArchivador);
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
	 * @param espacioArchivador espacio a asignar al archivador
	 */
	@Property
	public void obtenerEspacioDisponible_SinAñadirArchivos(int espacioArchivador) {
		ArchivadorSimple archivadorSimplePrueba = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		
		assertEquals(archivadorSimplePrueba.obtenerEspacioDisponible(), espacioArchivador);
	}
}
