package gal.udc.fic.vvs.email.correo;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

public class Reenvio extends DecoradorMensaje {

    public Reenvio(MensajeAbstracto mensaje, Correo correo) {
        super(mensaje);
        _correo = correo;
    }

    public int obtenerTamaño() {
    	EtmPoint point = monitor.createPoint("Reenvio:obtenerTamaño");
    	point.collect();
        return super.obtenerTamaño() + _correo.obtenerTamaño();
    }

    public String obtenerVisualizacion() {
    	EtmPoint point = monitor.createPoint("Reenvio:obtenerVisualizacion");
    	point.collect();
        return super.obtenerVisualizacion() + "\n\n---- Correo reenviado ----\n\n" + _correo.obtenerVisualizacion() + "\n---- Fin correo reenviado ----";
    }

    private Correo _correo;
	private static EtmMonitor monitor = EtmManager.getEtmMonitor();

}
