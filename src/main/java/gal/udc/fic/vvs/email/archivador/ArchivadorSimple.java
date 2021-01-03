package gal.udc.fic.vvs.email.archivador;

import java.util.Vector;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import gal.udc.fic.vvs.email.correo.Correo;

public class ArchivadorSimple implements Archivador {

    public ArchivadorSimple(String nombre, int espacio) {
        _nombre = nombre;
        _espacioTotal = espacio;
        _espacioDisponible = espacio;
        _correos = new Vector();
    }

    public String obtenerNombre() {
    	EtmPoint point = monitor.createPoint("ArchivadorSimple:obtenerNombre");
    	point.collect();
        return _nombre;
    }

    public boolean almacenarCorreo(Correo correo) {
    	EtmPoint point = monitor.createPoint("ArchivadorSimple:almacenarCorreo");
        if (correo.obtenerTamaño() < _espacioDisponible) {
            _correos.addElement(correo);
            _espacioDisponible -= correo.obtenerTamaño();
            point.collect();
            return true;
        }
        point.collect();
        return false;
    }

    public int obtenerEspacioTotal() {
    	EtmPoint point = monitor.createPoint("ArchivadorSimple:obtenerEspacioTotal");
    	point.collect();
        return _espacioTotal;
    }

    public int obtenerEspacioDisponible() {
    	EtmPoint point = monitor.createPoint("ArchivadorSimple:obtenerEspacioDisponible");
    	point.collect();
        return _espacioDisponible;
    }

    public Archivador obtenerDelegado() {
    	EtmPoint point = monitor.createPoint("ArchivadorSimple:obtenerDelegado");
    	point.collect();
        return null;
    }

    public void establecerDelegado(Archivador archivador) {
    	EtmPoint point = monitor.createPoint("ArchivadorSimple:establecerDelegado");
    	point.collect();
    }

    private String _nombre;
    private int _espacioTotal, _espacioDisponible;
    private Vector _correos;
	private static EtmMonitor monitor = EtmManager.getEtmMonitor();


}
