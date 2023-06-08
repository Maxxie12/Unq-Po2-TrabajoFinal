package ar.edu.unq.po2.TrabajoFinal;

import java.util.Date;

public class Opinion {
	private String resenia;
	private Date fechaPublicacion;
	// agregar usuario?
	
	public String getResenia() {
		return resenia;
	}
	public void setResenia(String resenia) {
		this.resenia = resenia;
	}
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
}
