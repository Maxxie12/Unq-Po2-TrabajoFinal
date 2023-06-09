package ar.edu.unq.po2.Muestra;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unq.po2.TrabajoFinal.Foto;
import ar.edu.unq.po2.TrabajoFinal.Ubicacion;
import ar.edu.unq.po2.Usuario.Usuario;

public class Muestra {
    private Ubicacion 			ubicacion;
    private Usuario 			usuario;
    private OpinionImagen       tipoInsecto;
    private LocalDate			fecha;
    private ArrayList<Opinion> 	opiniones; 
    private EstadoMuestra       estado;
    
    
    public Muestra(Ubicacion ubicacion, Usuario usuario, Opinion opinion) {
    	this.ubicacion = ubicacion;
    	this.usuario = usuario;
    	this.opiniones = new ArrayList<Opinion>();
    	this.tipoInsecto = opinion.getOpinion();
    	this.estado = new MuestraNoVerificada();
    	this.opiniones.add(opinion);
    }
    
	
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	
	public LocalDate getFecha (){
		return fecha;
	}
	
	public ArrayList<Opinion> getOpiniones() {
		return opiniones;
	}
	
	private void cambiarEstado(EstadoMuestra nuevoEstado) {
		this.estado = nuevoEstado;
	}


	public OpinionImagen getTipoInsecto() {
		return tipoInsecto;
	}
	
}

