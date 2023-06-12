package ar.edu.unq.po2.Usuario;

public class UsuarioExperto extends EstadoUsuario{

	public UsuarioExperto(Usuario user) {
		this.user = user;
	}

	public void setState() {
		this.user.cambiarEstado(new UsuarioBasico(this.getUser()));
	}

	@Override
	protected void actualizarEstado(int cantMuestrasEnviadas, int cantMuestrasOpinadas) {
		if (cantMuestrasEnviadas <= 10 || cantMuestrasOpinadas < 20) {
			this.setState();
		}
	}

	@Override
	protected Boolean esExperto() {
		return true;
	}
   
}
