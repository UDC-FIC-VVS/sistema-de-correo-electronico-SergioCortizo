package gal.udc.fic.vvs.email.correo;

import java.util.Collection;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

public abstract class DecoradorMensaje extends MensajeAbstracto {

    public DecoradorMensaje(MensajeAbstracto decorado) {
        _decorado = decorado;
    }

    public void establecerLeido(boolean leido) {
    	EtmPoint point = monitor.createPoint("DecoradorMensaje:establecerLeido");    	
        _decorado.establecerLeido(leido);
        point.collect();
    }

    public int obtenerNoLeidos() {
    	EtmPoint point = monitor.createPoint("DecoradorMensaje:obtenerNoLeidos");
    	point.collect();
        return _decorado.obtenerNoLeidos();
    }

    public int obtenerTamaño() {
    	EtmPoint point = monitor.createPoint("DecoradorMensaje:obtenerTamaño");
    	point.collect();
        return _decorado.obtenerTamaño();
    }

    public Integer obtenerIcono() {
    	EtmPoint point = monitor.createPoint("DecoradorMensaje:obtenerIcono");
    	point.collect();
        return _decorado.obtenerIcono();
    }

    public String obtenerPreVisualizacion() {
    	EtmPoint point = monitor.createPoint("DecoradorMensaje:obtenerPreVisualizacion");
    	point.collect();
        return _decorado.obtenerPreVisualizacion();
    }

    public String obtenerVisualizacion() {
    	EtmPoint point = monitor.createPoint("DecoradorMensaje:obtenerVisualizacion");
    	point.collect();
        return _decorado.obtenerVisualizacion();
    }

    public String obtenerRuta() {
    	EtmPoint point = monitor.createPoint("DecoradorMensaje:obtenerRuta");
    	point.collect();
        return _decorado.obtenerRuta();
    }

    public Collection explorar() throws OperacionInvalida {
    	EtmPoint point = monitor.createPoint("DecoradorMensaje:explorar");
    	point.collect();
        return _decorado.explorar();
    }

    public Collection buscar(String busqueda) {
    	EtmPoint point = monitor.createPoint("DecoradorMensaje:buscar");
    	
        Collection resultado = _decorado.buscar(busqueda);
        if (resultado.remove(_decorado)) {
            resultado.add(this);
        }
        point.collect();
        return resultado;
    }

    public void añadir(Correo correo) throws OperacionInvalida {
    	EtmPoint point = monitor.createPoint("DecoradorMensaje:añadir");
        _decorado.añadir(correo);
        point.collect();
    }

    public void eliminar(Correo correo) throws OperacionInvalida {
    	EtmPoint point = monitor.createPoint("DecoradorMensaje:eliminar");
        _decorado.eliminar(correo);
        point.collect();
    }

    public Correo obtenerHijo(int n) throws OperacionInvalida {
    	EtmPoint point = monitor.createPoint("DecoradorMensaje:obtenerHijo");
    	point.collect();
        return _decorado.obtenerHijo(n);
    }

    public Correo obtenerPadre() {
    	EtmPoint point = monitor.createPoint("DecoradorMensaje:obtenerPadre");
    	point.collect();
        return _decorado.obtenerPadre();
    }

    protected void establecerPadre(Correo padre) {
    	EtmPoint point = monitor.createPoint("DecoradorMensaje:establecerPadre");
        _decorado.establecerPadre(padre);
        point.collect();
    }

    private MensajeAbstracto _decorado;
	private static EtmMonitor monitor = EtmManager.getEtmMonitor();

}
