package ar.edu.unq.po2.Usuario;

import java.util.ArrayList;
import ar.edu.unq.po2.Muestra.Opinion;

public class UsuarioEspecialista extends Usuario{
	EstadoUsuario estado = new UsuarioExperto();
	public UsuarioEspecialista(int id, String username) {
		super(id, username);
	}	
	
	@Override
	public Boolean esExperto() {
		return estado.esExperto();
	}
	
	@Override // es necesaria?
	public void actualizarEstado(int cantMuestrasEnviadas, int cantMuestrasOpinadas) {
		System.out.println("El usuario especialista no puede modificar su estado");
	}
		
}