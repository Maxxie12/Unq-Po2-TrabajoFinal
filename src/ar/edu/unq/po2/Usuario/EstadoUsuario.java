package ar.edu.unq.po2.Usuario;

public abstract class EstadoUsuario {
	Usuario user;
	
	public abstract void setState();
	
	public void setUser(Usuario user) {
		this.user = user;
	}
	
	protected Usuario getUser() {
		return this.user;
	}
	
}
