package ar.edu.unq.po2.Usuario;

import java.util.ArrayList;

import ar.edu.unq.po2.Muestra.Muestra;
import ar.edu.unq.po2.Muestra.Opinion;
import ar.edu.unq.po2.TrabajoFinal.Sistema;

public class Usuario {
	
	private int    id;
	private String userName;
	private EstadoUsuario state;
	private ArrayList<Opinion> opiniones;
	
	
	public Usuario(int id, String username, EstadoUsuario state) {
		this.setId(id);
		this.setUserName(username);
		this.setState(state);
		this.setOpiniones(new ArrayList<Opinion>());
	}
	
	public Usuario() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public EstadoUsuario getState() {
		return state;
	}

	public void setState(EstadoUsuario state) {
		this.state = state;
	}

	public ArrayList<Opinion> getOpiniones() {
		return opiniones;
	}

	public void setOpiniones(ArrayList<Opinion> opiniones) {
		this.opiniones = opiniones;
	}


	public void darOpinion(Muestra muestra, Opinion opinion) {
		muestra.getOpiniones().add(opinion);	
	}
	
	public void enviarMuestra(Muestra muestra, Sistema sistema) {
		sistema.agregarMuestra(muestra);
	}
		
	public void cambiarEstado() {
		state.setState();
	}
	
	public void cambiarEstado(EstadoUsuario state) {
		this.state = state;
		state.setUser(this);
	}
		
}
