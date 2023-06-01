package ar.edu.unq.po2.TrabajoFinal;

import java.util.ArrayList;

import ar.edu.unq.po2.Usuario.EstadoUsuario;
import ar.edu.unq.po2.Usuario.Usuario;
import ar.edu.unq.po2.Usuario.UsuarioExperto;

public class UsuarioEspecialista extends Usuario{
	EstadoUsuario estado = new UsuarioExperto();
	public UsuarioEspecialista(int id, String username) {
		this.setId(id);
		this.setUserName(username);
		this.setState(new UsuarioExperto());
		this.setOpiniones(new ArrayList<Opinion>());
	}
		
}