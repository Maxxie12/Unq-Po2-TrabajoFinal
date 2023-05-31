package ar.edu.unq.po2.Usuario;

import ar.edu.unq.po2.TrabajoFinal.EstadoUsuario;

public class UsuarioBasico implements EstadoUsuario{

	Usuario user;
	
	public Usuario getUser() {
		return this.user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}


	@Override
	public void setState() {
		this.getUser().cambiarEstado(new UsuarioExperto());
	}
	
}
