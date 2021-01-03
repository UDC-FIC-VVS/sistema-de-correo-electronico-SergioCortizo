package gal.udc.fic.vvs.email.correo;

import java.util.Collection;
import java.util.Vector;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

public class Carpeta extends CorreoAbstracto {

    public Carpeta(String nombre) {
        _nombre = nombre;
        _hijos = new Vector();
    }

    public void establecerLeido(boolean leido) {
    	EtmPoint point = monitor.createPoint("Carpeta:establecerLeido");
    	
        try {
            for (int i = 0; i < _hijos.size(); i++) {
                obtenerHijo(i).establecerLeido(leido);
            }
            point.collect();
        } catch (OperacionInvalida e) { }
    }

    public int obtenerNoLeidos() {
    	EtmPoint point = monitor.createPoint("Carpeta:obtenerNoLeidos");
        int resultado = 0;
        try {
            for (int i = 0; i < _hijos.size(); i++) {
                resultado += obtenerHijo(i).obtenerNoLeidos();
            }
            point.collect();
        } catch (OperacionInvalida e) { }
        return resultado;
    }

    public int obtenerTamaño() {
    	EtmPoint point = monitor.createPoint("Carpeta:obtenerTamaño");
        int resultado = 0;
        try {
            for (int i = 0; i < _hijos.size(); i++) {
                resultado += obtenerHijo(i).obtenerTamaño();
            }
            point.collect();
        } catch (OperacionInvalida e) { }
        return resultado;
    }

    public Integer obtenerIcono() {
    	EtmPoint point = monitor.createPoint("Carpeta:obtenerIcono");
    	point.collect();
        return Correo.ICONO_CARPETA;
    }

    public String obtenerPreVisualizacion() {
    	EtmPoint point = monitor.createPoint("Carpeta:obtenerPreVisualizacion");
    	point.collect();
        return obtenerVisualizacion();
    }

    public String obtenerVisualizacion() {
    	EtmPoint point = monitor.createPoint("Carpeta:obtenerVisualizacion");
    	
        String resultado = _nombre;
        if (obtenerNoLeidos() > 0) {
            resultado += " (" + obtenerNoLeidos() + ")";
        }
        point.collect();
        return resultado;
    }

    public Collection explorar() throws OperacionInvalida {
    	EtmPoint point = monitor.createPoint("Carpeta:explorar");
    	point.collect();
        return _hijos;
    }

    public Collection buscar(String busqueda) {
    	EtmPoint point = monitor.createPoint("Carpeta:buscar");
        Vector resultado = new Vector();
        try {
            for (int i = 0; i < _hijos.size(); i++) {
                resultado.addAll(obtenerHijo(i).buscar(busqueda));
            }
        } catch (OperacionInvalida e) { }
        point.collect();
        return resultado;
    }

    public void añadir(Correo correo) throws OperacionInvalida {
    	EtmPoint point = monitor.createPoint("Carpeta:añadir");
	if (correo.obtenerPadre() != null) {
	    correo.obtenerPadre().eliminar(correo);
	}
        ((CorreoAbstracto) correo).establecerPadre(this);
        _hijos.addElement(correo);
        point.collect();
    }

    public void eliminar(Correo correo) throws OperacionInvalida {
    	EtmPoint point = monitor.createPoint("Carpeta:eliminar");
        if (_hijos.removeElement(correo)) {
            ((CorreoAbstracto) correo).establecerPadre(null);
        }
        point.collect();
    }

    public Correo obtenerHijo(int n) throws OperacionInvalida {
    	EtmPoint point = monitor.createPoint("Carpeta:obtenerHijo");
    	point.collect();
	return ((Correo)_hijos.elementAt(n));

    }

    private Vector _hijos;
    private String _nombre;
	private static EtmMonitor monitor = EtmManager.getEtmMonitor();

}
