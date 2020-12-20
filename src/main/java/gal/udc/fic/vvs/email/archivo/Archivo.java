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
    	EtmPoint point = etmMonitor.createPoint("Archivo:obtenerNombre");
    	
        return _nombre;
    }

    public String obtenerContenido() {
    	EtmPoint point = etmMonitor.createPoint("Archivo:obtenerContenido");
    	
        return _contenido;
    }

    public int obtenerTamaño() {
    	EtmPoint point = etmMonitor.createPoint("Archivo:obtenerTamaño");
    	
        return _contenido.length();
    }

    public String obtenerPreVisualizacion() {
    	EtmPoint point = etmMonitor.createPoint("Archivo:obtenerPreVisualizacion");
    	
        return _nombre + "(" + obtenerTamaño() + " bytes, " + obtenerMimeType() + ")";
    }

    protected abstract String obtenerMimeType();

    private String _nombre;
    private String _contenido;
    private static final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();
    
}
