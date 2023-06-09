package ar.edu.unq.po2.Muestra;

import java.util.Date;

import ar.edu.unq.po2.Usuario.Usuario;

public class Opinion {
	private  OpinionImagen opinion;
	private  Date fechaPublicacion;
	private  Usuario usuario;
	
	
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}
	
	public OpinionImagen getOpinion() {
		return opinion;
	}

	public void setOpinion(OpinionImagen opinion) {
		this.opinion = opinion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	
}
