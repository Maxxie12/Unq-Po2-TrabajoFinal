package ar.edu.unq.po2.Usuario;

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
