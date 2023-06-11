package ar.edu.unq.po2.TrabajoFinal;

import java.util.ArrayList;

import ar.edu.unq.po2.Muestra.Muestra;
import ar.edu.unq.po2.Muestra.MuestraVerificada;
import ar.edu.unq.po2.Muestra.Opinion;

public class ClasificadorDeMuestras {
	private Sistema sistema;
	
	// clasifica state de la muestra

	public void clasificarMuestras() {
	ArrayList<Muestra> muestrasNoVerificadas = (ArrayList<Muestra>) this.sistema.getMuestras().stream().filter(muestra -> (muestra.esVerificada().equals(false)));
	muestrasNoVerificadas.stream().filter(muestra -> muestra.opinionesExpertos().stream().count() >= 2);
	this.clasificar(muestrasNoVerificadas);
	}

	public void clasificar(ArrayList<Muestra> muestras) {
		muestras.stream().forEach(muestra -> muestra.cambiarEstado(new MuestraVerificada()));;
	}
}
