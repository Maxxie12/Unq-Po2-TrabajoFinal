package ar.edu.unq.po2.Usuario;

public class UsuarioBasico extends EstadoUsuario{

	public UsuarioBasico(Usuario usuario) {
		this.user = usuario;
	}

	@Override
	public void setState() {
		this.getUser().cambiarEstado(new UsuarioExperto(this.user));
	}
	
	protected void actualizarEstado(int cantMuestrasEnviadas, int cantMuestrasOpinadas) {
		if (cantMuestrasEnviadas > 20 && cantMuestrasOpinadas > 10) {
			this.setState();
		}
		
	}

	@Override
	protected Boolean esExperto() {
		return false;
	}

}
