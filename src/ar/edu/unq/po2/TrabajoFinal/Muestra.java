package ar.edu.unq.po2.TrabajoFinal;

import java.time.LocalDate;
import java.util.ArrayList;

public class Muestra {

	private String 				especie;
    private Foto				foto;
    private Ubicacion 			ubicacion;
    private Usuario 			usuario;
    private String				opinion;
    private LocalDate			fecha;
    private ArrayList<String> 	opiniones; 
    
    
	public String getEspecie() {
		return especie;
	}
	public Foto getFoto() {
		return foto;
	}
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public String getOpinion() {
		return opinion;
	}
	
	public LocalDate getFecha (){
		return fecha;
	}
	public ArrayList<String> getOpiniones() {
		return opiniones;
	}
}

