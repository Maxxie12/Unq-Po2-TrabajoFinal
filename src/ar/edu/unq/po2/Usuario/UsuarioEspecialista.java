package ar.edu.unq.po2.Usuario;


public class UsuarioEspecialista extends Usuario{
	EstadoUsuario state;
	public UsuarioEspecialista(int id, String username) {
		super(id, username);
		this.state = new UsuarioExperto(this);
	}	
	
	@Override // 
	public void actualizarEstado(int cantMuestrasEnviadas, int cantMuestrasOpinadas) {
		System.out.println("El usuario especialista no puede modificar su estado");
	}
		
}