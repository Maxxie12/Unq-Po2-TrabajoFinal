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
	



	public void suscribirAValidacion(ObserverZonaCobertura organizacion) {
		this.getSubscritosAValidacion().add(organizacion);
		
	}


	public void suscribirACarga(ObserverZonaCobertura organizacion) {
		this.getSubscritosACarga().add(organizacion);
		
	}


	public void desuscribirDeValidacion(ObserverZonaCobertura organizacion) {
		this.getSubscritosAValidacion().remove(organizacion);
		
	}


	public void desuscribirDeCarga(ObserverZonaCobertura organizacion) {
		this.getSubscritosACarga().remove(organizacion);
		
	}
	
	
	/* se solapan si las distancias entre las zonas es
	 * menor o igual a la suma de sus radios
	 */
	public List<ZonaDeCobertura> zonasSolapadas(List<ZonaDeCobertura> zonasAComparar) {
	    List<ZonaDeCobertura> zonasSolapadas = new ArrayList<>();

	    for (ZonaDeCobertura zona : zonasAComparar) {
	        double distancia = this.epicentro.distanciaEntre(zona.epicentro);
	        double distanciaLimite = this.radioEnKm + zona.radioEnKm;

	        if (distancia <= distanciaLimite) {
	            zonasSolapadas.add(zona);
	        }
	    }

	    return zonasSolapadas;
	}
	
	
	
	public void agregarMuestra(Muestra muestra) {
			this.getMuestrasEnZona().add(muestra);
			this.notificarCargaDeMuestra( muestra);
	}
	
	
	
	public void notificarCargaDeMuestra( Muestra muestra) {
	    for (ObserverZonaCobertura observer : this.getSubscritosACarga()) {
	        observer.nuevaCargaMuestra(this, muestra);
	    }
	   
	   
	}

	public void notificarValidacionDeMuestra( Muestra muestra) {
	    for (ObserverZonaCobertura observer : this.getSubscritosAValidacion()) {
	        observer.nuevaValidacionMuestra(this, muestra);
	    }
	}

	
	
	
	
	

	

	
}
