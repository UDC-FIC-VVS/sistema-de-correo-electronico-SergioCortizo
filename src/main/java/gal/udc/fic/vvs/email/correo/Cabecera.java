package gal.udc.fic.vvs.email.correo;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

public class Cabecera extends DecoradorMensaje {

    public Cabecera(MensajeAbstracto mensaje, String nombre, String valor) {
        super(mensaje);
        _nombre = nombre;
        _valor = valor;
    }

    public int obtenerTamaño() {
    	EtmPoint point = monitor.createPoint("Cabecera:obtenerTamaño");
    	point.collect();
        return super.obtenerTamaño() + _nombre.length() + _valor.length();
    }


    public String obtenerVisualizacion() {
    	EtmPoint point = monitor.createPoint("Cabecera:obtenerVisualizacion");
    	point.collect();
        return _nombre + ": " + _valor + "\n" + super.obtenerVisualizacion();
    }

    String _nombre;
    String _valor;
	private static EtmMonitor monitor = EtmManager.getEtmMonitor();

}
