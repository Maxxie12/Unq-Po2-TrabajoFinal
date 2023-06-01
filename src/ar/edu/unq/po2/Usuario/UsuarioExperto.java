package ar.edu.unq.po2.Usuario;

public class UsuarioExperto extends EstadoUsuario{

	public void setState() {
		this.user.cambiarEstado(new UsuarioBasico());
	}
   
}
