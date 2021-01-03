package gal.udc.fic.vvs.email.correo;

import java.util.Collection;
import java.util.Vector;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import gal.udc.fic.vvs.email.archivo.Texto;

public class Mensaje extends MensajeAbstracto {

    public Mensaje(Texto contenido) {
        _contenido = contenido;
        _leido = false;
    }

    public void establecerLeido(boolean leido) {
    	EtmPoint point = monitor.createPoint("Mensaje:establecerLeido");
        _leido = leido;
        point.collect();
    }

    public int obtenerNoLeidos() {
    	EtmPoint point = monitor.createPoint("Mensaje:obtenerNoLeidos");
        if(_leido) {
        	point.collect();
            return 0;
        } else {
        	point.collect();
            return 1;
        }
    }

    public int obtenerTamaño() {
    	EtmPoint point = monitor.createPoint("Mensaje:obtenerTamaño");
    	point.collect();
        return _contenido.obtenerTamaño();
    }

    public Integer obtenerIcono() {
    	EtmPoint point = monitor.createPoint("Mensaje:obtenerIcono");
        if(_leido) {
        	point.collect();
            return Correo.ICONO_MENSAJE;
        } else {
        	point.collect();
            return Correo.ICONO_NUEVO_MENSAJE;
        }
    }

    public String obtenerPreVisualizacion() {
    	EtmPoint point = monitor.createPoint("Mensaje:obtenerPreVisualizacion");
        String visualizacion = obtenerVisualizacion();
        point.collect();
        return visualizacion.substring(0, Math.min(visualizacion.length(), TAMAÑO_PREVISUALIZACION)) + "...";
    }

    public String obtenerVisualizacion() {
    	EtmPoint point = monitor.createPoint("Mensaje:obtenerVisualizacion");
    	point.collect();
        return _contenido.obtenerContenido();
    }

    public Collection buscar(String busqueda) {
    	EtmPoint point = monitor.createPoint("Mensaje:buscar");

        Vector resultado = new Vector();
        if (obtenerVisualizacion().toLowerCase().matches(".*" + busqueda.toLowerCase() + ".*")) {
            resultado.addElement(this);
        }
        point.collect();
        return resultado;
    }

    private final static int TAMAÑO_PREVISUALIZACION = 32;
    private boolean _leido;
    private Texto _contenido;
	private static EtmMonitor monitor = EtmManager.getEtmMonitor();

}
