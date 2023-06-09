package ar.edu.unq.po2.Usuario;

public class UsuarioBasico extends EstadoUsuario{

	private Usuario user;
	
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
