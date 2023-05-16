package ar.edu.unq.po2.TrabajoFinal;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeCobertura {

	 private String nombre;
	 private Ubicacion epicentro;
	 private double radio;
	 private List<Muestra> muestras;

	 	public ZonaDeCobertura(String nombre, Ubicacion epicentro, double radio) {
	       	this.nombre = nombre;
	        this.epicentro = epicentro;
	        this.radio = radio;
	        this.muestras = new ArrayList<>();
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public Ubicacion getEpicentro() {
	        return epicentro;
	    }

	    public double getRadio() {
	        return radio;
	    }

	    public List<Muestra> getMuestras() {
	        return muestras;
	    }

	    public void agregarMuestra(Muestra muestra) {
	        muestras.add(muestra);
	    }
}
