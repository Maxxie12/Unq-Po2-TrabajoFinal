package ar.edu.unq.po2.Muestra;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.*;
import ar.edu.unq.po2.Organizacion.Ubicacion;
import ar.edu.unq.po2.Usuario.Usuario;

public class Muestra {
    private Ubicacion 			ubicacion;
    private Usuario 			usuario;
    private OpinionImagen       tipoInsecto;
    private LocalDate			fechaCreacion;
    private ArrayList<Opinion> 	opiniones; 
    private IEstadoMuestra       estado;
    
    
    public Muestra(Ubicacion ubicacion, Opinion opinion) {
    	this.ubicacion = ubicacion;
    	this.usuario = opinion.getUsuario();
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
	
	public void cambiarEstado(IEstadoMuestra nuevoEstado) {
		this.estado = nuevoEstado;
	}

	public IEstadoMuestra getEstadoMuestra() {
		return this.estado;
	}

	public OpinionImagen getTipoInsecto() {
		return tipoInsecto;
	}
	
	public void agregarOpinion(Opinion opinion) { // ver de agregar exception si ya opino
		if(this.elUsuarioNoOpino(opinion.getUsuario())) {
			this.estado.agregarOpinion(opinion);
		} 
	}

	public Opinion opinionDeUsuario(Usuario usuario) {
		// Precondicion: el usuario tiene que haber opinado en la muestra
		Stream<Opinion> opinionLista = this.getOpiniones().stream().filter(opinion -> opinion.getUsuario().equals(usuario));
		return opinionLista.toList().get(0);
	}
	
	public Boolean elUsuarioNoOpino(Usuario usuario) {
		Stream<Opinion> opinionLista = this.getOpiniones().stream().filter(opinion -> opinion.getUsuario().getId() == usuario.getId());
		return opinionLista.toList().size() == 0;
	}


	public Boolean esVerificada() {
		return estado.esVerificada();
	}


	public List<Opinion> opinionesExpertos() {
		Stream <Opinion> opinionesExpertos = this.opiniones.stream().filter(opinion -> opinion.getUsuario().esExperto());
		return opinionesExpertos.toList();
	}
	
	public void actualizarOpinion(){
		ArrayList<OpinionImagen> opinionesDeImagen = new ArrayList<OpinionImagen>();
		this.getOpiniones().stream().forEach(opinion -> opinionesDeImagen.add(opinion.getOpinion()));
		this.actualizarOpinionActual(opinionesDeImagen);
	}
	

    public void  actualizarOpinionActual(List<OpinionImagen> opiniones){
        HashMap<OpinionImagen, Integer> recuento = new HashMap<>();

        for (OpinionImagen opinion : opiniones) {
            recuento.put(opinion, recuento.getOrDefault(opinion, 0) + 1);
        }

        OpinionImagen opinionConMayorCantidad = null;
        int cantidadMaxima = 0;

        for (Map.Entry<OpinionImagen, Integer> entry : recuento.entrySet()) {
        	OpinionImagen opinion = entry.getKey();
            int cantidad = entry.getValue();

            if (cantidad > cantidadMaxima) {
                cantidadMaxima = cantidad;
                opinionConMayorCantidad = opinion;
            }
        }
        this.validarOpinionConMayorCantidad(opinionConMayorCantidad, recuento, cantidadMaxima);
        // this.tipoInsecto = opinionConMayorCantidad;
	}
    
    public void validarOpinionConMayorCantidad(OpinionImagen opinion, HashMap<OpinionImagen, Integer> mapOpiniones, int cantidad) {
    	int cantidadDeValoresIguales = 0;
    	for(Map.Entry<OpinionImagen, Integer> entry : mapOpiniones.entrySet()) {
    	    OpinionImagen opinionDeImagen = entry.getKey();
    	    int cantidadDeVotaciones = entry.getValue();
			if (cantidad == cantidadDeVotaciones) {
				cantidadDeValoresIguales += 1;
    	    }   
    	}
    	
    	this.definirTipoDeInsecto(cantidadDeValoresIguales > 1, opinion);
    }
    
    public void definirTipoDeInsecto(boolean esEmpate, OpinionImagen opinion) {
    	if(esEmpate) {
    		this.tipoInsecto = OpinionImagen.NO_DEFINIDA;
    	} else {
    		this.tipoInsecto = opinion;
    	}
    }


	public void agregarOpinionDe(Opinion opinion) {
		this.opiniones.add(opinion);
	}
}

