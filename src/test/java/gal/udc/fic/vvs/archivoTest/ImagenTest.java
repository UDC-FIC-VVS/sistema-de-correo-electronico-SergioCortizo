package gal.udc.fic.vvs.archivoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Imagen;

public class ImagenTest {
	private final String nombreImagen = "ImagenPrueba";
	private final String contenidoImagen = "3k6aJuuumy4/UyFQTuC+HQ==";
	private final String previsualizacionImagen = nombreImagen + "(" + contenidoImagen.length() + " bytes, image/png)";
	
	@Test
	public void imagenObjectIsWellGenerated() {
		Imagen imagenATestear = new Imagen(nombreImagen, contenidoImagen);
		
		assertEquals(nombreImagen, imagenATestear.obtenerNombre());
		assertEquals(contenidoImagen, imagenATestear.obtenerContenido());
		assertEquals(contenidoImagen.length(), imagenATestear.obtenerTamaño());
		assertEquals(previsualizacionImagen, imagenATestear.obtenerPreVisualizacion());
	}
}
