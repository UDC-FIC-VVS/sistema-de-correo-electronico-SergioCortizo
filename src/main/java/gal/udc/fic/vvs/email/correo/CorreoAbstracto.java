package gal.udc.fic.vvs.email.correo;

import java.util.Collection;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

public abstract class CorreoAbstracto implements Correo {

    public CorreoAbstracto() {
        _padre = null;
    }

    public String obtenerRuta() {
    	EtmPoint point = monitor.createPoint("CorreoAbstracto:obtenerRuta");
        if (obtenerPadre() != null) {
        	point.collect();
            return obtenerPadre().obtenerRuta() + " > " + obtenerPreVisualizacion();
        } else {
        	point.collect();
            return obtenerPreVisualizacion();
        }
    }

    public Collection explorar() throws OperacionInvalida {
    	EtmPoint point = monitor.createPoint("CorreoAbstracto:explorar");
    	point.collect();
        throw new OperacionInvalida();
    }

    public void añadir(Correo correo) throws OperacionInvalida {
    	EtmPoint point = monitor.createPoint("CorreoAbstracto:añadir");
    	point.collect();
        throw new OperacionInvalida();
    }

    public void eliminar(Correo correo) throws OperacionInvalida {
    	EtmPoint point = monitor.createPoint("CorreoAbstracto:eliminar");
    	point.collect();
        throw new OperacionInvalida();
    }

    public Correo obtenerHijo(int n) throws OperacionInvalida {
    	EtmPoint point = monitor.createPoint("CorreoAbstracto:obtenerHijo");
    	point.collect();
        throw new OperacionInvalida();
    }

    public Correo obtenerPadre() {
    	EtmPoint point = monitor.createPoint("CorreoAbstracto:obtenerPadre");
    	point.collect();
        return _padre;
    }

    protected void establecerPadre(Correo padre) {
    	EtmPoint point = monitor.createPoint("CorreoAbstracto:establecerPadre");    	
        _padre = padre;
        point.collect();
    }

    private Correo _padre;
	private static EtmMonitor monitor = EtmManager.getEtmMonitor();

}
