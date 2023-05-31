package ar.edu.unq.po2.Usuario;

import java.util.ArrayList;

import ar.edu.unq.po2.TrabajoFinal.EstadoUsuario;
import ar.edu.unq.po2.TrabajoFinal.Muestra;
import ar.edu.unq.po2.TrabajoFinal.Opinion;
import ar.edu.unq.po2.TrabajoFinal.Sistema;

public class Usuario {
	
	private int    id;
	private String userName;
	private EstadoUsuario state;
	private ArrayList<Opinion> opiniones;
	
	
	public Usuario(int id, String username, EstadoUsuario state) {
		this.id = id;
		this.userName = username;
		this.state = state;
		state.setUser(this);
	}
		
	public void darOpinion(Muestra muestra) {
		
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
