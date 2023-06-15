package ar.edu.unq.po2.Common;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import ar.edu.unq.po2.Usuario.Usuario;
import ar.edu.unq.po2.Muestra.Muestra;
import ar.edu.unq.po2.Muestra.Opinion;

public class ClasificadorDeUsuarios {
	private Sistema sistema;
	
	public ClasificadorDeUsuarios(Sistema sistema) {
		this.sistema = sistema;
	}
	
	public void modificarEstadoDeUsuarios(Sistema sistema) {
		this.sistema.getUsuarios().forEach(usuario -> this.clasificarUsuarioPor(this.muestrasPublicadasPorUsuario(usuario), this.opinionesDeMuestras(usuario), usuario));
	}
	
	public List<Muestra> muestrasPublicadasPorUsuario(Usuario usuario) {
		LocalDate fechaDehoy = null;
	    Stream <Muestra> muestras = this.sistema.getMuestras().stream().filter(muestra -> muestra.getUsuario().equals(usuario) && muestra.getFechaCreacion().isAfter(fechaDehoy.now().minusDays(30)));
	    return muestras.toList();
	}
	
	public List<Opinion> opinionesDeMuestras(Usuario usuario){
		LocalDate fechaDehoy = null;
		List <Muestra> muestras = this.sistema.getMuestras();
		List <Opinion> opiniones = new ArrayList<Opinion>();
		for(int i = 0; i < muestras.size(); i++){
			if(!muestras.get(i).elUsuarioNoOpino(usuario)) {
				opiniones.add(muestras.get(i).opinionDeUsuario(usuario));
			}
			 
		}
		return opiniones.stream().filter(opinion -> opinion.getFechaPublicacion().isAfter(fechaDehoy.now().minusDays(30))).toList();
	}
	
	public void clasificarUsuarioPor(List <Muestra> muestras, List<Opinion> opiniones, Usuario usuario) {
		usuario.actualizarEstado(muestras.size(), opiniones.size());
	}
	
}
