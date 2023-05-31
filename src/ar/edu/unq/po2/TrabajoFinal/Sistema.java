package ar.edu.unq.po2.TrabajoFinal;

import java.util.ArrayList;

import ar.edu.unq.po2.Usuario.Usuario;

public class Sistema {
	
	private ArrayList<Muestra> muestras;
	private ArrayList<Usuario> usuarios;
	private ArrayList<ZonaDeCobertura> zonasDeCobertura;
	private ArrayList<Organizacion> organizaciones;
	
	protected void agregarMuestra(Muestra muestra) {
		this.muestras.add(muestra);
	}
	
	private void actualizarUsuarios(){
		this.usuarios.stream().forEach(usuario -> this.catalogar(usuario));
	}
	
	private void catalogar(Usuario usuario) { // hay que terminar la idea de opinion
		int cantidadDeMuestrasUsuario = 0;
		int cantidadDeOpiniones = 0;
		
	}
}

