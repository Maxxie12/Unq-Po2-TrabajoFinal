package ar.edu.unq.po2.Usuario;

import java.util.ArrayList;

import ar.edu.unq.po2.Muestra.Opinion;

public class UsuarioEspecialista extends Usuario{
	EstadoUsuario estado = new UsuarioExperto();
	public UsuarioEspecialista(int id, String username) {
		this.setId(id);
		this.setUserName(username);
		this.setState(new UsuarioExperto());
		this.setOpiniones(new ArrayList<Opinion>());
	}
		
}