package ar.edu.unq.po2.Usuario;

import ar.edu.unq.po2.TrabajoFinal.EstadoUsuario;

public class UsuarioExperto implements EstadoUsuario{

	Usuario user;	
	@Override
	public void setState() {
		this.user.cambiarEstado(new UsuarioBasico());
	}

	@Override
	public void setUser(Usuario usuario) {
		this.user = usuario;
	}
   
}
