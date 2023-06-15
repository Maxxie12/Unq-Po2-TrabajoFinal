package ar.edu.unq.po2.Usuario;


public class UsuarioEspecialista extends Usuario{
	public UsuarioEspecialista(int id, String username) {
		super(id, username);
		this.cambiarEstado(new UsuarioExperto(this));
	}	
	
	@Override // 
	public void actualizarEstado(int cantMuestrasEnviadas, int cantMuestrasOpinadas) {
		
	}
		
}