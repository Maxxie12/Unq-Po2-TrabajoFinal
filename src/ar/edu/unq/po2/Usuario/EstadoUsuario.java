package ar.edu.unq.po2.Usuario;

public abstract class EstadoUsuario {
	Usuario user;
	
	public abstract void setState();
	
	protected Usuario getUser() {
		return this.user;
	}

	protected abstract void actualizarEstado(int cantMuestrasEnviadas, int cantMuestrasOpinadas);

	protected abstract Boolean esExperto();
	
}
