package gal.udc.fic.vvs.util;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;

/**
 * Clase para generar de forma aleatoria un objeto de la clase {@link Carpeta}.
 * 
 * @author Sergio Cortizo De Dios
 */
public class CarpetaGenerator extends Generator<Carpeta> {
	
    public static final int TAMAÑO = (int) (Math.random() * (1000 - 1)) + 1;
    public static final String nombreMensajes = "Mensaje";
    public static final String contenidoMensajes = "Mensaje de prueba ";
    
	public CarpetaGenerator() {
		super(Carpeta.class);
	}

	@Override
	public Carpeta generate(SourceOfRandomness random, GenerationStatus status) {
		Carpeta carpeta = new Carpeta("Carpeta de prueba");

		for (int i = 0; i < TAMAÑO; i++) {
			try {
				carpeta.añadir(new Mensaje(new Texto(nombreMensajes, contenidoMensajes + i)));
			} catch (OperacionInvalida e) {}
		}
		return carpeta;
	}

}
