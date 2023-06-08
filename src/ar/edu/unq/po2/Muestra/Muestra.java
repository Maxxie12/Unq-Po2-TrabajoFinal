package ar.edu.unq.po2.Muestra;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unq.po2.TrabajoFinal.Foto;
import ar.edu.unq.po2.TrabajoFinal.Opinion;
import ar.edu.unq.po2.TrabajoFinal.Ubicacion;
import ar.edu.unq.po2.Usuario.Usuario;

public class Muestra {

	private String 				especie;
    private Foto				foto;
    private Ubicacion 			ubicacion;
    private Usuario 			usuario;
    private Opinion				opinion;
    private LocalDate			fecha;
    private ArrayList<Opinion> 	opiniones; 
    private EstadoMuestra       estado;
    
    
    public Muestra(String especie, Foto foto, Ubicacion ubicacion, Usuario usuario, Opinion opinion) {
    	this.especie = opinion.getResenia();
    	this.foto = foto;
    	this.ubicacion = ubicacion;
    	this.usuario = usuario;
    	this.opinion = opinion;
    	this.opiniones = new ArrayList<Opinion>();
    	this.estado = new MuestraNoVerificada();
    	this.opiniones.add(opinion);
    }
    
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
	
	public Opinion getOpinion() {
		return opinion;
	}
	
	public LocalDate getFecha (){
		return fecha;
	}
	
	public ArrayList<Opinion> getOpiniones() {
		return opiniones;
	}
	
	protected void cambiarEstado(EstadoMuestra nuevoEstado) {
		this.estado = nuevoEstado;
	}
		
}

