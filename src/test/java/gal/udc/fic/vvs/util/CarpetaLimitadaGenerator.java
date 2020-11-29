package gal.udc.fic.vvs.util;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.CarpetaLimitada;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;

public class CarpetaLimitadaGenerator extends Generator<CarpetaLimitada> {

    public static final int TAMAÑO = 1000;
	
	public CarpetaLimitadaGenerator() {
		super(CarpetaLimitada.class);
	}

	@Override
	public CarpetaLimitada generate(SourceOfRandomness random, GenerationStatus status) {
		Carpeta carpeta = new Carpeta("Carpeta limitada");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, TAMAÑO);
		for (int i = 0; i < TAMAÑO; i++) {
			try {
				carpetaLimitada.añadir(new Mensaje(new Texto("Mensaje", "Mensaje de prueba")));
			} catch (OperacionInvalida e) {}
		}
		return carpetaLimitada;
	}

}
