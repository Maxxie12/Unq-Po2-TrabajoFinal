package ar.edu.unq.po2.Muestra;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

import ar.edu.unq.po2.TrabajoFinal.Ubicacion;
import ar.edu.unq.po2.Usuario.Usuario;

public class Muestra {
    private Ubicacion 			ubicacion;
    private Usuario 			usuario;
    private OpinionImagen       tipoInsecto;
    private LocalDate			fechaCreacion;
    private ArrayList<Opinion> 	opiniones; 
    private EstadoMuestra       estado;
    
    
    public Muestra(Ubicacion ubicacion, Usuario usuario, Opinion opinion) {
    	this.ubicacion = ubicacion;
    	this.usuario = usuario;
    	this.opiniones = new ArrayList<Opinion>();
    	this.tipoInsecto = opinion.getOpinion();
    	this.estado = new MuestraNoVerificada(this);
    	this.opiniones.add(opinion);
    	this.fechaCreacion.now();
    }
    
	
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	
	public LocalDate getFechaCreacion (){
		return fechaCreacion;
	}
	
	public ArrayList<Opinion> getOpiniones() {
		return opiniones;
	}
	
	public void cambiarEstado(EstadoMuestra nuevoEstado) {
		this.estado = nuevoEstado;
	}

	public EstadoMuestra getEstadoMuestra() {
		return this.estado;
	}

	public OpinionImagen getTipoInsecto() {
		return tipoInsecto;
	}
	
	public void agregarOpinion(Opinion opinion) {
		this.estado.agregarOpinion(opinion);
	}

	public ArrayList<Opinion> opinionDeUsuario(Usuario usuario) {
		return (ArrayList<Opinion>) this.getOpiniones().stream().filter(opinion -> opinion.getUsuario().equals(usuario));
	}


	public Boolean esVerificada() {
		return estado.esVerificada();
	}


	public ArrayList<Opinion> opinionesExpertos() {
		return (ArrayList<Opinion>) this.opiniones.stream().filter(opinion -> opinion.getUsuario().esExperto());
	}
	
	public void actualizarOpinionActual() {
		// inicializar contadores para cada opinion y recorrer todo con un for?
		ArrayList<OpinionImagen> opinionesDeImagen = new ArrayList<OpinionImagen>();
		this.getOpiniones().stream().forEach(opinion -> opinionesDeImagen.add(opinion.getOpinion()));
		this.actualizarSegunOpinionMayoritaria(opinionesDeImagen);
	}


	public void actualizarSegunOpinionMayoritaria(ArrayList<OpinionImagen> opinionesDeImagen) {
		
	}

	
}

