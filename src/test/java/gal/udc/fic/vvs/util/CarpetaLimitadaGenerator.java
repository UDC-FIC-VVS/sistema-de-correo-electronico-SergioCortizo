package gal.udc.fic.vvs.util;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.CarpetaLimitada;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;

/**
 * Clase para generar de forma aleatoria un objeto de la clase {@link CarpetaLimitada}.
 * 
 * @author Sergio Cortizo De Dios
 */
public class CarpetaLimitadaGenerator extends Generator<CarpetaLimitada> {

    public static final int TAMAÑO = (int) (Math.random() * (1000 - 1)) + 1;
    public static final String nombreMensajes = "Mensaje";
    public static final String contenidoMensajes = "Mensaje de prueba ";
    
	public CarpetaLimitadaGenerator() {
		super(CarpetaLimitada.class);
	}

	@Override
	public CarpetaLimitada generate(SourceOfRandomness random, GenerationStatus status) {
		Carpeta carpeta = new Carpeta("Carpeta limitada");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, TAMAÑO);
		for (int i = 0; i < TAMAÑO; i++) {
			try {
				carpetaLimitada.añadir(new Mensaje(new Texto(nombreMensajes, contenidoMensajes + i)));
			} catch (OperacionInvalida e) {}
		}
		return carpetaLimitada;
	}

}
