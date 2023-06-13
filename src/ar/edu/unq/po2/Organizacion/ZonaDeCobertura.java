package ar.edu.unq.po2.Organizacion;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Muestra.Muestra;



public class ZonaDeCobertura {
	
	private String nombre;
	private Ubicacion epicentro;
	private int  radioEnKm;
	private List<Muestra> muestrasEnZona = new ArrayList<Muestra>();
	private List<ObserverZonaCobertura> subscritosAValidacion = new ArrayList<>();;
	private List<ObserverZonaCobertura> subscritosACarga = new ArrayList<>();;
	
	
	public ZonaDeCobertura(String nombre, Ubicacion epicentro, int distanciaEnKm) {
		super();
		this.nombre = nombre;
		this.epicentro = epicentro;
		this.radioEnKm = distanciaEnKm;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Ubicacion getEpicentro() {
		return epicentro;
	}


	public void setEpicentro(Ubicacion epicentro) {
		this.epicentro = epicentro;
	}


	public int getRadioEnKm() {
		return radioEnKm;
	}


	public void setRadioEnKm(int distanciaEnKm) {
		this.radioEnKm = distanciaEnKm;
	}
	
	

	public List<Muestra> getMuestrasEnZona() {
		return muestrasEnZona;
	}

	
	public List<ObserverZonaCobertura> getSubscritosAValidacion() {
		return subscritosAValidacion;
	}
	
	public List<ObserverZonaCobertura> getSubscritosACarga() {
		return subscritosACarga;
	}
	

	public int diametro() {
		return this.radioEnKm * 2;
	}


	public void suscribirAValidacion(Organizacion organizacion) {
		this.getSubscritosAValidacion().add(organizacion);
		
	}


	public void suscribirACarga(Organizacion organizacion) {
		this.getSubscritosACarga().add(organizacion);
		
	}


	public void desuscribirDeValidacion(Organizacion organizacion) {
		this.getSubscritosAValidacion().remove(organizacion);
		
	}


	public void desuscribirDeCarga(Organizacion organizacion) {
		this.getSubscritosACarga().remove(organizacion);
		
	}
	
	
	
	public List<ZonaDeCobertura> zonasSolapadas(List<ZonaDeCobertura> zonasAComparar) {
	    List<ZonaDeCobertura> zonasSolapadas = new ArrayList<>();

	    for (ZonaDeCobertura zona : zonasAComparar) {
	        if (this.getRadioEnKm() > this.getEpicentro().distanciaEntre(zona.getEpicentro())) {
	            zonasSolapadas.add(zona);
	        }
	    }

	    return zonasSolapadas;
	}
	
	
	
	public void agregarMuestra(Muestra muestra) {
			this.getMuestrasEnZona().add(muestra);
			this.notificarCargaDeMuestra(this, muestra);
	}
	
	
	
	public void notificarCargaDeMuestra(ZonaDeCobertura zonaDeCobertura, Muestra muestra) {
	    for (ObserverZonaCobertura observer : this.getSubscritosACarga()) {
	        observer.nuevaCargaMuestra(zonaDeCobertura, muestra);
	    }
	   
	   
	}

	public void notificarValidacionDeMuestra(ZonaDeCobertura zonaDeCobertura, Muestra muestra) {
	    for (ObserverZonaCobertura observer : this.getSubscritosAValidacion()) {
	        observer.nuevaValidacionMuestra(zonaDeCobertura, muestra);
	    }
	}

	
	
	
	
	

	

	
}
