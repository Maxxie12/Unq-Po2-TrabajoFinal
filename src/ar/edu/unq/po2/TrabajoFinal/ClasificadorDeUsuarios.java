package ar.edu.unq.po2.TrabajoFinal;

import java.time.LocalDate;
import java.util.ArrayList;
import ar.edu.unq.po2.Usuario.Usuario;
import ar.edu.unq.po2.Muestra.Muestra;
import ar.edu.unq.po2.Muestra.Opinion;

public class ClasificadorDeUsuarios {
	private Sistema sistema;
	
	public ClasificadorDeUsuarios(Sistema sistema) {
		this.sistema = sistema;
	}
	
	public void modificarEstadoDeUsuarios(Sistema sistema) {
		this.sistema.getUsuarios().forEach(usuario -> this.clasificarUsuario(usuario));
	}
	
	public void clasificarUsuario(Usuario usuario) {
		LocalDate fechaDehoy = null;
		fechaDehoy.now();
	    ArrayList <Muestra> muestras = (ArrayList<Muestra>) this.sistema.getMuestras().stream().filter(muestra -> muestra.getUsuario().equals(usuario) && muestra.getFechaCreacion().isAfter(fechaDehoy.minusDays(30)));
	    // ArrayList<Opinion> opinionesDeMuestras = this.opinionesDeUsuario(usuario);
	   this.clasificarUsuarioPor(muestras, opinionesDeMuestras(usuario), usuario);
	}
	
	public ArrayList<Opinion> opinionesDeMuestras(Usuario usuario){
		LocalDate fechaDehoy = null;
		fechaDehoy.now();
		ArrayList <Muestra> muestras = this.sistema.getMuestras();
		ArrayList <Opinion> opiniones = new ArrayList<Opinion>();
		for(int i = 0; i < muestras.size(); i++){
			opiniones.addAll(muestras.get(i).opinionDeUsuario(usuario)); // se agrega como lista aunque solo sea una opinion por muestra
		}
		return (ArrayList<Opinion>) opiniones.stream().filter(opinion -> opinion.getFechaPublicacion().isBefore(fechaDehoy.minusDays(30)));
	}
	
	public void clasificarUsuarioPor(ArrayList <Muestra> muestras, ArrayList<Opinion> opiniones, Usuario usuario) {
		usuario.actualizarEstado(muestras.size(), opiniones.size());
	}
	
}
