package ar.edu.unq.po2.TrabajoFinal;

import ar.edu.unq.po2.Usuario.Usuario;

public interface EstadoUsuario {
	public abstract void setState();
	public abstract void setUser(Usuario user);
}
