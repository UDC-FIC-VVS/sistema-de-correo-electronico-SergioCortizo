package gal.udc.fic.vvs.util;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.CarpetaLimitada;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;

public class CarpetaGenerator extends Generator<Carpeta> {
	
    public static final int TAMAÑO = (int) (Math.random() * (100000 - 1)) + 1;

	protected CarpetaGenerator() {
		super(Carpeta.class);
	}

	@Override
	public Carpeta generate(SourceOfRandomness random, GenerationStatus status) {
		Carpeta carpeta = new Carpeta("Carpeta de prueba");

		for (int i = 0; i < TAMAÑO; i++) {
			try {
				carpeta.añadir(new Mensaje(new Texto("Mensaje", "Mensaje de prueba " + i)));
			} catch (OperacionInvalida e) {}
		}
		return carpeta;
	}

}
