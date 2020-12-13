package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Imagen;

public class ImagenTest {
	private final String nombreImagen = "ImagenPrueba";
	private final String contenidoImagen = "3k6aJuuumy4/UyFQTuC+HQ==";
	private final String previsualizacionImagen = nombreImagen + "(" + contenidoImagen.length() + " bytes, image/png)";
	
	@Test
	public void obtenerNombreTest() {
		Imagen imagenATestear = new Imagen(nombreImagen, contenidoImagen);
		
		assertEquals(nombreImagen, imagenATestear.obtenerNombre());
	}
	
	@Test
	public void obtenerContenidoTest() {
		Imagen imagenATestear = new Imagen(nombreImagen, contenidoImagen);
		
		assertEquals(contenidoImagen, imagenATestear.obtenerContenido());
	}
	
	@Test
	public void obtenerTamañoTest() {
		Imagen imagenATestear = new Imagen(nombreImagen, contenidoImagen);
		
		assertEquals(contenidoImagen.length(), imagenATestear.obtenerTamaño());
	}
	
	@Test
	public void obtenerPreVisualizacion() {
		Imagen imagenATestear = new Imagen(nombreImagen, contenidoImagen);
		
		assertEquals(previsualizacionImagen, imagenATestear.obtenerPreVisualizacion());
	}
}
