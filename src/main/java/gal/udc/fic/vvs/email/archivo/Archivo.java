package gal.udc.fic.vvs.email.archivo;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

public abstract class Archivo {

    public Archivo(String nombre, String contenido) {
        _nombre = nombre;
        _contenido = contenido;
    }

    public String obtenerNombre() {
    	EtmPoint point = monitor.createPoint("Archivo:obtenerNombre");
    	point.collect();
        return _nombre;
    }

    public String obtenerContenido() {
    	EtmPoint point = monitor.createPoint("Archivo:obtenerContenido");
    	point.collect();
        return _contenido;
    }

    public int obtenerTamaño() {
    	EtmPoint point = monitor.createPoint("Archivo:obtenerTamaño");
    	point.collect();
        return _contenido.length();
    }

    public String obtenerPreVisualizacion() {
    	EtmPoint point = monitor.createPoint("Archivo:obtenerPreVisualizacion");
    	point.collect();
        return _nombre + "(" + obtenerTamaño() + " bytes, " + obtenerMimeType() + ")";
    }

    protected abstract String obtenerMimeType();

    private String _nombre;
    private String _contenido;
	private static EtmMonitor monitor = EtmManager.getEtmMonitor();

    
}
