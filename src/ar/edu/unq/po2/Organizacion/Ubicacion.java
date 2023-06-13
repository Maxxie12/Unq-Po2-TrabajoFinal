package ar.edu.unq.po2.Organizacion;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Muestra.Muestra;
import ar.edu.unq.po2.TrabajoFinal.Sistema;

public class Ubicacion {
	
	
	private Double latitud;
	private Double longitud;
	
	



	public Ubicacion(Double latitud, Double longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}


	public Double getLatitud() {
		return latitud;
	}


	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}


	public Double getLongitud() {
		return longitud;
	}


	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
	
	
	
	
	//acos = arco seno
	//sin = seno
	//cos = coseno
	// devuelve la distancia en kilometros 
	public double distanciaEntre ( Ubicacion ubicacion) {
		
		double  radioTierra = 6371.01; //Kilometros
		
		double latitud1 = Math.toRadians(this.getLatitud());
        double longitud1 = Math.toRadians(this.getLongitud());
        double latitud2 = Math.toRadians(ubicacion.getLatitud());
        double longitud2 = Math.toRadians(ubicacion.getLongitud());
        
        double distancia = radioTierra * Math.acos(Math.sin(latitud1) * Math.sin(latitud2)
        				   + Math.cos(latitud1) * Math.cos(latitud2) * Math.cos(longitud1 - longitud2));
        
        return distancia;
	}
	
	
	public List<Ubicacion> seEncuentranAMenosDeKM (List<Ubicacion> ubicaciones , int kilometros){
		List<Ubicacion> ubicacionesCercanas = new ArrayList<>();
        
        for (Ubicacion ubicacion : ubicaciones) {
            double distancia = distanciaEntre(ubicacion);
            
            if (distancia <= kilometros) {
                ubicacionesCercanas.add(ubicacion);
            }
        }
        
        return ubicacionesCercanas;
        
	}


		
	
}