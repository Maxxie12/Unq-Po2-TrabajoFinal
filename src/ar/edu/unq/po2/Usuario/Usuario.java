package ar.edu.unq.po2.Usuario;

import ar.edu.unq.po2.Common.Sistema;
import ar.edu.unq.po2.Muestra.Muestra;
import ar.edu.unq.po2.Muestra.Opinion;

public class Usuario {
	
	private int    id;
	private String userName;
	private EstadoUsuario state;
	
	public Usuario(int id, String username) {
		this.id = id;
		this.userName = username;
		this.state = new UsuarioBasico(this);
	}
	
	
	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public EstadoUsuario getState() {
		return state;
	}

	public void darOpinion(Muestra muestra, Opinion opinion) {
		muestra.agregarOpinion(opinion);
	}
	
	public void enviarMuestra(Muestra muestra, Sistema sistema) {
		sistema.agregarMuestra(muestra);
	}
		
	
	public void cambiarEstado(EstadoUsuario state) {
		this.state = state;
	}

	public void actualizarEstado(int cantMuestrasEnviadas, int cantMuestrasOpinadas) {
		state.actualizarEstado(cantMuestrasEnviadas, cantMuestrasOpinadas);
	}


	public Boolean esExperto() {
		return state.esExperto();
	}
		
}
